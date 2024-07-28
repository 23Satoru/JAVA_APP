/************************************************************************************
 *
 * メンバー管理  テスト用ドライバ
 *
 *
 * 		@author
 * 		@version	1.0
 *
 ************************************************************************************/

package eSystem.test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import eSystem.ConsoleInput;
import eSystem.dao.ConnectionManager;
import eSystem.dao.MemberDAO;
import eSystem.entity.Member;

//
//ヒントを参考に ★印 の箇所に実装する必要があります。
//
public class MemberMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Connection   con = null;

		// データベースに接続する。
		try {
			con = ConnectionManager.getConnection();
		} catch (SQLException e) {
			System.out.println("データベースへの接続に失敗しました。");
			e.printStackTrace();
			System.exit(1);
		}

		// ここからテストを行う。
		try {
			// ★
			// ConsoleInputオブジェクトをnewする
			ConsoleInput ci = new ConsoleInput();
			// ★
			// コンソール画面に "検索する従業員のメンバーコードを入力してください。"と表示する。
			// 入力したメンバーコードはString型のmemberCodeに格納する
			String memberCode = ci.getConsole("検索する従業員のメンバーコードを入力してください。");

			// 実行の構成からメンバーコードを入力する場合
			//String memberCode = args[0];

	        // メンバーDAOのオブジェクトを生成する
			MemberDAO memberDAO  = new MemberDAO(con);

			// ★
			// メンバーDAOのメンバー検索メソッド(引数はメンバーコード)を呼び出してメンバー検索を行う
			Member member = memberDAO.find(memberCode);

			// 検索結果を出力する
			System.out.println("＜メンバー検索１＞");
			if (member != null) {// 結果のオブジェクトがnull以外
				System.out.println("メンバーコード ：" + member.getMemberCode());/* メンバーコード */
				System.out.println("メンバー名     ：" + member.getMemberName());/* 名前 */
				//System.out.println("パスワード     ：" + member.getPassword()); // パスワードは出力しない
				System.out.println("権限           ：" + member.getRole());/* Role */
				System.out.println("メールアドレス ：" + member.getMail());/* Mail */
				System.out.println("郵便番号       ：" + member.getZipCode());/* ZipCode */
				System.out.println("都道府県       ：" + member.getPrefecture());/* Prefecture */
				System.out.println("住所           ：" + member.getAddress());/* Address */
				System.out.println("電話番号       ：" + member.getTel());/* Tel */
				System.out.println("在籍年数       ：" + Integer.toString(member.getYears()) + "年");
			}
			else{
				// 結果のオブジェクトがnull
				System.out.println("入力されたメンバーコードが間違っています。");
			}
		} catch (NullPointerException e) {
			System.out.println("NullPointerExceptionがスローされました。");
			e.printStackTrace();
//★ MemberDAOの検索メソッドを実装するとSQLExceptionの処理が必要になります。コメントを外して下さい。
		} catch (SQLException e) {
			System.out.println("SQLExceptionがスローされました。");
			e.printStackTrace();
//★ getConsoleメソッドを実装するとIOExceptionの処理が必要になります。コメントを外して下さい。
		} catch (IOException e) {
			System.out.println("IOExceptionがスローされました。");
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
