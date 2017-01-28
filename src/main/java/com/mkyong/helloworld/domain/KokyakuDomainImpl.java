package com.mkyong.helloworld.domain;

import com.mkyong.helloworld.domain.i.KokyakuDomain;
import com.mkyong.helloworld.entity.MKokyaku;
import com.mkyong.helloworld.entity.MKokyakuBusho;
import com.mkyong.helloworld.kubun.GenteiKubun;
import com.mkyong.helloworld.kubun.KokyakuKubun;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class KokyakuDomainImpl implements KokyakuDomain {
	private MKokyaku kokyaku;
	private MKokyakuBusho kokyakuBusho;

	/**
	 * 個人限定判定
	 * 
	 * @retrun 個人限定顧客ならtrue
	 */
	@Override
	public boolean isKojinGentei() {
		if (isKojin() && GenteiKubun.限定.getLabel().equals(kokyaku.getGenteiKubun())) {
			return true;
		}
		return false;
	}

	private boolean isKojin() {
		if (KokyakuKubun.個人.getLabel().equals(kokyaku.getKokyakuKubun())) {
			return true;
		}
		return false;
	}
}
