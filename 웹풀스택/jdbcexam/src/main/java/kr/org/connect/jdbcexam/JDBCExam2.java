package kr.org.connect.jdbcexam;

import kr.org.connect.jdbcexam.dao.RoleDao;
import kr.org.connect.jdbcexam.dto.Role;

public class JDBCExam2 {
	public static void main(String[] args) {
		int roleId = 501;
		String description = "DTO";
		
		Role role = new Role(roleId, description);
		
		RoleDao dao = new RoleDao();
		int insertCnt = dao.addRole(role);
		
		System.out.println(insertCnt);
	}
}
