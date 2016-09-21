package com.mkyong.helloworld.service;

import com.mkyong.helloworld.service.entity.UserEntity;

public interface TitleService {
	public String getDefaultTitle();

	public String getTitle(UserEntity user);
}
