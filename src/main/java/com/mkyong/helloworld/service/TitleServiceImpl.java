package com.mkyong.helloworld.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.mkyong.helloworld.service.dao.TitleDao;
import com.mkyong.helloworld.service.entity.UserEntity;

@Component
@Service
public class TitleServiceImpl implements TitleService {

	@Autowired
	private TitleDao titleDao;

	@Override
	public String getDefaultTitle() {
		return "Hello Spring4 !!";
	}

	@Override
	public String getTitle(UserEntity user) {
		return titleDao.getGreeting(user.locale) + " " + user.name;
	}

}
