package com.mkyong.helloworld.kubun;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum DayOfWeek implements Kubun {
	月曜日("1"), 火曜日("2"), 水曜日("3"), 木曜日("4"), 金曜日("5"), 土曜日("6"), 日曜日("7");
	private String code;

	/**
	 * 週末判定
	 * 
	 * @return 土曜、日曜ならtrue
	 */
	public boolean isWeekEnd() {
		if (this == DayOfWeek.日曜日 || this == DayOfWeek.土曜日) {
			return false;
		}
		return true;
	}
}
