package cn.kgc.tangcco.tcmp073.xumaofeng.comm.properties;

import java.io.IOException;





import java.io.InputStream;
import java.util.Properties;
/**
 * java工厂                         
 * @author 啊啊啊
 * 
 */
public class PropertiesUtils {               
	
	private Properties properties;
	private static PropertiesUtils propertiesUtils;
	private PropertiesUtils() {
		InputStream in = this.getClass().getResourceAsStream("/applicationContext.propersties");
		properties = new Properties();
		try {
			properties.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 
	 * @author 许茂峰
	 * @param key
	 * @param encoding
	 * @return String
	 */
	public String getValue(String key) {
		return properties.getProperty(key);
	}
	
	public static PropertiesUtils getInstance() {
		if(propertiesUtils==null) {
			propertiesUtils = new PropertiesUtils();
		}
		return propertiesUtils;
	}
	
	
	
	
	
}
