import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @(#) TestFilter.java
 * @Package 
 * 
 * Copyright © ApexSoft Corporation. All rights reserved.
 *
 */

/**
 *  类描述：
 * 
 *  @author:  Logan
 *
 *  History:  2017年4月5日 上午1:41:36   Logan   Created.
 *           
 */
public class TestFilter implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("preHandle");
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("postHandle");

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("afterCompletion");

	}

}
