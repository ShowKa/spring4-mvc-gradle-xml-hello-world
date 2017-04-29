package com.mkyong.helloworld.value;

import java.time.LocalDate;
import java.util.Calendar;

public class EigyoDate extends TheDate {
	public EigyoDate(Calendar calendar) {
		super(calendar);
	}

	public EigyoDate(int year, int month, int date) {
		super(year, month, date);
	}

	public EigyoDate(LocalDate date) {
		super(date);
	}

	public EigyoDate(java.util.Date date) {
		super(date);
	}

	public static final EmptyEigyoDate EMPTY = EmptyEigyoDate.SINGLETON_INSTANCE;

}

class EmptyEigyoDate extends EigyoDate {

	public static final EmptyEigyoDate SINGLETON_INSTANCE = new EmptyEigyoDate();

	private EmptyEigyoDate() {
		super(LocalDate.MIN);
	}

}