/**
 *
 * @(#) NewsEditDao.java
 * @Package ofly.ep.admin.dao
 * 
 * Copyright © ApexSoft Corporation. All rights reserved.
 *
 */

package ofly.ep.test.dao;

import java.util.List;
import java.util.Map;

import ofly.ep.test.vo.EpSubDesVO;
public interface IEpSubDesDao {
	List<EpSubDesVO> queryListByType(Map<String, Object> params);
	
}
