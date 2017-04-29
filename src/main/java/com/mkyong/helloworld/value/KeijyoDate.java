package com.mkyong.helloworld.value;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class KeijyoDate extends TheDate {

	public KeijyoDate(Calendar calendar) {
		super(calendar);
	}

	public KeijyoDate(Date date) {
		super(date);
	}

	public KeijyoDate(int year, int month, int date) {
		super(year, month, date);
	}

	public KeijyoDate(LocalDate date) {
		super(date);
	}

	public static final EmptyKeijoDate EMPTY = EmptyKeijoDate.SINGLETON_INSTANCE;

}

class EmptyKeijoDate extends KeijyoDate {

	public static final EmptyKeijoDate SINGLETON_INSTANCE = new EmptyKeijoDate();

	private EmptyKeijoDate() {
		super(LocalDate.MIN);
	}

}
