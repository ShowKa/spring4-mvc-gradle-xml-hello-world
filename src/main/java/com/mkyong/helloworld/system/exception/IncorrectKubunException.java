package com.mkyong.helloworld.system.exception;

import com.mkyong.helloworld.kubun.i.Kubun;

import lombok.Getter;

/**
 * 設定対象に設定不可の区分が設定された場合の例外
 * 
 * @author Administrator
 *
 */
@Getter
public class IncorrectKubunException extends ApplicationException {
	/**
	 * SID.
	 */
	private static final long serialVersionUID = -7827002962832575044L;

	/** 設定対象 */
	private String targetName;

	/** 区分名 */
	private Kubun kubunName;

	/**
	 * 区分不正例外
	 * 
	 * @param kubunName
	 */
	public IncorrectKubunException(String targetName, Kubun kubun) {
		super(targetName + "に" + kubun.toString() + "は設定できません。");
		this.targetName = targetName;
		this.kubunName = kubun;
	}

}
