package com.mkyong.helloworld.domain;

import com.mkyong.helloworld.system.exception.SystemException;
import com.mkyong.helloworld.value.EigyoDate;
import com.mkyong.helloworld.value.KeijyoDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BushoDateDomain extends AbstractDomain {

	// private members
	private String bushoCode = "";

	private EigyoDate eigyoDate = EigyoDate.EMPTY;

	private KeijyoDate keijoDate = KeijyoDate.EMPTY;

	private int version = 0;

	// public method
	public boolean eigyoDateEqualsKeiyoDate() {
		return this.eigyoDate.equals(this.keijoDate);
	}

	public boolean isEmpty() {
		return this instanceof EmptyBushoDateDomain;
	}

	@Override
	protected boolean equals(AbstractDomain other) {
		BushoDateDomain o = (BushoDateDomain) other;
		return this.bushoCode.equals(o.bushoCode);
	}

	@Override
	public int hashCode() {
		return bushoCode.hashCode();
	}

	@Override
	public void validate() throws SystemException {
	}

	// Empty
	public static final BushoDateDomain EMPTY = EmptyBushoDateDomain.INSTANCE;

}

/**
 * Empty
 * 
 * @author ShowKa
 *
 */
class EmptyBushoDateDomain extends BushoDateDomain {

	public static final EmptyBushoDateDomain INSTANCE = new EmptyBushoDateDomain();

	private EmptyBushoDateDomain() {
		super();
	}

	@Override
	public boolean eigyoDateEqualsKeiyoDate() {
		return false;
	}

}
