import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.AuthenticationFailedException;

public class Sendmail {
		
	String sendmails(String to,String sub,String body)
	{
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "587");

		Session session = Session.getDefaultInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(" *** Your Email *** "," *** Gmail password *** ");
				}
			});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(" *** Your Email *** "));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(to));
			message.setSubject(sub);
			message.setText(body);

			Transport.send(message);

			System.out.println("Done");
			
			return("Mail sent.");

		} catch (MessagingException e) {
			
			throw new RuntimeException(e);
			
		}
	}
}