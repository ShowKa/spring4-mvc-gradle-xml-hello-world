package com.mkyong.helloworld.dao.i;

import com.mkyong.helloworld.domain.KokyakuTantoBushoDomain;
import com.mkyong.helloworld.entity.MKokyakuTantoBusho;
import com.mkyong.helloworld.entity.MKokyakuTantoBushoId;

public interface KokyakuBushoDao {
	/**
	 * 主キーで取得
	 * 
	 * @param id
	 *            主キー
	 * @return エンティティ
	 */
	public MKokyakuTantoBusho getByPrimaryKey(MKokyakuTantoBushoId id);

	/**
	 * 登録
	 * 
	 * @param entity
	 *            エンティティ
	 */
	public void persist(MKokyakuTantoBusho entity);

	/**
	 * 更新
	 * 
	 * @param entity
	 *            エンティティ
	 */
	public void update(MKokyakuTantoBusho entity);

	/**
	 * 削除
	 * 
	 * @param entity
	 *            エンティティ
	 */
	public void delete(MKokyakuTantoBusho entity);

	/**
	 * ドメイン取得
	 * 
	 * @param kokyakuCode
	 *            顧客コード
	 * @param bushoCode
	 *            部署コード
	 * @return 顧客担当部署ドメイン
	 */
	public KokyakuTantoBushoDomain getDomain(String kokyakuCode, String bushoCode);

	/**
	 * ドメイン登録
	 * 
	 * @param domain
	 */
	public void register(KokyakuTantoBushoDomain domain);

}
