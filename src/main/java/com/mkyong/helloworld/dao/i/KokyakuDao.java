package com.mkyong.helloworld.dao.i;

import java.util.List;

import com.mkyong.helloworld.dao.parameter.KokyakuSearchParameter;
import com.mkyong.helloworld.domain.KokyakuDomain;
import com.mkyong.helloworld.entity.MKokyaku;

public interface KokyakuDao {
	/**
	 * 主キー検索
	 * 
	 * @param key
	 *            顧客コード
	 * @return 顧客Entity
	 */
	public MKokyaku getByPrimaryKey(String key);

	/**
	 * 永続化
	 * 
	 * @param kokyaku
	 */
	public void persist(MKokyaku kokyaku);

	/**
	 * 削除
	 * 
	 * @param kokyaku
	 */
	public void delete(MKokyaku kokyaku);

	/**
	 * 顧客検索
	 * 
	 * @param param
	 *            検索条件パラメータ
	 * @return 顧客Entity List
	 */
	public List<MKokyaku> search(KokyakuSearchParameter param);

	/**
	 * 顧客名で顧客検索.
	 * 
	 * <pre>
	 * 部分一致検索
	 * </pre>
	 * 
	 * @param name
	 *            顧客名
	 * @return 顧客 Entity List
	 */
	public List<MKokyaku> searchByName(String name);
	
	/**
	 * 顧客ドメイン登録
	 */
	public void register(KokyakuDomain domain);

}
