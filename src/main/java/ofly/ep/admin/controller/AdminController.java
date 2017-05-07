/**
 *
 * @(#) AdminController.java
 * @Package ofly.ep.admin.controller
 * 
 * Copyright © ApexSoft Corporation. All rights reserved.
 *
 */

package ofly.ep.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *  类描述：
 * 
 *  @author:  Logan
 *
 *  History:  2017年5月6日 下午9:03:45   Logan   Created.
 *           
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
	
	public static final String PATH_ADMIN_INIT = "admin/admin";
	
	@RequestMapping("/init")
	public String init() {
		return PATH_ADMIN_INIT;
	}

}
