package base;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * page使用
 */
@Component("page")
@Data
public class Page{
	//当前页
	private int currentPage=1;
	//页面显示数据个数
	private int currentCount=5;
	//总数
	private long totalCount;
	// 分页数
	private long totalPages;
	// 是否开启跳转页面功能
	private boolean skip=true;
  // 模块需要使用的标题类型
	private String useTitle ;
	// 跳转的url路径
	private String redirectUrl ;

}
