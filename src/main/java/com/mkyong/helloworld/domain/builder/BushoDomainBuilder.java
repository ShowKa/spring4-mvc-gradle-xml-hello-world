package com.mkyong.helloworld.domain.builder;

import com.mkyong.helloworld.domain.BushoDateDomain;
import com.mkyong.helloworld.domain.BushoDomain;
import com.mkyong.helloworld.kubun.BushoKubun;
import com.mkyong.helloworld.kubun.JigyoKubun;

public class BushoDomainBuilder extends AbstractDomainBuilder<BushoDomain, BushoDomainBuilder> {

	// private member
	/** 部署コード */
	private String code;

	/** 部署区分 */
	private BushoKubun bushoKubun;

	/** 事業区分 */
	private JigyoKubun jigyoKubun;

	/** 部署名 */
	private String name;

	/** 部署日付ドメイン */
	private BushoDateDomain bushoDateDomain;

	/** バージョン */
	private int version;

	// protected method
	@Override
	protected void apply(BushoDomain domain, BushoDomainBuilder builder) {
		builder.withCode(domain.getCode());
		builder.withBushoKubun(domain.getBushoKubun());
		builder.withJigyoKubun(domain.getJigyoKubun());
		builder.withName(domain.getName());
		builder.withBushoDateDomain(domain.getBushoDateDomain());
		builder.withVersion(domain.getVersion());
	}

	@Override
	protected BushoDomain createDomainObject() {
		return new BushoDomain(code, bushoKubun, jigyoKubun, name, bushoDateDomain, version);
	}

	@Override
	protected BushoDomainBuilder getThis() {
		return this;
	}

	@Override
	protected BushoDomainBuilder newInstance() {
		return new BushoDomainBuilder();
	}

	// public method
	/**
	 * {@link BushoDomain}に与える部署コードをこのビルダに設定する。
	 *
	 * @param code
	 *            部署コード
	 * @return {@link BushoDomainBuilder}
	 */
	public BushoDomainBuilder withCode(final String code) {
		addConfigurator(new BuilderConfigurator<BushoDomainBuilder>() {
			@Override
			public void configure(BushoDomainBuilder builder) {
				builder.code = code;
			}
		});
		return getThis();
	}

	/**
	 * {@link BushoDomain}に与える部署区分をこのビルダに設定する。
	 *
	 * @param bushoKubun
	 *            部署区分
	 * @return {@link BushoDomainBuilder}
	 */
	public BushoDomainBuilder withBushoKubun(final BushoKubun bushoKubun) {
		addConfigurator(new BuilderConfigurator<BushoDomainBuilder>() {
			@Override
			public void configure(BushoDomainBuilder builder) {
				builder.bushoKubun = bushoKubun;
			}
		});
		return getThis();
	}

	/**
	 * {@link BushoDomain}に与える事業区分をこのビルダに設定する。
	 *
	 * @param jigyoKubun
	 *            事業区分
	 * @return {@link BushoDomainBuilder}
	 */
	public BushoDomainBuilder withJigyoKubun(final JigyoKubun jigyoKubun) {
		addConfigurator(new BuilderConfigurator<BushoDomainBuilder>() {
			@Override
			public void configure(BushoDomainBuilder builder) {
				builder.jigyoKubun = jigyoKubun;
			}
		});
		return getThis();
	}

	/**
	 * {@link BushoDomain}に与える部署名をこのビルダに設定する。
	 *
	 * @param name
	 *            部署名
	 * @return {@link BushoDomainBuilder}
	 */
	public BushoDomainBuilder withName(final String name) {
		addConfigurator(new BuilderConfigurator<BushoDomainBuilder>() {
			@Override
			public void configure(BushoDomainBuilder builder) {
				builder.name = name;
			}
		});
		return getThis();
	}

	/**
	 * {@link BushoDomain}に与える部署日付ドメインをこのビルダに設定する。
	 *
	 * @param bushoDateDomain
	 *            部署日付ドメイン
	 * @return {@link BushoDomainBuilder}
	 */
	public BushoDomainBuilder withBushoDateDomain(final BushoDateDomain bushoDateDomain) {
		addConfigurator(new BuilderConfigurator<BushoDomainBuilder>() {
			@Override
			public void configure(BushoDomainBuilder builder) {
				builder.bushoDateDomain = bushoDateDomain;
			}
		});
		return getThis();
	}

	/**
	 * {@link BushoDomain}に与えるバージョンをこのビルダに設定する。
	 *
	 * @param version
	 *            バージョン
	 * @return {@link BushoDomainBuilder}
	 */
	public BushoDomainBuilder withVersion(final int version) {
		addConfigurator(new BuilderConfigurator<BushoDomainBuilder>() {
			@Override
			public void configure(BushoDomainBuilder builder) {
				builder.version = version;
			}
		});
		return getThis();
	}

}