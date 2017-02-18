package com.mkyong.helloworld.dao.i;

import com.mkyong.helloworld.domain.NyukinMotoDomain;
import com.mkyong.helloworld.entity.MNyukinMoto;

public interface NyukinMotoDao {
	/**
	 * 主キーで取得
	 * 
	 * @param id
	 *            主キー
	 * @return エンティティ
	 */
	public MNyukinMoto getByPrimaryKey(Integer id);

	/**
	 * 登録
	 * 
	 * @param entity
	 *            エンティティ
	 */
	public void persist(MNyukinMoto entity);

	/**
	 * 更新
	 * 
	 * @param entity
	 *            エンティティ
	 */
	public void update(MNyukinMoto entity);

	/**
	 * 削除
	 * 
	 * @param entity
	 *            エンティティ
	 */
	public void delete(MNyukinMoto entity);

	/**
	 * ドメイン取得
	 * 
	 * @param id
	 */
	public NyukinMotoDomain getNyukinMotoDomain(Integer id);

}
