package com.mkyong.helloworld.domain.builder;

import com.mkyong.helloworld.domain.BushoDomain;
import com.mkyong.helloworld.domain.KokyakuDomain;
import com.mkyong.helloworld.kubun.GenteiKubun;
import com.mkyong.helloworld.kubun.KokyakuKubun;

public class KokyakuDomainBuilder extends AbstractDomainBuilder<KokyakuDomain, KokyakuDomainBuilder> {

	// private member
	/** 顧客コード */
	private String code;

	/** 限定区分 */
	private GenteiKubun genteiKubun;

	/** 顧客区分 */
	private KokyakuKubun kokyakuKubun;

	/** 顧客名 */
	private String name;

	/** 住所 */
	private String address;

	/** 主幹部署ドメイン */
	private BushoDomain shukanBushoDomain;

	// protected method
	@Override
	protected void apply(KokyakuDomain domain, KokyakuDomainBuilder builder) {
		builder.withCode(domain.getCode());
		builder.withGenteiKubun(domain.getGenteiKubun());
		builder.withKokyakuKubun(domain.getKokyakuKubun());
		builder.withName(domain.getName());
		builder.withAddress(domain.getAddress());
		builder.withShukanBushoDomain(domain.getShukanBushoDomain());
	}

	@Override
	protected KokyakuDomain createDomainObject() {
		return new KokyakuDomain(code, genteiKubun, kokyakuKubun, name, address, shukanBushoDomain);
	}

	@Override
	protected KokyakuDomainBuilder getThis() {
		return this;
	}

	@Override
	protected KokyakuDomainBuilder newInstance() {
		return new KokyakuDomainBuilder();
	}

	// public method
	/**
	 * {@link KokyakuDomain}に与える顧客コードをこのビルダに設定する。
	 *
	 * @param code
	 *            顧客コード
	 * @return {@link KokyakuDomainBuilder}
	 */
	public KokyakuDomainBuilder withCode(final String code) {
		addConfigurator(new BuilderConfigurator<KokyakuDomainBuilder>() {
			@Override
			public void configure(KokyakuDomainBuilder builder) {
				builder.code = code;
			}
		});
		return getThis();
	}

	/**
	 * {@link KokyakuDomain}に与える限定区分をこのビルダに設定する。
	 *
	 * @param genteiKubun
	 *            限定区分
	 * @return {@link KokyakuDomainBuilder}
	 */
	public KokyakuDomainBuilder withGenteiKubun(final GenteiKubun genteiKubun) {
		addConfigurator(new BuilderConfigurator<KokyakuDomainBuilder>() {
			@Override
			public void configure(KokyakuDomainBuilder builder) {
				builder.genteiKubun = genteiKubun;
			}
		});
		return getThis();
	}

	/**
	 * {@link KokyakuDomain}に与える顧客区分をこのビルダに設定する。
	 *
	 * @param kokyakuKubun
	 *            顧客区分
	 * @return {@link KokyakuDomainBuilder}
	 */
	public KokyakuDomainBuilder withKokyakuKubun(final KokyakuKubun kokyakuKubun) {
		addConfigurator(new BuilderConfigurator<KokyakuDomainBuilder>() {
			@Override
			public void configure(KokyakuDomainBuilder builder) {
				builder.kokyakuKubun = kokyakuKubun;
			}
		});
		return getThis();
	}

	/**
	 * {@link KokyakuDomain}に与える顧客名をこのビルダに設定する。
	 *
	 * @param name
	 *            顧客名
	 * @return {@link KokyakuDomainBuilder}
	 */
	public KokyakuDomainBuilder withName(final String name) {
		addConfigurator(new BuilderConfigurator<KokyakuDomainBuilder>() {
			@Override
			public void configure(KokyakuDomainBuilder builder) {
				builder.name = name;
			}
		});
		return getThis();
	}

	/**
	 * {@link KokyakuDomain}に与える住所をこのビルダに設定する。
	 *
	 * @param address
	 *            住所
	 * @return {@link KokyakuDomainBuilder}
	 */
	public KokyakuDomainBuilder withAddress(final String address) {
		addConfigurator(new BuilderConfigurator<KokyakuDomainBuilder>() {
			@Override
			public void configure(KokyakuDomainBuilder builder) {
				builder.address = address;
			}
		});
		return getThis();
	}

	/**
	 * {@link KokyakuDomain}に与える主幹部署コードをこのビルダに設定する。
	 *
	 * @param shukanBushoCode
	 *            主幹部署コード
	 * @return {@link KokyakuDomainBuilder}
	 */
	public KokyakuDomainBuilder withShukanBushoDomain(final BushoDomain shukanBushoDomain) {
		addConfigurator(new BuilderConfigurator<KokyakuDomainBuilder>() {
			@Override
			public void configure(KokyakuDomainBuilder builder) {
				builder.shukanBushoDomain = shukanBushoDomain;
			}
		});
		return getThis();
	}
}