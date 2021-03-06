/**
 *
 * @(#) NewsVo.java
 * @Package ofly.ep.admin.vo
 * 
 * Copyright © ApexSoft Corporation. All rights reserved.
 *
 */

package ofly.ep.admin.vo;

/**
 *  类描述：
 * 
 *  @author:  Logan
 *
 *  History:  2017年4月21日 上午12:57:27   Logan   Created.
 *           
 */
public class NewsVo {
	private int id;
	private String title;
	private String type;
	private String content;
	private String creatTime;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCreatTime() {
		return creatTime;
	}
	public void setCreatTime(String creatTime) {
		this.creatTime = creatTime;
	}
	@Override
	public String toString() {
		return "NewsVo [id=" + id + ", title=" + title + ", type=" + type + ", content=" + content + ", creatTime="
				+ creatTime + "]";
	}
	
}
