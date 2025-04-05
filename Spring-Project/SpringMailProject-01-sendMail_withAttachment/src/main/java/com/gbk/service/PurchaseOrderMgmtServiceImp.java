package com.gbk.service;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;

@Service("purchaseService")
public class PurchaseOrderMgmtServiceImp implements IPurchaseOrderMgmtService {
	
	@Autowired
	private JavaMailSender sender;
	
	@Value("${spring.mail.username}")
	private String fromMail;

	@Override
	public String purchase(String[] items, double[] prices, String[] emails) throws Exception {
		//calculate bill amount
		double billAmount=0;
		for(double p:prices) {
			billAmount+=p;
		}
		
		String msg = Arrays.toString(items)+" are purchased having price:: "+Arrays.toString(prices)+" bill amount is:: "+billAmount;
		
		String mailStatus=sendMail(msg,emails);
		return msg+"...."+mailStatus;
	}
	String sendMail(String messageBody,String[] toEmails) throws Exception{
		//create MIME msg object
		MimeMessage message = sender.createMimeMessage();
		//MIME msg helper (attachment)
		MimeMessageHelper helper=new MimeMessageHelper(message,true);
		//set msg header
		helper.setFrom(fromMail);
		helper.setTo(toEmails);
		helper.setSubject("open it to know it");
		helper.setSentDate(new Date());
		helper.setText(messageBody);
		helper.addAttachment("gbk.jpg", new ClassPathResource("gbk.jpg"));
		sender.send(message);
		return "mail has sent";
	}

}
