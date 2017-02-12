package com.mkyong.helloworld.dao.i;

import com.mkyong.helloworld.domain.BushoDateDomain;
import com.mkyong.helloworld.entity.MBushoDate;

public interface BushoDateDao {
	/**
	 * 主キーで取得
	 * 
	 * @param id
	 *            主キー
	 * @return エンティティ
	 */
	public MBushoDate getByPrimaryKey(String id);

	/**
	 * 登録
	 * 
	 * @param entity
	 *            エンティティ
	 */
	public void persist(MBushoDate entity);

	/**
	 * 更新
	 * 
	 * @param entity
	 *            エンティティ
	 */
	public void update(MBushoDate entity);

	/**
	 * 削除
	 * 
	 * @param entity
	 *            エンティティ
	 */
	public void delete(MBushoDate entity);

	/**
	 * 部署ドメイン取得
	 * 
	 * @param bushoCode
	 *            部署コード
	 * @return 部署ドメイン
	 */
	public BushoDateDomain getBushoDateDomain(String bushoCode);

}
