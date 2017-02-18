package com.mkyong.helloworld.domain.builder;

import com.mkyong.helloworld.domain.NyukinKakeInfoDomain;
import com.mkyong.helloworld.domain.NyukinMotoDomain;
import com.mkyong.helloworld.kubun.HanbaiKubun;

public class NyukinMotoDomainBuilder extends AbstractDomainBuilder<NyukinMotoDomain, NyukinMotoDomainBuilder> {

	// private member
	/** ID */
	private Integer id;

	/** 販売区分 */
	private HanbaiKubun hanbaiKubun;

	/** 入金掛売情報 */
	private NyukinKakeInfoDomain nyukinKakeInfoDomain;

	/** バージョン */
	private int version;

	// protected method
	@Override
	protected void apply(NyukinMotoDomain domain, NyukinMotoDomainBuilder builder) {
		builder.withId(domain.getId());
		builder.withHanbaiKubun(domain.getHanbaiKubun());
		builder.withNyukinKakeInfoDomain(domain.getNyukinKakeInfoDomain());
		builder.withVersion(domain.getVersion());
	}

	@Override
	protected NyukinMotoDomain createDomainObject() {
		return new NyukinMotoDomain(id, hanbaiKubun, nyukinKakeInfoDomain, version);
	}

	@Override
	protected NyukinMotoDomainBuilder getThis() {
		return this;
	}

	@Override
	protected NyukinMotoDomainBuilder newInstance() {
		return new NyukinMotoDomainBuilder();
	}

	// public method
	/**
	 * {@link NyukinMotoDomain}に与えるIDをこのビルダに設定する。
	 *
	 * @param id
	 *            ID
	 * @return {@link NyukinMotoDomainBuilder}
	 */
	public NyukinMotoDomainBuilder withId(final Integer id) {
		addConfigurator(new BuilderConfigurator<NyukinMotoDomainBuilder>() {
			@Override
			public void configure(NyukinMotoDomainBuilder builder) {
				builder.id = id;
			}
		});
		return getThis();
	}

	/**
	 * {@link NyukinMotoDomain}に与える販売区分をこのビルダに設定する。
	 *
	 * @param hanbaiKubun
	 *            販売区分
	 * @return {@link NyukinMotoDomainBuilder}
	 */
	public NyukinMotoDomainBuilder withHanbaiKubun(final HanbaiKubun hanbaiKubun) {
		addConfigurator(new BuilderConfigurator<NyukinMotoDomainBuilder>() {
			@Override
			public void configure(NyukinMotoDomainBuilder builder) {
				builder.hanbaiKubun = hanbaiKubun;
			}
		});
		return getThis();
	}

	/**
	 * {@link NyukinMotoDomain}に与える入金掛売情報をこのビルダに設定する。
	 *
	 * @param nyukinKakeInfoDomain
	 *            入金掛売情報
	 * @return {@link NyukinMotoDomainBuilder}
	 */
	public NyukinMotoDomainBuilder withNyukinKakeInfoDomain(final NyukinKakeInfoDomain nyukinKakeInfoDomain) {
		addConfigurator(new BuilderConfigurator<NyukinMotoDomainBuilder>() {
			@Override
			public void configure(NyukinMotoDomainBuilder builder) {
				builder.nyukinKakeInfoDomain = nyukinKakeInfoDomain;
			}
		});
		return getThis();
	}

	/**
	 * {@link NyukinMotoDomain}に与えるバージョンをこのビルダに設定する。
	 *
	 * @param version
	 *            バージョン
	 * @return {@link NyukinMotoDomainBuilder}
	 */
	public NyukinMotoDomainBuilder withVersion(final int version) {
		addConfigurator(new BuilderConfigurator<NyukinMotoDomainBuilder>() {
			@Override
			public void configure(NyukinMotoDomainBuilder builder) {
				builder.version = version;
			}
		});
		return getThis();
	}

}