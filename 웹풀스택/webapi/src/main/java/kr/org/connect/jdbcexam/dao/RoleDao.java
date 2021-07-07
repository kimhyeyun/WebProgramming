package kr.org.connect.jdbcexam.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.org.connect.jdbcexam.dto.Role;

public class RoleDao {
	private static String dburl = "jdbc:mysql://localhost:3306/connectdb";
	private static String dbUser = "connectuser";
	private static String dbpasswd = "connect123!@#";
	
	public int addRole(Role role) {
		int insertCount = 0;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		String sql = "INSERT INTO role(role_id, description) VALUES (?,?)";
		
		try{
			conn = DriverManager.getConnection(dburl,dbUser,dbpasswd);
			ps = conn.prepareStatement(sql);
					
			ps.setInt(1, role.getRoleId());
			ps.setString(2, role.getDescription());
			
			insertCount = ps.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return insertCount;
	}
	
	public List<Role> getRoles(){
		List<Role> list = new ArrayList<Role>();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		String sql = "SELECT description, role_id FROM role order by role_id desc";
		
		try{
			conn = DriverManager.getConnection(dburl,dbUser,dbpasswd);
			ps = conn.prepareStatement(sql);
				
			try{
				ResultSet rs = ps.executeQuery();

				while(rs.next()) {
					String description = rs.getString(1);
					int id = rs.getInt(2);
					Role role = new Role(id, description);
					list.add(role);
				}
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}catch (Exception e1) {
			// TODO: handle exception
			e1.printStackTrace();
		}
		return list;
	}
	
	public int deleteRole(Integer roleId) {
		int deleteCnt = 0;
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
			
			String sql = "DELETE FROM role WHERE role_id=?";
			
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, roleId);
			
			deleteCnt = ps.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if(ps != null) {
				try {
					ps.close();
				}catch (Exception e) {
					// TODO: handle exception
				}
			}
			if(conn != null) {
				try {
					conn.close();
				}catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
		return deleteCnt;
	}
	
	public int updateRole(Role role) {
		int updateCnt = 0;
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
			
			String sql = "UPDATE role SET description = ? WHERE role_id=?";
			
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, role.getDescription());
			ps.setInt(2, role.getRoleId());
			
			updateCnt = ps.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if(ps != null) {
				try {
				ps.close();
				}catch (Exception e2) {
					// TODO: handle exception
				}
			}
			
			if(conn != null) {
				try {
					conn.close();
				}catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
		return updateCnt;
	}
	
	
	public Role getRole(Integer roleId) {
		Role role = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dburl,dbUser,dbpasswd);
			String sql = "SELECT description,role_id FROM role WHERE role_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, roleId);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				String description = rs.getString(1);
				int id = rs.getInt("role_id");
				role = new Role(id,description);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) {
				try {
					rs.close();
				}catch (SQLException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
			if(ps!=null) {
				try {
					ps.close();
				}catch (SQLException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				}catch (SQLException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}
		return role;
	}


}
