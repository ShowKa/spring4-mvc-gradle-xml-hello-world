package com.mkyong.helloworld.domain.builder;

import com.mkyong.helloworld.domain.KokyakuKojinDomain;

public class KokyakuKojinDomainBuilder extends AbstractDomainBuilder<KokyakuKojinDomain, KokyakuKojinDomainBuilder> {

	// private member
	/** code */
	private java.lang.String code;

	/** genteiKubun */
	private com.mkyong.helloworld.kubun.GenteiKubun genteiKubun;

	/** kokyakuKubun */
	private com.mkyong.helloworld.kubun.KokyakuKubun kokyakuKubun;

	/** name */
	private java.lang.String name;

	/** address */
	private java.lang.String address;

	/** shukanBushoDomain */
	private com.mkyong.helloworld.domain.BushoDomain shukanBushoDomain;

	/** oyaKokyakuDomain */
	private com.mkyong.helloworld.domain.KokyakuDomain oyaKokyakuDomain;

	// protected method
	@Override
	protected void apply(KokyakuKojinDomain domain, KokyakuKojinDomainBuilder builder) {
		builder.withCode(domain.getCode());
		builder.withGenteiKubun(domain.getGenteiKubun());
		builder.withKokyakuKubun(domain.getKokyakuKubun());
		builder.withName(domain.getName());
		builder.withAddress(domain.getAddress());
		builder.withShukanBushoDomain(domain.getShukanBushoDomain());
		builder.withOyaKokyakuDomain(domain.getOyaKokyakuDomain());
	}

	@Override
	protected KokyakuKojinDomain createDomainObject() {
		return new KokyakuKojinDomain(code, genteiKubun, kokyakuKubun, name, address, shukanBushoDomain,
				oyaKokyakuDomain);
	}

	@Override
	protected KokyakuKojinDomainBuilder getThis() {
		return this;
	}

	@Override
	protected KokyakuKojinDomainBuilder newInstance() {
		return new KokyakuKojinDomainBuilder();
	}

	// public method
	/**
	 * {@link KokyakuKojinDomain}に与えるcodeをこのビルダに設定する。
	 *
	 * @param code
	 *            code
	 * @return {@link KokyakuKojinDomainBuilder}
	 */
	public KokyakuKojinDomainBuilder withCode(final java.lang.String code) {
		addConfigurator(new BuilderConfigurator<KokyakuKojinDomainBuilder>() {
			@Override
			public void configure(KokyakuKojinDomainBuilder builder) {
				builder.code = code;
			}
		});
		return getThis();
	}

	/**
	 * {@link KokyakuKojinDomain}に与えるgenteiKubunをこのビルダに設定する。
	 *
	 * @param genteiKubun
	 *            genteiKubun
	 * @return {@link KokyakuKojinDomainBuilder}
	 */
	public KokyakuKojinDomainBuilder withGenteiKubun(final com.mkyong.helloworld.kubun.GenteiKubun genteiKubun) {
		addConfigurator(new BuilderConfigurator<KokyakuKojinDomainBuilder>() {
			@Override
			public void configure(KokyakuKojinDomainBuilder builder) {
				builder.genteiKubun = genteiKubun;
			}
		});
		return getThis();
	}

	/**
	 * {@link KokyakuKojinDomain}に与えるkokyakuKubunをこのビルダに設定する。
	 *
	 * @param kokyakuKubun
	 *            kokyakuKubun
	 * @return {@link KokyakuKojinDomainBuilder}
	 */
	public KokyakuKojinDomainBuilder withKokyakuKubun(final com.mkyong.helloworld.kubun.KokyakuKubun kokyakuKubun) {
		addConfigurator(new BuilderConfigurator<KokyakuKojinDomainBuilder>() {
			@Override
			public void configure(KokyakuKojinDomainBuilder builder) {
				builder.kokyakuKubun = kokyakuKubun;
			}
		});
		return getThis();
	}

	/**
	 * {@link KokyakuKojinDomain}に与えるnameをこのビルダに設定する。
	 *
	 * @param name
	 *            name
	 * @return {@link KokyakuKojinDomainBuilder}
	 */
	public KokyakuKojinDomainBuilder withName(final java.lang.String name) {
		addConfigurator(new BuilderConfigurator<KokyakuKojinDomainBuilder>() {
			@Override
			public void configure(KokyakuKojinDomainBuilder builder) {
				builder.name = name;
			}
		});
		return getThis();
	}

	/**
	 * {@link KokyakuKojinDomain}に与えるaddressをこのビルダに設定する。
	 *
	 * @param address
	 *            address
	 * @return {@link KokyakuKojinDomainBuilder}
	 */
	public KokyakuKojinDomainBuilder withAddress(final java.lang.String address) {
		addConfigurator(new BuilderConfigurator<KokyakuKojinDomainBuilder>() {
			@Override
			public void configure(KokyakuKojinDomainBuilder builder) {
				builder.address = address;
			}
		});
		return getThis();
	}

	/**
	 * {@link KokyakuKojinDomain}に与えるshukanBushoDomainをこのビルダに設定する。
	 *
	 * @param shukanBushoDomain
	 *            shukanBushoDomain
	 * @return {@link KokyakuKojinDomainBuilder}
	 */
	public KokyakuKojinDomainBuilder withShukanBushoDomain(
			final com.mkyong.helloworld.domain.BushoDomain shukanBushoDomain) {
		addConfigurator(new BuilderConfigurator<KokyakuKojinDomainBuilder>() {
			@Override
			public void configure(KokyakuKojinDomainBuilder builder) {
				builder.shukanBushoDomain = shukanBushoDomain;
			}
		});
		return getThis();
	}

	/**
	 * {@link KokyakuKojinDomain}に与えるoyaKokyakuDomainをこのビルダに設定する。
	 *
	 * @param oyaKokyakuDomain
	 *            oyaKokyakuDomain
	 * @return {@link KokyakuKojinDomainBuilder}
	 */
	public KokyakuKojinDomainBuilder withOyaKokyakuDomain(
			final com.mkyong.helloworld.domain.KokyakuDomain oyaKokyakuDomain) {
		addConfigurator(new BuilderConfigurator<KokyakuKojinDomainBuilder>() {
			@Override
			public void configure(KokyakuKojinDomainBuilder builder) {
				builder.oyaKokyakuDomain = oyaKokyakuDomain;
			}
		});
		return getThis();
	}

}