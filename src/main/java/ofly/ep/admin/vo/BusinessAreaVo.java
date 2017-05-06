/**
 *
 * @(#) BusinessAreaBo.java
 * @Package ofly.ep.admin.vo
 * 
 * Copyright © ApexSoft Corporation. All rights reserved.
 *
 */

package ofly.ep.admin.vo;

import org.springframework.web.multipart.MultipartFile;

/**
 *  类描述：业务领域Vo
 * 
 *  @author:  Logan
 *
 *  History:  2017年5月6日 上午9:28:01   Logan   Created.
 *           
 */
public class BusinessAreaVo {
	
	private int id;			// 主键
	private String type;		// 业务领域类别 businessAreaType
	private String title;		// 业务自类别标题
	private String content;		// 业务子领域 html显示内容
	private String titlePicId;	// 业务子领域 标题图片ID
	private String creatTime;	// 创建时间
	MultipartFile picFile;// 文件
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTitlePicId() {
		return titlePicId;
	}
	public void setTitlePicId(String titlePicId) {
		this.titlePicId = titlePicId;
	}
	public String getCreatTime() {
		return creatTime;
	}
	public void setCreatTime(String creatTime) {
		this.creatTime = creatTime;
	}
	
	public MultipartFile getPicFile() {
		return picFile;
	}
	public void setPicFile(MultipartFile picFile) {
		this.picFile = picFile;
	}
	@Override
	public String toString() {
		return "BusinessAreaVo [id=" + id + ", type=" + type + ", title=" + title + ", content=" + content
				+ ", titlePicId=" + titlePicId + ", creatTime=" + creatTime + "]";
	}
	
	
}
