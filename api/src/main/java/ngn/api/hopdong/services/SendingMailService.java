package ngn.api.hopdong.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class SendingMailService {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	public SendingMailService() {
	
	}
	
	public void sendMail(String to,String subject,String content) {
		boolean multipart = true;
		try {
			MimeMessage message = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, multipart, "utf-8");
			message.setContent(content, "text/html; charset=utf-8");
			helper.setTo(to);
			helper.setSubject(subject);
			message.setFrom("ctytest55@gmail.com");
			javaMailSender.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
//		try {
//			SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
//			simpleMailMessage.setTo(to);
//			simpleMailMessage.setSubject(subject);
//			simpleMailMessage.setText(content);
//			javaMailSender.send(simpleMailMessage);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}
	
}
