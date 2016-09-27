package com.mkyong.helloworld.service;

import com.mkyong.helloworld.service.entity.User;

public interface TitleService {
	public String getDefaultTitle();

	public String getTitle(User user);
}
