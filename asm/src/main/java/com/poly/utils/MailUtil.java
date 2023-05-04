package com.poly.utils;

import java.util.Properties;
import java.util.Random;

import javax.mail.*;
import javax.mail.internet.*;

public class MailUtil {

	public static int random() {
		Random rand = new Random();
		return rand.nextInt(999999) + 100000;
	}

	public static void sendEmail(String to, int random) {
		try {

			// Thong so ket noi SMTP Server
			Properties p = new Properties();
			p.put("mail.smtp.auth", "true");
			p.put("mail.smtp.starttls.enable", "true");
			p.put("mail.smtp.host", "smtp.gmail.com");
			p.put("mail.smtp.port", "587");
			p.put("mail.smtp.ssl.protocols", "TLSv1.2");
			String from = "kietsls061@gmail.com";
			String subject = "Mật khẩu mới của bạn là";
			String body = String.valueOf(random);
			// Ket noi SMTP Server
			Session s = Session.getInstance(p, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					String username = from;
					String password = "lkmwbpulwcjhoceo"; //
					return new PasswordAuthentication(username, password);
				}
			});

			// Tao message
			MimeMessage msg = new MimeMessage(s);
			msg.setFrom(new InternetAddress(from));
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			msg.setSubject(subject, "utf-8");
			msg.setText(body, "utf-8", "html");
			msg.setReplyTo(msg.getFrom());

			Transport.send(msg);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public static void sendEmailShare(String user,String to, String link) {
		try {

			// Thong so ket noi SMTP Server
			Properties p = new Properties();
			p.put("mail.smtp.auth", "true");
			p.put("mail.smtp.starttls.enable", "true");
			p.put("mail.smtp.host", "smtp.gmail.com");
			p.put("mail.smtp.port", "587");
			p.put("mail.smtp.ssl.protocols", "TLSv1.2");
			String from = "kietsls061@gmail.com";
			String subject = "Link video được chia sẻ bởi: " + user;
			String body = link;
			// Ket noi SMTP Server
			Session s = Session.getInstance(p, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					String username = from;
					String password = "lkmwbpulwcjhoceo"; //
					return new PasswordAuthentication(username, password);
				}
			});

			// Tao message
			MimeMessage msg = new MimeMessage(s);
			msg.setFrom(new InternetAddress(from));
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			msg.setSubject(subject, "utf-8");
			msg.setText(body, "utf-8", "html");
			msg.setReplyTo(msg.getFrom());

			Transport.send(msg);
			System.out.println("send email thành công");

		} catch (Exception ex) {
			System.out.println("send email error");
			ex.printStackTrace();
		}
	}
}
