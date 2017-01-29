package com.mkyong.helloworld.dao.parameter;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class KokyakuSearchParameter {
	/** 顧客コード. */
	private String code;
	/** 顧客名 */
	private String name;
}
