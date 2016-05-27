import java.io.Serializable;

public class SysTitle implements Serializable {

  
    private Integer id;             //seq
    
    private String titleName;       //标题
 
    private String titleType;       //类型

    private String titleProperty;   //属性
  
    private String titlePx;     //排序

    private String titleFlag;    // 是否启用
   
    private String listShow = "0" ;   //是否在list中显示 0-显示 1-不显示

    private String newShow = "0";    //是否在添加的页面显示 0-显示 1-不显示
   
    private String readShow = "0";   //是否在读取的页面显示 0-显示 1-不显示
  
    private String updateShow = "0";  //是否在修改的页面显示 0-显示 1-不显示
   
    private Object titleValue;
   
    private String ids;


}