package com.mkyong.helloworld.dao.i;

import com.mkyong.helloworld.entity.MKyujitsu;
import com.mkyong.helloworld.entity.MKyujitsuPK;

public interface KyujitsuDao {
	/**
	 * 主キーで取得
	 * 
	 * @param id
	 *            主キー
	 * @return エンティティ
	 */
	public MKyujitsu getByPrimaryKey(MKyujitsuPK id);

	/**
	 * 登録
	 * 
	 * @param entity
	 *            エンティティ
	 */
	public void persist(MKyujitsu entity);

	/**
	 * 更新
	 * 
	 * @param entity
	 *            エンティティ
	 */
	public void update(MKyujitsu entity);

	/**
	 * 削除
	 * 
	 * @param entity
	 *            エンティティ
	 */
	public void delete(MKyujitsu entity);

}
