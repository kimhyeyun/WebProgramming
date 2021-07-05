package kr.org.connect.jdbcexam;

import kr.org.connect.jdbcexam.dao.RoleDao;

public class JDBCExam4 {
	
	public static void main(String[] args) {
		int roleId = 500;
		
		RoleDao dao = new RoleDao();
		
		int deleteCnt = dao.deleteRole(roleId);
		
		System.out.println(deleteCnt);
	}

}
