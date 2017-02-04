package mail;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class sendMailAcknoledgmentToStudent {

	static  String senderEmailAddress="harshitad20@gmail.com";
	static String senderEmailPassword = "ambikapur";
	
	public static void sendMailAcknoledgment(String sendTo,String subject,String msg) {
		
		final String username = senderEmailAddress;
		final String password = senderEmailPassword;

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(senderEmailAddress));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(sendTo));
			message.setSubject(subject);
			message.setText(msg);
			Transport.send(message);
			System.out.println("Done");
			
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}