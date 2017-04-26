package com.mkyong.helloworld.kubun;

import com.mkyong.helloworld.kubun.i.Kubun;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum BlockNumber implements Kubun {
	AA("AA"), ZZ("ZZ"), 未設定("");
	private String code;

	public boolean isHuteiki() {
		return this == ZZ;
	}
}
