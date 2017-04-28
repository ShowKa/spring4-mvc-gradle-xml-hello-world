package com.mkyong.helloworld.web.u01;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mkyong.helloworld.domain.BushoDomain;
import com.mkyong.helloworld.domain.KokyakuDomain;
import com.mkyong.helloworld.domain.KokyakuKojinDomain;
import com.mkyong.helloworld.domain.KokyakuKojinTantoBushoDomain;
import com.mkyong.helloworld.domain.KokyakuTantoBushoDomain;
import com.mkyong.helloworld.domain.NyukinKakeInfoDomain;
import com.mkyong.helloworld.domain.NyukinMotoDomain;
import com.mkyong.helloworld.domain.SeikyuSakiDomain;
import com.mkyong.helloworld.domain.builder.KokyakuDomainBuilder;
import com.mkyong.helloworld.domain.builder.KokyakuKojinDomainBuilder;
import com.mkyong.helloworld.domain.builder.KokyakuKojinTantoBushoDomainBuilder;
import com.mkyong.helloworld.domain.builder.KokyakuTantoBushoDomainBuilder;
import com.mkyong.helloworld.domain.builder.NyukinKakeInfoDomainBuilder;
import com.mkyong.helloworld.domain.builder.NyukinMotoDomainBuilder;
import com.mkyong.helloworld.domain.builder.SeikyuSakiDomainBuilder;
import com.mkyong.helloworld.kubun.GenteiKubun;
import com.mkyong.helloworld.kubun.HanbaiKubun;
import com.mkyong.helloworld.kubun.KokyakuKubun;
import com.mkyong.helloworld.kubun.NyukinHohoKubun;
import com.mkyong.helloworld.kubun.NyukinTsukiKubun;
import com.mkyong.helloworld.kubun.SeikyuKubun;
import com.mkyong.helloworld.kubun.SeikyushoSakuseiBashoKubun;
import com.mkyong.helloworld.kubun.ShohizeiKubun;
import com.mkyong.helloworld.kubun.i.Kubun;
import com.mkyong.helloworld.service.i.BushoService;
import com.mkyong.helloworld.service.i.KokyakuKojinTantoBushoService;
import com.mkyong.helloworld.service.i.KokyakuService;
import com.mkyong.helloworld.service.i.KokyakuTantoBushoService;
import com.mkyong.helloworld.system.Warning;

@Controller
public class U01G001Controller {

	// service
	@Autowired
	@Qualifier("kokyakuServiceImpl")
	private KokyakuService kokyakuService;

	@Autowired
	@Qualifier("kokyakuTantoBushoServiceImpl")
	private KokyakuTantoBushoService kokyakuTantoBushoService;

	@Autowired
	private KokyakuKojinTantoBushoService kokyakuKojinTantoBushoService;

	@Autowired
	private BushoService bushoService;

	// public method called by request
	@RequestMapping(value = "/U01G001", method = RequestMethod.GET)
	public String index(Map<String, Object> model, HttpSession session) {
		System.out.println(session);
		return "/u01/u01g001";
	}

	@RequestMapping(value = "/U01G001/search", method = RequestMethod.POST)
	public void search(@ModelAttribute U01G001Form form) {
	}

	/**
	 * 顧客の新規登録
	 * 
	 * @param form
	 *            画面フォーム
	 */
	@RequestMapping(value = "/U01G001/registerHojin", method = RequestMethod.POST)
	public void register(@ModelAttribute U01G001Form form) {
		// ドメイン作成
		KokyakuTantoBushoDomain domain = builKokyakuTantoBushoDomain(form);

		// 検証
		kokyakuTantoBushoService.validate(domain);
		List<Warning> warnings = kokyakuTantoBushoService.warn(domain);
		warnings.size();

		// 登録
		kokyakuTantoBushoService.register(domain);
	}

