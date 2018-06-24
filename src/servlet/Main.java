package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.GetMutterListLogic;
import model.Mutter;
import model.PostMutterLogic;
import model.User;

/**
 * Servlet implementation class Main
 */
@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//つぶやきリストを取得して、リクエストスコープに保存
		GetMutterListLogic getMutterListLogic = new GetMutterListLogic();
		List<Mutter> mutterList = getMutterListLogic.execute();
		request.setAttribute("mutterList",  mutterList);

//		ServletContext application = this.getServletContext();
//		List<Mutter> mutterList = (List<Mutter>) application.getAttribute("mutterList");
//		if(mutterList == null){
//			mutterList = new ArrayList<Mutter>();
//			application.setAttribute("mutterList",  mutterList);
//		}
		HttpSession session = request.getSession();
		User loginUser = (User) session.getAttribute("loginUser");

		if(loginUser == null){
			response.sendRedirect("/example/");
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("main.jsp");
			dispatcher.forward(request,  response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String text = request.getParameter("text");

		if(text != null && text.length() != 0){
//			ServletContext application = this.getServletContext();
//			List<Mutter> mutterList = (List<Mutter>) application.getAttribute("mutterList");
			HttpSession session = request.getSession();
			User loginUser = (User) session.getAttribute("loginUser");
			//つぶやきをつぶやきリストに追加
//			Mutter mutter = new Mutter(loginUser.getName(), text);
//			PostMutterLogic postMutterLogic = new PostMutterLogic();
//			postMutterLogic.execute(mutter);

			Mutter mutter = new Mutter(loginUser.getName(), text);
			PostMutterLogic postMutterLogic = new PostMutterLogic();
			postMutterLogic.execute(mutter);

//			application.setAttribute("mutterList",mutterList);
		} else {
			request.setAttribute("errorMsg",  "つぶやきが入力されていません");
		}

		//つぶやきリストを取得して、リクエストスコープに保存
		GetMutterListLogic getMutterListLogic = new GetMutterListLogic();
		List<Mutter> mutterList = getMutterListLogic.execute();
		request.setAttribute("mutterList",  mutterList);


		RequestDispatcher dispatcher = request.getRequestDispatcher("/main.jsp");
		dispatcher.forward(request, response);


		/*ServletContext application = this.getServletContext();
		List<Mutter> mutterList = (List<Mutter>) application.getAttribute("mutterList");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/main.jsp");
		dispatcher.forward(request, response);*/



		/*ServletContext application = this.getServletContext();
		List<Mutter> mutterList = (List<Mutter>) application.getAttribute("mutterList");
		if(mutterList == null){
			mutterList = new ArrayList<Mutter>();
			application.setAttribute("mutterList", mutterList);
		}

		HttpSession session = request.getSession();
		User loginUser = (User) session.getAttribute("loginUser");

		if(loginUser == null){
			response.sendRedirect("/example/");
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/main.jsp");
			dispatcher.forward(request, response);
		}*/
	}

}
