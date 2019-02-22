package controller;

import java.io.IOException;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.util.ArrayList;
import java.util.Properties;
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
import vo.organization_needVO;
import vo.subscriptionVO;

/**
 * Servlet implementation class orgThingsController
 */
@WebServlet("/orgThingsController")
public class orgThingsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public orgThingsController() {
        super();
        // TODO Auto-generated constructor stub
    }
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		organizationDAO objOrgDAO = new organizationDAO();
		//String ein = "002";
		HttpSession s = request.getSession();
		String ein = (String) s.getAttribute("ein");
		organization_needVO objOrganization_needVO = new organization_needVO();
		objOrganization_needVO.setEIN(ein);
		List list =objOrgDAO.getThingOfOrg(objOrganization_needVO);
		
		s.setAttribute("key_list", list);
		
		
		response.sendRedirect("user/org_things.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("bye");
			organization_needVO objOrgNeedVO = new organization_needVO();
			organizationDAO objOrgDAO = new organizationDAO();
			HttpSession session=request.getSession();
			
			
			if(request.getParameter("electronics")!= null)
				objOrgNeedVO.setElec(1);
			else
				objOrgNeedVO.setElec(0);
			
			if(request.getParameter("education")!= null)
				objOrgNeedVO.setEdu(1);
			else
				objOrgNeedVO.setEdu(0);
			
			if(request.getParameter("health")!=null)
				objOrgNeedVO.setHealth(1);
			else
				objOrgNeedVO.setHealth(0);
			
			if(request.getParameter("hunger")!=null)
				objOrgNeedVO.setHunger(1);
			else
				objOrgNeedVO.setHunger(0);
			
			if(request.getParameter("sports")!=null)
				objOrgNeedVO.setSports(1);
			else
				objOrgNeedVO.setSports(0);
			
			if(request.getParameter("household")!=null)
				objOrgNeedVO.setHousehold(1);
			else
				objOrgNeedVO.setHousehold(0);
			
			//objOrgNeedVO.setEIN("002");
			String ein = (String) session.getAttribute("ein");
			objOrgNeedVO.setEIN(ein);
			String typeOfFunction = request.getParameter("hiddenBtn");
			//String typeOfFunction1 = request.getParameter("hiddenBtn1");
			if(typeOfFunction.equals("submitBtn"))
			{
				/*insert things org needs*/
				boolean status = objOrgDAO.insertOrgNeed(objOrgNeedVO);
			}
			else if(typeOfFunction.equals("updateBtn"))
			{
				boolean status = objOrgDAO.updateOrgNeed(objOrgNeedVO);
			}
			
			/*sending email to user/guest for subsciption : start*/
			ArrayList orgList = (ArrayList) objOrgDAO.getOrgNameFromEIN(ein);
			insertVO orgVO = (insertVO)orgList.get(0);
			String orgName = orgVO.getName();
			
			subscriptionDAO sDAO = new subscriptionDAO();
			ArrayList fetchedemail = (ArrayList) sDAO.getEmailForSubscription(ein);
			
			if(fetchedemail.size()>0){
					final  String username = "admitatwecare@gmail.com";
					final  String password = "Spring@2017";
					Properties props = new Properties();
					props.put("mail.smtp.host", "smtp.gmail.com");
					props.put("mail.smtp.socketFactory.port", "465");
					props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
					props.put("mail.smtp.auth", "true");
					props.put("mail.smtp.port", "465");

					Session sessionMail = Session.getInstance(props, new javax.mail.Authenticator() {
						protected PasswordAuthentication getPasswordAuthentication() {
							return new PasswordAuthentication(username, password);
						}
					});
					for (int i=0;i<fetchedemail.size();i++){
						try {
							subscriptionVO sObj =  (subscriptionVO) fetchedemail.get(i);
							Message message = new MimeMessage(sessionMail);
							message.setFrom(new InternetAddress("from-email@gmail.com"));
							message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(sObj.getEmail_id()));
							message.setSubject("Updates from "+orgName);
							
							//message.setContent("<h1> Message: " + data + "</h1>", "text/html");

							message.setContent("Dear User"+ "," + "<br/>This is an update alert.<br/><br/>"
									+ "Your subscribed organization  " +orgName +  " has updated things available for donation."
											+ "<br/>Regards<br/>WeCare", "text/html");

							Transport.send(message);

							System.out.println("Done");
						
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
			}
			/*sending email to user/guest for subsciption : end*/
			
			/*after saving/updating org needs org is displayed with same page with selected values*/
			List list =objOrgDAO.getThingOfOrg(objOrgNeedVO);
			session.setAttribute("key_list", list);
			response.sendRedirect("user/org_things.jsp");

		
		
		
	}

}
