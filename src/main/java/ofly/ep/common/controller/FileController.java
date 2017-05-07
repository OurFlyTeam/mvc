/**
 *
 * @(#) IFileController.java
 * @Package ofly.ep.common.controller
 * 
 * Copyright © ApexSoft Corporation. All rights reserved.
 *
 */

package ofly.ep.common.controller;

import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ofly.ep.common.api.IFileService;

/**
 *  类描述：
 * 
 *  @author:  Logan
 *
 *  History:  2017年5月6日 下午2:51:53   Logan   Created.
 *           
 */
@Controller
@RequestMapping("/file")
public class FileController {

	@Autowired
	private IFileService fileService;
	@RequestMapping("/download")
	public void download(HttpServletRequest request ,HttpServletResponse response,
						 String id) throws IOException {
		byte[] bytes = fileService.download(id);
		ServletOutputStream out = response.getOutputStream();
		out.write(bytes);
	}

}