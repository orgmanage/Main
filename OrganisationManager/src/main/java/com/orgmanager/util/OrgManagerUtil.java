package com.orgmanager.util;

import java.math.BigDecimal;

public class OrgManagerUtil {

public static boolean isNull(String string){
	if(null!=string && string.length()>0)
		return false;
	return true;
}

public static boolean isNull(BigDecimal value){
	if(null!=value)
		return false;
	return true;
}
	
}
