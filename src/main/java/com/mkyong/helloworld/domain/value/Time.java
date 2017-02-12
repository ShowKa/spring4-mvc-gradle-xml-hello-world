package com.mkyong.helloworld.domain.value;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Time {
	private int hour;
	private int minute;
	private int second;
}
