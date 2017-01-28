package com.mkyong.helloworld.service;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mkyong.helloworld.dao.i.CountryDao;
import com.mkyong.helloworld.dao.i.GreetingDao;
import com.mkyong.helloworld.entity.User;
import com.mkyong.helloworld.service.i.TitleService;

@Component
@Service
@Transactional
public class TitleServiceImpl implements TitleService {

	@Autowired
	private GreetingDao titleDao;

	@Autowired
	private CountryDao countyDao;

	@Override
	public String getDefaultTitle() {
		return "Hello Spring4 !!";
	}

	@Override
	public String getTitle(User user) {

		Locale locale = user.locale;

		// honorific
		String honorificName = null;
		Integer countryId = null;
		if (locale.equals(Locale.JAPAN)) {
			honorificName = user.name + " " + "San";
			countryId = 50;
		} else if (locale.equals(Locale.CHINA)) {
			honorificName = user.name + " " + "XianSheng";
			countryId = 23;
		} else if (locale.equals(Locale.FRANCE)) {
			honorificName = "Monsieur." + user.name;
			countryId = 34;
		} else {
			honorificName = "Mr." + user.name;
		}

		// country
		String country = null;
		if (countryId != null) {
			country = countyDao.getByPrimaryKey(countryId).country;
		} else {
			country = "Somewhere";
		}

		return titleDao.getGreeting(user.locale) + " " + honorificName + " from " + country;
	}

}
