package com.mkyong.helloworld.domain.builder;

import com.mkyong.helloworld.domain.SeikyuSakiDomain;
import com.mkyong.helloworld.kubun.SeikyuKubun;
import com.mkyong.helloworld.kubun.SeikyushoSakuseiBashoKubun;

public class SeikyuSakiDomainBuilder extends AbstractDomainBuilder<SeikyuSakiDomain, SeikyuSakiDomainBuilder> {

	// private member
	/** id */
	private Integer id;

	/** seikyuSaskiName */
	private String seikyuSaskiName;

	/** seikyuKubun */
	private SeikyuKubun seikyuKubun;

	/** seikyushoSakuseiBashoKubun */
	private SeikyushoSakuseiBashoKubun seikyushoSakuseiBashoKubun;

	/** version */
	private Integer version;

	// protected method
	@Override
	protected void apply(SeikyuSakiDomain domain, SeikyuSakiDomainBuilder builder) {
		builder.withId(domain.getId());
		builder.withSeikyuSaskiName(domain.getSeikyuSaskiName());
		builder.withSeikyuKubun(domain.getSeikyuKubun());
		builder.withSeikyushoSakuseiBashoKubun(domain.getSeikyushoSakuseiBashoKubun());
		builder.withVersion(domain.getVersion());
	}

	@Override
	protected SeikyuSakiDomain createDomainObject() {
		return new SeikyuSakiDomain(id, seikyuSaskiName, seikyuKubun, seikyushoSakuseiBashoKubun, version);
	}

	@Override
	protected SeikyuSakiDomainBuilder getThis() {
		return this;
	}

	@Override
	protected SeikyuSakiDomainBuilder newInstance() {
		return new SeikyuSakiDomainBuilder();
	}

	// public method
	/**
	 * {@link SeikyuSakiDomain}に与えるidをこのビルダに設定する。
	 *
	 * @param id
	 *            id
	 * @return {@link SeikyuSakiDomainBuilder}
	 */
	public SeikyuSakiDomainBuilder withId(final Integer id) {
		addConfigurator(new BuilderConfigurator<SeikyuSakiDomainBuilder>() {
			@Override
			public void configure(SeikyuSakiDomainBuilder builder) {
				builder.id = id;
			}
		});
		return getThis();
	}

	/**
	 * {@link SeikyuSakiDomain}に与えるseikyuSaskiNameをこのビルダに設定する。
	 *
	 * @param seikyuSaskiName
	 *            seikyuSaskiName
	 * @return {@link SeikyuSakiDomainBuilder}
	 */
	public SeikyuSakiDomainBuilder withSeikyuSaskiName(final String seikyuSaskiName) {
		addConfigurator(new BuilderConfigurator<SeikyuSakiDomainBuilder>() {
			@Override
			public void configure(SeikyuSakiDomainBuilder builder) {
				builder.seikyuSaskiName = seikyuSaskiName;
			}
		});
		return getThis();
	}

	/**
	 * {@link SeikyuSakiDomain}に与えるseikyuKubunをこのビルダに設定する。
	 *
	 * @param seikyuKubun
	 *            seikyuKubun
	 * @return {@link SeikyuSakiDomainBuilder}
	 */
	public SeikyuSakiDomainBuilder withSeikyuKubun(final SeikyuKubun seikyuKubun) {
		addConfigurator(new BuilderConfigurator<SeikyuSakiDomainBuilder>() {
			@Override
			public void configure(SeikyuSakiDomainBuilder builder) {
				builder.seikyuKubun = seikyuKubun;
			}
		});
		return getThis();
	}

	/**
	 * {@link SeikyuSakiDomain}に与えるseikyushoSakuseiBashoKubunをこのビルダに設定する。
	 *
	 * @param seikyushoSakuseiBashoKubun
	 *            seikyushoSakuseiBashoKubun
	 * @return {@link SeikyuSakiDomainBuilder}
	 */
	public SeikyuSakiDomainBuilder withSeikyushoSakuseiBashoKubun(
			final SeikyushoSakuseiBashoKubun seikyushoSakuseiBashoKubun) {
		addConfigurator(new BuilderConfigurator<SeikyuSakiDomainBuilder>() {
			@Override
			public void configure(SeikyuSakiDomainBuilder builder) {
				builder.seikyushoSakuseiBashoKubun = seikyushoSakuseiBashoKubun;
			}
		});
		return getThis();
	}

	/**
	 * {@link SeikyuSakiDomain}に与えるversionをこのビルダに設定する。
	 *
	 * @param version
	 *            version
	 * @return {@link SeikyuSakiDomainBuilder}
	 */
	public SeikyuSakiDomainBuilder withVersion(final Integer version) {
		addConfigurator(new BuilderConfigurator<SeikyuSakiDomainBuilder>() {
			@Override
			public void configure(SeikyuSakiDomainBuilder builder) {
				builder.version = version;
			}
		});
		return getThis();
	}

}