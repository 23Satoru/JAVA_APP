/*
 * MemberDAO
 *
 * 役割
 * Memberテーブルへアクセスするメソッド定義
 * 主にSQL文を使ってMemberテーブルへアクセスする
 *
 * メンバー登録
 * メンバー削除
 * メンバー変更
 * メンバー個別検索
 * メンバー全件検索
 *
 *
 */
package eSystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import eSystem.entity.Member;


public class MemberDAO {

    /**
     * データベースの接続
     */
	private Connection con;

    /**
     * コンストラクタ
     *
     * @param con データベースの接続
     */
	public MemberDAO(Connection con) {
		this.con = con;
	}

    /**
     * メンバーを検索
     *
     * @param memberCode メンバーコード
     * @return Member メンバー
     * @throws SQLException データベースエラーが発生した場合
     */
	public Member find(String memberCode) throws SQLException {
		//★
		String sql = "SELECT MemberCode,Role,Name,Password,ZipCode,Prefecture,Address,Tel,Mail,Years, DepartmentCode FROM member WHERE MemberCode = ?";

		PreparedStatement stmt = null;
		ResultSet res = null;
		Member member = null;

		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, memberCode);
			res = stmt.executeQuery();

			if (res.next()) {

				member = new Member(res.getString("MemberCode"), res.getString("Role"), res.getString("Name"), res.getString("Password"), res.getString("ZipCode"),
						res.getString("Prefecture"), res.getString("Address"), res.getString("Tel"), res.getString("Mail"),res.getInt("Years"),
						res.getString("DepartmentCode"));
			}


		} finally {
			if (res != null) {
				res.close();
			}
			if (stmt != null) {
				stmt.close();
			}
		}

		return member;
	}

    /**
     * メンバーを検索する。
     *
     * @param memberCode メンバーコード
     * @param password   パスワード
     * @return Member メンバー
     * @throws SQLException データベースエラーが発生した場合
     */
	public Member findMember(String memberCode, String password) throws SQLException {
		//★
        String sql = "SELECT MemberCode,Role,Name,Password,ZipCode,Prefecture,Address,Tel,Mail,Years,DepartmentCode FROM member WHERE MemberCode = ?";

        PreparedStatement stmt = null;
        ResultSet res = null;
        Member member = null;

		try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, memberCode);
            res = stmt.executeQuery();

            if (res.next()) {
            	
                member = new Member(
                        res.getString("MemberCode"), res.getString("Role"), res.getString("Name"), res.getString("Password"),
                        res.getString("ZipCode"), res.getString("Prefecture"), res.getString("Address"), res.getString("Tel"),
                        res.getString("Mail"), res.getInt("Years"), res.getString("DepartmentCode"));
            }
		} finally {
			if (res != null) {
				res.close();
			}
			if (stmt != null) {
				stmt.close();
			}
		}

		return member;
	}

    /**
     * メンバーを登録する。
     *
     * @param member メンバー
     * @return boolean
     * @throws SQLException データベースエラーが発生した場合
     */
	public boolean insert(Member member) throws SQLException {
		boolean result = false;
//		//★
		String sql = "INSERT INTO Member VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement(sql);
//			//★
			stmt.setString(1, member.getMemberCode());
			stmt.setString(2, member.getMemberName());
			stmt.setString(3, member.getPassword());
			stmt.setString(4, member.getRole());
			stmt.setString(5, member.getMail());
			stmt.setString(6, member.getZipCode());
			stmt.setString(7, member.getPrefecture());
			stmt.setString(8, member.getAddress());
			stmt.setString(9, member.getTel());
			stmt.setInt(10, member.getYears());
			stmt.setString(11, member.getDepartmentCode());


			int count=0;
			
			count = stmt.executeUpdate();
			if (count == 1) { 
				result = true;
			}
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}

		return result;

	}

    /**
     * メンバーを削除する。
     *
     * @param memberCode メンバーコード
     * @return boolean true: 処理成功, false: 処理失敗
     * @throws SQLException データベースエラーが発生した場合
     */
    public boolean deleteMember(String memberCode) throws SQLException {
        String sql = "DELETE FROM Member WHERE memberCode = ?";

         try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, memberCode);
            int count = stmt.executeUpdate();
            return count == 1;
        }
    }

    /**
     * メンバーを更新する。
     *
     * @param member メンバー
     * @return boolean true: 処理成功, false: 処理失敗
     * @throws SQLException データベースエラーが発生した場合
     */

    public boolean updateMember(Member member) throws SQLException {
        String sql = "UPDATE Member SET " +
                "MemberCode = ?," +
                "Name = ?," +
                "Password = ?," +
                "Role = ?," +
                "Mail = ?," +
                "ZipCode = ?," +
                "Prefecture = ?," +
                "Address = ?," +
                "Tel = ?," +
                "Years = ?," +
                "DepartmentCode = ? " +
                "WHERE MemberCode = ?";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, member.getMemberCode());
            stmt.setString(2, member.getMemberName());
            stmt.setString(3, member.getPassword());
            stmt.setString(4, member.getRole());
            stmt.setString(5, member.getMail());
            stmt.setString(6, member.getZipCode());
            stmt.setString(7, member.getPrefecture());
            stmt.setString(8, member.getAddress());
            stmt.setString(9, member.getTel());
            stmt.setInt(10, member.getYears());
            stmt.setString(11, member.getDepartmentCode());

            int count = stmt.executeUpdate();
            return count == 1;
        }
    }

    /**
     * メンバーを全件検索する。
     *
     * @return メンバーリスト
     * @throws SQLException データベースエラーが発生した場合
     */
    public List<Member> findMemberList() throws SQLException {
        List<Member> memberList = new ArrayList<>();
        //★
        String sql = "SELECT MemberCode,Role,Name,Password,ZipCode,Prefecture,Address,Tel,Mail,Years,DepartmentCode FROM member ORDER BY MemberCode";

        try (Statement stmt = con.createStatement(); ResultSet res = stmt.executeQuery(sql)) {

            while (res.next()) {
                Member member = new Member(
                        res.getString("MemberCode"),
                        res.getString("Role"),
                        res.getString("Name"),
                        res.getString("Password"),
                        res.getString("ZipCode"),
                        res.getString("Prefecture"),
                        res.getString("Address"),
                        res.getString("Tel"),
                        res.getString("Mail"),
                        res.getInt("Years"),
                        res.getString("DepartmentCode")
                );
                memberList.add(member);
            }
        }
        return memberList;
    }

}
