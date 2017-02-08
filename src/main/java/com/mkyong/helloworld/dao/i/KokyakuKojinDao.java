package com.mkyong.helloworld.dao.i;

import com.mkyong.helloworld.entity.MKokyakuKojin;

/**
 * 顧客個人DAO
 * 
 * @author ShowKa
 *
 */
public interface KokyakuKojinDao {
	/**
	 * 主キーで取得
	 * 
	 * @param key
	 *            個人顧客コード
	 * @return 顧客個人Entity
	 */
	public MKokyakuKojin getByPrimaryKey(String key);

	/**
	 * 永続化
	 * 
	 * @param kokyakuKojin
	 */
	public void persist(MKokyakuKojin kokyakuKojin);

	/**
	 * 削除
	 * 
	 * @param kokyakuKojin
	 */
	public void delete(MKokyakuKojin kokyakuKojin);

}
