package com.mkyong.helloworld.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mkyong.helloworld.dao.i.KokyakuBushoDao;
import com.mkyong.helloworld.domain.BushoDomain;
import com.mkyong.helloworld.domain.KokyakuDomain;
import com.mkyong.helloworld.domain.KokyakuKojinDomain;
import com.mkyong.helloworld.domain.KokyakuKojinTantoBushoDomain;
import com.mkyong.helloworld.kubun.CourseCode;
import com.mkyong.helloworld.kubun.ShohizeiKubun;
import com.mkyong.helloworld.service.i.KokyakuKojinService;
import com.mkyong.helloworld.service.i.KokyakuKojinTantoBushoService;
import com.mkyong.helloworld.system.exception.IncorrectKubunException;
import com.mkyong.helloworld.system.exception.ValidateException;

@Component
@Service
@Transactional
public class KokyakuKojinTantoBushoServiceImpl extends KokyakuTantoBushoServiceImpl
		implements KokyakuKojinTantoBushoService {

	@Autowired
	private KokyakuBushoDao kokyakuBushoDao;

	@Autowired
	private KokyakuKojinService kokyakuKojinService;

	/**
	 * 顧客個人整合性検証
	 */
	@Override
	public boolean validate(KokyakuKojinTantoBushoDomain domain) {

		// この個人顧客の担当部署 ∈ 親納品先の担当部署一覧
		KokyakuKojinDomain kojin = domain.getKokyakuKojinDomain();
		KokyakuDomain oya = kojin.getOyaKokyakuDomain();
		BushoDomain tantoBusho = domain.getBushoDomain();
		boolean existsTantoBusho = existsKokyakuTantoBusho(oya.getCode(), tantoBusho.getCode());
		if (!existsTantoBusho) {
			throw new ValidateException("個人顧客の担当部署は、親顧客の担当部署として登録されている必要があります。");
		}

		// 個人顧客の場合、内税
		if (domain.getShohizeiKubun() != ShohizeiKubun.内税) {
			throw new IncorrectKubunException("消費税区分", domain.getShohizeiKubun());
		}

		// 販売部署の場合の整合性検証
		if (domain.isHanbaiBusho()) {
			validateHanbaiBusho(domain);
		}

		// レンタル部署の場合の整合性検証
		if (domain.isRentalBusho()) {
			validateRentalBusho(domain);
		}

		// 基底
		super.validate(domain);

		// 含有ドメインの整合性検証
		kokyakuKojinService.validate(domain.getKokyakuKojinDomain());

		return true;
	}

	/**
	 * 登録
	 */
	@Override
	public void register(KokyakuKojinTantoBushoDomain domain) {
		// 含有ドメイン
		kokyakuKojinService.register(domain.getKokyakuKojinDomain());
		// 登録
		kokyakuBushoDao.register(domain);
	}

	/**
	 * 部署=販売の場合の整合性判定.
	 * 
	 * <pre>
	 * TODO 本当は専用のServiceに定義した方が良い
	 * </pre>
	 */
	@Override
	public void validateHanbaiBusho(KokyakuKojinTantoBushoDomain domain) throws ValidateException {
		if (domain.getKokyakuTantoBushoHanbaiDomain().isHuteiki()) {
			throw new IncorrectKubunException("ブロックNo.", domain.getKokyakuTantoBushoHanbaiDomain().getBlockNumber());
		}
	}

	/**
	 * 部署＝レンタルの場合の整合性検証
	 */
	@Override
	public void validateRentalBusho(KokyakuKojinTantoBushoDomain domain) throws ValidateException {
		CourseCode course = domain.getKokyakuTantoBushoRentalDomain().getCourseCode();
		if (course != CourseCode.ZZZZ) {
			throw new IncorrectKubunException("コースコード", course);
		}
	}
}
