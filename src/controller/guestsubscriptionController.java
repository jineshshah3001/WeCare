package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.organizationDAO;
import dao.subscriptionDAO;
import vo.insertVO;
import vo.subscriptionVO;

/**
 * Servlet implementation class guestsubscriptionInsertController
 */
@WebServlet("/guestsubscriptionController")
public class guestsubscriptionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public guestsubscriptionController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		subscriptionDAO subscriptionObj =  new subscriptionDAO();
		String email_id=(String) session.getAttribute("email_id");
		subscriptionVO obj = new subscriptionVO();
			List l= subscriptionObj.fetchNGO();
			session.setAttribute("key_list", l);
		
		response.sendRedirect("user/guestsubscription.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		subscriptionDAO subscriptionObj =  new subscriptionDAO();
		organizationDAO orgdao=new organizationDAO();
		//String email_id=(String) session.getAttribute("email_id");
		String email_id = request.getParameter("email_id");
		subscriptionVO obj = new subscriptionVO();
		String[] ein = request.getParameterValues("EIN");
	
		for(int i=0;i<ein.length;i++){
			obj.setEmail_id(email_id);
			obj.setEIN(ein[i]);
			obj.setActive(0);
			insertVO v=new insertVO();
			List lTemp = orgdao.getOrgNameFromEIN(ein[i]);
			v = (insertVO) lTemp.get(0);
			obj.setName(v.getName());
			subscriptionObj.insert(obj);

		}
		
		
		//List l1 = subscriptionObj.getSubscription(obj);
		//session.setAttribute("fetchedNGOs", l1);
		
		
		response.sendRedirect("user/index.jsp");
	}

}
