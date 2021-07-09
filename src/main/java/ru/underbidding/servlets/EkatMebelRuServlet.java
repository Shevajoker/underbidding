package ru.underbidding.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ru.underbidding.main.EkatMebelRu;
import ru.underbidding.model.AnrexProduct;
import ru.underbidding.service.AnrexProductService;

/**
 * Servlet implementation class EkatMebelRuServlet
 */
public class EkatMebelRuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EkatMebelRuServlet() {
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
		String article = (String) request.getParameter("anrex-product");
		String url = (String) request.getParameter("ekatMebelRuUrl");
		
		EkatMebelRu ekatMebelRu = new EkatMebelRu();
		ekatMebelRu.saveProduct(url, article);
		
		HttpSession session = request.getSession();
		
		session.setAttribute("AartNum", article);
		session.setAttribute("products", products);
		getServletContext().getRequestDispatcher("/admin.jsp").forward(request, response);
	}

}
