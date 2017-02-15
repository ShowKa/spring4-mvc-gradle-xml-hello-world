package com.mkyong.helloworld.value;

import java.math.BigDecimal;

import com.mkyong.helloworld.system.exception.ApplicationException;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Kakaku extends AbstractValue {

	/** 税抜価格 */
	BigDecimal kakaku;

	/** 税(小数) */
	BigDecimal zei;

	@Override
	public boolean isEmpty() {
		return kakaku == null;
	}

	/**
	 * 価格と税が同じなら一致とみなす.
	 */
	@Override
	protected boolean equals(AbstractValue other) {
		Kakaku o = (Kakaku) other;
		if (!kakaku.equals(o.kakaku)) {
			return false;
		}
		if (!zei.equals(o.zei)) {
			return false;
		}
		return true;
	}

	/**
	 * 税込価格取得
	 * 
	 * <pre>
	 * 端数がある場合は、ゼロに近づける。
	 * 絶対値が同じ場合、負の価格であっても、正の価格の場合と同じ値になる。
	 * </pre>
	 * 
	 * @return 税込価格
	 */
	public BigDecimal getZeikomiKakaku() {
		return kakaku.multiply(zei.add(BigDecimal.ONE)).setScale(0, BigDecimal.ROUND_DOWN);
	}

	/**
	 * 価格加算
	 * 
	 * <pre>
	 * 税率が一致しない場合はエラー
	 * </pre>
	 * 
	 * @param other
	 *            加算対象
	 * @return 加算後の価格
	 */
	public Kakaku add(Kakaku other) {
		if (!zei.equals(other.zei)) {
			throw new ApplicationException("加算対象の金額の税率が一致しません。");
		}
		return new Kakaku(kakaku.add(other.kakaku), zei);
	}

	/**
	 * 価格加算
	 * 
	 * <pre>
	 * 税率が一致しない場合はエラー
	 * </pre>
	 * 
	 * @param others
	 *            加算対象
	 * @return 加算後の価格
	 */
	public Kakaku add(Kakaku... others) {
		Kakaku base = new Kakaku(this.kakaku, this.zei);
		for (Kakaku o : others) {
			if (!zei.equals(o.zei)) {
				throw new ApplicationException("AP0005");
			}
			base = base.add(o);
		}
		return base;
	}

	/**
	 * 価格減算
	 * 
	 * <pre>
	 * 税率が一致しない場合はエラー
	 * </pre>
	 * 
	 * @param other
	 *            減算対象
	 * @return 減算後の価格
	 */
	public Kakaku subscribe(Kakaku other) {
		if (!zei.equals(other.zei)) {
			throw new ApplicationException("AP0005");
		}
		return new Kakaku(kakaku.subtract(other.kakaku), zei);
	}
}
