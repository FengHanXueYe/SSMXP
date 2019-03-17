package cn.kgc.tangcco.tcmp073.xumaofeng.comm.properties;

import java.util.HashMap;

import java.util.Map;

public class PropertiesFactory {

	private static Map<String,Object> mp = new HashMap<>();
	public static Object getInstance(String key) {
		Object obj = null;
		if(mp.containsKey(key)) {
			obj = mp.get(key);
		}else {
			try {
				obj = Class.forName(PropertiesUtils.getInstance().getValue(key)).newInstance();
				mp.put(key, obj);
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return obj;
	}
	
	
	
}
