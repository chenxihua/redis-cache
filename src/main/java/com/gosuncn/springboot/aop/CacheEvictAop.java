//package com.gosuncn.springboot.aop;
//
//import com.gosuncn.springboot.annoation.CacheEvictEx;
//import org.apache.commons.lang.StringUtils;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.Signature;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.aspectj.lang.reflect.MethodSignature;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.stereotype.Component;
//
//import java.lang.reflect.Method;
//import java.util.Iterator;
//import java.util.Set;
//
///**
// * @ClassName: CacheEvictAop
// * @Create By: chenxihua
// * @Date: 2019/10/21 14:54
// **/
//@Aspect
//@Component
//public class CacheEvictAop {
//
//    private static final Logger logger = LoggerFactory.getLogger(CacheEvictAop.class);
//
//
//    @Autowired
//    StringRedisTemplate stringRedisTemplate;
//
//
//    @Pointcut(value = "@annotation(com.gosuncn.springboot.annoation.CacheEvictEx)")
//    public void cutService(){
//    }
//
//    @Around("cutService()")
//    public Object cacheEvict(ProceedingJoinPoint point) throws Throwable {
//        logger.warn("进入aop切面。。。");
//        // 先执行任务
//        Object result = point.proceed();
//        try {
//            // 处理任务
//            handle(point);
//        } catch (Throwable throwable) {
//            throwable.printStackTrace();
//        }
//        return result;
//    }
//
//    private void handle(ProceedingJoinPoint point) throws NoSuchMethodException {
//        // 获取拦截的方法名
//        Signature signature = point.getSignature();
//        MethodSignature msig = null;
//        if (!(signature instanceof MethodSignature)){
//            throw new IllegalArgumentException("该注解只能用于方法");
//        }
//        msig = (MethodSignature)signature;
//        Object target = point.getTarget();
//        Method method = target.getClass().getMethod(msig.getName(), msig.getParameterTypes());
//        // 获取操作名称
//        CacheEvictEx annotation = method.getAnnotation(CacheEvictEx.class);
//        String pattern = annotation.pattern();
//
//        logger.info("pattern: "+pattern);
//
//        if (StringUtils.isNotBlank(pattern)){
//            Set<String> keys = stringRedisTemplate.keys(pattern);
//            Iterator<String> iterator = keys.iterator();
//            while (iterator.hasNext()){
//                String nextKey = iterator.next();
////                String nextValue = stringRedisTemplate.opsForValue().get(nextKey);
//
//                logger.warn("key: "+nextKey+"; value: ");
//
////                if (null != nextValue){
////                    stringRedisTemplate.delete(nextValue);
////                }
//            }
//        }
//    }
//
//
//}


/**
 *   以上方法，是南浩哥的用法
 */