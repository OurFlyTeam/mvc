package ofly.ep.test.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MethodLogAspectJ {

	private final Logger logger = Logger.getLogger(MethodLogAspectJ.class.getName());

	// 切入点表达式按需配置
	@Pointcut("execution(ofly.ep.test.* *.*(..)))")
	// @Pointcut("execution(ofly.ep.**.OFlyTestController.addShop(..)))")
	private void myPointcut() {
	}

	/**
	 * 方法开始执行
	 */
	@Before("myPointcut()")
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
	//
	// /**
	// * 方法结束执行
	// */
	// @After("myPointcut()")
	// public void after(Object returnVal){
	// logger.info("方法正常结束了,方法的返回值:" + returnVal);
	// }
	//
	// @AfterReturning("myPointcut()")
	// public void doAfter(Object returnVal) {
	// logger.info("方法正常结束了,方法的返回值:" + returnVal);
	// }
	//
	// @AfterThrowing("myPointcut()")
	// public void afterThrowing(Throwable e) {
	// if (e instanceof RuntimeException) {
	// logger.info("通知中发现异常RuntimeException", e);
	// } else {
	// logger.info("通知中发现未知异常", e);
	// }
	// }
	// /**
	// * 声明前置通知
	// */
	// @Before("pointCutMethod()")
	// public void doBefore() {
	// System.out.println("前置通知");
	// }

	// /**
	// * 声明后置通知
	// *
	// * @param result
	// */
	// @AfterReturning(pointcut = "pointCutMethod()", returning = "result")
	// public void doAfterReturning(String result) {
	// System.out.println("后置通知");
	// System.out.println("---" + result + "---");
	// }
	//
	/**
	 * 声明例外通知
	 */
	@AfterThrowing(pointcut = "pointCutMethod()", throwing = "e")
	public void doAfterThrowing(Exception e) {
		System.out.println("例外通知");
		System.out.println(e.getMessage());
	}
	//
	// /**
	// * 声明最终通知
	// */
	// @After("pointCutMethod()")
	// public void doAfter() {
	// System.out.println("最终通知");
	// }
	//
	// /**
	// * 声明环绕通知
	// *
	// * @param pjp
	// * @return
	// * @throws Throwable
	// */
	// @Around("pointCutMethod()")
	// public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
	// System.out.println("进入方法---环绕通知");
	// Object o = pjp.proceed();
	// System.out.println("退出方法---环绕通知");
	// return o;
	// }

}
