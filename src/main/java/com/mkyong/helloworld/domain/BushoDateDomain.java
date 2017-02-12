package com.mkyong.helloworld.domain;

import com.mkyong.helloworld.domain.value.DateWithoutTime;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class BushoDateDomain {

	// private members
	private String bushoCode;

	private DateWithoutTime eigyoDate;

	private DateWithoutTime keijoDate;

	private int version;

	// public method
	public boolean eigyoDateEqualsKeiyoDate() {
		return this.eigyoDate.equals(this.keijoDate);
	}
}
