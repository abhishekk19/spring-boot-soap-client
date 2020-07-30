package com.example.genericrestapi.util;

import org.springframework.util.DigestUtils;

public class MD5Util {
	
	
	public static String generateMd5Key(String value) {
		
	//	if(value.length()!=0)
        return DigestUtils.md5DigestAsHex(value.getBytes());
		

	}

}
