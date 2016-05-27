package com.frame.commons.reg;

/**
 * 匹配
 * @author admin
 *
 */
@SuppressWarnings("unused")
public class Matcher {
	private static String regex  ;
	//判断是否是字符
	private final static String WORD = "\\w*" 	;
	//判断是否是数字
	private final static String NUMBER = "^[0-9]*$" ;
	//匹配中文字符的正则表达式：  评注：匹配中文还真是个头疼的事，有了这个表达式就好办了 
	private final static String CHINA_WORD = "^[u4e00-u9fa5]*$" ;
	//匹配双字节字符(包括汉字在内)：  评注：可以用来计算字符串的长度（一个双字节字符长度计2，ASCII字符计1） 
	private final static String DOUBLE_WORD = "^[^x00-xff]*$" ;
	//非数字或字符
	private final static String NOT_WORD = "^[\\t|\\b|\\n]*$" ;
	// 匹配Email地址的正则表达式：
	private final static String EMAIL = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*.\\w+([-.]\\w+)*$"; 
	//url
	private final static String URL = "^[a-zA-z]+://[^\\s]*$" ;
	// 匹配帐号是否合法(字母开头，允许5-16字节，允许字母数字下划线)：
	private final static String CARD = "^[a-zA-Z][a-zA-Z0-9_]{4,15}$" ;
	// 匹配国内电话号码： 评注：匹配形式如 0511-4405222 或 021-87888822 
	private final static String PHONE ="^\\d{3}-\\d{8}|\\d{4}-\\d{7}$" ;
	//匹配腾讯QQ号： 腾讯QQ号从10000开始 
	private final static String QQ = "^[1-9][0-9]{4,}$" ; 
	// 匹配中国邮政编码：  中国邮政编码为6位数字 
	private final static String ZIP = "^[1-9]d{5}$" ;
	// 匹配身份证：d{15}|d{18} 中国的身份证为15位或18位  X x 
	private final static String STAFF_CARD = "^\\d{14}|\\d{17}(\\d{1}|x|X)$" ;
	// 匹配ip4地址：d+.d+.d+.d+ 
	private final static String IP4 = "^\\d{3}\\.\\d{3}\\.\\d{3}\\.\\d{3}$" ;
//			　　匹配特定数字： 
//			　　^[1-9]d*$　 　 //匹配正整数 
//			　　^-[1-9]d*$ 　 //匹配负整数 
//			　　^-?[1-9]d*$　　 //匹配整数 
//			　　^[1-9]d*|0$　 //匹配非负整数（正整数 + 0） 
//			　　^-[1-9]d*|0$　　 //匹配非正整数（负整数 + 0） 
//			　　^[1-9]d*.d*|0.d*[1-9]d*$　　 //匹配正浮点数 
//			　　^-([1-9]d*.d*|0.d*[1-9]d*)$　 //匹配负浮点数 
//			　　^-?([1-9]d*.d*|0.d*[1-9]d*|0?.0+|0)$　 //匹配浮点数 
//			　　^[1-9]d*.d*|0.d*[1-9]d*|0?.0+|0$　　 //匹配非负浮点数（正浮点数 + 0） 
//			　　^(-([1-9]d*.d*|0.d*[1-9]d*))|0?.0+|0$　　//匹配非正浮点数（负浮点数 + 0） 
//			　　评注：处理大量数据时有用，具体应用时注意修正 
//			　　匹配特定字符串： 
//			　　^[A-Za-z]+$　　//匹配由26个英文字母组成的字符串 
//			　　^[A-Z]+$　　//匹配由26个英文字母的大写组成的字符串 
//			　　^[a-z]+$　　//匹配由26个英文字母的小写组成的字符串 
//			　　^[A-Za-z0-9]+$　　//匹配由数字和26个英文字母组成的字符串 
//			　　^w+$　　//匹配由数字、26个英文字母或者下划线组成的字符串 
//			　　在使用RegularExpressionValidator验证控件时的验证功能及其验证表达式介绍如下: 
//			　　只能输入数字：“^[0-9]*$” 
//			　　只能输入n位的数字：“^d{n}$” 
//			　　只能输入至少n位数字：“^d{n,}$” 
//			　　只能输入m-n位的数字：“^d{m,n}$” 
//			　　只能输入零和非零开头的数字：“^(0|[1-9][0-9]*)$” 
//			　　只能输入有两位小数的正实数：“^[0-9]+(.[0-9]{2})?$” 
//			　　只能输入有1-3位小数的正实数：“^[0-9]+(.[0-9]{1,3})?$” 
//			　　只能输入非零的正整数：“^+?[1-9][0-9]*$” 
//			　　只能输入非零的负整数：“^-[1-9][0-9]*$” 
//			　　只能输入长度为3的字符：“^.{3}$” 
//			　　只能输入由26个英文字母组成的字符串：“^[A-Za-z]+$” 
//			　　只能输入由26个大写英文字母组成的字符串：“^[A-Z]+$” 
//			　　只能输入由26个小写英文字母组成的字符串：“^[a-z]+$” 
//			　　只能输入由数字和26个英文字母组成的字符串：“^[A-Za-z0-9]+$” 
//			　　只能输入由数字、26个英文字母或者下划线组成的字符串：“^w+$” 
//			　　验证用户密码:“^[a-zA-Z]w{5,17}$”正确格式为：以字母开头，长度在6-18之间， 
//			　　只能包含字符、数字和下划线。 
//			　　验证是否含有^%&'',;=?$"等字符：“[^%&'',;=?$x22]+” 
//			　　只能输入汉字：“^[u4e00-u9fa5],{0,}$” 
//			　　验证Email地址：“^w+[-+.]w+)*@w+([-.]w+)*.w+([-.]w+)*$” 
//			　　验证InternetURL：“^http://([w-]+.)+[w-]+(/[w-./?%&=]*)?$” 
//			　　验证电话号码：“^((d{3,4})|d{3,4}-)?d{7,8}$” 
//			　　正确格式为：“XXXX-XXXXXXX”，“XXXX-XXXXXXXX”，“XXX-XXXXXXX”， 
//			　　“XXX-XXXXXXXX”，“XXXXXXX”，“XXXXXXXX”。 
//			　　验证身份证号（15位或18位数字）：“^d{15}|d{}18$” 
//			　　验证一年的12个月：“^(0?[1-9]|1[0-2])$”正确格式为：“01”-“09”和“1”“12” 
//			　　验证一个月的31天：“^((0?[1-9])|((1|2)[0-9])|30|31)$” 
//			　　正确格式为：“01”“09”和“1”“31”。 
//			　　匹配中文字符的正则表达式： [u4e00-u9fa5] 
//			　　匹配双字节字符(包括汉字在内)：[^x00-xff] 
//			　　匹配空行的正则表达式：n[s| ]*r 
//			　　匹配HTML标记的正则表达式：/<(.*)>.*|<(.*) />/ 
//			　　匹配首尾空格的正则表达式：(^s*)|(s*$) 
//			　　匹配Email地址的正则表达式：w+([-+.]w+)*@w+([-.]w+)*.w+([-.]w+)* 
//			　　匹配网址URL的正则表达式：http://([w-]+.)+[w-]+(/[w- ./?%&=]*)? 
	
	
	public String getRegex() {
		return regex;
	}

	@SuppressWarnings("static-access")
	public void setRegex(String regex) {
		this.regex = regex;
	}

	private Matcher(){}
	
	@SuppressWarnings("static-access")
	public Matcher(String reg) {
		this.regex = reg ;
	}
	
	/**
	 * 判断是否匹配
	 * @return
	 */
	public  boolean m(String msg) {
		boolean flag = false ;
		if ( msg .matches(regex)) {
			flag = true ;
		}
		return flag;
	}
	
	public static boolean m(String reg,String msg) {
		boolean flag = false ;
		if (msg.matches(reg)) {
			flag = true ;
		}
		return flag ;
	}
	/**
	 * 判断 strsub 是否存在msg 中
	 * @param msg
	 * @param strsub
	 */
	public static boolean isExist(String msg ,String strsub) {
		boolean flag = false ;
		if (msg .contains( strsub)) {
			flag = true ;
		}
		return flag ;
	}
}
