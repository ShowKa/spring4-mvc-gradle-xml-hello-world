package com.mkyong.helloworld.kubun;

import com.mkyong.helloworld.kubun.i.Kubun;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SeikyushoSakuseiBashoKubun implements Kubun {
	センター("00"), 担当部署("10"), WEB("20"), 未設定("");
	String code;
}
