package com.mkyong.helloworld.dao.i;

import com.mkyong.helloworld.domain.NyukinKakeInfoDomain;
import com.mkyong.helloworld.entity.MNyukinKakeInfo;

public interface NyukinKakeInfoDao {
	/**
	 * 主キーで取得
	 * 
	 * @param id
	 *            主キー
	 * @return エンティティ
	 */
	public MNyukinKakeInfo getByPrimaryKey(Integer id);

	/**
	 * 登録
	 * 
	 * @param entity
	 *            エンティティ
	 */
	public void persist(MNyukinKakeInfo entity);

	/**
	 * 更新
	 * 
	 * @param entity
	 *            エンティティ
	 */
	public void update(MNyukinKakeInfo entity);

	/**
	 * 削除
	 * 
	 * @param entity
	 *            エンティティ
	 */
	public void delete(MNyukinKakeInfo entity);

	/**
	 * ドメイン取得
	 * 
	 * @param id
	 */
	public NyukinKakeInfoDomain getNyukinKakeInfoDomain(Integer id);

	/**
	 * ドメイン登録
	 * 
	 * @param domain
	 */
	public void register(NyukinKakeInfoDomain domain);
}
