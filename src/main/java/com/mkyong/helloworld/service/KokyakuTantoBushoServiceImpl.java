package com.mkyong.helloworld.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mkyong.helloworld.dao.i.KokyakuBushoDao;
import com.mkyong.helloworld.domain.BushoDomain;
import com.mkyong.helloworld.domain.KokyakuDomain;
import com.mkyong.helloworld.domain.KokyakuTantoBushoDomain;
import com.mkyong.helloworld.domain.NyukinMotoDomain;
import com.mkyong.helloworld.domain.SeikyuSakiDomain;
import com.mkyong.helloworld.entity.MKokyakuTantoBusho;
import com.mkyong.helloworld.entity.MKokyakuTantoBushoId;
import com.mkyong.helloworld.kubun.BushoKubun;
import com.mkyong.helloworld.kubun.HanbaiKubun;
import com.mkyong.helloworld.kubun.KokyakuKubun;
import com.mkyong.helloworld.kubun.SeikyuKubun;
import com.mkyong.helloworld.kubun.SeikyushoSakuseiBashoKubun;
import com.mkyong.helloworld.service.i.BushoService;
import com.mkyong.helloworld.service.i.KokyakuService;
import com.mkyong.helloworld.service.i.KokyakuTantoBushoHanbaiService;
import com.mkyong.helloworld.service.i.KokyakuTantoBushoService;
import com.mkyong.helloworld.service.i.NyukinMotoService;
import com.mkyong.helloworld.service.i.SeikyuSakiService;
import com.mkyong.helloworld.system.Warning;
import com.mkyong.helloworld.system.exception.EmptyException;
import com.mkyong.helloworld.system.exception.IncorrectKubunException;
import com.mkyong.helloworld.system.exception.NotExistException;
import com.mkyong.helloworld.system.exception.ValidateException;

@Component
@Service
@Transactional
public class KokyakuTantoBushoServiceImpl implements KokyakuTantoBushoService {

	// DAO
	@Autowired
	private KokyakuBushoDao kokyakuBushoDao;

	// service
	@Autowired
	private BushoService bushoService;

	@Autowired
	private KokyakuService kokyakuService;

	@Autowired
	private KokyakuTantoBushoHanbaiService kokyakuTantoBushoHanbaiService;

	@Autowired
	private NyukinMotoService nyukinMotoService;

	@Autowired
	private SeikyuSakiService seikyuSakiService;

	/**
	 * 担当部署存在チェック
	 */
	@Override
	public boolean existsKokyakuTantoBusho(String kokyakuCode, String bushoCode) {
		MKokyakuTantoBushoId id = new MKokyakuTantoBushoId();
		id.setKokyakuCode(kokyakuCode);
		id.setBushoCode(bushoCode);
		MKokyakuTantoBusho e = kokyakuBushoDao.getByPrimaryKey(id);
		if (e == null) {
			return false;
		}
		return true;
	}

	/**
	 * 顧客担当部署取得
	 */
	@Override
	public KokyakuTantoBushoDomain getKokyakuTantoBusho(String kokyakuCode, String bushoCode) {
		return kokyakuBushoDao.getDomain(kokyakuCode, bushoCode);
	}

