package com.mkyong.helloworld.web.u01;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class U01G001Form {
	// private member

	// 顧客ドメイン
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

	// 顧客ドメイン（個人)
	/** 親顧客コード */
	private String oyaKokyakuCode;

	// 顧客担当部署ドメイン
	/** 担当部署コード */
	private String tantoBushoCode;

	/** 消費税区分 */
	private String shohizeiKubun;

	/** 責任者名 */
	private String sekininshaName;

	/** 顧客担当部署バージョン */
	private Integer kokyakuTantoBushoVersion;

	// 入金元ドメイン
	/** 入金元ID */
	private Integer nyukinMotoId = UUID.randomUUID().hashCode();

	/** 販売区分 */
	private String hanabaiKubun;

	/** 入金元バージョン */
	private Integer nyukinMotoVersion;

	// 入金掛売情報ドメイン
	/** 入金日 */
	private Integer nyukinDate;

	/** 入金方法 */
	private String nyukinHohoKubun;

	/** 入金月区分 */
	private String nyukinTsukiKubun;

	/** 締日 */
	private Integer ShimeDate;

	/** 入金掛売情報バージョン */
	private Integer nyukinKakeInfoVersion;

	// 請求先ドメイン
	/** 請求先ID */
	private Integer seikyuSakiId = UUID.randomUUID().hashCode();

	/** 請求区分 */
	private String seikyuKubun;

	/** 請求書作成場所区分 */
	private String seikyushoSakuseiBashoKubun;

	/** 請求先名 */
	private String seikyuSakiName;

	/** 請求先バージョン */
	private Integer seikyuSakiVersion;
}
