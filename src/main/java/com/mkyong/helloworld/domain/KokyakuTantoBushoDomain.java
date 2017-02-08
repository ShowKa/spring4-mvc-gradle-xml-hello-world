package com.mkyong.helloworld.domain;

import com.mkyong.helloworld.entity.MKokyakuBusho;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class KokyakuTantoBushoDomain extends AbstractDomain {
	// Entity
	private MKokyakuBusho mKokyakuBushoEntity;

	// Domain
	private KokyakuDomain kokyakuDomain;
}
