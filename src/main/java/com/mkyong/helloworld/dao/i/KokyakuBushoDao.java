package com.mkyong.helloworld.dao.i;

import com.mkyong.helloworld.domain.KokyakuTantoBushoDomain;
import com.mkyong.helloworld.entity.MKokyakuTantoBusho;
import com.mkyong.helloworld.entity.MKokyakuTantoBushoPK;

public interface KokyakuBushoDao {
	/**
	 * 主キーで取得
	 * 
	 * @param id
	 *            主キー
	 * @return エンティティ
	 */
	public MKokyakuTantoBusho getByPrimaryKey(MKokyakuTantoBushoPK id);

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
	 * ドメイン登録
	 * 
	 * @param domain
	 */
	public void register(KokyakuTantoBushoDomain domain);

}
