### testDemo
一、call_facade_service包（调用第三方服务）：

  1.feign调用
  2.RestTemplate调用
  3.WebClient
  
二、context_hold包(过滤器，后续添加ThreadLocal放入上下文):
  
  1.基于注解实现BasedOnAnnotationFilter
  2.基于java配置实现BasedOnJavaSettingFilter
  
三、excel包:
  
  配合apache poi和简单自定义注解实现简单的excel