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
 * Servlet implementation class subscriptionController
 */
@WebServlet("/subscriptionController")
public class subscriptionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public subscriptionController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
		//doPost(request, response);
		HttpSession session=request.getSession();
		String email =  (String)request.getSession().getAttribute("email_id");
		subscriptionDAO subscriptionObj =  new subscriptionDAO();
		subscriptionVO obj1 = new subscriptionVO();
		obj1.setEmail_id(email);
		
		List l1 = subscriptionObj.getSubscription(obj1);
		
		if(l1.size()>0){
			session.setAttribute("fetchedNGOs", l1);
		}
		else
		{
		insertVO obj = new insertVO();
		List l = subscriptionObj.fetchNGO();
		System.out.println(l);
		session.setAttribute("fetchedNGOs", l);
		}
		response.sendRedirect("user/subscription.jsp");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		subscriptionDAO subscriptionObj =  new subscriptionDAO();
		organizationDAO orgdao=new organizationDAO();
		String email_id =  (String)request.getSession().getAttribute("email_id");
		Boolean flag=subscriptionObj.deleteSubscription(email_id);
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
		
		String alleins = "";
		for(int i=0;i<ein.length-1;i++)
		{
			alleins=alleins+"'"+ein[i]+"',";
		}
		alleins=alleins+"'"+ein[ein.length-1]+"'";
		List l=subscriptionObj.findunsubngos(alleins);
		for(int i=0;i<l.size();i++){
			obj.setEmail_id(email_id);
			insertVO temp = (insertVO)l.get(i);
			obj.setEIN(temp.getEIN());
			obj.setName(temp.getName());
			obj.setActive(1);
			subscriptionObj.insert(obj);

		}
		
//		obj.setEmail_id(email_id);
//		List l = subscriptionObj.getSubscription(obj);
//		
//		if(l.size()>0){
//			//session.setAttribute("sList", l);
//			subscriptionObj.updateSubscription(obj);
//			
//		}
//		else
//		{
//			for(int i=0;i<ein.length;i++){
//				obj.setEmail_id(email_id);
//				obj.setEIN(ein[i]);
//				obj.setActive(1);
//				subscriptionObj.insert(obj);
//			}
//
//		}
//		
//		
		List l1 = subscriptionObj.getSubscription(obj);
		session.setAttribute("fetchedNGOs", l1);
		
		
		response.sendRedirect("user/subscription.jsp");
		
		
	}

}
