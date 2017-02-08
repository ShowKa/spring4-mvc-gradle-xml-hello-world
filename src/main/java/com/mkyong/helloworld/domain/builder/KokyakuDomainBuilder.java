package com.mkyong.helloworld.domain.builder;

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

	/** 主幹部署 */
	private String shukanBushoCode;

	@Override
	protected void apply(KokyakuDomain vo, KokyakuDomainBuilder builder) {
		builder.withKokyakuCode(vo.getCode());
	}

	@Override
	protected KokyakuDomain createDomainObject() {
		return new KokyakuDomain(code, genteiKubun, kokyakuKubun, name, address, shukanBushoCode);
	}

	@Override
	protected KokyakuDomainBuilder getThis() {
		return this;
	}

	@Override
	protected KokyakuDomainBuilder newInstance() {
		return new KokyakuDomainBuilder();
	}

	/**
	 * {@link KokyakuDomain}に与える名前をこのビルダに設定する。
	 *
	 * @param kokyakuCode
	 *            顧客コード
	 * @return {@link KokyakuDomainBuilder}
	 */
	public KokyakuDomainBuilder withKokyakuCode(final String kokyakuCode) {
		addConfigurator(new BuilderConfigurator<KokyakuDomainBuilder>() {
			@Override
			public void configure(KokyakuDomainBuilder builder) {
				builder.code = kokyakuCode;
			}
		});
		return getThis();
	}

	/**
	 * {@link KokyakuDomain}に与える名前をこのビルダに設定する。
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
	 * {@link KokyakuDomain}に与える名前をこのビルダに設定する。
	 *
	 * @param genteiKubun
	 *            限定区分
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

}
