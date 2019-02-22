package controller;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.hibernate.Hibernate;
import org.hibernate.Session;

import dao.CreateEventDao;
import dao.SuccessStoryDao;
import dao.insertDaoOrg;
import dao.insertDaoUser;
import vo.insertVO;
import vo.reminderVo;
import vo.reminderkey;
import vo.success_storiesVO;
import vo.userVO;
import vo.CreateEventVo;

@WebServlet("/SuccessStoryController")
public class SuccessStoryController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private static Session session1;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuccessStoryController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
//		String story_desc= request.getParameter("story_desc");
//		String story_name=request.getParameter("story_name");
//		
		SuccessStoryDao sdao = new SuccessStoryDao();
		success_storiesVO svo = new success_storiesVO();
//		String ein=null;
//		Integer uid=0;
//				
//		ein = (String)session.getAttribute("ein");
//		 uid =  Integer.parseInt((session.getAttribute("uid")).toString());
//		
		if ((session.getAttribute("ein")==null) && (session.getAttribute("uid")==null))
		{
			List l1=sdao.getSuccessStories();
			session.setAttribute("key", l1);
			response.sendRedirect("user/successstory_guest.jsp");
		}
		else{
			List l1=sdao.getSuccessStories();
			session.setAttribute("key", l1);
			System.out.println(l1);
			response.sendRedirect("user/successstory.jsp");	
		}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		String story_desc= request.getParameter("story_desc");
		String story_name=request.getParameter("story_name");
		
		SuccessStoryDao sdao = new SuccessStoryDao();
		success_storiesVO svo = new success_storiesVO();
		String ein = "";
		Integer uid = 0;
		if (session.getAttribute("ein")!=null){
		 ein = (String) session.getAttribute("ein");
		}
		System.out.println("uid" + session.getAttribute("uid") );
		if(session.getAttribute("uid")!=null){
		 uid =  Integer.parseInt((session.getAttribute("uid")).toString());
		}
		if (ein!= null)
		{
			CreateEventDao crt= new CreateEventDao();
			List l=crt.fetchNgoName(ein);
			if(l.size()>0)
			{
				insertVO v= (insertVO) l.get(0);
				svo.setStory_owner(v.getName());
			}	
		}
		else if (uid!= null)
		{
			insertDaoUser crt = new insertDaoUser();
			List l=crt.fetchUserName(uid);
			if(l.size()>0)
			{
				userVO u= (userVO) l.get(0);
				svo.setStory_owner(u.getUser_name());
			}
		}	
		System.out.println(story_name);
		System.out.println(story_desc);
		
		
		
		svo.setStory_desc(story_desc);
		svo.setStory_name(story_name);
		boolean status = sdao.insertSuccessStory(svo);
		
		List l1=sdao.getSuccessStories();
		session.setAttribute("key", l1);
		System.out.println(l1);
		response.sendRedirect("user/successstory.jsp");
		
		
	}

}
