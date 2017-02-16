package com.mkyong.helloworld.kubun;

import com.mkyong.helloworld.kubun.i.Kubun;
import com.mkyong.helloworld.system.exception.ApplicationException;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum NyukinTsukiKubun implements Kubun {
	当月("00"), 翌月("10"), 翌々月("20");
	String code;

	/**
	 * 当月=0として、月のスパンを返却する
	 * 
	 * @return
	 */
	public int getMonthSpan() {
		switch (this) {
		case 当月:
			return 0;
		case 翌月:
			return 1;
		case 翌々月:
			return 2;
		}
		throw new ApplicationException("存在しない区分");
	}
}
