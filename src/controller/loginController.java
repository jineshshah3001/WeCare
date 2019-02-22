package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.insertDaoOrg;
import dao.insertDaoUser;
import vo.insertVO;
import vo.insertapproval;
import vo.userVO;

@WebServlet("/loginController")
public class loginController extends HttpServlet {
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		if(session.getAttribute("ein")!=null){
			session.removeAttribute("ein");
			response.sendRedirect("user/index.jsp");
			
		}
		if(session.getAttribute("uid")!=null){
			session.removeAttribute("uid");
			response.sendRedirect("user/index.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session=request.getSession();
		Boolean match=false;
		String login=(String)session.getAttribute("login");
		String email_id=request.getParameter("email_id");
		request.getSession().setAttribute("email_id", email_id);
		String password=request.getParameter("password");
		insertDaoUser us = new insertDaoUser();
		String pass = us.get_SHA_512_SecurePassword(password, "salt");
		
			insertDaoOrg d= new insertDaoOrg();
			if (login.equals("org"))
			{
				
				List l=d.validateorg(email_id,pass);
				if(l.size()>0)
				{
					insertVO v= (insertVO) l.get(0);
					if ((v.getPassword().equals(pass))&&(v.getActive().equals("1")))
					{
						session.setAttribute("ein", v.getEIN());
						response.sendRedirect("user/home_org.jsp");
						
					}
					else if(v.getActive().equals("0")){
						response.sendRedirect("user/approvalpending.jsp");
					}
					else{
						session.setAttribute("errormsg","yes");
					response.sendRedirect("user/login.jsp?login=org");
				}
				}
				else
				{
					session.setAttribute("errormsg","yes");
					response.sendRedirect("user/login.jsp?login=org");
				}
				

			}
			else if (login.equals("usr"))
			{	
				List l=d.validateusr(email_id,pass);
				if(l.size()>0){
					userVO u = (userVO)l.get(0);
					if (u.getUser_psw().equals(pass))
					{
						session.setAttribute("uid", u.getUser_id());
						response.sendRedirect("user/index1.jsp");
						
					}
				}
				else{
					session.setAttribute("errormsg","yes");
					response.sendRedirect("user/login.jsp?login=usr"); }
			}
			
			else if (login.equals("adm"))
			{
				// l=d.validateusr(email_id,password);
				if(email_id != null && !email_id.equals("") && email_id.equals("admin")&& password != null && !password.equals("") && password.equals("admin"))
				{
				//userVO u = (userVO)l.get(0);
				/*if (u.getUser_psw().equals(password))
				{*/
					session.setAttribute("uid", 0);
					response.sendRedirect("user/approval.jsp");
					
				//}
				}
				else{
					session.setAttribute("errormsg","yes");
					response.sendRedirect("user/login.jsp?login=adm");
				}
			}
			
		System.out.println("All done!!");

	}


}