	/**
	 * 顧客担当部署整合性検証
	 */
	@Override
	public boolean validate(KokyakuTantoBushoDomain domain) {

		// 顧客
		KokyakuDomain kokyaku = domain.getKokyakuDomain();
		KokyakuKubun kokyakuKubun = kokyaku.getKokyakuKubun();

		// 担当部署
		BushoDomain tantoBusho = domain.getBushoDomain();

		// 担当部署存在チェック
		boolean existsTantoBusho = bushoService.existsBusho(tantoBusho.getCode());
		if (!existsTantoBusho) {
			throw new NotExistException("担当部署", tantoBusho.getCode());
		}

		// 担当部署の区分チェック
		if (tantoBusho.getBushoKubun() != BushoKubun.営業所) {
			throw new IncorrectKubunException("担当部署", tantoBusho.getBushoKubun());
		}

		// 設定した主幹部署は、担当部署として存在している必要がある。
		// ただし、主幹部署=担当部署であるなら、チェックは不要。
		BushoDomain shukanBusho = kokyaku.getShukanBushoDomain();
		if (!tantoBusho.equals(shukanBusho)) {
			boolean aleadyTantoExists = existsKokyakuTantoBusho(kokyaku.getCode(), shukanBusho.getCode());
			if (!aleadyTantoExists) {
				throw new ValidateException("担当部署として登録済みの部署のみ主幹部署として登録できます。");
			}
		}

		// 顧客区分 = カフェラウンジの場合の整合性検証
		if (kokyakuKubun == KokyakuKubun.カフェラウンジ) {
			this.validateCafe(domain);
		}

		// 販売区分 = 掛売の場合の整合性検証
		if (domain.getNyukinMotoDomain().getHanbaiKubun() == HanbaiKubun.掛売) {
			this.validateKakeuri(domain);
		}

		// 含有ドメインの整合性判定
		kokyakuService.validate(kokyaku);
		if (domain.isHanbaiBusho()) {
			kokyakuTantoBushoHanbaiService.validate(domain.getKokyakuTantoBushoHanbaiDomain());
		}
		nyukinMotoService.validate(domain.getNyukinMotoDomain());
		seikyuSakiService.validate(domain.getSeikyuSakiDomain());

		// OK
		return true;
	}

	/**
	 * 顧客担当部署整合性検証(警告)
	 */
	@Override
	public List<Warning> warn(KokyakuTantoBushoDomain domain) {
		ArrayList<Warning> warnings = new ArrayList<Warning>();

		// get old Data
		String bushoCode = domain.getBushoDomain().getCode();
		String kokyakuCode = domain.getKokyakuDomain().getCode();
		KokyakuTantoBushoDomain kokyakuBeforeUpdate = kokyakuBushoDao.getDomain(kokyakuCode, bushoCode);

		if (kokyakuBeforeUpdate.getShohizeiKubun() != domain.getShohizeiKubun()) {
			Warning w = new Warning("消費税区分が変更されました。契約・売上情報に表示される単価が変更されます。");
			warnings.add(w);
		}

		return warnings;
	}

	/**
	 * カフェラウンジ整合性検証
	 */
	@Override
	public void validateCafe(KokyakuTantoBushoDomain domain) {
		// 販売区分 = 現金 ならOK
		HanbaiKubun hanbaiKubun = domain.getNyukinMotoDomain().getHanbaiKubun();
		if (hanbaiKubun != HanbaiKubun.現金) {
			throw new IncorrectKubunException("販売区分", hanbaiKubun);
		}
	}

	/**
	 * 掛売販売の場合の整合性検証
	 */
	@Override
	public void validateKakeuri(KokyakuTantoBushoDomain domain) throws ValidateException {
		// 販売区分 = 掛売の場合、請求書作成場所区分、請求区分（発送方法）の設定が必要
		SeikyuSakiDomain seikyuSaki = domain.getSeikyuSakiDomain();
		if (seikyuSaki.getSeikyuKubun() == SeikyuKubun.EMPTY) {
			throw new EmptyException("請求区分");
		}
		if (seikyuSaki.getSeikyushoSakuseiBashoKubun() == SeikyushoSakuseiBashoKubun.EMPTY) {
			throw new EmptyException("請求場所作成区分");
		}
	}

	/**
	 * 入金元取得
	 */
	@Override
	public NyukinMotoDomain getNyukinMoto(String kokyakuCode, String bushoCode) {
		KokyakuTantoBushoDomain kokyakuTantoBusho = kokyakuBushoDao.getDomain(kokyakuCode, bushoCode);
		return kokyakuTantoBusho.getNyukinMotoDomain();
	}

	@Override
	public void register(KokyakuTantoBushoDomain domain) {

		// 顧客ドメイン
		if (domain.isShukan()) {
			kokyakuService.register(domain.getKokyakuDomain());
		}

		// メインドメイン
		kokyakuBushoDao.register(domain);

		// 販売部署
		if (domain.isHanbaiBusho()) {
			kokyakuTantoBushoHanbaiService.register(domain.getKokyakuTantoBushoHanbaiDomain());
		}

		// 入金元ドメイン
		nyukinMotoService.register(domain.getNyukinMotoDomain());

		// 請求先
		seikyuSakiService.register(domain.getSeikyuSakiDomain());

	}

	@Override
	public void update(KokyakuTantoBushoDomain domain) {
		// TODO Auto-generated method stub
	}

}
