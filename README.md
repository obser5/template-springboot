# template-springboot
Springboot模板，记录日常学习到的知识点。

# 如何使用
不涉及业务，收集了常用的接口、工具类等，用作平时参考。

# 目前已整合的类

## aop
* WebLogAspect - controller层切面类，用来打印请求和响应日志

## enums
* BusinessExceptionEnum - 业务异常枚举类
* ResponseEnum - response枚举类
* ServerException - 服务异常枚举类

## exception
* BusinessException - 业务异常类
* GlobalExceptionHandler - controller层异常处理器，可捕获controller层抛出的运行时和非运行异常，也可在controller层自行try catch处理
* ServerException - 服务异常类

## thrift
* ClientDemo - Thrift客户端Demo
* ServerDemo - Thrift服务端demo
* ThriftService - 由.thrift和.exe生成的.java代码，实现其中的接口即可
* ThriftServiceImpl - ThriftService实现类

## util
* ResponseWrapper - 返回值包装类
* SpringContextUtil - Spring容器工具类，可确保获取实例，解决线程注入时NullPointException的问题
* TokenUtil - token工具类，用来生成和解析token


