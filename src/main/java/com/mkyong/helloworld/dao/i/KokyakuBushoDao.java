package com.mkyong.helloworld.dao.i;

import com.mkyong.helloworld.domain.KokyakuTantoBushoDomain;
import com.mkyong.helloworld.entity.MKokyakuBusho;
import com.mkyong.helloworld.entity.MKokyakuBushoPK;

public interface KokyakuBushoDao {
	/**
	 * 主キーで取得
	 * 
	 * @param id
	 *            主キー
	 * @return エンティティー
	 */
	public MKokyakuBusho getByPrimaryKey(MKokyakuBushoPK id);

	/**
	 * 永続化
	 * 
	 * @param entity
	 *            エンティティー
	 */
	public void persist(MKokyakuBusho entity);

	/**
	 * 削除
	 * 
	 * @param entity
	 *            エンティティー
	 */
	public void delete(MKokyakuBusho entity);

	/**
	 * 顧客担当部署ドメインを取得
	 * 
	 * @param pk
	 *            顧客コード、部署コード
	 * @return 顧客担当部署ドメイン
	 */
	public KokyakuTantoBushoDomain getKokyakuTantoBushoDomain(MKokyakuBushoPK id);

}
