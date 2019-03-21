package cn.kgc.tangcco.tcmp073.xumaofeng;

public class TestConn {
	
	public static void main(String[] args) {
		Comm sl = new Comm();
		//937518043@qq.com486038436
//		String num = sl.sendEamilCode("505385234@qq.com");
		String num = sl.sendEamilCode("fenghanxueye@163.com");
		System.out.println("哈哈："+num);
		//System.out.println(new Comm().sendEamilCode("505385234@qq.com"));
		
	}
	
	
	
}
