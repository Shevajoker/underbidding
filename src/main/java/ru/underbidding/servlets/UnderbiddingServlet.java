package ru.underbidding.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ru.underbidding.model.AnrexProduct;
import ru.underbidding.service.AnrexProductService;

/**
 * Servlet implementation class UnderbiddingServlet
 */
public class UnderbiddingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UnderbiddingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		List<AnrexProduct> products = null;
		AnrexProductService anrexProductService = new AnrexProductService();
		products = anrexProductService.getAllAnrexProducts();
		
		
//		String urlP = request.getRequestURL().toString();
		String urlP = request.getContextPath();
		
		
		
		HttpSession session = request.getSession();
		session.setAttribute("products", products);
		session.setAttribute("urlP", urlP);
		getServletContext().getRequestDispatcher("/admin.jsp").forward(request, response);
	}

}
