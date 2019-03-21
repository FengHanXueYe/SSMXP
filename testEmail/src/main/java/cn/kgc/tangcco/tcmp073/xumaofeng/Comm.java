package cn.kgc.tangcco.tcmp073.xumaofeng;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

public class Comm {
		public String achieveCode() {
			String[] beforeShuffle = new String[] { "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F",
					"G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "a",
					"b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
					"w", "x", "y", "z" };
			//将数组转换成list集合
			/** （1）该方法不适用于基本数据类型（byte,short,int,long,float,double,boolean）
　　				（2）该方法将数组与列表链接起来，当更新其中之一时，另一个自动更新
　　				（3）不支持add和remove方法
			 */
			List list = Arrays.asList(beforeShuffle);
			//将list集合中的元素的顺序打乱
			Collections.shuffle(list);
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < list.size(); i++) {
				sb.append(list.get(i));
			}
			String afterShuffle = sb.toString();
			String result = afterShuffle.substring(3, 9);
			return result;
		}
		public String sendEamilCode(String email) {
			HtmlEmail send = new HtmlEmail();
			String resultCode = achieveCode();
			try {
//				send.setHostName("smtp.163.com");//发送服务
				send.setHostName("smtp.qq.com");//发送服务
				send.setSmtpPort(465);//发送端口号
				send.setSSLOnConnect(true);//开启 SSL 加密
				send.setCharset("utf-8");
				send.addTo(email);
//				send.setFrom("fenghanxueye@163.com");
//				send.setAuthentication("fenghanxueye@163.com", "jlysdaqc123456");
				send.setFrom("505385234@qq.com");
				send.setAuthentication("505385234@qq.com", "okmmzaqgniykcbdi");
				send.setSubject("呆鸡");
				send.setMsg("hello，呆鸡！：" + resultCode + "哈哈哈");
				send.send(); //发送
				/**
				 *  send.addTo(“这里面放的接收人的QQ邮箱”);
				 *  send.setSubject(“标题”);
				 *  send.setMsg(“内容”);		    
					send.setFrom(“这里面放的是发送人的QQ邮箱”);
					send.setAuthentication(“这里放的是发送人QQ邮箱”,”这个是QQ授权码”);	
				 */			
			} catch (EmailException e) {
				e.printStackTrace();
			}
			return resultCode;//返回验证码
		}
	
	
}
