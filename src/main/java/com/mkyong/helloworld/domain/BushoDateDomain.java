package com.mkyong.helloworld.domain;

import com.mkyong.helloworld.value.EigyoDate;
import com.mkyong.helloworld.value.KeijyoDate;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class BushoDateDomain extends AbstractDomain {

	// private members
	private String bushoCode;

	private EigyoDate eigyoDate;

	private KeijyoDate keijoDate;

	private int version;

	// public method
	public boolean eigyoDateEqualsKeiyoDate() {
		return this.eigyoDate.equals(this.keijoDate);
	}
}
