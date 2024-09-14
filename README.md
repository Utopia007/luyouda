# luyouda
> 作者：鹿又笑

## 项目介绍
深入业务场景的企业级实战项目，基于 UmiJS + React + Spring Boot + Redis + Caffine + ChatGLM AI + RxJava + SSE 的 AI 答题应用平台。
用户可以基于 AI 快速制作并发布多种答题应用，支持检索和分享应用、在线答题并基于评分算法或 AI 得到回答总结；管理员可以审核应用、集中管理整站内容，并进行统计分析。

## 项目三大阶段

1. 第一阶段，开发**答题应用平台,**用户可以通过上传题目和自定义评分规则，创建答题应用，供其他用户检索和使用。该阶段涉及Vue + Spring Boot 前后端全栈项目从 0 到 1 的开发。


2. 第二阶段，让 AI 为平台赋能，开发 AI 智能答题应用平台。用户只需设定主题，就能通过 AI 快速生成题目、让 AI 分析用户答案，极大降低创建答题应用的成本、提高回答多样性。


3. 第三阶段，通过多种企业开发技术手段进行 项目优化。包括 RxJava + SSE 优化 AI 生成体验、通过缓存和分库分表优化性能、通过幂等设计和线程池隔离提高系统安全性、通过统计分析和应用分享功能来将应用 “产品化” 等等。

## 设计架构
### 核心业务流程图
![image](https://github.com/user-attachments/assets/6be9165c-1ec9-4e1d-b1bd-cfbb058392c3)

### 架构设计图
![image](https://github.com/user-attachments/assets/0bff1328-af35-48ce-a528-ad998de1d9bf)


## 技术选型

### 后端

- Java Spring Boot 开发框架（万用后端模板）
- 存储层：MySQL 数据库 + Redis 缓存 + 腾讯云 COS 对象存储
- MyBatis-Plus 及 MyBatis X 自动生成
- Redisson 分布式锁
- Caffeine 本地缓存
- ⭐️ 基于 ChatGLM 大模型的通用 AI 能力
- ⭐️ RxJava 响应式框架 + 线程池隔离实战
- ⭐️ SSE 服务端推送
- ⭐️ Shardingsphere 分库分表
- ⭐️ 幂等设计 + 分布式 ID 雪花算法
- ⭐️ 多种设计模式
- ⭐️ 多角度项目优化：性能、稳定性、成本优化、产品优化等

### 前端

- React 
- UmiJS 框架
- Axios 请求库
- Arco Design 组件库
- 前端工程化：ESLint + Prettier + TypeScript
- 富文本编辑器
- QRCode.js 二维码生成
- ⭐️ OpenAPI 前端代码生成



