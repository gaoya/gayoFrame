package com.frame;
import java.io.Serializable;

public class SysTitle implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;             //seq
    
    private String title_name;       //标题
 
    private String title_type;       //类型

    private String title_property;   //属性
  
    private String title_px;     //排序

    private String title_flag;    // 是否启用
   
    private String list_show = "0" ;   //是否在list中显示 0-显示 1-不显示

    private String new_show = "0";    //是否在添加的页面显示 0-显示 1-不显示
   
    private String read_show = "0";   //是否在读取的页面显示 0-显示 1-不显示
  
    private String update_show = "0";  //是否在修改的页面显示 0-显示 1-不显示

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle_name() {
		return title_name;
	}

	public void setTitle_name(String title_name) {
		this.title_name = title_name;
	}

	public String getTitle_type() {
		return title_type;
	}

	public void setTitle_type(String title_type) {
		this.title_type = title_type;
	}

	public String getTitle_property() {
		return title_property;
	}

	public void setTitle_property(String title_property) {
		this.title_property = title_property;
	}

	public String getTitle_px() {
		return title_px;
	}

	public void setTitle_px(String title_px) {
		this.title_px = title_px;
	}

	public String getTitle_flag() {
		return title_flag;
	}

	public void setTitle_flag(String title_flag) {
		this.title_flag = title_flag;
	}

	public String getList_show() {
		return list_show;
	}

	public void setList_show(String list_show) {
		this.list_show = list_show;
	}

	public String getNew_show() {
		return new_show;
	}

	public void setNew_show(String new_show) {
		this.new_show = new_show;
	}

	public String getRead_show() {
		return read_show;
	}

	public void setRead_show(String read_show) {
		this.read_show = read_show;
	}

	public String getUpdate_show() {
		return update_show;
	}

	public void setUpdate_show(String update_show) {
		this.update_show = update_show;
	}

	@Override
	public String toString() {
		return "SysTitle [id=" + id + ", title_name=" + title_name + ", title_type=" + title_type + ", title_property="
				+ title_property + ", title_px=" + title_px + ", title_flag=" + title_flag + ", list_show=" + list_show
				+ ", new_show=" + new_show + ", read_show=" + read_show + ", update_show=" + update_show + "]";
	}

	 
   
  
}