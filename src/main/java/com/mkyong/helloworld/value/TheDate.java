package com.mkyong.helloworld.value;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;

import lombok.Getter;

@Getter
public class TheDate {
	private LocalDate date;

	public TheDate(LocalDate date) {
		this.date = date;
	}

	public TheDate(java.util.Date date) {
		this.date = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}

	public TheDate(Calendar calendar) {
		int y = calendar.get(Calendar.YEAR);
		int m = calendar.get(Calendar.MONTH);
		int d = calendar.get(Calendar.DATE);
		this.date = LocalDate.of(y, m, d);
	}

	public TheDate(int year, int month, int date) {
		this.date = LocalDate.of(year, month, date);
	}

	public java.util.Date toDate() {
		return java.util.Date.from(this.date.atStartOfDay(ZoneId.systemDefault()).toInstant());
	}

	public Calendar toCalendar() {
		Calendar c = Calendar.getInstance();
		c.set(date.getYear(), date.getMonthValue(), date.getDayOfMonth());
		return c;
	}
}
