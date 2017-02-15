package com.mkyong.helloworld.domain;

public abstract class AbstractDomain {

	/**
	 * ドメインが空で、意味をなさないオブジェクトであるか判定。
	 * 
	 * @return 空ならtrue
	 * 
	 */
	public abstract boolean isEmpty();

	/**
	 * 同値判定
	 * 
	 * <pre>
	 * 全く同じ存在 (同一部署、同一顧客、同一伝票等) とみなせる場合true
	 * DBテーブルに置ける主キーの値同士を比較して、同一か否かを判定する。
	 * </pre>
	 * 
	 * @param other
	 *            比較対象
	 * @return 同じものならtrue
	 */
	protected abstract boolean equals(AbstractDomain other);

	/**
	 * 同値判定
	 * 
	 * <pre>
	 * 全く同じ存在 (同一部署、同一顧客、同一伝票等) とみなせる場合true
	 * DBテーブルに置ける主キーの値同士を比較して、同一か否かを判定する。
	 * </pre>
	 * 
	 * @param other
	 *            比較対象
	 * @return 同じものならtrue
	 */
	@Override
	public final boolean equals(Object other) {
		if (other == this) {
			return true;
		}

		if (other == null) {
			return false;
		}

		if (other instanceof AbstractDomain) {
			return equals((AbstractDomain) other);
		}
		return false;
	}

	/**
	 * ハッシュコード取得
	 * 
	 * @return ハッシュ値
	 */
	@Override
	public abstract int hashCode();

	/**
	 * ハッシュコード生成用関数
	 * 
	 * @param objects
	 *            equals()で比較対象となるメンバの値を渡してください。
	 * @return ハッシュ値
	 */
	protected final static int generateHashCode(Object... objects) {
		int hash = 1;
		for (Object o : objects) {
			hash = 31 * hash + (o == null ? 0 : o.hashCode());
		}
		return hash;
	}
}
