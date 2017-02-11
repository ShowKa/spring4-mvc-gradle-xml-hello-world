package com.mkyong.helloworld.web.u01;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class U01G001Form {
	// private member
	/** 顧客コード */
	private String code;

	/** 限定区分 */
	private String genteiKubun;

	/** 顧客区分 */
	private String kokyakuKubun;

	/** 顧客名 */
	private String name;

	/** 住所 */
	private String address;

	/** 主幹部署 */
	private String shukanBushoCode;
}
