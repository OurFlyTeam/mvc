/**
 *
 * @(#) BusinessAreaService.java
 * @Package ofly.ep.admin.service
 * 
 * Copyright © ApexSoft Corporation. All rights reserved.
 *
 */

package ofly.ep.test.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ofly.ep.test.api.IEpSubDesService;
import ofly.ep.test.dao.IEpSubDesDao;
import ofly.ep.test.vo.EpSubDesVO;

@Service
public class EpSubDesService implements IEpSubDesService {
	
	@Resource
	private IEpSubDesDao dao;
	
	@Override
	public List<EpSubDesVO> queryListByType(Map<String, Object> params) {
		// TODO Auto-generated method stub
		List<EpSubDesVO> list = dao.queryListByType(params);
		return list;
	}
	
	
}
