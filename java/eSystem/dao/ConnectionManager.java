/*
 * DB接続管理クラス
 *
 * 役割
 * DB接続時のログイン情報（URL、USER ID、パスワード）を使い、DB接続を行う
 * DB接続後にコネクションオブジェクトを返却する
 *
 */

package eSystem.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

	private static final String URL = "jdbc:mysql://localhost:3306/sample?";
	private static final String USER = "root";
	private static final String PASSWORD = "pass";

	/**
	 * データベースの接続を取得する。
	 * @return データベースの接続
	 */
	public static synchronized Connection getConnection() throws SQLException {
		Connection con = null;
		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch(SQLException e) {
			e.printStackTrace();
			throw e;
		}

		return con;
	}
}
