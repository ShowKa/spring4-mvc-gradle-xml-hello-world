package com.mkyong.helloworld.kubun;

import com.mkyong.helloworld.kubun.i.Kubun;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum JigyoKubun implements Kubun<JigyoKubun> {
	販売("01"), レンタル("02"), 兼業("10"), EMPTY("");
	private String code;
}
