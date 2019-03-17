package cn.kgc.tangcco.tcmp073.xumaofeng.comm.utils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

public class BeanUtil {

	public static final String AJAXDAO = "ajax";
	
	public static <T>void paraMap(T t,Map<String,String[]> parameter) {
		try {
			BeanUtils.populate(t, parameter);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
	
}
