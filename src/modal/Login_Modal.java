package modal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.Login_Bean;
import common_things.DB_Connection;

public class Login_Modal {
	public boolean check_email(Login_Bean obj_Login_Bean) {
		boolean flag = false;
		
		DB_Connection obj_DB_Connection = new DB_Connection();
		Connection connection = obj_DB_Connection.getConnection();

		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String query = "select * from employee_mst where email=? and password=?";
			ps = connection.prepareStatement(query);
			ps.setString(1, obj_Login_Bean.getEmail());
			ps.setString(2, obj_Login_Bean.getPassword());
			System.out.println(ps);
			rs = ps.executeQuery();

			if (rs.next()) {
				flag = true;
			}
		} catch (Exception e) {

		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (Exception e2) {

			}
		}
		return flag;
	}
}