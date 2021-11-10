# blog
技术选型： springboot + vue
参照码神之路写的博客系统后端，后续会不断更新和完善

bug点
1. 发布文章之后，首页没有显示刚发布的文章
2. 写文章时，图片无法显示

待优化：
1. 文章可以放入es当中，便于后续中文分词搜索
2. 评论数据，可以考虑放入mongodb当中（可以增加图片评论）
3. 阅读数和评论数， 考虑把阅读数和评论数 增加的时候放入redis incr 自增， 使用定时任务 定时把数据固话到数据库当中
4. 为了加快访问速度，部署的时候，可以把图片，js，css等放入七牛云存储中，加快网站访问速度

管理平台待优化点：
添加角色，用户拥有多个角色，一个角色拥有多个权限

总结：
1. jwt + redis
    token令牌的登录方式，访问认证速度快，session共享，安全性
    redis做了令牌和用户信息的对应管理， 1. 进一步增加了安全性 2， 登录用户做了缓存 3. 灵活控制用户的过期（续期，提掉线等）
2. threadLocal 使用了保存用户信息， 请求的线程之内， 可以随时获取登录的用户，做了线程隔离
3. 在使用完ThreadLocal之后，做了value的删除，防止了内存泄漏
4. 线程安全-update table set value = newValue where id=1 and value = oldValue
5. 线程池，应用非常广，面试7个核心参数（对当前的主业务流程无影响的操作，放入线程池执行）
    1.登录，记录日志
6. 权限系统 重点内容
7. 统一日志记录，统一缓存处理
