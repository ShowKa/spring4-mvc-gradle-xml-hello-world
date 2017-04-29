package com.mkyong.helloworld.kubun;

import com.mkyong.helloworld.kubun.i.Kubun;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum GenteiKubun implements Kubun<GenteiKubun> {
	限定("01"), 限定しない("02"), EMPTY("");
	private String code;
}
