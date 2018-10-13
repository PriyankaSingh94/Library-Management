package main.java.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import main.java.DTOs.DepartmentDTO;
import main.java.DTOs.RoleDTO;
import main.java.UI.HomePage;

public class RolesAndDepartmentsDAO {

	TestConnection test;
	Connection con;
	Statement stmt;
	PreparedStatement pst;
	ResultSet rs;
	String query;
	HomePage home;
	String[] rolesList = { "student", "teacher", "librarian" };
	String[] deptList = { "ECE", "CS", "MECH", "Civil", "EE", "IE", "IT" };

	public void addRolesAndDepts() throws SQLException {
		if(getRoles().size() == 0){
			for (int i = 0; i < rolesList.length; i++) {
				query = "insert into library_app.tbl_roles (role_name) values (?)";
				connect(query, rolesList[i]);
			}
		}
		if(getDepartments().size() == 0){
			for (int i = 0; i < deptList.length; i++) {
				query = "insert into library_app.tbl_departments (title) values (?)";
				connect(query, deptList[i]);
			}
		}
	}
	
	public void connect(String query, String name) {

		try {
			test = new TestConnection();
			con = test.getConnection();
			pst = (PreparedStatement) con.prepareStatement(query);
			pst.setString(1, name);
			int i = pst.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public ResultSet connect(String query) {

		try {
			test = new TestConnection();
			con = test.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
		} catch (Exception e) {
			System.out.println(e);
		}
		return rs;
	}

	public ArrayList<DepartmentDTO> getDepartments() throws SQLException {

		String query = "select * from library_app.tbl_departments";
		ArrayList<DepartmentDTO> departments = new ArrayList<DepartmentDTO>();
		rs = connect(query);
		while (rs.next()) {
			DepartmentDTO dto = new DepartmentDTO();
			dto.setDeptId(rs.getInt(1));
			dto.setDeptName(rs.getString(2));
			departments.add(dto);
		}
		return departments;
	}

	public ArrayList<RoleDTO> getRoles() throws SQLException {

		String query = "select * from library_app.tbl_roles";
		ArrayList<RoleDTO> rolesList = new ArrayList<RoleDTO>();
		rs = connect(query);
		while (rs.next()) {
			RoleDTO dto = new RoleDTO();
			dto.setRoleId(rs.getInt(1));
			dto.setRoleName(rs.getString(2));
			rolesList.add(dto);
		}
		return rolesList;
	}

}
