package kr.org.connect.jdbcexam;

import java.util.List;

import kr.org.connect.jdbcexam.dao.RoleDao;
import kr.org.connect.jdbcexam.dto.Role;

public class JDBCExam3 {
	public static void main(String[] args) {
	
		RoleDao dao = new RoleDao();
	
		List<Role> list = dao.getRoles();
		
		for(Role role : list) {
			System.out.println(role);
		}
	}
}
