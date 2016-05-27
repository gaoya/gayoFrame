package com.frame.commons.utils;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 16-3-9
 * Time: 下午2:12
 * To change this template use File | Settings | File Templates.
 */
public class StringUtils {
	private StringUtils(){ }

	/**
	 * 将首字母转换成大写，
	 * 		思路：首字母是a-z之间的英文，则进行转换，否则不进行处理
	 *
	 * @param msg 待处理的String类型数据
	 * @return 返回处理过的String 类型数据
	 */
	public static String captureLowerCase(String msg) {
		String ret=null;     //返回值
		char[] chars;      //将String ->chars
		StringBuffer sb=new StringBuffer();       //chars append的集合
		if(isNotEmpty(msg)){
			chars=msg.toCharArray();
			for(int i=0;i<chars.length;i++){
				if(i==0&&(chars[i]>='A'&&chars[i]<='Z')){
					chars[i]=(char)(chars[i]+32);
				}
				sb.append(chars[i]);
			}
			ret=sb.toString();
		}
		return ret;
	}

	/**
	 * 将首字母转换成大写，
	 * 若首字母是a-z之间的英文，则进行转换，否则不进行处理
	 *
	 * @param msg 待处理的String类型数据
	 * @return 返回处理过的String 类型数据
	 */
	public static String captureUpperCase(String msg){
		String ret=null;     //返回值
		char[] chars;      //将String ->chars
		StringBuffer sb=new StringBuffer();       //chars append的集合
		if(isNotEmpty(msg)){
			chars=msg.toCharArray();
			for(int i=0;i<chars.length;i++){
				if(i==0&&(chars[i]>='a'&&chars[i]<='z')){
					chars[i]=(char)(chars[i]-32);
				}
				sb.append(chars[i]);
			}
			ret=sb.toString();
		}
		return ret;
	}

	/**
	 * 将数据的长度达到指定的长度
	 *		在左侧添加空格
	 * @param msg   需要处理的数据
	 * @param count 处理的数据需要达到的长度
	 * @return 返回指定长度的数据
	 */
	public static String toLengthL(String msg,int count){
		return addReg(count-msg.length()," ")+msg;
	}

	/**
	 *  将数据的长度添加到指定长度
	 *  	在右侧添加空格
	 * @param msg 	需要处理的数据
	 * @param count	数据需要达到的长度
	 * @return	返回指定长度的数据
	 */
	public static String toLengthR(String msg,int count){
		return msg+addReg(count-msg.length()," ");
	}

	/**
	 * 添加指定长度的字符
	 *
	 * @param count 长度
	 * @param msg   添加的字符
	 * @return
	 */
	public static String addReg(int count,String msg){
		StringBuffer sb=new StringBuffer("");
		for(int i=0;i<count;i++){
			sb.append(msg);
		}
		return sb.toString();
	}

	/**
	 * 判断数据是否为空
	 * @param msg 需要判断的数据
	 * @return true 是空 false 非空
	 */
	public static boolean isEmpty(String msg){
		boolean flag=false;
		if(msg==null||"".equals(msg)||msg.length()==0){
			flag=true;
		}
		return flag;
	}

	/**
	 * 判断字符串是否非空
	 *
	 * @param msg 输入的字符串
	 * @return true 非空 false 空
	 */
	public static boolean isNotEmpty(String msg){
		return !isEmpty(msg);
	}

	/**
	 * 去掉字符串两端的空格
	 *
	 * @param msg 需要处理的数据
	 * @return 返回处理后的字符串信息
	 */
	public static String trim(String msg){
		String ret=null;
		if(isNotEmpty(msg)){
			ret=msg.trim();
		}
		return ret;
	}

	/**
	 * 去掉字符串左边的空格
	 *
	 * @param msg	需要处理的数据
	 * @return	返回处理后的数据
	 */
	public static String trimL(String msg){
		String ret=null;
		StringBuffer sb=new StringBuffer("");     //需要拼接的字符串
		int end=0;        //结束位置
		char[] chars;

		if(isNotEmpty(msg)){
			if(msg.startsWith(" ")){
				chars=msg.toCharArray();
				for(char c1 : chars){
					if(" ".equals(c1)){
						end++;
					}else{
						break;
					}
				}
			}
			ret=sb.append(msg.substring(end)).toString();
		}
		return ret;
	}

	/**
	 * 去掉右边的空格
	 *
	 * @param info
	 * @return
	 */
	public static String trimR(String info){
		String ret=null;
		StringBuffer sb=new StringBuffer("");
		int end;
		char[] chars;
		if(isNotEmpty(info)){
			end=info.length()-1;
			chars=info.toCharArray();
			for(int i=chars.length-1;i>=0;i--){
				if(" ".equals(chars[i])){
					end--;
				}else{
					break;
				}
			}
			ret=sb.append(info.substring(0,end)).toString();
		}
		return ret;
	}

	/**
	 * 去掉所有的空格
	 *		思路：将字符串转换成字符，然后判断是否为空、
	 *			若字符为空，则变成""
	 * @param info
	 * @return
	 */
	public static String trimAll(String info){
		String ret=null;
		StringBuffer sb=new StringBuffer("");
		char[] chars;
		if(isNotEmpty(info)){
			chars=info.toCharArray();
			for(char c1 : chars){
				if(" ".equals(c1)){
					sb.append("");
				}else{
					sb.append(c1);
				}
			}
			ret=sb.toString();
		}
		return ret;
	}
}
