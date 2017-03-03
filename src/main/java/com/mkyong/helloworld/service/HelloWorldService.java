package com.mkyong.helloworld.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mkyong.helloworld.entity.User;
import com.mkyong.helloworld.service.i.TitleService;

@Component
@Service
@Transactional
public class HelloWorldService {

	@Autowired
	private TitleService titleService;

	private static final Logger logger = LoggerFactory.getLogger(HelloWorldService.class);

	public String getDesc() {

		logger.debug("getDesc() is executed!");

		return "Gradle + Spring MVC Hello World Example";

	}

	public String getDefaultTitle() {
		return titleService.getDefaultTitle();
	}

	public String getTitle(User user) {

		String name = user.name;

		logger.debug("getTitle() is executed! $name : {}", name);

		return titleService.getTitle(user);

	}

}