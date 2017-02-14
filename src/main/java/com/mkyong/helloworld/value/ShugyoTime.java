package com.mkyong.helloworld.value;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ShugyoTime extends AbstractValue {

	/** 就業開始時刻 */
	private TheTime start;

	/** 就業終了時刻 */
	private TheTime end;

	/**
	 * 空判定
	 * 
	 * @return 開始、終了時刻ともにnullならtrue
	 */
	@Override
	public boolean isEmpty() {
		if (this.start != null) {
			return false;
		}
		if (this.end != null) {
			return false;
		}
		return true;
	}

	/**
	 * 整合性チェック 緩やかチェック
	 * 
	 * <pre>
	 * 開始、終了時刻が前後してなければtrue
	 * 一方の値がnull、あるいは両方共nullの場合もtrue
	 * 両方値があり、時刻が前後している場合のみfalse
	 * </pre>
	 * 
	 * @return チェック結果
	 */
	public boolean validate() {
		if (this.isEmpty()) {
			return true;
		}
		if (this.start == null) {
			return true;
		}
		if (this.end == null) {
			return true;
		}
		return start.getTime().isBefore(end.getTime());
	}

	/**
	 * 整合性チェック 厳密チェック
	 * 
	 * <pre>
	 * 両方値が設定されていて、時刻が前後していなければtrue
	 * それ以外はfalse
	 * </pre>
	 * 
	 * @return チェック結果
	 */
	public boolean validateStrictly() {
		if (this.isEmpty()) {
			return false;
		}
		if (this.start == null) {
			return false;
		}
		if (this.end == null) {
			return false;
		}
		return start.getTime().isBefore(end.getTime());
	}

	/**
	 * 24時間営業判定
	 * 
	 * @return 開業=00:00 かつ 就業23:59 ならtrue
	 */
	public boolean is24HourEigyo() {

		if (!start.equals(new TheTime(0, 0))) {
			return false;
		}

		if (!end.equals(new TheTime(23, 59))) {
			return false;
		}

		return true;
	}

	/**
	 * 同値判定
	 * 
	 * @return 開始時刻と終了時刻が一致するならtrue
	 */
	@Override
	protected boolean equals(AbstractValue other) {

		// 型不一致ならfalse
		if (!(other instanceof ShugyoTime)) {
			return false;
		}

		// 開始時刻と終了事項が一致するならtrue
		ShugyoTime _other = (ShugyoTime) other;
		if (!this.start.equals(_other.start)) {
			return false;
		}
		if (!this.end.equals(_other.end)) {
			return false;
		}
		return true;
	}
}
