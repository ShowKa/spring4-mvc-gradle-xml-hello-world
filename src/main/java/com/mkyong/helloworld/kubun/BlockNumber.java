package com.mkyong.helloworld.kubun;

import com.mkyong.helloworld.kubun.i.Kubun;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum BlockNumber implements Kubun<BlockNumber> {
	AA("AA"), ZZ("ZZ"), EMPTY("");
	private String code;

	public boolean isHuteiki() {
		return this == ZZ;
	}
}
