package com.mkyong.helloworld.kubun;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum BushoKubun implements Kubun {
	営業所("01"), 本部("99");
	private String code;
}
