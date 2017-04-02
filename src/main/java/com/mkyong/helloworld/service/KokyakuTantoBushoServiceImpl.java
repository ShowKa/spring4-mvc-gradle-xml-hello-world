package com.mkyong.helloworld.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mkyong.helloworld.dao.i.KokyakuBushoDao;
import com.mkyong.helloworld.domain.BushoDomain;
import com.mkyong.helloworld.domain.KokyakuDomain;
import com.mkyong.helloworld.domain.KokyakuTantoBushoDomain;
import com.mkyong.helloworld.entity.MKokyakuTantoBusho;
import com.mkyong.helloworld.entity.MKokyakuTantoBushoId;
import com.mkyong.helloworld.kubun.BushoKubun;
import com.mkyong.helloworld.service.i.BushoService;
import com.mkyong.helloworld.service.i.KokyakuService;
import com.mkyong.helloworld.service.i.KokyakuTantoBushoService;
import com.mkyong.helloworld.service.i.NyukinMotoService;
import com.mkyong.helloworld.service.i.SeikyuSakiService;
import com.mkyong.helloworld.system.exception.IncorrectKubunException;
import com.mkyong.helloworld.system.exception.NotExistException;
import com.mkyong.helloworld.system.exception.ValidateException;

@Component
@Service
@Transactional
public class KokyakuTantoBushoServiceImpl implements KokyakuTantoBushoService {

	// service
	@Autowired
	private KokyakuBushoDao kokyakuBushoDao;

	@Autowired
	private BushoService bushoService;

	@Autowired
	private KokyakuService kokyakuService;

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
	 * 顧客担当部署整合性検証
	 */
	@Override
	public boolean validate(KokyakuTantoBushoDomain kokyakuTantoBushoDomain) {

		// 顧客担当部署
		KokyakuTantoBushoDomain d = kokyakuTantoBushoDomain;

		// 顧客
		KokyakuDomain kokyaku = d.getKokyakuDomain();

		// 担当部署
		BushoDomain tantoBusho = d.getBushoDomain();

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

		// 含有ドメインの整合性判定
		kokyakuService.validate(kokyaku);
		nyukinMotoService.validate(d.getNyukinMotoDomain());
		seikyuSakiService.validate(d.getSeikyuSakiDomain());

		// OK
		return true;
	}

	@Override
	public void register(KokyakuTantoBushoDomain domain) {
		kokyakuBushoDao.register(domain);

		// 含有ドメイン登録

		// 顧客ドメイン
		if (domain.isShukan()) {
			kokyakuService.register(domain.getKokyakuDomain());
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
