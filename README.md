**初探nacos 配置中心**

 - 1: 参照 [nacos官网](https://nacos.io/zh-cn/) 下载安装 nacos服务 并启动
 
 - 2: 访问 http://127.0.0.1:8848/nacos 默认需要输入账号与密码（nacos/nacos）软件conf目录中 application.properties 可配置数据是否使用数据库以及取消登录验证等配置
 
 - 3: 管理界面中创建一个命名空间（通常可理解为软件各个环境 开发环境 测试环境 发布环境）这里我创建dev命名空间![](https://shop.io.mi-img.com/app/shop/img?id=shop_81a516129175c96c00210f83a8e8ead4.png)
 
 - 4: 回到配置管理切换到 dev 下创建两个配置
 ![](https://shop.io.mi-img.com/app/shop/img?id=shop_2bdb0dff67d3ced0ffeabd19904b9a41.png)
 
 - 5: 新建一个配置,格式我们选择yaml
 ![新建一个配置](https://shop.io.mi-img.com/app/shop/img?id=shop_de32b248cfaeb01bce88eb3f393abc64.png "新建一个配置")
 
 - 6: 配置好后可看一下详情
 ![服务1配置](https://shop.io.mi-img.com/app/shop/img?id=shop_1b9eb378bf487568a10edfb29e384d46.png "服务1配置")![服务2配置](https://shop.io.mi-img.com/app/shop/img?id=shop_85adfd69a04ae4764de03c273175a7be.png "服务2配置")
####  以上便完成了 nacos 配置中心的基础配置
------------


