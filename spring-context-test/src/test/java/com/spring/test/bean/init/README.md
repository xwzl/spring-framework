Spring 定制化接口之一


初始化 bean 之后执行

执行顺序：

- aware 接口：invokeAwareMethods
- post 接口： applyBeanPostProcessorsBeforeInitialization
- init 接口： invokeInitMethods
- post 接口： applyBeanPostProcessorsAfterInitialization
