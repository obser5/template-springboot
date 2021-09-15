# template-springboot
Springboot模板，记录日常学习到的知识点。

# 如何使用
不涉及业务，收集了常用的接口、工具类等，用作平时参考。

# 目前已整合的类

## 工具类
* ResponseWrapper - 返回值包装类
* SpringContextUtil - Spring容器工具类，可确保获取实例，解决线程注入时NullPointException的问题
* TokenUtil - token工具类，用来生成和解析token

## 切面类
* WebLogAspect - controller层切面类，用来打印请求和响应日志

## 接口
* /upload 单文件上传
