package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import domain.Kakikomi;

public class AddCommentDAO {

    
    public AddCommentDAO(Kakikomi bo) {

        if(bo.getName().isEmpty()) {
            bo.setName( "名無し");
        }
        if(bo.getComment().isEmpty()) {
            bo.setComment( "コメント無し");
        }


        final String jdbcId = "root";
        final String jdbcPass = "";
        final String jdbcUrl = "jdbc:mysql://localhost:3306/board?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Asia/Tokyo";

        Connection con = null;

        try {

            con = DriverManager.getConnection(jdbcUrl, jdbcId, jdbcPass);

            System.out.println("Connected....");

            try {

                PreparedStatement ps = con.prepareStatement("INSERT INTO board (name, comment) VALUES (?, ?)");

                ps.setString(1, bo.getName());
                ps.setString(2, bo.getComment());

               
                int r = ps.executeUpdate();

                if (r != 0) {
                    System.out.println(r + "件の書き込みを追加しました。");
                } else {
                    System.out.println("書き込みできませんでした。");
                }

                ps.close();

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

        }

    }

}
