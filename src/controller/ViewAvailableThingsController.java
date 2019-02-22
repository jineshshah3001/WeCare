package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.available_thingsVO;
import vo.insertVO;
import dao.AvailableThingsDao;
import dao.organizationDAO;

/**
 * Servlet implementation class availableThingsController
 */
@WebServlet("/ViewAvailableThingsController")
public class ViewAvailableThingsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAvailableThingsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		
		String flag = request.getParameter("display");
		if(flag != null && !flag.equals("") && flag.equals("yes")){
		organizationDAO objOrgDAO = new organizationDAO();
		insertVO objInsertVO = new insertVO();
		HttpSession session=request.getSession();
		String ein = (String) session.getAttribute("ein");
		objInsertVO.setEIN(ein);

		ArrayList things = new ArrayList<>();
		ArrayList users = new ArrayList<>();

		List l = objOrgDAO.getAvailableThings(objInsertVO);
		for(int i=0;i<l.size();i++){
			List l1= Arrays.asList(l.get(i));
			Object[] l2=(Object[]) l1.get(0);
			things.add(Arrays.asList(l2[0]));
			users.add(Arrays.asList(l2[1]));
		}
		session.setAttribute("things", things);
		session.setAttribute("user", users);
		session.setAttribute("category", "elec");

		response.sendRedirect("user/availableThings.jsp");
		}
		if(flag != null && !flag.equals("") && flag.equals("no"))
		{
			doPost(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		String parameter = request.getParameter("param1");

		available_thingsVO obj = new available_thingsVO();
		obj.setCategory(parameter==null?"elec":parameter);
		
		AvailableThingsDao objDao = new AvailableThingsDao();
		List l = objDao.getUserAndAvailableThings(obj);
		
		ArrayList things = new ArrayList<>();
		ArrayList users = new ArrayList<>();

		for(int i=0;i<l.size();i++){
			List l1= Arrays.asList(l.get(i));
			Object[] l2=(Object[]) l1.get(0);
			things.add(Arrays.asList(l2[0]));
			users.add(Arrays.asList(l2[1]));
		}
		session.setAttribute("things", things);
		session.setAttribute("user", users);
		session.setAttribute("category", parameter);
		
		response.sendRedirect("user/availableThings.jsp");

	
	}

}
