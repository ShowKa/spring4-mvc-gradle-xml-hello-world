package com.mkyong.helloworld.domain.builder;

import com.mkyong.helloworld.domain.KokyakuTantoBushoDomain;

public class KokyakuTantoBushoDomainBuilder
		extends AbstractDomainBuilder<KokyakuTantoBushoDomain, KokyakuTantoBushoDomainBuilder> {

	// private member
	/** kokyakuDomain */
	protected com.mkyong.helloworld.domain.KokyakuDomain kokyakuDomain;

	/** budhoDomain */
	protected com.mkyong.helloworld.domain.BushoDomain bushoDomain;

	/** shohizeiKubun */
	protected com.mkyong.helloworld.kubun.ShohizeiKubun shohizeiKubun;

	/** sekininshaName */
	protected java.lang.String sekininshaName;

	/** kokyakuTantoBushoHanbaiDomain */
	protected com.mkyong.helloworld.domain.KokyakuTantoBushoHanbaiDomain kokyakuTantoBushoHanbaiDomain;

	/** kokyakuTantoBushoRentalDomain */
	protected com.mkyong.helloworld.domain.KokyakuTantoBushoRentalDomain kokyakuTantoBushoRentalDomain;

	/** nyukinMotoDomain */
	protected com.mkyong.helloworld.domain.NyukinMotoDomain nyukinMotoDomain;

	/** seikyuSakiDomain */
	protected com.mkyong.helloworld.domain.SeikyuSakiDomain seikyuSakiDomain;

	/** version */
	protected int version;

	// protected method
	@Override
	protected void apply(KokyakuTantoBushoDomain domain, KokyakuTantoBushoDomainBuilder builder) {
		builder.withKokyakuDomain(domain.getKokyakuDomain());
		builder.withBushoDomain(domain.getBushoDomain());
		builder.withShohizeiKubun(domain.getShohizeiKubun());
		builder.withSekininshaName(domain.getSekininshaName());
		builder.withKokyakuTantoBushoHanbaiDomain(domain.getKokyakuTantoBushoHanbaiDomain());
		builder.withKokyakuTantoBushoRentalDomain(domain.getKokyakuTantoBushoRentalDomain());
		builder.withNyukinMotoDomain(domain.getNyukinMotoDomain());
		builder.withSeikyuSakiDomain(domain.getSeikyuSakiDomain());
		builder.withVersion(domain.getVersion());
	}

	@Override
	protected KokyakuTantoBushoDomain createDomainObject() {
		return new KokyakuTantoBushoDomain(kokyakuDomain, bushoDomain, shohizeiKubun, sekininshaName,
				kokyakuTantoBushoHanbaiDomain, kokyakuTantoBushoRentalDomain, nyukinMotoDomain, seikyuSakiDomain,
				version);
	}

	@Override
	protected KokyakuTantoBushoDomainBuilder getThis() {
		return this;
	}

	@Override
	protected KokyakuTantoBushoDomainBuilder newInstance() {
		return new KokyakuTantoBushoDomainBuilder();
	}

	// public method
	/**
	 * {@link KokyakuTantoBushoDomain}に与えるkokyakuDomainをこのビルダに設定する。
	 *
	 * @param kokyakuDomain
	 *            kokyakuDomain
	 * @return {@link KokyakuTantoBushoDomainBuilder}
	 */
	public KokyakuTantoBushoDomainBuilder withKokyakuDomain(
			final com.mkyong.helloworld.domain.KokyakuDomain kokyakuDomain) {
		addConfigurator(new BuilderConfigurator<KokyakuTantoBushoDomainBuilder>() {
			@Override
			public void configure(KokyakuTantoBushoDomainBuilder builder) {
				builder.kokyakuDomain = kokyakuDomain;
			}
		});
		return getThis();
	}

	/**
	 * {@link KokyakuTantoBushoDomain}に与えるbudhoDomainをこのビルダに設定する。
	 *
	 * @param budhoDomain
	 *            budhoDomain
	 * @return {@link KokyakuTantoBushoDomainBuilder}
	 */
	public KokyakuTantoBushoDomainBuilder withBushoDomain(final com.mkyong.helloworld.domain.BushoDomain budhoDomain) {
		addConfigurator(new BuilderConfigurator<KokyakuTantoBushoDomainBuilder>() {
			@Override
			public void configure(KokyakuTantoBushoDomainBuilder builder) {
				builder.bushoDomain = budhoDomain;
			}
		});
		return getThis();
	}

	/**
	 * {@link KokyakuTantoBushoDomain}に与えるshohizeiKubunをこのビルダに設定する。
	 *
	 * @param shohizeiKubun
	 *            shohizeiKubun
	 * @return {@link KokyakuTantoBushoDomainBuilder}
	 */
	public KokyakuTantoBushoDomainBuilder withShohizeiKubun(
			final com.mkyong.helloworld.kubun.ShohizeiKubun shohizeiKubun) {
		addConfigurator(new BuilderConfigurator<KokyakuTantoBushoDomainBuilder>() {
			@Override
			public void configure(KokyakuTantoBushoDomainBuilder builder) {
				builder.shohizeiKubun = shohizeiKubun;
			}
		});
		return getThis();
	}

	/**
	 * {@link KokyakuTantoBushoDomain}に与えるsekininshaNameをこのビルダに設定する。
	 *
	 * @param sekininshaName
	 *            sekininshaName
	 * @return {@link KokyakuTantoBushoDomainBuilder}
	 */
	public KokyakuTantoBushoDomainBuilder withSekininshaName(final java.lang.String sekininshaName) {
		addConfigurator(new BuilderConfigurator<KokyakuTantoBushoDomainBuilder>() {
			@Override
			public void configure(KokyakuTantoBushoDomainBuilder builder) {
				builder.sekininshaName = sekininshaName;
			}
		});
		return getThis();
	}

	/**
	 * {@link KokyakuTantoBushoDomain}に与えるkokyakuTantoBushoHanbaiDomainをこのビルダに設定する。
	 *
	 * @param kokyakuTantoBushoHanbaiDomain
	 *            kokyakuTantoBushoHanbaiDomain
	 * @return {@link KokyakuTantoBushoDomainBuilder}
	 */
	public KokyakuTantoBushoDomainBuilder withKokyakuTantoBushoHanbaiDomain(
			final com.mkyong.helloworld.domain.KokyakuTantoBushoHanbaiDomain kokyakuTantoBushoHanbaiDomain) {
		addConfigurator(new BuilderConfigurator<KokyakuTantoBushoDomainBuilder>() {
			@Override
			public void configure(KokyakuTantoBushoDomainBuilder builder) {
				builder.kokyakuTantoBushoHanbaiDomain = kokyakuTantoBushoHanbaiDomain;
			}
		});
		return getThis();
	}

	/**
	 * {@link KokyakuTantoBushoDomain}に与えるkokyakuTantoBushoRentalDomainをこのビルダに設定する。
	 *
	 * @param kokyakuTantoBushoRentalDomain
	 *            kokyakuTantoBushoRentalDomain
	 * @return {@link KokyakuTantoBushoDomainBuilder}
	 */
	public KokyakuTantoBushoDomainBuilder withKokyakuTantoBushoRentalDomain(
			final com.mkyong.helloworld.domain.KokyakuTantoBushoRentalDomain kokyakuTantoBushoRentalDomain) {
		addConfigurator(new BuilderConfigurator<KokyakuTantoBushoDomainBuilder>() {
			@Override
			public void configure(KokyakuTantoBushoDomainBuilder builder) {
				builder.kokyakuTantoBushoRentalDomain = kokyakuTantoBushoRentalDomain;
			}
		});
		return getThis();
	}

	/**
	 * {@link KokyakuTantoBushoDomain}に与えるnyukinMotoDomainをこのビルダに設定する。
	 *
	 * @param nyukinMotoDomain
	 *            nyukinMotoDomain
	 * @return {@link KokyakuTantoBushoDomainBuilder}
	 */
	public KokyakuTantoBushoDomainBuilder withNyukinMotoDomain(
			final com.mkyong.helloworld.domain.NyukinMotoDomain nyukinMotoDomain) {
		addConfigurator(new BuilderConfigurator<KokyakuTantoBushoDomainBuilder>() {
			@Override
			public void configure(KokyakuTantoBushoDomainBuilder builder) {
				builder.nyukinMotoDomain = nyukinMotoDomain;
			}
		});
		return getThis();
	}

	/**
	 * {@link KokyakuTantoBushoDomain}に与えるseikyuSakiDomainをこのビルダに設定する。
	 *
	 * @param seikyuSakiDomain
	 *            seikyuSakiDomain
	 * @return {@link KokyakuTantoBushoDomainBuilder}
	 */
	public KokyakuTantoBushoDomainBuilder withSeikyuSakiDomain(
			final com.mkyong.helloworld.domain.SeikyuSakiDomain seikyuSakiDomain) {
		addConfigurator(new BuilderConfigurator<KokyakuTantoBushoDomainBuilder>() {
			@Override
			public void configure(KokyakuTantoBushoDomainBuilder builder) {
				builder.seikyuSakiDomain = seikyuSakiDomain;
			}
		});
		return getThis();
	}

	/**
	 * {@link KokyakuTantoBushoDomain}に与えるversionをこのビルダに設定する。
	 *
	 * @param version
	 *            version
	 * @return {@link KokyakuTantoBushoDomainBuilder}
	 */
	public KokyakuTantoBushoDomainBuilder withVersion(final int version) {
		addConfigurator(new BuilderConfigurator<KokyakuTantoBushoDomainBuilder>() {
			@Override
			public void configure(KokyakuTantoBushoDomainBuilder builder) {
				builder.version = version;
			}
		});
		return getThis();
	}

}