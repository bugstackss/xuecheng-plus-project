##  项目介绍 

学成在线项目借鉴了MOOC（大型开放式网络课程，即MOOC（massive open online
courses））的设计思想，是一个提供IT职业课程在线学习的平台，它为即将和已经加入IT领域的技术人才提供在线学习服务，用户通过在线学习、在线练习、在线考试等学习内容，最终掌握所学的IT技能，并能在工作中熟练应用。

在线教育的模式出现多种多样，包括：B2C、C2C、B2B2C等业务模式。**学成在线采用B2B2C业务模式**，即向企业或个人在线教育平台提供教学服务，老师和学生通过平台完成整个教学和学习的过程，市场上类似的平台有：网易云课堂、腾讯课堂等，学成在线的特点是IT职业课程在线教学。

##  功能模块与演示

本项目包括门户、个人学习中心、教学机构管理平台、运营平台、社交系统、系统管理6个模块

![image](http://mxchen-figure-bed.oss-cn-hangzhou.aliyuncs.com/img/2023/02/14/20230214205834.png)

本项目主要包括三类用户角色：学生、教学机构的老师、平台运营人员。

本项目主要包括三类用户角色：学生、教学机构的老师、平台运营人员。

主要讲解下边的业务流程：

1、教学机构的老师登录教学管理平台，编辑课程信息，发布自己的课程。

2、平台运营人员登录运营平台审核课程、视频等信息，审核通过后课程方可发布。

课程编辑与发布流程如下

![image](http://mxchen-figure-bed.oss-cn-hangzhou.aliyuncs.com/img/2023/02/14/20230214210007.png)

3、课程发布后学生登录平台进行选课、在线学习。

免费课程可直接学习，收费课程需要下单购买。

学生选课流程如下：

![image](http://mxchen-figure-bed.oss-cn-hangzhou.aliyuncs.com/img/2023/02/14/20230214210031.png)

## 项目技术架构

 学成在线项目采用当前流行的前后端分离架构开发，由以下流程来构成：用户层、CDN内容分发和加速、负载均衡、UI层、微服务层、数据层。

> 项目技术架构图

![image](http://mxchen-figure-bed.oss-cn-hangzhou.aliyuncs.com/img/2023/02/14/20230214210146.png)

> 技术架构列表

| **序号** | **名称** | **功能描述**                                                 |
| -------- | -------- | ------------------------------------------------------------ |
| 1        | 用户层   | 用户层描述了本系统所支持的用户类型包括：pc用户、app用户、h5用户。pc用户通过浏览器访问系统、app用户通过android、ios手机访问系统，H5用户通过h5页面访问系统。 |
| 2        | CDN      | CDN全称Content Delivery Network，即内容分发网络，本系统所有静态资源全部通过CDN加速来提高访问速度。系统静态资源包括：html页面、js文件、css文件、image图片、pdf和ppt及doc教学文档、video视频等。 |
| 3        | 负载均衡 | 系统的CDN层、UI层、服务层及数据层均设置了负载均衡服务，上图仅在UI层前边标注了负载均衡。 每一层的负载均衡会根据系统的需求来确定负载均衡器的类型，系统支持4层负载均衡+7层负载均衡结合的方式，4层负载均衡是指在网络传输层进行流程转发，根据IP和端口进行转发，7层负载均衡完成HTTP协议负载均衡及反向代理的功能，根据url进行请求转发。 |
| 4        | UI层     | UI层描述了系统向pc用户、app用户、h5用户提供的产品界面。根据系统功能模块特点确定了UI层包括如下产品界面类型： 1）面向pc用户的门户系统、学习中心系统、教学管理系统、系统管理中心。 2）面向h5用户的门户系统、学习中心系统。 3）面向app用户的门户系统、学习中心系统。 |
| 5        | 微服务层 | 微服务层将系统服务分类三类：业务服务、基础服务、第三方代理服务。 **业务服务**：主要为学成在线核心业务提供服务，并与数据层进行交互获得数据。 **基础服务**：主要管理学成在线系统运行所需的配置、日志、任务调度、短信等系统级别的服务。 **第三方代理服务**：系统接入第三方服务完成业务的对接，例如认证、支付、视频点播/直播、用户认证和授权。 |
| 6        | 数据层   | 数据层描述了系统的数据存储的内容类型，**关系性数据库：**持久化的业务数据使用MySQL。 **消息队列**：存储系统服务间通信的消息，本身提供消息存取服务，与微服务层的系统服务连接。 **索引库：**存储课程信息的索引信息，本身提供索引维护及搜索的服务，与微服务层的系统服务连接。 **缓存：**作为系统的缓存服务，作为微服务的缓存数据便于查询。 **文件存储：**提供系统静态资源文件的分布式存储服务，文件存储服务器作为CDN服务器的数据来源，CDN上的静态资源将最终在文件存储服务器上保存多份。 |

> 流程说明

1. 用户可以通过pc、手机等客户端访问系统进行在线学习。
2. 系统应用CDN技术，对一些图片、CSS、视频等资源从CDN调度访问。
3. 所有的请求全部经过负载均衡器。
4. 对于PC、H5等客户端请求，首先请求UI层，渲染用户界面。
5. 客户端UI请求服务层获取进行具体的业务操作。
6. 服务层将数据持久化到数据库。

## 项目技术栈

 学成在线按照技术分层的基础上，需要对主要层次使用具体的技术作说明。下面是学成在线技术栈结构图。

> 技术栈（技术结构图）

[![image](http://mxchen-figure-bed.oss-cn-hangzhou.aliyuncs.com/img/2023/02/14/20230214210116.png)](https://user-images.githubusercontent.com/82166879/216629422-f06514f0-8660-495e-bcd6-5998cfe4cf4f.png)



## 提交规范

```
【新增】    内容
【修复】    内容
【生成】    逆向工程生成代码
【文档】    文档变更
【格式】    代码格式(不影响代码运行的变动)
【重构】    既不是增加新功能,也不是修复bug
【优化】    性能优化
【测试】    测试内容
【工具】    依赖包的变动
【合并】    时间:yyyy-MM-dd HH:mm
【初始】    初始化环境，代码分层架构
【完善】    功能未完成的基础上
【配置】    脚本,配置文件相关

示例：
如添加登录功能
【新增】: 登录功能
添加了hutool
【工具】: 添加了hutool工具包,5.8.5版本
```