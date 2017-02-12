package com.mkyong.helloworld.dao.i;

import com.mkyong.helloworld.domain.BushoDomain;
import com.mkyong.helloworld.entity.MBusho;

public interface BushoDao {
	/**
	 * 主キーで取得
	 * 
	 * @param id
	 *            主キー
	 * @return エンティティ
	 */
	public MBusho getByPrimaryKey(String id);

	/**
	 * 登録
	 * 
	 * @param entity
	 *            エンティティ
	 */
	public void persist(MBusho entity);

	/**
	 * 更新
	 * 
	 * @param entity
	 *            エンティティ
	 */
	public void update(MBusho entity);

	/**
	 * 削除
	 * 
	 * @param entity
	 *            エンティティ
	 */
	public void delete(MBusho entity);

	/**
	 * 部署ドメイン取得
	 * 
	 * @param bushoCode
	 *            部署コード
	 * @return 部署ドメイン
	 */
	public BushoDomain getBushoDomain(String bushoCode);

}
