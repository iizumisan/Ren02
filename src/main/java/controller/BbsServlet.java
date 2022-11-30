package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BbsDao;
import domain.Kakikomi;

@WebServlet("/bbs")
public class BbsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 掲示板画面を表示
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// これまでの投稿リストを取得
		BbsDao dao = new BbsDao();
		List<Kakikomi> kakikomiList = dao.findAll();

		// 投稿リストをリクエストスコープに格納(JSPに渡す)
		request.setAttribute("kakikomiList", kakikomiList);

		// 掲示板画面を表示
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/bbs.jsp");
		rd.forward(request, response);
	}

	// 投稿内容の保存
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 投稿内容を受けとる
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		String comment = request.getParameter("comment");
		
		
		// バリデーション
		
		
		
		// 問題がなければ投稿
		Kakikomi kakikomi = new Kakikomi();
		kakikomi.setName(name);
		kakikomi.setComment(comment);
		
		BbsDao dao = new BbsDao();
		dao.add(kakikomi);
		
		// 同じURLにリダイレクト→ doGetが呼び出される
		response.sendRedirect("/Ren02/bbs");
	}

}