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
import dao.organizationDAO;
import vo.available_thingsVO;
import dao.AvailableThingsDao;
import vo.insertVO;
import vo.organization_needVO;

@WebServlet("/AvailableThingsController")
public class AvailableThingsController extends HttpServlet{

	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AvailableThingsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AvailableThingsDao objAvailThingsDAO = new AvailableThingsDao();
		//String ein = "002";
		HttpSession s = request.getSession();
		if (s.getAttribute("uid") != null){
			Integer uid = (Integer) s.getAttribute("uid");
			available_thingsVO objAvailThingsVO = new available_thingsVO();
			objAvailThingsVO.setUser_id(uid);
			List list =objAvailThingsDAO.getAvailThings(objAvailThingsVO);
			
			s.setAttribute("key_list", list);
			response.sendRedirect("user/available_things.jsp");
		}
		else {
			response.sendRedirect("user/register_request.jsp");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		available_thingsVO objAvailThingsVO = new available_thingsVO();
		AvailableThingsDao objAvailThingsDAO = new AvailableThingsDao();
		HttpSession session=request.getSession();
		
		
		if(request.getParameter("electronics")!= null)
		{	objAvailThingsVO.setElec(1);
			objAvailThingsVO.setElectext(request.getParameter("electext"));}
		else
		{	objAvailThingsVO.setElec(0);
		objAvailThingsVO.setElectext("");}
		
		if(request.getParameter("education")!= null)
		{	objAvailThingsVO.setEdu(1);
		objAvailThingsVO.setEdutext(request.getParameter("edutext"));}
		else
		{	objAvailThingsVO.setEdu(0);
		objAvailThingsVO.setEdutext("");}
		
		if(request.getParameter("health")!=null)
		{	objAvailThingsVO.setHealth(1);
		objAvailThingsVO.setHealthtext(request.getParameter("healthtext"));
		}
		else
		{	objAvailThingsVO.setHealth(0);
		objAvailThingsVO.setHealthtext("");}
		
		if(request.getParameter("hunger")!=null)
		{	objAvailThingsVO.setHunger(1);
		objAvailThingsVO.setHungertext(request.getParameter("hungertext"));
		}
		else
		{	objAvailThingsVO.setHunger(0);
		objAvailThingsVO.setHungertext("");
		}
		
		if(request.getParameter("sports")!=null)
		{	objAvailThingsVO.setSports(1);
		objAvailThingsVO.setSportstext(request.getParameter("sportstext"));
		}
		else
		{	objAvailThingsVO.setSports(0);
		objAvailThingsVO.setSportstext("");
		}
		
		if(request.getParameter("household")!=null)
		{	objAvailThingsVO.setHousehold(1);
		objAvailThingsVO.setHousetext(request.getParameter("housetext"));
		}
		else
		{	objAvailThingsVO.setHousehold(0);
		objAvailThingsVO.setHousetext("");
		}
		
		objAvailThingsVO.setOther(request.getParameter("other"));
		
		//objOrgNeedVO.setEIN("002");
		Integer uid = (Integer) session.getAttribute("uid");
		objAvailThingsVO.setUser_id(uid);
		String typeOfFunction = request.getParameter("hiddenBtn");
		//String typeOfFunction1 = request.getParameter("hiddenBtn1");
		if(typeOfFunction.equals("submitBtn"))
		{
			/*insert things org needs*/
			boolean status = objAvailThingsDAO.insertAvailThings(objAvailThingsVO);
		}
		else if(typeOfFunction.equals("updateBtn"))
		{
			boolean status = objAvailThingsDAO.updateAvailThings(objAvailThingsVO);
		}
		
		/*after saving/updating org needs org is displayed with same page with selected values*/
		List list =objAvailThingsDAO.getAvailThings(objAvailThingsVO);
		session.setAttribute("key_list", list);
		response.sendRedirect("user/available_things.jsp");


	}
}

