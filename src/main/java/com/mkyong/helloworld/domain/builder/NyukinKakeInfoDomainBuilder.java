package com.mkyong.helloworld.domain.builder;

import com.mkyong.helloworld.domain.NyukinKakeInfoDomain;
import com.mkyong.helloworld.kubun.NyukinHohoKubun;
import com.mkyong.helloworld.kubun.NyukinTsukiKubun;

public class NyukinKakeInfoDomainBuilder
		extends AbstractDomainBuilder<NyukinKakeInfoDomain, NyukinKakeInfoDomainBuilder> {
	// private member
	/** ID */
	private Integer id;

	/** 締日 */
	private Integer shimeDate;

	/** 入金月区分 */
	private NyukinTsukiKubun nyukinTsukiKubun;

	/** 入金方法 */
	private NyukinHohoKubun nyukinHohoKubun;

	/** 入金日 */
	private Integer nyukinDate;

	/** バージョン */
	private int version;

	// protected method
	@Override
	protected void apply(NyukinKakeInfoDomain domain, NyukinKakeInfoDomainBuilder builder) {
		builder.withId(domain.getId());
		builder.withShimeDate(domain.getShimeDate());
		builder.withNyukinTsukiKubun(domain.getNyukinTsukiKubun());
		builder.withNyukinHohoKubun(domain.getNyukinHohoKubun());
		builder.withNyukinDate(domain.getNyukinDate());
		builder.withVersion(domain.getVersion());
	}

	@Override
	protected NyukinKakeInfoDomain createDomainObject() {
		return new NyukinKakeInfoDomain(id, shimeDate, nyukinTsukiKubun, nyukinHohoKubun, nyukinDate, version);
	}

	@Override
	protected NyukinKakeInfoDomainBuilder getThis() {
		return this;
	}

	@Override
	protected NyukinKakeInfoDomainBuilder newInstance() {
		return new NyukinKakeInfoDomainBuilder();
	}

	// public method
	/**
	 * {@link NyukinKakeInfoDomain}に与えるIDをこのビルダに設定する。
	 *
	 * @param id
	 *            ID
	 * @return {@link NyukinKakeInfoDomainBuilder}
	 */
	public NyukinKakeInfoDomainBuilder withId(final Integer id) {
		addConfigurator(new BuilderConfigurator<NyukinKakeInfoDomainBuilder>() {
			@Override
			public void configure(NyukinKakeInfoDomainBuilder builder) {
				builder.id = id;
			}
		});
		return getThis();
	}

	/**
	 * {@link NyukinKakeInfoDomain}に与える締日をこのビルダに設定する。
	 *
	 * @param shimeDate
	 *            締日
	 * @return {@link NyukinKakeInfoDomainBuilder}
	 */
	public NyukinKakeInfoDomainBuilder withShimeDate(final Integer shimeDate) {
		addConfigurator(new BuilderConfigurator<NyukinKakeInfoDomainBuilder>() {
			@Override
			public void configure(NyukinKakeInfoDomainBuilder builder) {
				builder.shimeDate = shimeDate;
			}
		});
		return getThis();
	}

	/**
	 * {@link NyukinKakeInfoDomain}に与える入金月区分をこのビルダに設定する。
	 *
	 * @param nyukinTsukiKubun
	 *            入金月区分
	 * @return {@link NyukinKakeInfoDomainBuilder}
	 */
	public NyukinKakeInfoDomainBuilder withNyukinTsukiKubun(final NyukinTsukiKubun nyukinTsukiKubun) {
		addConfigurator(new BuilderConfigurator<NyukinKakeInfoDomainBuilder>() {
			@Override
			public void configure(NyukinKakeInfoDomainBuilder builder) {
				builder.nyukinTsukiKubun = nyukinTsukiKubun;
			}
		});
		return getThis();
	}

	/**
	 * {@link NyukinKakeInfoDomain}に与える入金方法をこのビルダに設定する。
	 *
	 * @param nyukinHohoKubun
	 *            入金方法
	 * @return {@link NyukinKakeInfoDomainBuilder}
	 */
	public NyukinKakeInfoDomainBuilder withNyukinHohoKubun(final NyukinHohoKubun nyukinHohoKubun) {
		addConfigurator(new BuilderConfigurator<NyukinKakeInfoDomainBuilder>() {
			@Override
			public void configure(NyukinKakeInfoDomainBuilder builder) {
				builder.nyukinHohoKubun = nyukinHohoKubun;
			}
		});
		return getThis();
	}

	/**
	 * {@link NyukinKakeInfoDomain}に与える入金日をこのビルダに設定する。
	 *
	 * @param nyukinDate
	 *            入金日
	 * @return {@link NyukinKakeInfoDomainBuilder}
	 */
	public NyukinKakeInfoDomainBuilder withNyukinDate(final Integer nyukinDate) {
		addConfigurator(new BuilderConfigurator<NyukinKakeInfoDomainBuilder>() {
			@Override
			public void configure(NyukinKakeInfoDomainBuilder builder) {
				builder.nyukinDate = nyukinDate;
			}
		});
		return getThis();
	}

	/**
	 * {@link NyukinKakeInfoDomain}に与えるバージョンをこのビルダに設定する。
	 *
	 * @param version
	 *            バージョン
	 * @return {@link NyukinKakeInfoDomainBuilder}
	 */
	public NyukinKakeInfoDomainBuilder withVersion(final int version) {
		addConfigurator(new BuilderConfigurator<NyukinKakeInfoDomainBuilder>() {
			@Override
			public void configure(NyukinKakeInfoDomainBuilder builder) {
				builder.version = version;
			}
		});
		return getThis();
	}

}