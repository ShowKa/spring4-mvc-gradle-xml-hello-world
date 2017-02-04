package com.mkyong.helloworld.domain;

import com.mkyong.helloworld.entity.MKokyakuBusho;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class KokyakuTantoBushoDomain {
	// Entity
	private MKokyakuBusho mKokyakuBusho;

	// Domain
	private KokyakuDomain kokyakuDomain;
}