	/**
	 * 個人顧客の新規登録
	 * 
	 * @param form
	 *            画面フォーム
	 */
	@RequestMapping(value = "/U01G001/registerKojin", method = RequestMethod.POST)
	public void registerKojin(@ModelAttribute U01G001Form form) {

		// 顧客個人ドメイン作成
		KokyakuKojinTantoBushoDomain domain = buildKokyakuKojijnTantoBushoDomainFromForm(form);

		// 検証
		kokyakuKojinTantoBushoService.validate(domain);

		// 登録
		kokyakuKojinTantoBushoService.register(domain);
	}

	// private method
	/**
	 * Formから顧客ドメインを作成.
	 * 
	 * @param form
	 *            フォーム
	 * @return 顧客ドメイン
	 */
	private KokyakuDomain buildKokyakuDomainFromForm(U01G001Form form) {
		BushoDomain shukanBusho = bushoService.getBushoDomain(form.getShukanBushoCode());
		return new KokyakuDomainBuilder().withAddress(form.getAddress())
				.withCode(form.getCode())
				.withGenteiKubun(GenteiKubun.valueOf(form.getGenteiKubun()))
				.withKokyakuKubun(KokyakuKubun.valueOf(form.getKokyakuKubun()))
				.withName(form.getName())
				.withShukanBushoDomain(shukanBusho)
				.build();
	}

	/**
	 * Formから顧客個人ドメインを作成.
	 * 
	 * @param form
	 *            フォーム
	 * @return 顧客個人ドメイン
	 */
	private KokyakuKojinDomain buildKokyakuKojijnDomainFromForm(U01G001Form form) {
		// 主管部署
		BushoDomain shukanBusho = bushoService.getBushoDomain(form.getShukanBushoCode());

		// 親顧客取得
		KokyakuDomain oyaKokyakuDomain = kokyakuService.getKokyakuDomain(form.getOyaKokyakuCode());

		// build
		KokyakuKojinDomainBuilder builder = new KokyakuKojinDomainBuilder();
		KokyakuKojinDomain domain = builder.withAddress(form.getAddress())
				.withCode(form.getCode())
				.withGenteiKubun(GenteiKubun.valueOf(form.getGenteiKubun()))
				.withKokyakuKubun(KokyakuKubun.valueOf(form.getKokyakuKubun()))
				.withName(form.getName())
				.withShukanBushoDomain(shukanBusho)
				.withOyaKokyakuDomain(oyaKokyakuDomain)
				.build();
		return domain;
	}

	/**
	 * Formから顧客担当部署ドメインを作成.
	 * 
	 * @param form
	 *            フォーム
	 * @return 顧客担当部署ドメイン
	 */
	private KokyakuTantoBushoDomain builKokyakuTantoBushoDomain(U01G001Form form) {
		// 顧客ドメイン
		KokyakuDomain kokyakuDomain = buildKokyakuDomainFromForm(form);
		// 担当部署ドメイン
		BushoDomain tantoBushoDomain = bushoService.getBushoDomain(form.getTantoBushoCode());
		// 入金元ドメイン
		NyukinMotoDomain nyukinMotoDomain = buildNyukinMotoDomain(form);
		// 請求先ドメイン
		SeikyuSakiDomain seikyuSakiDomain = buildSeikyuSakiDomain(form);

		// 顧客担当部署ドメイン
		KokyakuTantoBushoDomainBuilder b = new KokyakuTantoBushoDomainBuilder();
		KokyakuTantoBushoDomain domain = b.withBushoDomain(tantoBushoDomain)
				.withKokyakuDomain(kokyakuDomain)
				.withNyukinMotoDomain(nyukinMotoDomain)
				.withSeikyuSakiDomain(seikyuSakiDomain)
				.withSekininshaName(form.getSekininshaName())
				.withShohizeiKubun(ShohizeiKubun.valueOf(form.getShohizeiKubun()))
				.withVersion(form.getKokyakuTantoBushoVersion())
				.build();

		return domain;
	}

