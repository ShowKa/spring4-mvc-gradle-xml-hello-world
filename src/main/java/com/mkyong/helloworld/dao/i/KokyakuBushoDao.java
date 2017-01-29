package com.mkyong.helloworld.dao.i;

import com.mkyong.helloworld.domain.KokyakuDomain;
import com.mkyong.helloworld.domain.KokyakuKojinDomain;
import com.mkyong.helloworld.entity.MKokyakuBushoId;

public interface KokyakuBushoDao {
	/**
	 * 顧客ドメインを取得
	 * 
	 * @param pk
	 *            顧客コード、部署コード
	 * @return 顧客ドメイン
	 */
	public KokyakuDomain getKokyakuDomain(MKokyakuBushoId pk);

	/**
	 * 個人の顧客ドメインを取得
	 * 
	 * @param pk
	 *            顧客コード、部署コード
	 * @return 個人顧客ドメイン
	 */
	public KokyakuKojinDomain getKokyakuKojinDomain(MKokyakuBushoId pk);
}
