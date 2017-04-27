package com.mkyong.helloworld.kubun;

import com.mkyong.helloworld.kubun.i.Kubun;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 請求区分=請求書の発送方法
 * 
 * @author Administrator
 *
 */
@AllArgsConstructor
@Getter
public enum SeikyuKubun implements Kubun {
	請求書郵送("00"), 納品時請求("10"), 請求書不要("20"), 未設定("");
	String code;
}
