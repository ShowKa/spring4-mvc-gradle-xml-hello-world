package com.mkyong.helloworld.kubun;

import lombok.Getter;

@Getter
public enum GenteiKubun implements Kubun {
	限定("01"), 限定しない("02");
	private String code;

	GenteiKubun(String code) {
		this.code = code;
	}
}
