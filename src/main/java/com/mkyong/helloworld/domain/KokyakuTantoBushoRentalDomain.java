package com.mkyong.helloworld.domain;

import com.mkyong.helloworld.kubun.CourseCode;
import com.mkyong.helloworld.system.exception.SystemException;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class KokyakuTantoBushoRentalDomain extends AbstractDomain {

	// private members
	/** 顧客ドメイン */
	private KokyakuDomain kokyakuDomain;

	/** 部署ドメイン */
	private BushoDomain bushoDomain;

	/** コースコード */
	private CourseCode courseCode;

	/** バージョン（排他制御用） */
	private Integer version;

	// public method
	@Override
	protected boolean equals(AbstractDomain other) {
		KokyakuTantoBushoRentalDomain o = (KokyakuTantoBushoRentalDomain) other;
		return (this.kokyakuDomain.equals(o.kokyakuDomain) && this.bushoDomain.equals(o.bushoDomain));
	}

	@Override
	public int hashCode() {
		return generateHashCode(this.kokyakuDomain.hashCode(), this.bushoDomain.hashCode());
	}

	@Override
	public void validate() throws SystemException {
	}

	// Empty
	public static final KokyakuTantoBushoRentalDomain EMPTY = EmptyKokyakuTantoBushoRentalDomain.INSTANCE;
}

/**
 * Empty
 * 
 * @author ShowKa
 *
 */
class EmptyKokyakuTantoBushoRentalDomain extends KokyakuTantoBushoRentalDomain {
	public static final EmptyKokyakuTantoBushoRentalDomain INSTANCE = new EmptyKokyakuTantoBushoRentalDomain();

	private EmptyKokyakuTantoBushoRentalDomain() {
		super();
	}
}
