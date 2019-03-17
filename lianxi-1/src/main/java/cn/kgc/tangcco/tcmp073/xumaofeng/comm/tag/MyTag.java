package cn.kgc.tangcco.tcmp073.xumaofeng.comm.tag;

import java.io.IOException;

import javax.servlet.jsp.tagext.SimpleTagSupport;

public class MyTag extends SimpleTagSupport{
	
	@Override
	public void doTag() {
		try {
			getJspContext().getOut().println("hello tag!");
			//getJspContext()
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
