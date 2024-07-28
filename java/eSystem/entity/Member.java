/*
 * メンバーエンティティクラス
 *
 * 役割
 * DBへ登録や更新するための値を格納しておく
 * DBから取得した値を格納しておく
 *
 * クラス名＝テーブル名になることが一般的には多い
 *
 *
 */

package eSystem.entity;

public class Member {

	/** メンバーコード */
	private String memberCode;

	/** 権限 */
	private String role;

	/** メンバー名 */
	private String memberName;

	/** パスワード */
	private String password;

	/** 郵便番号 */
	private String zipCode;

	/** 都道府県 */
	private String prefecture;

	/** 住所 */
	private String address;

	/** 電話番号 */
	private String tel;

	/** メールアドレス */
	private String mail;

	/** 在籍年数 */
	private int years;

	/** 部署コード */
	private String departmentCode;

	/** 部署名 */
	private String departmentName;

	/**
	 * コンストラクタ（引数なし）
	 */
	public Member() {
	}

	/**
	 * 引数で指定した値を設定する。
	 *
	 * @param memberCode
	 * 			  メンバーコード
	 */
	public Member(String memberCode) {
		this.memberCode = memberCode;
		this.role = null;
	}
	/**
	 * 引数で指定した値を設定する。
	 *
	 * @param memberCode
	 *            メンバーコード
	 * @param role
	 *            権限
	 * @param memberName
	 *            メンバー名
	 * @param password
	 *            パスワード
	 * @param zipCode
	 *            郵便番号
	 * @param prefecture
	 *            都道府県
	 * @param address
	 *            住所
	 * @param tel
	 *            電話番号
	 * @param mail
	 *            メールアドレス
	 * @param years
	 *            在籍年数
	 * @param departmentCode
	 *            部署コード
	 * @param departmentName
	 *            部署名
	 */
	public Member(String memberCode, String role, String memberName, String password, String zipCode, String prefecture,
			String address, String tel, String mail, int years, String departmentCode, String departmentName) {
		this.memberCode = memberCode;
		this.role = role;
		this.memberName = memberName;
		this.password = password;
		this.zipCode = zipCode;
		this.prefecture = prefecture;
		this.address = address;
		this.tel = tel;
		this.mail = mail;
		this.years = years;
		this.departmentCode = departmentCode;
		this.departmentName = departmentName;
	}

	/**
	 * 引数で指定した値を設定する。
	 *
	 * @param memberCode
	 *            メンバーコード
	 * @param role
	 *            権限
	 * @param memberName
	 *            メンバー名
	 * @param password
	 *            パスワード
	 * @param zipCode
	 *            郵便番号
	 * @param prefecture
	 *            都道府県
	 * @param address
	 *            住所
	 * @param tel
	 *            電話番号
	 * @param mail
	 *            メールアドレス
	 * @param years
	 *            在籍年数
	 * @param departmentCode
	 *            部署コード
	 */
	public Member(String memberCode, String role, String memberName, String password, String zipCode, String prefecture,
			String address, String tel, String mail, int years, String departmentCode) {
		this.memberCode = memberCode;
		this.role = role;
		this.memberName = memberName;
		this.password = password;
		this.zipCode = zipCode;
		this.prefecture = prefecture;
		this.address = address;
		this.tel = tel;
		this.mail = mail;
		this.years = years;
		this.departmentCode = departmentCode;
	}
	/**
	 * メンバーコードを取得する。
	 *
	 * @return メンバーコード
	 */
	public String getMemberCode() {
		return memberCode;
	}

	/**
	 * メンバーコードを設定する。
	 *
	 * @param memberCode
	 *            メンバーコード
	 */
	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
	}

	/**
	 * 権限を取得する。
	 *
	 * @return 権限
	 */
	public String getRole() {
		return role;
	}

	/**
	 * 権限を設定する。
	 *
	 * @param role
	 *            権限
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * メンバー名を取得する。
	 *
	 * @return メンバー名
	 */
	public String getMemberName() {
		return memberName;
	}

	/**
	 * メンバー名を設定する。
	 *
	 * @param memberName
	 *            メンバー名
	 */
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	/**
	 * パスワードを取得する。
	 *
	 * @return パスワード
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * パスワードを設定する。
	 *
	 * @param password
	 *            パスワード
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 郵便番号を取得する。
	 *
	 * @return 郵便番号
	 */
	public String getZipCode() {
		return zipCode;
	}

	/**
	 * 郵便番号を設定する。
	 *
	 * @param zipCode
	 *            郵便番号
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	/**
	 * prefectureを取得する。
	 *
	 * @return prefecture
	 */
	public String getPrefecture() {
		return prefecture;
	}

	/**
	 * prefectureを設定する。
	 *
	 * @param prefecture
	 *            prefecture
	 */
	public void setPrefecture(String prefecture) {
		this.prefecture = prefecture;
	}

	/**
	 * 住所を取得する。
	 *
	 * @return 住所
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * 住所を設定する。
	 *
	 * @param address
	 *            住所
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * 電話番号を取得する。
	 *
	 * @return 電話番号
	 */
	public String getTel() {
		return tel;
	}

	/**
	 * 電話番号を設定する。
	 *
	 * @param tel
	 *            電話番号
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}

	/**
	 * メールアドレスを取得する。
	 *
	 * @return メールアドレス
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * メールアドレスを設定する。
	 *
	 * @param mail
	 *            メールアドレス
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * 部署コードを取得する。
	 *
	 * @return departmentCode
	 *            部署コード
	 */
	public String getDepartmentCode() {
		return departmentCode;
	}

	/**
	 * 部署コードを設定する。
	 *
	 * @param departmentCode
	 *            部署コード
	 */
	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	/**
	 * 部署名を取得する。
	 *
	 * @return departmentName
	 *            部署名
	 */
	public String getDepartmentName() {
		return departmentName;
	}

	/**
	 * 部署名を設定する。
	 *
	 * @param departmentName
	 *            部署名
	 */
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	/**
	 * 在籍年数を取得する。
	 *
	 * @return years
	 *            在籍年数
	 */
	public int getYears() {
		return years;
	}
	/**
	 * 在籍年数を設定する。
	 *
	 * @param years
	 *            在籍年数
	 */
	public void setYears(int years) {
		this.years = years;
	}


}
