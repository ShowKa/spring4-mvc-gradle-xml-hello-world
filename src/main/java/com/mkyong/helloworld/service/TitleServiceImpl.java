package com.mkyong.helloworld.service;

import org.springframework.stereotype.Component;

@Component
public class TitleServiceImpl implements TitleService {

	@Override
	public String getDefaultTitle() {
		return "Helle Spring4 !!";
	}

}
