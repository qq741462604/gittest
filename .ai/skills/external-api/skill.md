# 外调接口开发


关键词:

外调接口
第三方接口
HTTP调用
开放接口


规则:

1. 必须创建Client层

2. 必须创建Request DTO

3. 必须创建Response DTO

4. Controller禁止直接调用外部接口

5. 增加异常处理


代码结构:

controller

service

client

dto