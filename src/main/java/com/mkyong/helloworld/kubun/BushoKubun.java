package com.mkyong.helloworld.kubun;

import com.mkyong.helloworld.kubun.i.Kubun;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum BushoKubun implements Kubun<BushoKubun> {
	営業所("01"), 本部("99"), EMPTY("");
	private String code;
}
