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

	@Override
	public boolean isEmpty() {
		if(this.start != null) {
			return false;
		}
		if(this.end != null) {
			return false;
		}
		return true;
	}

	/**
	 * 整合性チェック  緩やかチェック 
	 * <pre>
	 * 開始、終了時刻が前後してなければtrue
	 * 一方の値がnull、あるいは両方共nullの場合もtrue
	 * 両方値があり、時刻が前後している場合のみfalse
	 * </pre>
	 * 
	 * @return チェック結果
	 */
	public boolean validate() {
		if(this.isEmpty()) {
			return true;
		}
		if(this.start == null){
			return true;
		}
		if(this.end == null) {
			return true;
		}
		return start.getTime().isBefore(end.getTime());
	}
	
	/**
	 * 整合性チェック  厳密チェック 
	 * <pre>
	 * 両方値が設定されていて、時刻が前後していなければtrue
	 * それ以外はfalse
	 * </pre>
	 * @return チェック結果
	 */
	public boolean validateStrictly() {
		if(this.isEmpty()) {
			return false;
		}
		if(this.start == null){
			return false;
		}
		if(this.end == null) {
			return false;
		}
		return start.getTime().isBefore(end.getTime());
	}
}
