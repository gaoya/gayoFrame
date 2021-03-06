package com.frame.commons.unicode;

import java.io.UnsupportedEncodingException;
/**
*
* java中的String类是按照unicode进行编码的，当使用String(byte[] bytes, String encoding)构造字符串时，
* encoding所指的是bytes中的数据是按照那种方式编码的，而不是最后产生的String是什么编码方式，
* 换句话说，是让系统把bytes中的数据由encoding编码方式转换成unicode编码。如果不指明，bytes的编码方式将由jdk根据操作系统决定。

       当我们从文件中读数据时，最好使用InputStream方式，然后采用String(byte[] bytes, String encoding)指明文件的编码方式。不要使用Reader方式，因为Reader方式会自动根据jdk指明的编码方式把文件内容转换成unicode编码。

       当我们从数据库中读文本数据时，采用ResultSet.getBytes()方法取得字节数组，同样采用带编码方式的字符串构造方法即可。

	ResultSet rs;
	bytep[] bytes = rs.getBytes();
	String str = new String(bytes, "gb2312");
	
	不要采取下面的步骤。
	
	ResultSet rs;
	String str = rs.getString();
	str = new String(str.getBytes("iso8859-1"), "gb2312");

       这种编码转换方式效率底。之所以这么做的原因是，ResultSet在getString()方法执行时，默认数据库里的数据编码方式为iso8859-1。
       系统会把数据依照iso8859-1的编码方式转换成unicode。使用str.getBytes("iso8859-1")把数据还原，
       然后利用new String(bytes, "gb2312")把数据从gb2312转换成unicode，中间多了好多步骤。

       从HttpRequest中读参数时，利用reqeust.setCharacterEncoding()方法设置编码方式，读出的内容就是正确的了。
*/
public class UnicodeUtils {
	/** 7位ASCII字符，也叫作ISO646-US、Unicode字符集的基本拉丁块 */
	public static final String US_ASCII = "US-ASCII";

	/** ISO 拉丁字母表 No.1，也叫作 ISO-LATIN-1 */
	public static final String ISO_8859_1 = "ISO-8859-1";

	/** 8 位 UCS 转换格式 */
	public static final String UTF_8 = "UTF-8";

	/** 16 位 UCS 转换格式，Big Endian（最低地址存放高位字节）字节顺序 */
	public static final String UTF_16BE = "UTF-16BE";

	/** 16 位 UCS 转换格式，Little-endian（最高地址存放低位字节）字节顺序 */
	public static final String UTF_16LE = "UTF-16LE";

	/** 16 位 UCS 转换格式，字节顺序由可选的字节顺序标记来标识 */
	public static final String UTF_16 = "UTF-16";

	/** 中文超大字符集 */
	public static final String GBK = "GBK";

	/**
	 * 将字符编码转换成US-ASCII码
	 */
	public String toASCII(String str) throws UnsupportedEncodingException{
		return this.toUnicode(str, US_ASCII);
	}
	/**
	 * 将字符编码转换成ISO-8859-1码
	 */
	public String toISO_8859_1(String str) throws UnsupportedEncodingException{
		return this.toUnicode(str, ISO_8859_1);
	}
	/**
	 * 将字符编码转换成UTF-8码
	 */
	public String toUTF_8(String str) throws UnsupportedEncodingException{
		return this.toUnicode(str, UTF_8);
	}
	/**
	 * 将字符编码转换成UTF-16BE码
	 */
	public String toUTF_16BE(String str) throws UnsupportedEncodingException{
		return this.toUnicode(str, UTF_16BE);
	}
	/**
	 * 将字符编码转换成UTF-16LE码
	 */
	public String toUTF_16LE(String str) throws UnsupportedEncodingException{
		return this.toUnicode(str, UTF_16LE);
	}
	/**
	 * 将字符编码转换成UTF-16码
	 */
	public String toUTF_16(String str) throws UnsupportedEncodingException{
		return this.toUnicode(str, UTF_16);
	}
	/**
	 * 将字符编码转换成GBK码
	 */
	public String toGBK(String str) throws UnsupportedEncodingException{
		return this.toUnicode(str, GBK);
	}

	/**
	 * 字符串编码转换的实现方法
	 * @param str  待转换编码的字符串
	 * @param newCharset 目标编码
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public String toUnicode(String str, String newCharset)
			throws UnsupportedEncodingException {
		String ret = null ;
		if (str != null && str.trim().length() !=0 ) {
			//用默认字符编码解码字符串。
			byte[] bs = str.getBytes();
			//用新的字符编码生成字符串
			ret = new String(bs, newCharset);
		}
		return ret ;
	}
	/**
	 * 字符串编码转换的实现方法
	 * @param str  待转换编码的字符串
	 * @param oldCharset 原编码
	 * @param newCharset 目标编码
	 * @return 
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public String toUnicode(String str, String oldCharset, String newCharset) 
			throws UnsupportedEncodingException {
		String ret = null ;
		if (str != null && str.trim().length() != 0 ) {
			//用旧的字符编码解码字符串。解码可能会出现异常。
			byte[] bs = str.getBytes(oldCharset);
			//用新的字符编码生成字符串
			ret = new String(bs, newCharset);
		}
		return ret ;
	}
	
}




