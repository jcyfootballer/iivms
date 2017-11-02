/**
 * <b>项目名：</b>datawork-common<br/>  
 * <b>包名：</b>com.funshion.dw.common.security.vo<br/>  
 * <b>文件名：</b>AppMenu.java<br/>  
 * <b>author：</b>jiangcyAppMenu.java<br/>  
 * <b>日期：</b>2015年5月15日-下午7:10:41<br/>  
 * <b>Copyright (c)</b> 2015风行在线-版权所有<br/>   
 */
package com.cars.iivmshome.auth.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: AppMenu
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: jiangcy
 * @date: 2015年5月15日 下午7:10:41
 */
public class AppMenu implements Serializable, Comparable<AppMenu> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 34101292785712063L;
	protected Integer id; // 唯一标识
	protected String appmenid; // 应用菜单标识
	protected String name; // 应用菜单名字
	protected Integer parentid; // 父级ID
	protected String url; // 资源路径
	protected String image; // 应用图片
	protected Integer seq; // 排序序号
	protected boolean haschildren; // 是否拥有孩子
	protected boolean isshow;

	public boolean isIsshow() {
		return isshow;
	}

	public void setIsshow(boolean isshow) {
		this.isshow = isshow;
	}

	protected List<AppMenu> children;
	
	public List<AppMenu> getChildren() {
		return children;
	}

	public void setChildren(List<AppMenu> children) {
		this.children = children;
	}

	public AppMenu(ModuleInfoVo vo) {
		this.setId(vo.getModuleId());
		this.setAppmenid(vo.getModuleCode());
		this.setName(vo.getModuleName());
		this.setParentid(vo.getParentModuleId());
		this.setHaschildren(!vo.getIsleaf());
		this.setUrl(vo.getModuleUrl());
		this.setImage(vo.getModuleIcon());
		this.setSeq(vo.getPriority());
		children = new ArrayList<AppMenu>();
		this.isshow = false;
	}

	public AppMenu() {
	}

	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAppmenid() {
		return appmenid;
	}

	public void setAppmenid(String appmenid) {
		this.appmenid = appmenid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getParentid() {
		return parentid;
	}

	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public boolean isHaschildren() {
		return haschildren;
	}

	public void setHaschildren(boolean haschildren) {
		this.haschildren = haschildren;
	}

	@Override
	public int compareTo(AppMenu o) {
		return this.getSeq().compareTo(o.getSeq());
	}

}
