/*package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.subscriptionDAO;
import vo.subscriptionVO;

*//**
 * Servlet implementation class guestsubscriptionInsertController
 *//*
@WebServlet("/guestsubscriptionInsertController")
public class guestsubscriptionInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    *//**
     * @see HttpServlet#HttpServlet()
     *//*
    public guestsubscriptionInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	*//**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 *//*
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	*//**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 *//*
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		subscriptionDAO subscriptionObj =  new subscriptionDAO();

		String email_id=(String) session.getAttribute("email_id");
		
		subscriptionVO obj = new subscriptionVO();
		String[] ein = request.getParameterValues("EIN");
		
		for(int i=0;i<ein.length;i++){
			System.out.println(ein[i]);
			obj.setEmail_id(email_id);
			obj.setEIN(ein[i]);
			subscriptionObj.insert(obj);
		}
		response.sendRedirect("user/index.jsp");
	}

}
*/