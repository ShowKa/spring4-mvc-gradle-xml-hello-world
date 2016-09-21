package com.mkyong.helloworld.service;

import java.util.Locale;

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

		Locale locale = user.locale;

		String honorificName = null;
		if (locale.equals(Locale.JAPAN)) {
			honorificName = user.name + " " + "San";
		} else if (locale.equals(Locale.CHINA)) {
			honorificName = user.name + " " + "XianSheng";
		} else if (locale.equals(Locale.FRANCE)) {
			honorificName = "Monsieur." + user.name;
		} else {
			honorificName = "Mr." + user.name;
		}

		return titleDao.getGreeting(user.locale) + " " + honorificName;
	}

}