	/**
	 * Formから顧客個人担当部署ドメインを作成.
	 * 
	 * @param form
	 *            フォーム
	 * @return 顧客担当部署ドメイン
	 */
	private KokyakuKojinTantoBushoDomain buildKokyakuKojijnTantoBushoDomainFromForm(U01G001Form form) {

		// 顧客ドメイン
		KokyakuKojinDomain kokyakuKojinDomain = buildKokyakuKojijnDomainFromForm(form);
		// 担当部署ドメイン
		BushoDomain tantoBushoDomain = bushoService.getBushoDomain(form.getTantoBushoCode());
		// 入金元ドメイン(親顧客から取得)
		NyukinMotoDomain nyukinMotoDomain = kokyakuTantoBushoService
				.getNyukinMoto(kokyakuKojinDomain.getOyaKokyakuDomain().getCode(), tantoBushoDomain.getCode());

		// 顧客担当部署ドメイン
		KokyakuKojinTantoBushoDomainBuilder b = new KokyakuKojinTantoBushoDomainBuilder();
		KokyakuKojinTantoBushoDomain domain = b.withBushoDomain(tantoBushoDomain)
				.withKokyakuKojinDomain(kokyakuKojinDomain)
				.withNyukinMotoDomain(nyukinMotoDomain)
				// .withSeikyuSakiDomain(seikyuSakiDomain)
				.withSekininshaName(form.getSekininshaName())
				.withShohizeiKubun(ShohizeiKubun.valueOf(form.getShohizeiKubun()))
				.withVersion(form.getKokyakuTantoBushoVersion())
				.build();

		return domain;
	}

	/**
	 * Formから入金元ドメインを作成.
	 * 
	 * @param form
	 *            フォーム
	 * @return 入金元ドメイン
	 */
	private NyukinMotoDomain buildNyukinMotoDomain(U01G001Form form) {

		// 入金掛売情報ドメイン
		NyukinKakeInfoDomain nyukinKakeInfoDomain = buildNyukinKakeInfoDomain(form);

		NyukinMotoDomainBuilder b = new NyukinMotoDomainBuilder();
		NyukinMotoDomain domain = b.withId(form.getNyukinMotoId())
				.withHanbaiKubun(HanbaiKubun.valueOf(form.getHanabaiKubun()))
				.withNyukinKakeInfoDomain(nyukinKakeInfoDomain)
				.withVersion(form.getNyukinMotoVersion())
				.build();
		return domain;
	}

	/**
	 * Formから入金掛売り情報ドメインを作成.
	 * 
	 * @param form
	 *            フォーム
	 * @return 入金掛売情報ドメイン
	 */
	private NyukinKakeInfoDomain buildNyukinKakeInfoDomain(U01G001Form form) {
		NyukinKakeInfoDomainBuilder b = new NyukinKakeInfoDomainBuilder();
		NyukinKakeInfoDomain domain = b.withId(form.getNyukinMotoId())
				.withNyukinDate(form.getNyukinDate())
				.withNyukinHohoKubun(NyukinHohoKubun.valueOf(form.getNyukinHohoKubun()))
				.withNyukinTsukiKubun(NyukinTsukiKubun.valueOf(form.getNyukinTsukiKubun()))
				.withShimeDate(form.getShimeDate())
				.withVersion(form.getNyukinKakeInfoVersion())
				.build();
		return domain;
	}

	/**
	 * Formから請求先ドメインを作成.
	 * 
	 * @param form
	 *            フォーム
	 * @return 請求先ドメイン
	 */
	private SeikyuSakiDomain buildSeikyuSakiDomain(U01G001Form form) {
		// get kubun
		SeikyuKubun seikyuKubun = Kubun.get(SeikyuKubun.class, form.getSeikyuKubun());
		SeikyushoSakuseiBashoKubun seikyushoSakuseiBashoKubun = Kubun.get(SeikyushoSakuseiBashoKubun.class,
				form.getSeikyushoSakuseiBashoKubun());
		// build
		SeikyuSakiDomainBuilder b = new SeikyuSakiDomainBuilder();
		b.withId(form.getSeikyuSakiId());
		b.withSeikyuKubun(seikyuKubun);
		b.withSeikyuSaskiName(form.getSeikyuSakiName());
		b.withSeikyushoSakuseiBashoKubun(seikyushoSakuseiBashoKubun);
		b.withVersion(form.getSeikyuSakiVersion());
		return b.build();
	}
}
