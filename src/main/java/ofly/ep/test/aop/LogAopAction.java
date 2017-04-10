package ofly.ep.test.aop;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import ofly.ep.test.entity.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;


@Aspect
public class LogAopAction {

	private final Logger logger = Logger.getLogger(LogAopAction.class.getName());
	
	//获取开始时间
    private long BEGIN_TIME ;

    //获取结束时间
    private long END_TIME;

    //定义本次log实体
    private Log log = new Log();

	//@Pointcut("execution(* ofly.ep.test.controller.OFlyTestController.*(..)))")
	@Pointcut("execution(* ofly.ep.test..*.*(..)))")
    //@Pointcut("@annotation(ofly.ep.test.aop.SystemLog)") 
	private void controllerAspect() {
	}

	/**
	 * 方法开始执行
	 */
	@Before("controllerAspect()")
	public void before(JoinPoint joinPoint) {
		BEGIN_TIME = new Date().getTime();
		String className = joinPoint.getTarget().getClass().getName();
		String methodName = joinPoint.getSignature().getName();
		logger.info(className + "的" + methodName + "执行了");
		Object[] args = joinPoint.getArgs();
		StringBuilder log = new StringBuilder("入参为");
		for (Object arg : args) {
			log.append(arg + " ");
		}
		logger.info(log.toString());
	}

	/**
	 * 方法结束执行
	 */
	@After("controllerAspect()")
	public void after() {
		END_TIME = new Date().getTime();
		logger.info("结束");
	}

	/**
	 * 方法结束执行后的操作
	 */
	@AfterReturning("controllerAspect()")
	public void doAfter() {
		if(log.getState()==1||log.getState()==-1){
            log.setActionTime(END_TIME-BEGIN_TIME);
            log.setGmtCreate(new Date(BEGIN_TIME));
            logger.info(">>>>>>>>>>存入到数据库");
        }else {
            logger.info(">>>>>>>>不存入到数据库");
        }
	}
//	public void doAfterReturning(Object returnVal) {
//		 logger.info("方法正常结束了,方法的返回值:" + returnVal);
//	}

	/**
	 * 方法有异常时的操作
	 */
	@AfterThrowing(pointcut = "controllerAspect()", throwing = "e")
	public void doAfterThrowing(Exception e) {
		logger.info("*********例外通知**********："+e.getMessage());
	}
	
	/*
	@Around("controllerAspect()")
	public Object around(ProceedingJoinPoint pjp) throws Throwable{
		logger.info("=========  1111111111  =========");  
        //日志实体对象
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        //获取当前登陆用户信息
        //User loginUser = SessionUtil.getLoginSession(request);
//        if(loginUser==null){
//            log.setLoginAccount("—— ——");
//        }else{
//            log.setLoginAccount(loginUser.getUserAuth().getIdentity());
//        }

        // 拦截的实体类，就是当前正在执行的controller
        Object target = pjp.getTarget();
        // 拦截的方法名称。当前正在执行的方法
        String methodName = pjp.getSignature().getName();
        // 拦截的方法参数
        Object[] args = pjp.getArgs();
        // 拦截的放参数类型
        Signature sig = pjp.getSignature();
        MethodSignature msig = null;
        if (!(sig instanceof MethodSignature)) {
            throw new IllegalArgumentException("该注解只能用于方法");
        }
        msig = (MethodSignature) sig;
        Class[] parameterTypes = msig.getMethod().getParameterTypes();

        Object object = null;

        Method method = null;
        try {
            method = target.getClass().getMethod(methodName, parameterTypes);
        } catch (NoSuchMethodException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (SecurityException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        if (null != method) {
            // 判断是否包含自定义的注解，说明一下这里的SystemLog就是我自己自定义的注解
            if (method.isAnnotationPresent(SystemLog.class)) {
                SystemLog systemlog = method.getAnnotation(SystemLog.class);
                log.setModule(systemlog.module());
                log.setMethod(systemlog.methods());
                log.setLoginIp(getIp(request));
                log.setActionUrl(request.getRequestURI());

                try {
                    object = pjp.proceed();
                    log.setDescription("执行成功");
                    log.setState((short) 1);
                } catch (Throwable e) {
                    // TODO Auto-generated catch block
                	logger.info("*********例外通知**********："+e.getMessage());
                    log.setDescription("执行失败");
                    log.setState((short)-1);
                }
            } else {//没有包含注解
                object = pjp.proceed();
                log.setDescription("此操作不包含注解");
                log.setState((short)0);
            }
        } else { //不需要拦截直接执行
            object = pjp.proceed();
            log.setDescription("不需要拦截直接执行");
            log.setState((short)0);
        }
		logger.info("getActionTime:"+log.getActionTime());  
		logger.info("getActionUrl:"+log.getActionUrl());  
		logger.info("getClass:"+log.getClass());  
		logger.info("getDescription:"+log.getDescription());  
		logger.info("getGmtCreate:"+log.getGmtCreate());  
		logger.info("getId:"+log.getId());  
		logger.info("getLoginAccount:"+log.getLoginAccount());  
		logger.info("getLoginIp:"+log.getLoginIp());  
		logger.info("getMethod:"+log.getMethod());  
		logger.info("getModule:"+log.getModule());  
		logger.info("getState:"+log.getState()); 
        return object;
    }*/

    /**
     * 获取ip地址
     * @param request
     * @return
     */
    private String getIp(HttpServletRequest request){
        if (request.getHeader("x-forwarded-for") == null) {
            return request.getRemoteAddr();
        }
        return request.getHeader("x-forwarded-for");
    }

}
