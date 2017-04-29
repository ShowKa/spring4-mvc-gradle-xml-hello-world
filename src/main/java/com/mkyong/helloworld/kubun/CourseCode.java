package com.mkyong.helloworld.kubun;

import com.mkyong.helloworld.kubun.i.Kubun;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CourseCode implements Kubun<CourseCode> {
	ZZZZ("ZZZZ");
	private String code;
}