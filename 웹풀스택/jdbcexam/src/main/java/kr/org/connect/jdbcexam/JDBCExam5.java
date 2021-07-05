package kr.org.connect.jdbcexam;

import kr.org.connect.jdbcexam.dao.RoleDao;
import kr.org.connect.jdbcexam.dto.Role;

public class JDBCExam5 {

	public static void main(String[] args) {
		int roleId = 500;
		String description = "CEO";
		
		Role role = new Role(roleId, description);
		
		RoleDao dao = new RoleDao();
		int updateCnt = dao.updateRole(role);
		
		System.out.println(updateCnt);
	}
}
