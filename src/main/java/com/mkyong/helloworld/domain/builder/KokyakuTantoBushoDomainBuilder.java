package com.mkyong.helloworld.domain.builder;

import com.mkyong.helloworld.domain.BushoDomain;
import com.mkyong.helloworld.domain.KokyakuDomain;
import com.mkyong.helloworld.domain.KokyakuTantoBushoDomain;
import com.mkyong.helloworld.kubun.ShohizeiKubun;

public class KokyakuTantoBushoDomainBuilder
		extends AbstractDomainBuilder<KokyakuTantoBushoDomain, KokyakuTantoBushoDomainBuilder> {

	// private member
	/** 顧客ドメイン */
	private KokyakuDomain kokyakuDomain;

	/** 部署ドメイン */
	private BushoDomain budhoDomain;

	/** 消費税区分 */
	private ShohizeiKubun shohizeiKubun;

	/** 責任者名 */
	private String sekininshaName;

	/** バージョン（排他制御用） */
	private int version;

	// protected method
	@Override
	protected void apply(KokyakuTantoBushoDomain domain, KokyakuTantoBushoDomainBuilder builder) {
		builder.withKokyakuDomain(domain.getKokyakuDomain());
		builder.withBudhoDomain(domain.getBudhoDomain());
		builder.withShohizeiKubun(domain.getShohizeiKubun());
		builder.withSekininshaName(domain.getSekininshaName());
		builder.withVersion(domain.getVersion());
	}

	@Override
	protected KokyakuTantoBushoDomain createDomainObject() {
		return new KokyakuTantoBushoDomain(kokyakuDomain, budhoDomain, shohizeiKubun, sekininshaName, version);
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
	 * {@link KokyakuTantoBushoDomain}に与える顧客ドメインをこのビルダに設定する。
	 *
	 * @param kokyakuDomain
	 *            顧客ドメイン
	 * @return {@link KokyakuTantoBushoDomainBuilder}
	 */
	public KokyakuTantoBushoDomainBuilder withKokyakuDomain(final KokyakuDomain kokyakuDomain) {
		addConfigurator(new BuilderConfigurator<KokyakuTantoBushoDomainBuilder>() {
			@Override
			public void configure(KokyakuTantoBushoDomainBuilder builder) {
				builder.kokyakuDomain = kokyakuDomain;
			}
		});
		return getThis();
	}

	/**
	 * {@link KokyakuTantoBushoDomain}に与える部署ドメインをこのビルダに設定する。
	 *
	 * @param budhoDomain
	 *            部署ドメイン
	 * @return {@link KokyakuTantoBushoDomainBuilder}
	 */
	public KokyakuTantoBushoDomainBuilder withBudhoDomain(final BushoDomain budhoDomain) {
		addConfigurator(new BuilderConfigurator<KokyakuTantoBushoDomainBuilder>() {
			@Override
			public void configure(KokyakuTantoBushoDomainBuilder builder) {
				builder.budhoDomain = budhoDomain;
			}
		});
		return getThis();
	}

	/**
	 * {@link KokyakuTantoBushoDomain}に与える消費税区分をこのビルダに設定する。
	 *
	 * @param shohizeiKubun
	 *            消費税区分
	 * @return {@link KokyakuTantoBushoDomainBuilder}
	 */
	public KokyakuTantoBushoDomainBuilder withShohizeiKubun(final ShohizeiKubun shohizeiKubun) {
		addConfigurator(new BuilderConfigurator<KokyakuTantoBushoDomainBuilder>() {
			@Override
			public void configure(KokyakuTantoBushoDomainBuilder builder) {
				builder.shohizeiKubun = shohizeiKubun;
			}
		});
		return getThis();
	}

	/**
	 * {@link KokyakuTantoBushoDomain}に与える責任者名をこのビルダに設定する。
	 *
	 * @param sekininshaName
	 *            責任者名
	 * @return {@link KokyakuTantoBushoDomainBuilder}
	 */
	public KokyakuTantoBushoDomainBuilder withSekininshaName(final String sekininshaName) {
		addConfigurator(new BuilderConfigurator<KokyakuTantoBushoDomainBuilder>() {
			@Override
			public void configure(KokyakuTantoBushoDomainBuilder builder) {
				builder.sekininshaName = sekininshaName;
			}
		});
		return getThis();
	}

	/**
	 * {@link KokyakuTantoBushoDomain}に与えるバージョン（排他制御用）をこのビルダに設定する。
	 *
	 * @param version
	 *            バージョン（排他制御用）
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