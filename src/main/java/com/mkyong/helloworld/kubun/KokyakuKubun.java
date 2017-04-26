package com.mkyong.helloworld.kubun;

import com.mkyong.helloworld.kubun.i.Kubun;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum KokyakuKubun implements Kubun {
	通常法人("01"), 個人("02"), カフェラウンジ("03"), 特殊("99"), 未設定("");
	private String code;
}
