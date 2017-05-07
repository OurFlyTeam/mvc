/**
 *
 * @(#) BusinessAreaService.java
 * @Package ofly.ep.admin.service
 * 
 * Copyright © ApexSoft Corporation. All rights reserved.
 *
 */

package ofly.ep.admin.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ofly.ep.admin.api.IBusinessAreaService;
import ofly.ep.admin.api.IProductCenterService;
import ofly.ep.admin.dao.IBusinessAreaDao;
import ofly.ep.admin.dao.IProductCenterDao;
import ofly.ep.admin.vo.BusinessAreaVo;
import ofly.ep.common.api.IFileService;
import ofly.ep.common.vo.FileVo;

/**
 *  类描述：
 * 
 *  @author:  Logan
 *
 *  History:  2017年5月6日 上午10:02:52   Logan   Created.
 *           
 */
@Service
public class ProductCenterService implements IProductCenterService {
	
	@Autowired
	private IProductCenterDao dao;
	@Autowired
	private IFileService fileService;
	
	@Override
	public List<BusinessAreaVo> queryListByType(Map<String, Object> params) {
		List<BusinessAreaVo> list = dao.queryListByType(params);
		return list;
	}

	@Override
	public int queryListNumByType(Map<String, Object> params) {
		int num = dao.queryListNumByType(params);
		return num;
	}

	@Override
	public Map<String, Object> save(BusinessAreaVo vo) throws IOException {
		Map<String, Object> result = null;
		if(vo.getId()==0) {// 新增
			result = insert(vo);
		} else {							 // 更新
			result = update(vo);
		}
		return result;
	}
	
	private Map<String, Object> update(BusinessAreaVo vo)  throws IOException {
		Map<String, Object> result = new  HashMap<>();
		if(!vo.getPicFile().isEmpty()) {
			//修改图片
			BusinessAreaVo vo2 = dao.queryByPrimarkKey(vo.getId());
			FileVo fileVo = new FileVo();
			fileVo.setFileId(vo2.getTitlePicId());
			fileVo.setFileName(vo.getPicFile().getOriginalFilename());
			fileVo.setFile(vo.getPicFile().getBytes());
			boolean update = fileService.update(fileVo);
			if(!update) {
				result.put("code", 0);
				result.put("msg", "更新图片失败");
				return result;
			}
		}
		// 更新 业务
		int i = dao.update(vo);
		if(i==0) {
			result.put("code", 0);
			result.put("msg", "更新业务数据失败");
		} else {
			result.put("code", 1);
			result.put("msg", "保存成功");
		}
		return result;
	}
	
	private Map<String, Object> insert(BusinessAreaVo vo) throws IOException  {
		Map<String, Object> result = new  HashMap<>();
		FileVo fileVo = new FileVo();
		String fileId = UUID.randomUUID().toString();
		fileVo.setFileId(fileId);
		fileVo.setFile(vo.getPicFile().getBytes());
		fileVo.setFileName(vo.getPicFile().getOriginalFilename());
		boolean upload = fileService.upload(fileVo);
		if(upload) {
			vo.setTitlePicId(fileId);
			int i = dao.insert(vo);
			if(i==0){
				result.put("code", 0);
				result.put("msg","业务领域数据保存失败");
			} else {
				result.put("code", 1);
				result.put("msg","保存成功");
			}
		} else {
			result.put("code", 0);
			result.put("msg","图片上传失败");
		}
		return result;
	}

	@Override
	public BusinessAreaVo queryByPrimarkKey(int id) {
		BusinessAreaVo vo = dao.queryByPrimarkKey(id);
		return vo;
	}

	@Override
	public Map<String, Object> delete(int id) {
		Map<String, Object> result = new HashMap<>();
		BusinessAreaVo vo = dao.queryByPrimarkKey(id);
		// 删除图片
		boolean i1 = fileService.delete(vo.getTitlePicId());
		if(!i1) {
			result.put("code", 0);
			result.put("msg", "删除图片失败");
			return result;
		}
		// 删除业务数据
		int i2 = dao.delete(id);
		if(i2==0) {
			result.put("code", 0);
			result.put("msg", "删除业务数据失败");
		} else{
			result.put("code", 1);
			result.put("msg", "删除成功");
		}
		return result;
	}
}
