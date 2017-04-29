package com.mkyong.helloworld.kubun;

import com.mkyong.helloworld.kubun.i.Kubun;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ShohizeiKubun implements Kubun<ShohizeiKubun> {
	内税("01"), 外税("02"), EMPTY("");
	private String code;
}
