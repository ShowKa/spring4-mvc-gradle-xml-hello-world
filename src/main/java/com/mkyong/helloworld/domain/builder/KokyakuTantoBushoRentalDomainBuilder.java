package com.mkyong.helloworld.domain.builder;

import com.mkyong.helloworld.domain.KokyakuTantoBushoRentalDomain;
import com.mkyong.helloworld.kubun.CourseCode;

public class KokyakuTantoBushoRentalDomainBuilder
		extends AbstractDomainBuilder<KokyakuTantoBushoRentalDomain, KokyakuTantoBushoRentalDomainBuilder> {

	// private member
	/** kokyakuDomain */
	private com.mkyong.helloworld.domain.KokyakuDomain kokyakuDomain;

	/** budhoDomain */
	private com.mkyong.helloworld.domain.BushoDomain bushoDomain;

	/** courseCode */
	private CourseCode courseCode;

	/** version */
	private java.lang.Integer version;

	// protected method
	@Override
	protected void apply(KokyakuTantoBushoRentalDomain domain, KokyakuTantoBushoRentalDomainBuilder builder) {
		builder.withKokyakuDomain(domain.getKokyakuDomain());
		builder.withBudhoDomain(domain.getBushoDomain());
		builder.withCourseCode(domain.getCourseCode());
		builder.withVersion(domain.getVersion());
	}

	@Override
	protected KokyakuTantoBushoRentalDomain createDomainObject() {
		return new KokyakuTantoBushoRentalDomain(kokyakuDomain, bushoDomain, courseCode, version);
	}

	@Override
	protected KokyakuTantoBushoRentalDomainBuilder getThis() {
		return this;
	}

	@Override
	protected KokyakuTantoBushoRentalDomainBuilder newInstance() {
		return new KokyakuTantoBushoRentalDomainBuilder();
	}

	// public method
	/**
	 * {@link KokyakuTantoBushoRentalDomain}に与えるkokyakuDomainをこのビルダに設定する。
	 *
	 * @param kokyakuDomain
	 *            kokyakuDomain
	 * @return {@link KokyakuTantoBushoRentalDomainBuilder}
	 */
	public KokyakuTantoBushoRentalDomainBuilder withKokyakuDomain(
			final com.mkyong.helloworld.domain.KokyakuDomain kokyakuDomain) {
		addConfigurator(new BuilderConfigurator<KokyakuTantoBushoRentalDomainBuilder>() {
			@Override
			public void configure(KokyakuTantoBushoRentalDomainBuilder builder) {
				builder.kokyakuDomain = kokyakuDomain;
			}
		});
		return getThis();
	}

	/**
	 * {@link KokyakuTantoBushoRentalDomain}に与えるbudhoDomainをこのビルダに設定する。
	 *
	 * @param budhoDomain
	 *            budhoDomain
	 * @return {@link KokyakuTantoBushoRentalDomainBuilder}
	 */
	public KokyakuTantoBushoRentalDomainBuilder withBudhoDomain(
			final com.mkyong.helloworld.domain.BushoDomain budhoDomain) {
		addConfigurator(new BuilderConfigurator<KokyakuTantoBushoRentalDomainBuilder>() {
			@Override
			public void configure(KokyakuTantoBushoRentalDomainBuilder builder) {
				builder.bushoDomain = budhoDomain;
			}
		});
		return getThis();
	}

	/**
	 * {@link KokyakuTantoBushoRentalDomain}に与えるcourseCodeをこのビルダに設定する。
	 *
	 * @param courseCode
	 *            courseCode
	 * @return {@link KokyakuTantoBushoRentalDomainBuilder}
	 */
	public KokyakuTantoBushoRentalDomainBuilder withCourseCode(final CourseCode courseCode) {
		addConfigurator(new BuilderConfigurator<KokyakuTantoBushoRentalDomainBuilder>() {
			@Override
			public void configure(KokyakuTantoBushoRentalDomainBuilder builder) {
				builder.courseCode = courseCode;
			}
		});
		return getThis();
	}

	/**
	 * {@link KokyakuTantoBushoRentalDomain}に与えるversionをこのビルダに設定する。
	 *
	 * @param version
	 *            version
	 * @return {@link KokyakuTantoBushoRentalDomainBuilder}
	 */
	public KokyakuTantoBushoRentalDomainBuilder withVersion(final java.lang.Integer version) {
		addConfigurator(new BuilderConfigurator<KokyakuTantoBushoRentalDomainBuilder>() {
			@Override
			public void configure(KokyakuTantoBushoRentalDomainBuilder builder) {
				builder.version = version;
			}
		});
		return getThis();
	}

}