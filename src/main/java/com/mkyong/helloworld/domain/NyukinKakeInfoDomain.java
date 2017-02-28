package com.mkyong.helloworld.domain;

import java.time.LocalDate;

import com.mkyong.helloworld.kubun.NyukinHohoKubun;
import com.mkyong.helloworld.kubun.NyukinTsukiKubun;
import com.mkyong.helloworld.value.TheDate;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class NyukinKakeInfoDomain extends AbstractDomain {

	// private member
	/** ID */
	Integer id;

	/** 締日 */
	Integer shimeDate;

	/** 入金月区分 */
	NyukinTsukiKubun nyukinTsukiKubun;

	/** 入金方法 */
	NyukinHohoKubun nyukinHohoKubun;

	/** 入金日 */
	Integer nyukinDate;

	/** バージョン(排他制御用) */
	Integer version;

	// public method
	/**
	 * 入金サイト取得
	 * 
	 * <pre>
	 * 入金サイト = 請求締日から入金予定日までの日数
	 * </pre>
	 * 
	 * @return 入金サイト
	 */
	public Integer getNyukinSight() {
		return (30 * nyukinTsukiKubun.getMonthSpan()) + (nyukinDate - shimeDate);
	}

	/**
	 * 引数で渡した日付を基準にして、次の請求締日を取得
	 * 
	 * @param date
	 *            基準日
	 * @return 次の請求締日
	 */
	public TheDate getNextSeikyuSimeDate(TheDate date) {
		LocalDate _d = date.getDate();
		LocalDate shimeDateOfThisMonth = _d.withDayOfMonth(shimeDate);
		if (shimeDateOfThisMonth.getDayOfMonth() > shimeDate) {
			return new TheDate(shimeDateOfThisMonth);
		}
		// 今月締日が過ぎているので来月の締日を返却する。
		return new TheDate(shimeDateOfThisMonth.plusMonths(1));
	}

	/**
	 * 
	 * 引数で渡した日付を基準にして、入金予定日を取得する。
	 * 
	 * @param date
	 *            基準日
	 * @return 入金予定日
	 */
	public TheDate getNyukinYoteiDate(TheDate date) {
		TheDate nextShimeDate = getNextSeikyuSimeDate(date);
		LocalDate nyukinMonth = nextShimeDate.getDate().plusMonths(nyukinTsukiKubun.getMonthSpan());
		return new TheDate(nyukinMonth.withDayOfMonth(nyukinDate));
	}

	/**
	 * 整合性チェック
	 * 
	 * <pre>
	 * 当月入金なのに、締日と入金日が前後していたらfalse
	 * </pre>
	 * 
	 * @return
	 */
	public boolean shimeDateBeforeNyukinDate() {
		if (this.nyukinTsukiKubun != NyukinTsukiKubun.当月) {
			return true;
		}
		if (nyukinDate.compareTo(shimeDate) > 0) {
			return true;
		}
		return false;
	}

	@Override
	protected boolean equals(AbstractDomain other) {
		NyukinKakeInfoDomain o = (NyukinKakeInfoDomain) other;
		return id.equals(o.id);
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}

}
