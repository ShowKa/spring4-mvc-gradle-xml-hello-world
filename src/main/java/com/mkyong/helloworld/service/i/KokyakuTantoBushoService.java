package com.mkyong.helloworld.service.i;

public interface KokyakuTantoBushoService {
	/**
	 * 顧客に、すでに担当部署が登録されているかチェックする
	 * 
	 * @param kokyakuCode
	 *            顧客コード
	 * @param bushoCode
	 *            部署コード
	 * @return チェック結果
	 */
	public boolean existsTantoBusho(String kokyakuCode, String bushoCode);
}
