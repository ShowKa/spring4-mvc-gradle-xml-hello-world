package com.mkyong.helloworld.domain.value;

import java.util.Calendar;
import java.util.Date;

import com.mkyong.helloworld.kubun.DayOfWeek;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class DateWithoutTime {
	private int year;
	private int month;
	private int dateOfMonth;

	/**
	 * 同日判定
	 * 
	 * @param dayWithoutTime
	 * @return 同じ日付ならtrue
	 */
	public boolean equals(DateWithoutTime dayWithoutTime) {
		if (this.year == dayWithoutTime.getYear() && this.month == dayWithoutTime.getMonth()
				&& this.dateOfMonth == dayWithoutTime.getDateOfMonth()) {
			return true;
		}
		return false;
	}

	/**
	 * 同日判定
	 * 
	 * @param date
	 * @return 同じ日ならtrue
	 */
	public boolean equals(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(date.getTime());

		if (this.year != cal.get(Calendar.YEAR)) {
			return false;
		}

		if (this.month != cal.get(Calendar.MONTH)) {
			return false;
		}

		if (this.dateOfMonth != cal.get(Calendar.DATE)) {
			return false;
		}

		return true;
	}

	/**
	 * 曜日取得
	 */
	public DayOfWeek getDayOfWeek() {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month - 1, dateOfMonth);
		int dayOfWeek = cal.getFirstDayOfWeek();
		return DayOfWeek.valueOf(String.valueOf(dayOfWeek));
	}

	/**
	 * Date型変換
	 * 
	 * @return Date型
	 */
	public Date toDate() {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month - 1, dateOfMonth, 0, 0, 0);
		return cal.getTime();
	}
}
