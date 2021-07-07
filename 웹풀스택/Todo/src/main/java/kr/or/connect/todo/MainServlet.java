package kr.or.connect.todo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.connect.dao.TodoDao;
import kr.or.connect.dto.TodoDto;

/**
 * Servlet implementation class MainServlet
 */
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MainServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		TodoDao dao = new TodoDao();
		List<TodoDto> list = dao.getTodos();

		List<TodoDto> todo = new ArrayList<TodoDto>();
		List<TodoDto> doing = new ArrayList<TodoDto>();
		List<TodoDto> done = new ArrayList<TodoDto>();

		for (TodoDto dto : list) {
			if (dto.getType().equals("TODO"))
				todo.add(dto);
			else if (dto.getType().equals("DOING"))
				doing.add(dto);
			else if (dto.getType().equals("DONE"))
				done.add(dto);
		}

		req.setAttribute("todo", todo);
		req.setAttribute("doing", doing);
		req.setAttribute("done", done);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/main.jsp");
		dispatcher.forward(req, resp);
	}

}
