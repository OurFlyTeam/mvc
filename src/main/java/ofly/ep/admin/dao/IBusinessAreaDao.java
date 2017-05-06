/**
 *
 * @(#) NewsEditDao.java
 * @Package ofly.ep.admin.dao
 * 
 * Copyright © ApexSoft Corporation. All rights reserved.
 *
 */

package ofly.ep.admin.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import ofly.ep.admin.vo.BusinessAreaVo;

/**
 *  类描述：新闻维护Dao
 * 
 *  @author:  Logan
 *
 *  History:  2017年4月21日 上午1:07:09   Logan   Created.
 *           
 */
public interface IBusinessAreaDao {
	/**
	 * Introduction	：根据类型查询业务区域子类List
	 *
	 * Author		：Logan                
	 * Create Date	：2017年4月21日 下午11:09:46
	 * History		: 2017年4月21日 下午11:09:46   Logan   Created.
	 *
	 * @param type
	 * @return
	 *
	 */
	List<BusinessAreaVo> queryListByType(Map<String, Object> params);
	/**
	 * Introduction	：根据类型查询业务区域子类List数量
	 *
	 * Author		：Logan                
	 * Create Date	：2017年4月21日 下午11:39:48
	 * History		: 2017年4月21日 下午11:39:48   Logan   Created.
	 *
	 * @param type
	 * @return
	 *
	 */
	int queryListNumByType(Map<String, Object> params);
	
	/**
	 * Introduction	：新增
	 *
	 * Author		：Logan                
	 * Create Date	：2017年5月6日 下午1:57:55
	 * History		: 2017年5月6日 下午1:57:55   Logan   Created.
	 *
	 * @param vo
	 * @return
	 *
	 */
	int insert(BusinessAreaVo vo);
	/**
	 * Introduction	：根据主键查询数据
	 *
	 * Author		：Logan                
	 * Create Date	：2017年5月6日 下午2:28:12
	 * History		: 2017年5月6日 下午2:28:12   Logan   Created.
	 *
	 * @param id
	 * @return
	 *
	 */
	BusinessAreaVo queryByPrimarkKey(@Param("id")int id);
	int update(BusinessAreaVo vo);
	int delete(@Param("id")int id);
}
