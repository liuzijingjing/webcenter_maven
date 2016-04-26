# webcenter_maven
@author 张凌思

* 有以下功能模块
* common              公共层(工具类，抽象类等)
* persistence         数据层(链接数据库，数据访问层DAO)
* persistence-api     数据访问接口层(链接数据库，数据访问层DAO)
* service             对外提供服务实现层(封装好的服务,实际处理异常)
* service-api         对外提供服务接口层(服务接口及服务实体对象)
* manager             数据访问层与接口层的衔接(主要处理DO和DTO转换和抛出异常)
* webcenter           web层负责页面跳转json数据解析等


* 启动顺序 persistence  -->  manager  -->  service  -->  webcenter
* 异常处理在service层 主要关注业务流程，包括业务验证，通用业务封装，业务异常的处理，错误信息的输出等。
* 事物处理在manager层 主要是验证实体，以及DTO与DO实体间转换，数据库事物操作调用，批量操作，向service层抛出异常
* 数据库持久化persistence层 主要配置数据库相关配置，DO的映射实体表，redis缓存的处理等，向manager层抛出异常
* 内部使用dubbo服务模块间调用
* 采用spring-boot微服务框架-零配置