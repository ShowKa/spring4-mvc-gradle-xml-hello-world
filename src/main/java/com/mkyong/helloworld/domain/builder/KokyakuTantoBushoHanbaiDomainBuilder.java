package com.mkyong.helloworld.domain.builder;

import com.mkyong.helloworld.domain.KokyakuTantoBushoHanbaiDomain;

public class KokyakuTantoBushoHanbaiDomainBuilder
		extends AbstractDomainBuilder<KokyakuTantoBushoHanbaiDomain, KokyakuTantoBushoHanbaiDomainBuilder> {

	// private member
	/** kokyakuDomain */
	private com.mkyong.helloworld.domain.KokyakuDomain kokyakuDomain;

	/** budhoDomain */
	private com.mkyong.helloworld.domain.BushoDomain bushoDomain;

	/** blockNumber */
	private java.lang.String blockNumber;

	/** version */
	private java.lang.Integer version;

	// protected method
	@Override
	protected void apply(KokyakuTantoBushoHanbaiDomain domain, KokyakuTantoBushoHanbaiDomainBuilder builder) {
		builder.withKokyakuDomain(domain.getKokyakuDomain());
		builder.withBudhoDomain(domain.getBushoDomain());
		builder.withBlockNumber(domain.getBlockNumber());
		builder.withVersion(domain.getVersion());
	}

	@Override
	protected KokyakuTantoBushoHanbaiDomain createDomainObject() {
		return new KokyakuTantoBushoHanbaiDomain(kokyakuDomain, bushoDomain, blockNumber, version);
	}

	@Override
	protected KokyakuTantoBushoHanbaiDomainBuilder getThis() {
		return this;
	}

	@Override
	protected KokyakuTantoBushoHanbaiDomainBuilder newInstance() {
		return new KokyakuTantoBushoHanbaiDomainBuilder();
	}

	// public method
	/**
	 * {@link KokyakuTantoBushoHanbaiDomain}に与えるkokyakuDomainをこのビルダに設定する。
	 *
	 * @param kokyakuDomain
	 *            kokyakuDomain
	 * @return {@link KokyakuTantoBushoHanbaiDomainBuilder}
	 */
	public KokyakuTantoBushoHanbaiDomainBuilder withKokyakuDomain(
			final com.mkyong.helloworld.domain.KokyakuDomain kokyakuDomain) {
		addConfigurator(new BuilderConfigurator<KokyakuTantoBushoHanbaiDomainBuilder>() {
			@Override
			public void configure(KokyakuTantoBushoHanbaiDomainBuilder builder) {
				builder.kokyakuDomain = kokyakuDomain;
			}
		});
		return getThis();
	}

	/**
	 * {@link KokyakuTantoBushoHanbaiDomain}に与えるbudhoDomainをこのビルダに設定する。
	 *
	 * @param budhoDomain
	 *            budhoDomain
	 * @return {@link KokyakuTantoBushoHanbaiDomainBuilder}
	 */
	public KokyakuTantoBushoHanbaiDomainBuilder withBudhoDomain(
			final com.mkyong.helloworld.domain.BushoDomain budhoDomain) {
		addConfigurator(new BuilderConfigurator<KokyakuTantoBushoHanbaiDomainBuilder>() {
			@Override
			public void configure(KokyakuTantoBushoHanbaiDomainBuilder builder) {
				builder.bushoDomain = budhoDomain;
			}
		});
		return getThis();
	}

	/**
	 * {@link KokyakuTantoBushoHanbaiDomain}に与えるblockNumberをこのビルダに設定する。
	 *
	 * @param blockNumber
	 *            blockNumber
	 * @return {@link KokyakuTantoBushoHanbaiDomainBuilder}
	 */
	public KokyakuTantoBushoHanbaiDomainBuilder withBlockNumber(final java.lang.String blockNumber) {
		addConfigurator(new BuilderConfigurator<KokyakuTantoBushoHanbaiDomainBuilder>() {
			@Override
			public void configure(KokyakuTantoBushoHanbaiDomainBuilder builder) {
				builder.blockNumber = blockNumber;
			}
		});
		return getThis();
	}

	/**
	 * {@link KokyakuTantoBushoHanbaiDomain}に与えるversionをこのビルダに設定する。
	 *
	 * @param version
	 *            version
	 * @return {@link KokyakuTantoBushoHanbaiDomainBuilder}
	 */
	public KokyakuTantoBushoHanbaiDomainBuilder withVersion(final java.lang.Integer version) {
		addConfigurator(new BuilderConfigurator<KokyakuTantoBushoHanbaiDomainBuilder>() {
			@Override
			public void configure(KokyakuTantoBushoHanbaiDomainBuilder builder) {
				builder.version = version;
			}
		});
		return getThis();
	}

}