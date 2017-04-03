package com.mkyong.helloworld.domain.builder;

import com.mkyong.helloworld.domain.KokyakuKojinTantoBushoDomain;

public class KokyakuKojinTantoBushoDomainBuilder
		extends AbstractDomainBuilder<KokyakuKojinTantoBushoDomain, KokyakuKojinTantoBushoDomainBuilder> {

	// private member
	/** kokyakuKojinDomain */
	private com.mkyong.helloworld.domain.KokyakuKojinDomain kokyakuKojinDomain;

	/** bushoDomain */
	private com.mkyong.helloworld.domain.BushoDomain bushoDomain;

	/** shohizeiKubun */
	private com.mkyong.helloworld.kubun.ShohizeiKubun shohizeiKubun;

	/** sekininshaName */
	private java.lang.String sekininshaName;

	/** kokyakuTantoBushoHanbaiDomain */
	private com.mkyong.helloworld.domain.KokyakuTantoBushoHanbaiDomain kokyakuTantoBushoHanbaiDomain;

	/** kokyakuTantoBushoRentalDomain */
	private com.mkyong.helloworld.domain.KokyakuTantoBushoRentalDomain kokyakuTantoBushoRentalDomain;

	/** nyukinMotoDomain */
	private com.mkyong.helloworld.domain.NyukinMotoDomain nyukinMotoDomain;

	/** seikyuSakiDomain */
	private com.mkyong.helloworld.domain.SeikyuSakiDomain seikyuSakiDomain;

	/** version */
	private int version;

	// protected method
	@Override
	protected void apply(KokyakuKojinTantoBushoDomain domain, KokyakuKojinTantoBushoDomainBuilder builder) {
		builder.withKokyakuKojinDomain(domain.getKokyakuKojinDomain());
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
	protected KokyakuKojinTantoBushoDomain createDomainObject() {
		return new KokyakuKojinTantoBushoDomain(kokyakuKojinDomain, bushoDomain, shohizeiKubun, sekininshaName,
				kokyakuTantoBushoHanbaiDomain, kokyakuTantoBushoRentalDomain, nyukinMotoDomain, seikyuSakiDomain,
				version);
	}

	@Override
	protected KokyakuKojinTantoBushoDomainBuilder getThis() {
		return this;
	}

	@Override
	protected KokyakuKojinTantoBushoDomainBuilder newInstance() {
		return new KokyakuKojinTantoBushoDomainBuilder();
	}

	// public method
	/**
	 * {@link KokyakuKojinTantoBushoDomain}に与えるkokyakuKojinDomainをこのビルダに設定する。
	 *
	 * @param kokyakuKojinDomain
	 *            kokyakuKojinDomain
	 * @return {@link KokyakuKojinTantoBushoDomainBuilder}
	 */
	public KokyakuKojinTantoBushoDomainBuilder withKokyakuKojinDomain(
			final com.mkyong.helloworld.domain.KokyakuKojinDomain kokyakuKojinDomain) {
		addConfigurator(new BuilderConfigurator<KokyakuKojinTantoBushoDomainBuilder>() {
			@Override
			public void configure(KokyakuKojinTantoBushoDomainBuilder builder) {
				builder.kokyakuKojinDomain = kokyakuKojinDomain;
			}
		});
		return getThis();
	}

	/**
	 * {@link KokyakuKojinTantoBushoDomain}に与えるbushoDomainをこのビルダに設定する。
	 *
	 * @param bushoDomain
	 *            bushoDomain
	 * @return {@link KokyakuKojinTantoBushoDomainBuilder}
	 */
	public KokyakuKojinTantoBushoDomainBuilder withBushoDomain(
			final com.mkyong.helloworld.domain.BushoDomain bushoDomain) {
		addConfigurator(new BuilderConfigurator<KokyakuKojinTantoBushoDomainBuilder>() {
			@Override
			public void configure(KokyakuKojinTantoBushoDomainBuilder builder) {
				builder.bushoDomain = bushoDomain;
			}
		});
		return getThis();
	}

	/**
	 * {@link KokyakuKojinTantoBushoDomain}に与えるshohizeiKubunをこのビルダに設定する。
	 *
	 * @param shohizeiKubun
	 *            shohizeiKubun
	 * @return {@link KokyakuKojinTantoBushoDomainBuilder}
	 */
	public KokyakuKojinTantoBushoDomainBuilder withShohizeiKubun(
			final com.mkyong.helloworld.kubun.ShohizeiKubun shohizeiKubun) {
		addConfigurator(new BuilderConfigurator<KokyakuKojinTantoBushoDomainBuilder>() {
			@Override
			public void configure(KokyakuKojinTantoBushoDomainBuilder builder) {
				builder.shohizeiKubun = shohizeiKubun;
			}
		});
		return getThis();
	}

	/**
	 * {@link KokyakuKojinTantoBushoDomain}に与えるsekininshaNameをこのビルダに設定する。
	 *
	 * @param sekininshaName
	 *            sekininshaName
	 * @return {@link KokyakuKojinTantoBushoDomainBuilder}
	 */
	public KokyakuKojinTantoBushoDomainBuilder withSekininshaName(final java.lang.String sekininshaName) {
		addConfigurator(new BuilderConfigurator<KokyakuKojinTantoBushoDomainBuilder>() {
			@Override
			public void configure(KokyakuKojinTantoBushoDomainBuilder builder) {
				builder.sekininshaName = sekininshaName;
			}
		});
		return getThis();
	}

	/**
	 * {@link KokyakuKojinTantoBushoDomain}に与えるkokyakuTantoBushoHanbaiDomainをこのビルダに設定する。
	 *
	 * @param kokyakuTantoBushoHanbaiDomain
	 *            kokyakuTantoBushoHanbaiDomain
	 * @return {@link KokyakuKojinTantoBushoDomainBuilder}
	 */
	public KokyakuKojinTantoBushoDomainBuilder withKokyakuTantoBushoHanbaiDomain(
			final com.mkyong.helloworld.domain.KokyakuTantoBushoHanbaiDomain kokyakuTantoBushoHanbaiDomain) {
		addConfigurator(new BuilderConfigurator<KokyakuKojinTantoBushoDomainBuilder>() {
			@Override
			public void configure(KokyakuKojinTantoBushoDomainBuilder builder) {
				builder.kokyakuTantoBushoHanbaiDomain = kokyakuTantoBushoHanbaiDomain;
			}
		});
		return getThis();
	}

	/**
	 * {@link KokyakuKojinTantoBushoDomain}に与えるkokyakuTantoBushoRentalDomainをこのビルダに設定する。
	 *
	 * @param kokyakuTantoBushoRentalDomain
	 *            kokyakuTantoBushoRentalDomain
	 * @return {@link KokyakuKojinTantoBushoDomainBuilder}
	 */
	public KokyakuKojinTantoBushoDomainBuilder withKokyakuTantoBushoRentalDomain(
			final com.mkyong.helloworld.domain.KokyakuTantoBushoRentalDomain kokyakuTantoBushoRentalDomain) {
		addConfigurator(new BuilderConfigurator<KokyakuKojinTantoBushoDomainBuilder>() {
			@Override
			public void configure(KokyakuKojinTantoBushoDomainBuilder builder) {
				builder.kokyakuTantoBushoRentalDomain = kokyakuTantoBushoRentalDomain;
			}
		});
		return getThis();
	}

	/**
	 * {@link KokyakuKojinTantoBushoDomain}に与えるnyukinMotoDomainをこのビルダに設定する。
	 *
	 * @param nyukinMotoDomain
	 *            nyukinMotoDomain
	 * @return {@link KokyakuKojinTantoBushoDomainBuilder}
	 */
	public KokyakuKojinTantoBushoDomainBuilder withNyukinMotoDomain(
			final com.mkyong.helloworld.domain.NyukinMotoDomain nyukinMotoDomain) {
		addConfigurator(new BuilderConfigurator<KokyakuKojinTantoBushoDomainBuilder>() {
			@Override
			public void configure(KokyakuKojinTantoBushoDomainBuilder builder) {
				builder.nyukinMotoDomain = nyukinMotoDomain;
			}
		});
		return getThis();
	}

	/**
	 * {@link KokyakuKojinTantoBushoDomain}に与えるseikyuSakiDomainをこのビルダに設定する。
	 *
	 * @param seikyuSakiDomain
	 *            seikyuSakiDomain
	 * @return {@link KokyakuKojinTantoBushoDomainBuilder}
	 */
	public KokyakuKojinTantoBushoDomainBuilder withSeikyuSakiDomain(
			final com.mkyong.helloworld.domain.SeikyuSakiDomain seikyuSakiDomain) {
		addConfigurator(new BuilderConfigurator<KokyakuKojinTantoBushoDomainBuilder>() {
			@Override
			public void configure(KokyakuKojinTantoBushoDomainBuilder builder) {
				builder.seikyuSakiDomain = seikyuSakiDomain;
			}
		});
		return getThis();
	}

	/**
	 * {@link KokyakuKojinTantoBushoDomain}に与えるversionをこのビルダに設定する。
	 *
	 * @param version
	 *            version
	 * @return {@link KokyakuKojinTantoBushoDomainBuilder}
	 */
	public KokyakuKojinTantoBushoDomainBuilder withVersion(final int version) {
		addConfigurator(new BuilderConfigurator<KokyakuKojinTantoBushoDomainBuilder>() {
			@Override
			public void configure(KokyakuKojinTantoBushoDomainBuilder builder) {
				builder.version = version;
			}
		});
		return getThis();
	}

}