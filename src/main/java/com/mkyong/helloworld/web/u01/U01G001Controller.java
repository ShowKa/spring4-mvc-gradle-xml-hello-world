package com.mkyong.helloworld.web.u01;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mkyong.helloworld.domain.BushoDomain;
import com.mkyong.helloworld.domain.KokyakuDomain;
import com.mkyong.helloworld.domain.KokyakuKojinDomain;
import com.mkyong.helloworld.domain.builder.KokyakuDomainBuilder;
import com.mkyong.helloworld.kubun.GenteiKubun;
import com.mkyong.helloworld.kubun.KokyakuKubun;
import com.mkyong.helloworld.service.i.BushoService;
import com.mkyong.helloworld.service.i.KokyakuKojinService;
import com.mkyong.helloworld.service.i.KokyakuService;

@Controller
public class U01G001Controller {

	// service
	@Autowired
	private KokyakuService kokyakuService;
	
	@Autowired
	private KokyakuKojinService kokyakuKojinService;

	@Autowired
	private BushoService bushoService;

	// public method called by request
	@RequestMapping(value = "/U01G001", method = RequestMethod.GET)
	public String index(Map<String, Object> model) {
		return "/u01/u01g001";
	}

	@RequestMapping(value = "/U01G001/search", method = RequestMethod.POST)
	public void search(@ModelAttribute U01G001Form form) {
	}

	@RequestMapping(value = "/U01G001/registerHojin", method = RequestMethod.POST)
	public void registerHojin(@ModelAttribute U01G001Form form) {
		// ドメイン作成
		KokyakuDomain domain = buildKokyakuDomainFromForm(form);
		
		// 検証
		kokyakuService.validateKokyaku(domain);
		kokyakuService.validateKokyakuHojin(domain);

		// 登録
		kokyakuService.registerKokyakuHojin(domain);
	}
	
	@RequestMapping(value = "/U01G001/registerKojin", method = RequestMethod.POST)
	public void registerKojin(@ModelAttribute U01G001Form form) {

		// 顧客個人ドメイン作成
		KokyakuKojinDomain domain = buildKokyakuKojijnDomainFromForm(form);

		// 検証
		kokyakuService.validateKokyaku(domain);
		kokyakuKojinService.validateKokyakuKojin(domain);

		// 登録
		kokyakuKojinService.registerKokyakuKojin(domain);
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
		BushoDomain shukanBudho = bushoService.getBushoDomain(form.getShukanBushoCode());
		return new KokyakuDomainBuilder().withAddress(form.getAddress())
				.withCode(form.getCode())
				.withGenteiKubun(GenteiKubun.valueOf(form.getGenteiKubun()))
				.withKokyakuKubun(KokyakuKubun.valueOf(form.getKokyakuKubun()))
				.withName(form.getName())
				.withShukanBushoDomain(shukanBudho)
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
		KokyakuDomain kokyakuDomain = buildKokyakuDomainFromForm(form);
		// FIXME
		return (KokyakuKojinDomain) kokyakuDomain;
	}
}
