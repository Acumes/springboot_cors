package com.htf.util;
/**
 * @description: 字符串工具类
 */
public class StringUtils {

	
	private StringUtils() {
	}

	public static boolean isEmpty(String str) {
		return str == null || str.length() == 0;
	}

	/**
	 * 将下划线分割的字符串转换为驼峰格式的字符串的方法
	 * 
	 * @param source
	 * @return
	 */
	public static String captureName(String source) {
		String[] str = source.toLowerCase().split("_");

		if (str.length == 0) {
			return source.toLowerCase();
		}

		StringBuffer buffer = new StringBuffer(str[0]);
		for (int j = 1; j < str.length; j++) {
			buffer.append(StringUtils.firstLetterToUpper(str[j]));
		}
		return buffer.toString();
	}

	/**
	 * 将字符串首字母大写的方法
	 * 
	 * @param source
	 * @return
	 */
	public static String firstLetterToUpper(String source) {
		char[] c = source.toCharArray();
		c[0] -= 32;
		return String.valueOf(c);
	}

	/**
	 * 把数字补全前缀为0，指定长度的字符串
	 */
	public static String getZeroNum(Integer num, Integer length) {
		String numStr = String.valueOf(num);
		int len = length - numStr.length();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < len; i++)
			sb.append("0");
		sb.append(numStr);
		return sb.toString();
	}
}
