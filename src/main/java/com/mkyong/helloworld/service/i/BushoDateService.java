package com.mkyong.helloworld.service.i;

import com.mkyong.helloworld.domain.value.DateWithoutTime;

public interface BushoDateService {
	/**
	 * 営業日判定
	 * 
	 * @param bushoCode
	 *            部署コード
	 * @param date
	 *            対象日付
	 * @return 対象日付が営業日ならtrue
	 */
	public boolean isEigyoDate(String bushoCode, DateWithoutTime date);
}
