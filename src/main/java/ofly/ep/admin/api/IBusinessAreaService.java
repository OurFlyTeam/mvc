/**
 *
 * @(#) BusinessAreaService.java
 * @Package ofly.ep.admin.api
 * 
 * Copyright © ApexSoft Corporation. All rights reserved.
 *
 */

package ofly.ep.admin.api;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import ofly.ep.admin.vo.BusinessAreaVo;

/**
 *  类描述：
 * 
 *  @author:  Logan
 *
 *  History:  2017年5月6日 上午10:00:25   Logan   Created.
 *           
 */
public interface IBusinessAreaService {
	/**
	 * Introduction	：根据类别查询List
	 *
	 * Author		：Logan                
	 * Create Date	：2017年5月6日 上午10:01:13
	 * History		: 2017年5月6日 上午10:01:13   Logan   Created.
	 *
	 * @param params
	 * @return
	 *
	 */
	List<BusinessAreaVo> queryListByType(Map<String, Object> params);
	/**
	 * Introduction	：根据类别查询Num
	 *
	 * Author		：Logan                
	 * Create Date	：2017年5月6日 上午10:01:48
	 * History		: 2017年5月6日 上午10:01:48   Logan   Created.
	 *
	 * @param params
	 * @return
	 *
	 */
	int queryListNumByType(Map<String, Object> params);
	/**
	 * Introduction	：保存
	 *
	 * Author		：Logan                
	 * Create Date	：2017年5月6日 下午1:05:00
	 * History		: 2017年5月6日 下午1:05:00   Logan   Created.
	 *
	 * @param vo
	 * @return
	 *
	 */
	Map<String, Object> save(BusinessAreaVo vo)throws IOException;
	/**
	 * Introduction	：根据主键查询数据
	 *
	 * Author		：Logan                
	 * Create Date	：2017年5月6日 下午2:29:15
	 * History		: 2017年5月6日 下午2:29:15   Logan   Created.
	 *
	 * @param id
	 * @return
	 *
	 */
	BusinessAreaVo queryByPrimarkKey(int id);
	Map<String, Object> delete(int id);

}
