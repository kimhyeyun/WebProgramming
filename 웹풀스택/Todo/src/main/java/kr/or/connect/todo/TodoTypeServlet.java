package kr.or.connect.todo;

import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.or.connect.dao.TodoDao;
import kr.or.connect.dto.TodoDto;

/**
 * Servlet implementation class TodoTypeServlet
 */
public class TodoTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TodoTypeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	super.doGet(req, resp);
    }
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		
		// client에서 보낸 데이터를 받음
		Long id = Long.parseLong(request.getParameter("id"));
		String type = request.getParameter("type");
		
		// id와 일치하는 할 일의 type을 변경
		TodoDao dao = new TodoDao();
		dao.updateTodo(id);
		
		List<TodoDto> list = dao.getTodos();
		List<TodoDto> jsonList = new ArrayList<TodoDto>();
		
		// 변경된 할 일 목록을 list에 저장
		for(TodoDto dto : list) {
			if(type.equals("TODO") && dto.getType().equals("DOING")) {
				jsonList.add(dto);
			}
			else if(type.equals("DOING") && dto.getType().equals("DONE")) {
				jsonList.add(dto);
			}
		}
		
		//list를 json 형식으로 변경
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(jsonList);
		
		// 전송
		PrintWriter out = response.getWriter();
		out.println(json);
		out.close();

		
	}


}
