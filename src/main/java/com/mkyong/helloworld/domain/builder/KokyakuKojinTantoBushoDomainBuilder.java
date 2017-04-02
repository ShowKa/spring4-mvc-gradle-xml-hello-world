package com.mkyong.helloworld.domain.builder;

import com.mkyong.helloworld.domain.KokyakuKojinDomain;
import com.mkyong.helloworld.domain.KokyakuKojinTantoBushoDomain;

public class KokyakuKojinTantoBushoDomainBuilder extends KokyakuTantoBushoDomainBuilder {

	// private member
	/** kokyakuKojinDomain */
	protected com.mkyong.helloworld.domain.KokyakuKojinDomain kokyakuKojinDomain;

	// protected method
	protected void apply(KokyakuKojinTantoBushoDomain domain, KokyakuKojinTantoBushoDomainBuilder builder) {
		super.apply(domain, builder);
		builder.withKokyakuKojinDomain(domain.getKokyakuKojinDomain());
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
	public KokyakuKojinTantoBushoDomainBuilder withKokyakuKojinDomain(final KokyakuKojinDomain kokyakuKojinDomain) {

		addConfigurator(new BuilderConfigurator<KokyakuTantoBushoDomainBuilder>() {
			@Override
			public void configure(KokyakuTantoBushoDomainBuilder builder) {
				KokyakuKojinTantoBushoDomainBuilder b = (KokyakuKojinTantoBushoDomainBuilder) builder;
				b.kokyakuKojinDomain = kokyakuKojinDomain;
			}
		});

		return getThis();
	}

}