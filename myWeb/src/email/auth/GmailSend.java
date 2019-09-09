package email.auth;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

//[발송 부분]
public class GmailSend {
	
	public void Gmailset(String user, String text, String content) {
		Properties p = System.getProperties();
		p.put("mail.smtp.starttls.enable", "true");
		p.put("mail.smtp.host","smtp.gmail.com"); // stmp 서버 호스트
		p.put("mail.smtp.auth", "true");
		p.put("mail.smtp.port", "587"); // gmail 포트
		
		Authenticator auth = new MyAuthentication(); //구글 계정 인증
		
		Session session = Session.getDefaultInstance(p, auth);
		MimeMessage msg = new MimeMessage(session);
		String fromName= "인증번호 발송자";
		String charSet = "UTF-8";
		
		try {
			//편지 보낸 시간 설정
			msg.setSentDate(new Date());
			
			//송신자 설정
			InternetAddress from = new InternetAddress();
			from = new InternetAddress("hhhongso@gmail.com", "관리자");
			msg.setFrom(from);
			
			//수신자 설정
			InternetAddress to = new InternetAddress(user);
			msg.setRecipient(Message.RecipientType.TO, to);
			
			// 제목 설정
			msg.setSubject(text, "UTF-8");
			
			//내용 설정
			msg.setText(content, "UTF-8");
			
			//메일 송신
			Transport.send(msg);
			
			System.out.println("메일 발송 완료 ");
		} catch (AddressException e) {
			System.out.println("메일 주소를 입력하지 않았습니다. ");
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			System.out.println("메일 메세지 내용에 오류가 있습니다. ");
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static void main(String[] args) {
		GmailSend mail = new GmailSend();
		String content = (int)(Math.random()*10000)+1000+"";
		mail.Gmailset("hhhongso@gmail.com", "인증코드 발송 ", "인증번호는 ["+content+"] 입니다.");
	}
}
