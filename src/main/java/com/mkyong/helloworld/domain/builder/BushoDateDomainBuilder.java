package com.mkyong.helloworld.domain.builder;

import com.mkyong.helloworld.domain.BushoDateDomain;
import com.mkyong.helloworld.value.EigyoDate;
import com.mkyong.helloworld.value.KeijyoDate;

public class BushoDateDomainBuilder extends AbstractDomainBuilder<BushoDateDomain, BushoDateDomainBuilder> {

	// private member
	/** 部署コード */
	private String bushoCode;

	/** 営業日 */
	private EigyoDate eigyoDate;

	/** 計上日 */
	private KeijyoDate keijoDate;

	/** バージョン */
	private int version;

	// protected method
	@Override
	protected void apply(BushoDateDomain domain, BushoDateDomainBuilder builder) {
		builder.withBushoCode(domain.getBushoCode());
		builder.withEigyoDate(domain.getEigyoDate());
		builder.withKeijoDate(domain.getKeijoDate());
		builder.withVersion(domain.getVersion());
	}

	@Override
	protected BushoDateDomain createDomainObject() {
		return new BushoDateDomain(bushoCode, eigyoDate, keijoDate, version);
	}

	@Override
	protected BushoDateDomainBuilder getThis() {
		return this;
	}

	@Override
	protected BushoDateDomainBuilder newInstance() {
		return new BushoDateDomainBuilder();
	}

	// public method
	/**
	 * {@link BushoDateDomain}に与える部署コードをこのビルダに設定する。
	 *
	 * @param bushoCode
	 *            部署コード
	 * @return {@link BushoDateDomainBuilder}
	 */
	public BushoDateDomainBuilder withBushoCode(final String bushoCode) {
		addConfigurator(new BuilderConfigurator<BushoDateDomainBuilder>() {
			@Override
			public void configure(BushoDateDomainBuilder builder) {
				builder.bushoCode = bushoCode;
			}
		});
		return getThis();
	}

	/**
	 * {@link BushoDateDomain}に与える営業日をこのビルダに設定する。
	 *
	 * @param eigyoDate
	 *            営業日
	 * @return {@link BushoDateDomainBuilder}
	 */
	public BushoDateDomainBuilder withEigyoDate(final EigyoDate eigyoDate) {
		addConfigurator(new BuilderConfigurator<BushoDateDomainBuilder>() {
			@Override
			public void configure(BushoDateDomainBuilder builder) {
				builder.eigyoDate = eigyoDate;
			}
		});
		return getThis();
	}

	/**
	 * {@link BushoDateDomain}に与える計上日をこのビルダに設定する。
	 *
	 * @param keijoDate
	 *            計上日
	 * @return {@link BushoDateDomainBuilder}
	 */
	public BushoDateDomainBuilder withKeijoDate(final KeijyoDate keijoDate) {
		addConfigurator(new BuilderConfigurator<BushoDateDomainBuilder>() {
			@Override
			public void configure(BushoDateDomainBuilder builder) {
				builder.keijoDate = keijoDate;
			}
		});
		return getThis();
	}

	/**
	 * {@link BushoDateDomain}に与えるバージョンをこのビルダに設定する。
	 *
	 * @param version
	 *            バージョン
	 * @return {@link BushoDateDomainBuilder}
	 */
	public BushoDateDomainBuilder withVersion(final int version) {
		addConfigurator(new BuilderConfigurator<BushoDateDomainBuilder>() {
			@Override
			public void configure(BushoDateDomainBuilder builder) {
				builder.version = version;
			}
		});
		return getThis();
	}

}