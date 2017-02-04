package com.mkyong.helloworld.service.i;

import com.mkyong.helloworld.domain.KokyakuKojinDomain;

public interface KokyakuKojinService {

	/**
	 * 個人顧客の整合性チェック.
	 * 
	 * <pre>
	 * 以下の条件を満たす。
	 * 区分=個人
	 * 親顧客が設定されている
	 * この個人顧客の担当部署 ∈ 親納品先の担当部署一覧
	 * </pre>
	 * 
	 * @return OKならtrue
	 */
	public boolean validateKojin(KokyakuKojinDomain kokyakuKojin, String tantoBushoCode);

}
