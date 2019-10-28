//package com.gosuncn.springboot.util;
//
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.util.CollectionUtils;
//
//import java.util.concurrent.TimeUnit;
//
///**
// * @ClassName: RedisUtil
// * @Create By: chenxihua
// * @Date: 2019/10/22 10:14
// **/
//public class RedisUtil {
//
//
//    private RedisTemplate<String, Object> redisTemplate;
//
//    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
//        this.redisTemplate = redisTemplate;
//    }
//
//    public boolean expire(String key, long time){
//        try {
//            if (time>0){
//                redisTemplate.expire(key, time, TimeUnit.SECONDS);
//            }
//            return true;
//        }catch (Exception e){
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    public long getExpire(String key){
//        return redisTemplate.getExpire(key, TimeUnit.SECONDS);
//    }
//
//    public boolean hasKey(String key){
//        try {
//            return redisTemplate.hasKey(key);
//        }catch (Exception e){
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    public void  del(String ... key){
//        if (key!=null && key.length>0){
//            if (key.length==1){
//                redisTemplate.delete(key[0]);
//            }else {
//                redisTemplate.delete(CollectionUtils.arrayToList(key));
//            }
//        }
//    }
//
//    public Object get(String key){
//        return key == null ? null:redisTemplate.opsForValue().get(key);
//    }
//
//    public boolean set(String key, Object value) {
//        try {
//            redisTemplate.opsForValue().set(key, value);
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    public boolean set(String key, Object value, long time){
//        try {
//            if (time>0){
//                redisTemplate.opsForValue().set(key, value, time);
//            }else {
//                set(key, value);
//            }
//            return true;
//        }catch (Exception e){
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//
//
//    public long incr(String key, long delta){
//        if (delta<0){
//            throw new RuntimeException("递增因子必须大于0");
//        }
//        return redisTemplate.opsForValue().increment(key, delta);
//    }
//
//    public long decr(String key, long delta){
//        if (delta<0){
//            throw new RuntimeException("递增因子必须小于0");
//        }
//        return redisTemplate.opsForValue().increment(key, -delta);
//    }
//
//
//
//
//
//}
