package com.mkyong.helloworld.kubun;

import com.mkyong.helloworld.kubun.i.Kubun;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum HanbaiKubun implements Kubun {
	現金("00"), 掛売("10"), 未設定("");
	String code;
}
