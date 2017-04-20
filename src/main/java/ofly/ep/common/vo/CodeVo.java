/**
 *
 * @(#) CodeVo.java
 * @Package ofly.ep.common.vo
 * 
 * Copyright © ApexSoft Corporation. All rights reserved.
 *
 */

package ofly.ep.common.vo;

/**
 *  类描述：标准代码Bo
 * 
 *  @author:  Logan
 *
 *  History:  2017年4月20日 下午11:04:34   Logan   Created.
 *           
 */
public class CodeVo {
	
	private String id;			// 标准代码ID
	private String parentId;	// 父节点ID
	private String name;		// 标准代码名称
	private String value;		// 标准代码值
	private String sortId;		// 标准代码分类ID
	private String sortName;	// 标准代码分类名称
	private String sortCode;	// 标准代码分类Code
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getSortId() {
		return sortId;
	}
	public void setSortId(String sortId) {
		this.sortId = sortId;
	}
	public String getSortName() {
		return sortName;
	}
	public void setSortName(String sortName) {
		this.sortName = sortName;
	}
	
	public String getSortCode() {
		return sortCode;
	}
	public void setSortCode(String sortCode) {
		this.sortCode = sortCode;
	}
	@Override
	public String toString() {
		return "CodeVo [id=" + id + ", parentId=" + parentId + ", name=" + name + ", value=" + value + ", sortId="
				+ sortId + ", sortName=" + sortName + ", sortCode=" + sortCode + "]";
	}
	
	

}
