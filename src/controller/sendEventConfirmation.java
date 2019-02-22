package controller;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.annotation.WebServlet;

@WebServlet("/SendEventController")
public class sendEventConfirmation {
	
	final static String username = "admitatwecare@gmail.com";
	final static String password = "Spring@2017";


	public static void send(String email, String data) {
		// TODO Auto-generated method stub
		System.out.println("helooooo");
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("from-email@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
			message.setSubject("Registration Confirmation");
			String dataarray[] = data.split(",");
			//message.setContent("<h1> Message: " + data + "</h1>", "text/html");

			System.out.println(dataarray);
			message.setContent("Dear User,<br><br>" + "This is a confirmation mail for " + dataarray[0] + " event which will be held on "
					+ dataarray[1] +"." + "</br>Thank you for volunteering.<br><br>Regards<br/>WeCare", "text/html");
			

			Transport.send(message);

			System.out.println("Done");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

