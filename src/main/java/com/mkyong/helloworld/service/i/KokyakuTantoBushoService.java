package com.mkyong.helloworld.service.i;

import com.mkyong.helloworld.domain.KokyakuTantoBushoDomain;
import com.mkyong.helloworld.domain.NyukinMotoDomain;

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
	public boolean existsKokyakuTantoBusho(String kokyakuCode, String bushoCode);

	/**
	 * コードから顧客担当部署を取得する
	 * 
	 * @param kokyakuCode
	 *            顧客コード
	 * @param bushoCode
	 *            部署コード
	 * @return 顧客担当部署ドメイン
	 */
	public KokyakuTantoBushoDomain getKokyakuTantoBusho(String kokyakuCode, String bushoCode);

	/**
	 * 顧客担当部署の整合性チェック
	 * 
	 * @param kokyakuTantoBushoDomain
	 * @return チェック結果
	 */
	public boolean validate(KokyakuTantoBushoDomain kokyakuTantoBushoDomain);

	/**
	 * 入金元取得
	 * 
	 * @param kokyakuCode
	 *            顧客コード
	 * @param BushoCode
	 *            部署コード
	 * @return 入金元ドメイン
	 */
	public NyukinMotoDomain getNyukinMoto(String kokyakuCode, String bushoCode);

	/**
	 * 顧客担当部署情報更新
	 * 
	 * @param domain
	 *            顧客担当部署ドメイン
	 */
	public void update(KokyakuTantoBushoDomain domain);

	/**
	 * 顧客担当部署新規登録
	 * 
	 * @param domain
	 *            顧客担当部署ドメイン
	 */
	public void register(KokyakuTantoBushoDomain domain);
}
