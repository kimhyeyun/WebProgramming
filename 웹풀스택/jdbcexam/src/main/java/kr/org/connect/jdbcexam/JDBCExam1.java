package kr.org.connect.jdbcexam;

import kr.org.connect.jdbcexam.dao.RoleDao;
import kr.org.connect.jdbcexam.dto.Role;

public class JDBCExam1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RoleDao dao = new RoleDao();
		Role role = dao.getRole(100);
		System.out.println(role);
	}

}
