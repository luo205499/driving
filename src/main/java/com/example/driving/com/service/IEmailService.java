package com.example.driving.com.service;

/**
 * 
* Description: 邮箱服务接口<br> 
* @Author:Mr.Yellow  <br> 
* Create Time:2018年10月3日 下午6:11:07<br>
 */
public interface IEmailService {
	/**
	 * 
	* @Description 发送简单纯文字邮件
	* @param to 收件人地址
	* @param subject 邮件主题
	* @param content 邮件内容<br>
	* @return boolean 成功返回true，失败返回false
	* @author Mr.Yellow<br>
	* Create Time:2018年10月4日 上午11:58:06
	 */
	public boolean sendSimpleMail(String to, String subject, String content);
	
	/**
	 * 
	* @Description 发送带单个或多个附件的邮件
	* @param to 收件人地址
	* @param subject 邮件主题
	* @param content 邮件内容
	* @param filepath 包含附件路径地址的字符串数组
	* @return boolean 功返回true，失败返回false
	* @author Mr.Yellow<br>
	* Create Time:2018年10月4日 下午2:15:54
	 */
	public boolean sendAttachmentMail(String to, String subject, String content, String[] filepath);
	
	/**
	 * 
	* @Description 发送包含单张或多张图片的邮件<br>
	* 注意：content内容要使用HTML的img引入，参考测试类
	* @param to 收件人地址
	* @param subject 邮件主题
	* @param contentText 邮件文字内容
	* @param rscPath 包含图片路径的字符串数组<br>
	* @return void
	* @author Mr.Yellow<br>
	* Create Time:2018年10月4日 下午2:47:03
	 */
	public boolean sendImageMail(String to, String subject, String contentText, String[] rscPath);
}
