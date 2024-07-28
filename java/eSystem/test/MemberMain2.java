package eSystem.test;

import java.sql.Connection;
import java.sql.SQLException;

import eSystem.dao.ConnectionManager;
import eSystem.dao.MemberDAO;
import eSystem.entity.Member;

public class MemberMain2 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Connection   con = null;

		// 引数の数をチェックする
		if(args.length != 11)
		{
			System.out.println("引数を１１個設定してください。");
			System.exit(1);
		}

		// データベースに接続する。
		try {
			con = ConnectionManager.getConnection();
		} catch (SQLException e) {
			System.out.println("データベースへの接続に失敗しました。");
			e.printStackTrace();
			System.exit(1);
		}

		try {
			// ★  引数の値を変数に格納する
			String memberCode = args[0];// ★引数1番目
			String memberName = args[1];// ★引数2番目
			String password = args[2];// ★引数3番目
			String role = args[3];// ★引数4番目
			String mail = args[4];// ★引数5番目
			String zipCode = args[5];// ★引数6番目
			String prefecture = args[6];// ★引数7番目
			String address = args[7];// ★引数8番目
			String tel = args[8];// ★引数9番目
			int years = Integer.parseInt(args[9]);// ★引数10番目
			String departmentCode = args[10];// ★引数11番目

			// メンバー情報を格納するオブジェクトを生成する
			Member member = new Member(memberCode, role, memberName, password, zipCode, prefecture, address, tel, mail, years, departmentCode);

			// メンバーDAOのオブジェクトを生成する
			MemberDAO memberDAO  = new MemberDAO(con);

			// ★ メンバーコードでメンバー検索(引数はメンバーコード)を行い、メンバーが存在しているか確認する
			Member findMember= memberDAO.find(memberCode);

			// ★ 既に登録済みのメンバーコードの場合は、メッセージ表示
			if (findMember != null) {
				System.out.println("既に登録済みのメンバーコードです。登録をやり直して下さい。");
			}else {
				//★ メンバー登録メソッド呼び出し
				memberDAO.insert(member);

				// 登録結果を出力する
				System.out.println("＜メンバー登録＞");
				System.out.println("メンバーコード ：" + member.getMemberCode());/* メンバーコード */
				System.out.println("メンバー名     ：" + member.getMemberName());/* 名前 */
				//System.out.println("パスワード     ：" + member.getPassword()); // パスワードは出力しない
				System.out.println("権限           ：" + member.getRole());/* Role */
				System.out.println("メールアドレス ：" + member.getMail());/* Mail */
				System.out.println("郵便番号       ：" + member.getZipCode());/* ZipCode */
				System.out.println("都道府県       ：" + member.getPrefecture());/* Prefecture */
				System.out.println("住所           ：" + member.getAddress());/* Address */
				System.out.println("電話番号       ：" + member.getTel());/* Tel */
				System.out.println("在籍年数       ：" + Integer.toString(member.getYears()) + "年");/* 在籍年数 */
				System.out.println("部署コード     ：" + member.getDepartmentCode());/* DepartmentCode */
			}
		} catch (NullPointerException e) {
			// データベース接続が無効な状態で、MemberDAOオブジェクトの引数に指定した場合、NullPointerExceptionが発生する
			System.out.println("NullPointerExceptionがスローされました。");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("SQLExceptionがスローされました。");
			e.printStackTrace();
		} finally {
			try {// データベースへの接続を切断する
				con.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
