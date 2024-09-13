package com.techtraveller.ServiceImp;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.techtraveller.Exception.EmailNotSendException;
import com.techtraveller.Service.EmailService;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailServiceImp implements EmailService {

	@Autowired
	private JavaMailSender mailSender;
	
	@Value("${mail.from}")
	private String mailFrom;

	@Override
	public void sendEmail(String subject, String message, String to) {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setTo(to);
		simpleMailMessage.setSubject(subject);
		simpleMailMessage.setText(message);
		simpleMailMessage.setFrom(mailFrom);
		mailSender.send(simpleMailMessage);

	}

	@Override
	public void sendEmail(String[] to, String subject, String message) {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setTo(to);
		simpleMailMessage.setSubject(subject);
		simpleMailMessage.setText(message);
		simpleMailMessage.setFrom(mailFrom);
		mailSender.send(simpleMailMessage);

	}

	@Override
	public void sendEmailWithHtml(String to, String subject, String htmlContent) {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setFrom(mailFrom);
			helper.setText(htmlContent, true);
			mailSender.send(mimeMessage);

		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			throw new EmailNotSendException("Failed to send email to: " + to);
		}

	}

	@Override
	public void sendEmailWithFile(String to, String subject, String message, File file) {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setFrom(mailFrom);
			helper.setText(message);
			FileSystemResource fileSystemResource = new FileSystemResource(file);
			helper.addAttachment(fileSystemResource.getFilename(), file);
			mailSender.send(mimeMessage);

		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			throw new EmailNotSendException("Failed to send email to: " + to);
		}

	}

	@Override
	public void sendEmailWithFile(String to, String subject, String message, InputStream is) {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setFrom(mailFrom);
			helper.setText(message);
		File file=new File("src/main/resources/email/test.png");
		Files.copy(is, file.toPath(),StandardCopyOption.REPLACE_EXISTING);
		FileSystemResource fileSystemResource=new FileSystemResource(file);
		helper.addAttachment(fileSystemResource.getFilename(), file);
			mailSender.send(mimeMessage);

		} catch (MessagingException e) {
			throw new EmailNotSendException("Failed to send email to: " + to);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getLinkForEmailVerification(String emailToken) {
		String link="http://localhost:8080/auth/verify-email?token="+emailToken;
		return link;
	}
	
	
	

}