package com.annotation;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE})//目标是方法
@Retention(RetentionPolicy.RUNTIME) //注解会在class中存在， 运行时可通过反射获取
@Inherited
@Documented//文档生成时，该注解将被包含在javadoc中，
public @interface UserAccess {
    String desc() default "身份和安全验证开始。。。";
}
