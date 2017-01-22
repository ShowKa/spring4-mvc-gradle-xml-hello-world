package com.mkyong.helloworld.web.u01;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class U01G001Controller {

	@RequestMapping(value = "/U01G001", method = RequestMethod.GET)
	public String index(Map<String, Object> model) {

		return "/u01/u01g001";
	}
}
