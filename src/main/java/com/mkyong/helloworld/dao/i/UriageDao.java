package com.mkyong.helloworld.dao.i;

import com.mkyong.helloworld.entity.Uriage;

public interface UriageDao {
	public Uriage getByKey(String seq);

	public void persist(Uriage uriage);

	public void delete(Uriage uriage);

	public void update(Uriage uriage);
}
