package kr.or.connect.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.or.connect.dto.TodoDto;

public class TodoDao {

	private static String dburl = "jdbc:mysql://localhost:3306/todo";
	private static String dbuser = "connectuser";
	private static String dbpw = "connect123!@#";
	
	public int addTodo(TodoDto dto) {
		int result = 0;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		String sql = "INSERT INTO todo (title, name, sequence) VALUES (?,?,?)";
		
		try {
			conn = DriverManager.getConnection(dburl, dbuser, dbpw);
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, dto.getTitle());
			ps.setString(2, dto.getName());
			ps.setInt(3, dto.getSequence());
			
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(ps != null) {
				try {
					ps.close();
				}catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				}catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}
		
		return result;
	}
	
	
	public List<TodoDto> getTodos(){
		List<TodoDto> list = new ArrayList<TodoDto>();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		TodoDto dto = null;
		
		String sql = "SELECT * FROM todo ORDER BY regdate";
		
		try {
			conn = DriverManager.getConnection(dburl, dbuser, dbpw);
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				long id = rs.getLong(1);
				String title = rs.getString(2);
				String name = rs.getString(3);
				int seq = rs.getInt(4);
				String type = rs.getString(5);
				String regdate = rs.getString(6);
				
				dto = new TodoDto(id, name, regdate, seq, title, type); 
				list.add(dto);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(rs != null) {
				try {
					rs.close();
				}catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
			
			if(ps != null) {
				try {
					ps.close();
				}catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
			
			if(conn != null) {
				try {
					conn.close();
				}catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}
		
		return list;
	}
	
	public int updateTodo(long id) {
		int result = 0;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		String sql1 = "UPDATE todo SET type = 'DOING' WHERE type = 'TODO' AND id = ?";
		String sql2 = "UPDATE todo SET type = 'DONE' WHERE type = 'DOING' AND id = ?";		

		
		// TODO -> DOING
		try {
			conn = DriverManager.getConnection(dburl, dbuser, dbpw);
			ps = conn.prepareStatement(sql2);
			ps.setLong(1, id);
			result = ps.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(ps != null) {
				try {
					ps.close();
				}catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				}catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}
		
		try {
			conn = DriverManager.getConnection(dburl, dbuser, dbpw);
			ps = conn.prepareStatement(sql1);
			ps.setLong(1, id);
			result = ps.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(ps != null) {
				try {
					ps.close();
				}catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				}catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}
		
		return result;
	}
}
