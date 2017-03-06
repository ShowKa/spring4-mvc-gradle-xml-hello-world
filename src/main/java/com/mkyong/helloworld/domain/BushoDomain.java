package com.mkyong.helloworld.domain;

import com.mkyong.helloworld.kubun.BushoKubun;
import com.mkyong.helloworld.kubun.JigyoKubun;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class BushoDomain extends AbstractDomain {

	// private member
	private String code;

	private BushoKubun bushoKubun;

	private JigyoKubun jigyoKubun;

	private String name;

	private BushoDateDomain bushoDateDomain;

	private int version;

	// public method
	/**
	 * 営業所判定
	 * 
	 * @return 営業所ならtrue
	 */
	public boolean isEigyosho() {
		if (BushoKubun.営業所 == this.bushoKubun) {
			return true;
		}
		return false;
	}

	/**
	 * 販売事業判定
	 * 
	 * @return 販売事業をしているならtrue
	 */
	public boolean isHanbaiJigyoBusho() {
		if (JigyoKubun.販売 == this.jigyoKubun || JigyoKubun.兼業 == this.jigyoKubun) {
			return true;
		}
		return false;
	}

	/**
	 * レンタル事業判定
	 * 
	 * @return レンタル事業をしているならtrue
	 */
	public boolean isRentalJigyoBusho() {
		if (JigyoKubun.レンタル == this.jigyoKubun || JigyoKubun.兼業 == this.jigyoKubun) {
			return true;
		}
		return false;
	}

	@Override
	protected boolean equals(AbstractDomain other) {
		BushoDomain o = (BushoDomain) other;
		return code.equals(o.code);
	}

	@Override
	public int hashCode() {
		return code.hashCode();
	}

	// private method
}
