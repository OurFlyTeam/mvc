package ofly.ep.test.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class LogAopAction {

	private final Logger logger = Logger.getLogger(MethodLogAspectJ.class.getName());

	//@Pointcut("execution(ofly.ep.test.* *.*(..)))")
	@Pointcut("execution(* *.*(..)))")
	private void controllerAspect() {
	}

	/**
	 * 方法开始执行
	 */
	@Before("controllerAspect()")
	public void before(JoinPoint joinPoint) {
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
		System.out.println("结束");
	}

	/**
	 * 方法结束执行后的操作
	 */
	@AfterReturning("controllerAspect()")
	public void doAfter() {
		System.out.println("AfterReturning");
	}
//	public void doAfterReturning(Object returnVal) {
//		 logger.info("方法正常结束了,方法的返回值:" + returnVal);
//	}

	/**
	 * 方法有异常时的操作
	 */
	@AfterThrowing(pointcut = "controllerAspect()", throwing = "e")
	public void doAfterThrowing(Exception e) {
		System.out.println("例外通知--------------");
		System.out.println(e.getMessage());
	}

}
