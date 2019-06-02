
- 后端： SpringBoot2.x + SSM
- 前端： Vue.JS2.x + ElementUI
测试环境

IDEA + SpringBoot-2.1.3

##### 各层命名规约
1. Service/Dao层的方法规范：
    - 获取单对象的方法用get做前缀
    - 多个对象的方法用list做前缀
    - 获取拥挤值的方法用count
    - 插入：save、insert
    - 删除：remove/delete
    - 修改：update
2.领域模型（domain）命名规范
    - 数据对象： xxxDO，xxx为数据表名
    - 数据传输对象：xxxDTO，xxx为业务领域相关的名称
    - 展示对象：xxxVo，xxx为网页名
    - POJO是DO/DTO/BO/VO的统称，禁止命名成xxxPOJO
3.常量的复用层次有5层：跨应用共享常量、应用内共享变量、子工程内、包内、类内
    - 跨应用共享常量：放在二方库中，是client.jar中的constant目录下
    - 应用内共享常量：放在一方库中，是modules中的constant目录下
    - 子工程内部共享常量：是在当前子工程的constant目录下
    - 包内共享常量：当前包下中的constant目录下
    - 类内共享常量：在类内部private static final目录下
    
##### 代码格式
- if/for/while/switch/do等与括号之间必须加空格
- 注释风格：//与内容之间有一个括号
- 多个参数逗号沟边必须加空格
- IDE的ntext file encoding设置为UTF-8；IDE换行符使用Unix格式
- 所有相同类型的包装类对象之间指的比较，全部使用equals方法比较
例如：Integer在-128至127之外的数据会堆上产生，无法复用。

##### 关于基础数据类型与包装数据类型
- 所有POJO类属性必须使用包装数据类型
- RPC方法的返回值和参数必须使用包装数据类型
- 局部变量使用基本数据类型
- 序列化类新增属性时，不要修改serialVersionUID字段，避免反序列化失败；
- 构造方法禁止加入业务逻辑，如果有初始化漏记放在init方法
- POJO类必须写toString方法
- 使用索引访问String的split方法得到数组，需要做最后一个分隔符后有没有内容的检查，否则抛出IndexOutOfBoundsException
- 类内方法定义顺序依次：共有方法或保护方法>私有方法>getter/setter方法

final声明类、成员变量、方法等表示 不可修改、继承、重写、重新被赋值

clone默认为浅拷贝

##### 集合处理
- 只要重写equal就必须重写hashcode，Set存储的是不可重复对象，Map的key为自定义对象，一定要重写这两个方法
- 集合站数组用toArray(T[] array)；使用工具类Arrays.asList将数组转换成集合