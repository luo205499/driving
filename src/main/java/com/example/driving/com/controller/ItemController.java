package com.example.driving.com.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.example.driving.com.entity.Item;
import com.example.driving.com.service.IItemService;
import com.example.driving.com.util.FileUtil;
import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Timestamp;


@Controller
public class ItemController {
	@Resource
	private IItemService itemService;

	/**
	 * 跳转科目一模拟考试界面
	 *
	 * @author Lcl
	 * @param @return    参数
	 * @return String    返回类型
	 * @throws
	 * @date 2018年12月16日 下午2:35:16
	 */
	@RequestMapping("mockExam")
	public String mockExam(){
		return "mockExam";
	}


	/**
	 * 跳转科目四模拟考试界面
	 *
	 * @author Lcl
	 * @param @return    参数
	 * @return String    返回类型
	 * @throws
	 * @date 2018年12月16日 下午2:35:16
	 */
	@RequestMapping("mockExam4")
	public String mockExam4(){
		return "mockExam4";
	}
	/**
	 * 科目一模拟考试
	 * @param pageNum
	 * @return
	 */
	@RequestMapping("getitem")
	@ResponseBody
	public Item getItem(int pageNum){
		return itemService.getItem(pageNum);
	}
	/**
	 * 科目i四模拟考试
	 * @param pageNum
	 * @return
	 */
	@RequestMapping("getitem4")
	@ResponseBody
	public Item getItem4(int pageNum){
		return itemService.getItem4(pageNum);
	}

	/**
	 * 跳转随机练习界面
	 * @return practice2
	 */
	@RequestMapping("practice")
	public String practice(){
		return "practice";
	}

	/**
	 * 跳转顺序练习界面
	 * @return
	 */
	@RequestMapping("practice2")
	public String practice2(){
		return "practice2";
	}
	/**
	 * 获取随机练习试题
	 * @param pageNum
	 * @return
	 */
	@RequestMapping("/practiceAny")
	@ResponseBody
	public Item practiceAny(int pageNum){
		return  itemService.practiceAny(pageNum);
	}

	/**
	 * 顺序练习
	 * @param pageNum
	 * @return
	 */
	@RequestMapping("/practiceOrder")
	@ResponseBody
	public Item practiceOrder(int pageNum){
		return  itemService.practiceOrder(pageNum);
	}

	/**
	 * 跳转添加试题界面
	 * @param
	 * @return
	 */
	@RequestMapping("toaddItem")

	public String toaddItem(){
		return "addItem";
	}
	/**
	 * 添加试题
	 * @param item
	 * @return
	 */
	@RequestMapping("addItem")
	@ResponseBody
	public String addItem(@RequestParam("img2") MultipartFile img2,Item item){
		String re="<script>alert(\"添加试题失败\");window.location.href='toaddItem';</script>";
		if(!img2.isEmpty()) {
			// 获取文件名称,包含后缀
			String fileName = img2.getOriginalFilename();

			// 存放在这个路径下：该路径是该工程目录下的static文件下：(注：该文件可能需要自己创建)
			// 放在static下的原因是，存放的是静态文件资源，即通过浏览器输入本地服务器地址，加文件名时是可以访问到的
			String path = "D:/idea/work/driving/src/main/resources/static/images/";
//			String path = ClassUtils.getDefaultClassLoader().getResource("").getPath()
			try {
				// 该方法是对文件写入的封装，在util类中，导入该包即可使用
				long t = System.currentTimeMillis();// 获得当前系统毫秒数,
				fileName=t+fileName;
				FileUtil.fileupload(img2.getBytes(), path, fileName);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// 接着创建对应的实体类，将以下路径进行添加，然后通过数据库操作方法写入
			Timestamp timestamp=new Timestamp(System.currentTimeMillis());
			fileName="images/"+fileName;
			item.setImg(" <img src="+fileName+">");
		}
		int re2=itemService.addItem(item);
		if (re2>0){
			re="<script>alert(\"添加试题成功\");window.location.href='toaddItem';</script>";
		}
		return re;
	}

	//跳转到针对练习页面
	@RequestMapping(value="/toForPractice")
	public String toForPractice(int role,HttpServletRequest request) {
		request.getSession().setAttribute("role",role);
		return "forPractice";
	}

	@RequestMapping("/forPractice")
	@ResponseBody
	public Item forPractice(int pageNum,HttpServletRequest request){
		return  itemService.forPractice(pageNum,request);
	}


	//跳转到上传文件的页面
	@RequestMapping(value="/gouploadimg", method = RequestMethod.GET)
	public String goUploadImg() {
		//跳转到 templates 目录下的 uploadimg.html
		return "uploadimg";
	}


}
