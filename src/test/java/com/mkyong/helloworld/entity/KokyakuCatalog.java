package com.mkyong.helloworld.entity;

import com.mkyong.helloworld.domain.KokyakuDomain;
import com.mkyong.helloworld.domain.builder.KokyakuDomainBuilder;
import com.mkyong.helloworld.kubun.GenteiKubun;
import com.mkyong.helloworld.kubun.KokyakuKubun;

public class KokyakuCatalog {
	public static KokyakuDomain KOKYAKU_UT001 = new KokyakuDomainBuilder().withAddress("UT001住所")
			.withCode("UT001")
			.withGenteiKubun(GenteiKubun.限定しない)
			.withKokyakuKubun(KokyakuKubun.法人)
			.withName("UT001名前")
			// .withShukanBushoCode("UT001")
			.build();
}
