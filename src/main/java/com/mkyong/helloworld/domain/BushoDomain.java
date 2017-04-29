package com.mkyong.helloworld.domain;

import com.mkyong.helloworld.kubun.BushoKubun;
import com.mkyong.helloworld.kubun.JigyoKubun;
import com.mkyong.helloworld.system.exception.SystemException;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BushoDomain extends AbstractDomain {

	// private member
	private String code = "";

	private BushoKubun bushoKubun = BushoKubun.EMPTY;;

	private JigyoKubun jigyoKubun = JigyoKubun.EMPTY;

	private String name = "";

	private BushoDateDomain bushoDateDomain = BushoDateDomain.EMPTY;

	private int version = 0;

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

	public boolean isEmpty() {
		return this instanceof EmptyBushoDomain;
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

	@Override
	public void validate() throws SystemException {
	}

	// Empty
	public static final EmptyBushoDomain EMPTY = EmptyBushoDomain.INSTANCE;

}

/**
 * Empty
 * 
 * @author ShowKa
 *
 */
class EmptyBushoDomain extends BushoDomain {
	public static final EmptyBushoDomain INSTANCE = new EmptyBushoDomain();
}
