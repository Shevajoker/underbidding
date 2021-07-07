package ru.underbidding.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ru.underbidding.model.AnrexProduct;
import ru.underbidding.model.OtherProduct;
import ru.underbidding.model.ShowTable;
import ru.underbidding.service.AnrexProductService;
import ru.underbidding.service.OtherProductService;

/**
 * Servlet implementation class InformationServlet
 */
//@WebServlet("/information")
public class InformationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InformationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String data = request.getParameter("date");
		System.out.println(data);
		if (data!=null) {
		List<AnrexProduct> listAnrexProduct = null;
		List<OtherProduct> listOtherProduct = null;
		List<ShowTable> listShowTables = new ArrayList<ShowTable>();
		AnrexProductService anrexProductService = new AnrexProductService();
		OtherProductService otherProductService = new OtherProductService();
		
		listAnrexProduct = anrexProductService.getAllAnrexProducts();
		listOtherProduct = otherProductService.getOtherProductsBySiteName(data);
		
		for (AnrexProduct anrexProduct : listAnrexProduct) {
			for(OtherProduct otherProduct : listOtherProduct) {
				if (anrexProduct.getArticle().equals(otherProduct.getAnrexArticle())) {
				
			ShowTable showTable = new ShowTable(anrexProduct.getArticle(), anrexProduct.getName(), anrexProduct.getPriceActual(), otherProduct.getPriceActual(), anrexProduct.getPriceOld(), otherProduct.getPriceOld(), anrexProduct.getUrl(), otherProduct.getUrl());
			listShowTables.add(showTable);
				}
			}
		}
		
		
		HttpSession session = request.getSession();
		session.setAttribute("listShowTables", listShowTables);
		session.setAttribute("data", data);
		}
		
		
		getServletContext().getRequestDispatcher("/information.jsp").forward(request, response);
		
	}

	
}
