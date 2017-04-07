package ofly.ep.test.aop;

import java.lang.annotation.*;

/**
 * Created by 3bear on 2017/4/07.
 */

@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SystemLog {
    String module()  default "";
    String methods()  default "";
}
