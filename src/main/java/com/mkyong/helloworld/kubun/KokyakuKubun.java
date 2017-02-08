package com.mkyong.helloworld.kubun;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum KokyakuKubun implements Kubun {
	法人("法人", "01"), 個人("個人", "02");
	private String label;
	private String code;
}
