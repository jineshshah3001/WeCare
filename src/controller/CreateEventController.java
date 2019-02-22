package controller;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CreateEventDao;
import dao.organizationDAO;
import dao.subscriptionDAO;
import vo.CreateEventVo;
import vo.insertVO;
import vo.subscriptionVO;

/**
 * Servlet implementation class createeventcontroller
 */
@WebServlet("/CreateEventController")
public class CreateEventController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateEventController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		HttpSession session=request.getSession();
		String event_id = request.getParameter("eventid");
		
		String ein = (String) session.getAttribute("ein");
		CreateEventDao obj1 = new CreateEventDao();
		CreateEventVo object1 = new CreateEventVo();

		if(event_id != null && event_id.equals("0")){
		object1.setEIN(ein);

		List l1 = obj1.getAllevents(object1);
		session.setAttribute("events", l1);
		session.setAttribute("eventToUpdate", "null");
		
		}
		else
		{
			//object1 = null;
			object1.setEvent_id(Integer.parseInt(event_id));
			List l = obj1.getEventFromEventID(object1);
			session.setAttribute("eventToUpdate", l);
		}
		response.sendRedirect("user/create_event.jsp");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			String event_name =  request.getParameter("event_name");
			String location = request.getParameter("location");
			String time = request.getParameter("time");
			String date = request.getParameter("date");
			String description = request.getParameter("description");
			String flag=request.getParameter("flag");
			String btn = request.getParameter("btn");
			System.out.println(btn);
			HttpSession session=request.getSession();
			String ein = (String) session.getAttribute("ein");
			
			String ngo_name=null;
			String URL=null;
			CreateEventDao crt= new CreateEventDao();	
			List l=crt.fetchNgoName(ein);
					if(l.size()>0)
					{
						insertVO v= (insertVO) l.get(0);
						 ngo_name=v.getName();
						 URL=v.getURL();
					}
			
			CreateEventVo object = new CreateEventVo();
			object.setEvent_name(event_name);
			object.setLocation(location);
			object.setTime(time);
			object.setDate(date);
			object.setDescription(description);
			object.setEIN(ein);
			object.setActive(1);
			object.setNgo_name(ngo_name);
			object.setURL(URL);
			
			CreateEventDao obj = new CreateEventDao();
			if(flag.equals("0")){
			obj.insert(object);
			
			/*sending email to user/guest for subsciption : start*/
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
							message.setSubject("Updates from "+ngo_name);
							
							//message.setContent("<h1> Message: " + data + "</h1>", "text/html");

							message.setContent("Dear User"+ "," + "<br/>This is an update alert.<br/><br/>"
									+ "Your subscribed organization  " +ngo_name +  " has new upcoming event on "+date+"."
									+ "<br/> Login into WeCare to know more."
									+ "<br/>Regards<br/>WeCare", "text/html");

							Transport.send(message);

							System.out.println("Done");
						
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
			}
			/*sending email to user/guest for subsciption : end*/
			}
			else{
				object.setEvent_id(Integer.parseInt(flag));
				
				if(btn.equalsIgnoreCase("Inactive Event"))
				{
					object.setActive(0);
				}
				boolean update_status=obj.update(object);
				
				if(update_status && !btn.equalsIgnoreCase("Inactive Event")){
					/*sending email to user/guest for subsciption : start*/
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
									message.setSubject("Updates from "+ngo_name);
									
									//message.setContent("<h1> Message: " + data + "</h1>", "text/html");

									message.setContent("Dear User"+ "," + "<br/>This is an update alert.<br/><br/>"
											+ "Your subscribed organization  " +ngo_name +  " updated it's event details."
											+ "<br/> Login into WeCare to know more."
											+ "<br/>Regards<br/>WeCare", "text/html");

									Transport.send(message);

									System.out.println("Done");
								
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
					}
					/*sending email to user/guest for subsciption : end*/
				}
			}

			List l1 = obj.getAllevents(object);
			session.setAttribute("events", l1);
			session.setAttribute("eventToUpdate", "null");
			response.sendRedirect("user/create_event.jsp");
	}

}
