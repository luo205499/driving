package com.example.driving.com.service.impl;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import com.example.driving.com.service.IEmailService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;


/**
 * 
* Description: 邮箱服务接口 实现<br> 
* @Author:Mr.Yellow  <br> 
* Create Time:2018年10月3日 下午6:11:36<br>
 */
@Service
public class EmailService implements IEmailService {

	//从application.properties配置文件中注入发送者的邮件地址
	@Value("${spring.mail.username}")
	private String fromEmail;
	
	//注入spring发送邮件的对象
	@Autowired
    private JavaMailSender mailSender;

	@Override
	public boolean sendSimpleMail(String to, String subject, String content) {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setTo(to);
		simpleMailMessage.setFrom(fromEmail);
		simpleMailMessage.setSubject(subject);
		simpleMailMessage.setText(content);	
		try {
			mailSender.send(simpleMailMessage);  		//执行发送
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public boolean sendAttachmentMail(String to, String subject, String content, String[] filepath) {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(content);
			helper.setFrom(fromEmail);
			if(filepath.length>0){						//读取附件文件（传入文件路径）
				for (String string : filepath) {		//遍历文件数组，实现多个附件的添加
					FileSystemResource file = new FileSystemResource(new File(string));
					String fileName = file.getFilename();//获取文件名
					helper.addAttachment(fileName, file);//参数：文件名，文件路径
				}
				try {
					mailSender.send(mimeMessage);		//发送邮件
				} catch (Exception e) {
					return false;						//发送出现异常(或者文件路径不对)
				}
				return true;							//成功发送
			}else {
				return false;    						//没有附件文件（中断发送）
			}
		} catch (MessagingException e) {
			e.printStackTrace();		                //捕获到创建MimeMessageHelper的异常
		}
		return false;
	}

	@Override
	public boolean sendImageMail(String to, String subject, String contentText, String[] rscPath) {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper helper = null;
		try {
			helper = new MimeMessageHelper(mimeMessage,true);
			helper.setTo(to);
			helper.setSubject(subject);
			
			//构建一个html的内容，中间放图片
			StringBuffer contentHtml = new StringBuffer();
			contentHtml.append("<html><body>");
			contentHtml.append(contentText+"<hr><br>");	//追加文字内容
			
			//遍历添加要传送的图片
			for(int i=0;i<rscPath.length;i++){
				 FileSystemResource res = new FileSystemResource(new File(rscPath[i]));
				 contentHtml.append("<img src=\'cid:"+res.getFilename()+"\'></img><br><br>");
				 helper.addInline(res.getFilename(), res);//以每张图片的名称作为其id
			}
			
			contentHtml.append("</body></html>");	    //HTML结尾
			
			//设置邮件内容，html:true 表示启动HTML格式的邮件
			helper.setText(contentHtml.toString(),true);			
			helper.setFrom(fromEmail);		
			mailSender.send(mimeMessage);    			//发送邮件	
		} catch (Exception e) {
			return false;								//发送出现异常
		}
		return true;									//发送成功
	}
}
