package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import domain.Kakikomi;

public class BbsDao {

	final String jdbcId = "root";
	final String jdbcPass = "";
	final String jdbcUrl = "jdbc:mysql://localhost:3306/board?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Asia/Tokyo";

	
	// 投稿リストを取得
	public List<Kakikomi> findAll() {
		System.out.println("データベースから投稿リストを取得");

		List<Kakikomi> list = new ArrayList<>();

		
		Connection con = null;

		try {

			con = DriverManager.getConnection(jdbcUrl, jdbcId, jdbcPass);

			System.out.println("Connected....");

			try {
				Statement st = con.createStatement();
				String sql = "select * from bbs";

				try {

					ResultSet rs = st.executeQuery(sql);

					while (rs.next()) {

						Kakikomi kakikomi = new Kakikomi();
						kakikomi.setId(rs.getInt("id"));
						kakikomi.setName(rs.getString("name"));
						kakikomi.setComment(rs.getString("comment"));
						kakikomi.setDate(rs.getTimestamp("date"));

						list.add(kakikomi);
					}

					rs.close();
					st.close();

				} catch (SQLException e) {
					e.printStackTrace();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {

				if (con != null) {
					try {
						con.close();

					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Connection Failed.");
			return null;
		}
		return list;

	}

	// 投稿を登録
	public void add(Kakikomi kakikomi) {
		System.out.println("以下をデータベースに保存");
		System.out.println(kakikomi.getDate());
		System.out.println(kakikomi.getId());
		System.out.println(kakikomi.getName());
		System.out.println(kakikomi.getComment());

		Connection con = null;

		try {

			con = DriverManager.getConnection(jdbcUrl, jdbcId, jdbcPass);

			System.out.println("Connected....");

			try {
				Statement st = con.createStatement();
				String sql = "insert into bbs "
				+ " (id, name, comment, date)"
				+ " VALUES (?, ?, ?, NOW())";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setObject(1, kakikomi.getId(), Types.INTEGER);
				stmt.setString(2, kakikomi.getName());
				stmt.setString(3, kakikomi.getComment());
				stmt.executeUpdate();
			} catch (Exception e) {
				throw e;
			}

			
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Connection Failed.");
			
		} finally {

			if (con != null) {
				try {
					con.close();

				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

