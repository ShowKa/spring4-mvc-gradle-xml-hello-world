package com.mkyong.helloworld.kubun;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum GenteiKubun implements Kubun {
	限定("限定", "1"), 限定しない("限定しない", "2");
	private String label;
	private String code;
}
