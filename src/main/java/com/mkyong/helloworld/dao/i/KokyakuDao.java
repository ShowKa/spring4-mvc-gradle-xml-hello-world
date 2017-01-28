package com.mkyong.helloworld.dao.i;

import java.util.List;

import com.mkyong.helloworld.dao.parameter.KokyakuSearchParameter;
import com.mkyong.helloworld.entity.MKokyaku;

public interface KokyakuDao {
	public MKokyaku getByPrimaryKey(String key);

	public void persist(MKokyaku kokyaku);

	public void delete(MKokyaku kokyaku);

	public List<MKokyaku> search(KokyakuSearchParameter param);

	public List<MKokyaku> searchByName(String name);

}
