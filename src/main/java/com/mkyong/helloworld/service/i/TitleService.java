package com.mkyong.helloworld.service.i;

import com.mkyong.helloworld.entity.User;

public interface TitleService {
	public String getDefaultTitle();

	public String getTitle(User user);
}
