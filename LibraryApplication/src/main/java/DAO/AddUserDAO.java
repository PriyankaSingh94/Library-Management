package main.java.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import com.mysql.jdbc.PreparedStatement;
import main.java.DTOs.CommonDTO;
import main.java.DTOs.LibrarianDTO;
import main.java.DTOs.StudentDTO;
import main.java.DTOs.TeacherDTO;

public class AddUserDAO {

	TestConnection test;
	Connection con;
	Statement stmt;
	PreparedStatement pst;
	ResultSet rs;
	String query;
	String str;
	String tblName;

	public void addUser(CommonDTO obj, String deptName) {

		int i = 0;
		switch (obj.getUserDto().getRoleName()) {
		case "student":
			tblName = "tbl_students";
			break;
		case "teacher":
			tblName = "tbl_teacher";
			break;
		case "librarian":
			tblName = "tbl_librarian";
			break;
		}
		str = "insert into library_app.tbl_lib_enrol (username) values(?)";
		if (connect(str, obj.getUserDto().getUserName()) != 0) {
			if (tblName.equalsIgnoreCase("tbl_librarian")) {
				query = "insert into library_app." + tblName
						+ " (first_name, last_name, email_id, contact_no, address, role_id, lib_id) "
						+ "values (?,?,?,?,?,"
						+ "(select role_id from library_app.tbl_roles where role_name = ?),(select lib_id from library_app.tbl_lib_enrol where username = ?))";
			} else {
				query = "insert into library_app." + tblName
						+ " (first_name, last_name, email_id, contact_no, address, role_id, lib_id,dept_id) "
						+ "values (?,?,?,?,?,"
						+ "(select role_id from library_app.tbl_roles where role_name = ?),(select lib_id from library_app.tbl_lib_enrol where username = ?),"
						+ "(select dept_id from library_app.tbl_departments where dept_name = ?))";
			}
			try {
				test = new TestConnection();
				con = test.getConnection();
				pst = (PreparedStatement) con.prepareStatement(query);
				pst.setString(1, obj.getFirstName());
				pst.setString(2, obj.getLastName());
				pst.setString(3, obj.getEmailId());
				pst.setLong(4, obj.getContactNum());
				pst.setString(5, obj.getAddress());
				pst.setString(6, obj.getUserDto().getRoleName());
				pst.setString(7, obj.getUserDto().getUserName());
				pst.setString(8, deptName);
				i = pst.executeUpdate();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public int connect(String query, String name) {

		int i = 0;
		try {
			test = new TestConnection();
			con = test.getConnection();
			pst = (PreparedStatement) con.prepareStatement(query);
			pst.setString(1, name);
			i = pst.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		return i;
	}

}
