package ru.underbidding.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ru.underbidding.main.AnrexInfo;

/**
 * Servlet implementation class AddArticleAnrexInfo
 */
public class AddArticleAnrexInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddArticleAnrexInfo() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String url = (String) request.getParameter("urlAnrexInfo");
		
		AnrexInfo anrexInfo = new AnrexInfo();
		anrexInfo.saveAnrexInfoProduct(url);
		
		request.setAttribute("urlAnrexInfo", "");
		getServletContext().getRequestDispatcher("/admin.jsp").forward(request, response);
		
	}

}
