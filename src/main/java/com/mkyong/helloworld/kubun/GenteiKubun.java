package com.mkyong.helloworld.kubun;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum GenteiKubun implements Kubun {
	限定("01"), 限定しない("02");
	private String code;
}
