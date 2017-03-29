# 快捷目录

> #### ▌ Thread基础
* [线程是什么]
* [线程是一个程序里面不同的执行路径 。]
* [线程的基本概念：线程是一个程序内部的顺序控制流]
* [线程和进程的区别]
* [1.线程可以看成是轻量级的进程，同一类线程共享代码和数据空间，每个线程有独立的运行栈和程序计数器（PC）,线程切换的开销小]
* [2.每个进程都有独立的代码空间及数据空间（进程上下文），进程间的切换会有较大的开销]
* [3.多进程：在操作系统中能同时运行多个任务（程序）]
* [4.多线程：在同一应用程序中有多个顺序流同时执行]

* [Java的线程是通过java.lang.Thread类来实现的]
* [JVM启动时会有一个由主方法（public static void main(){}）所定义的线程]
* [可以通过创建Thread的实例来创建新的线程]
* [每个线程都是通过某个特定Thread对象所对应的方法run（）来完成其操作的，方法run()称为线程体]
* [通过调用Thread类的start()方法来启动一个线程]
> #### ▌ 相关资料


> #### ▌ 开发文档
* [线程的创建和启动]
可以有两种方式创建新的线程：
第一种：
    1.定义线程类实现Runnable接口
    2.Thread myThread = new Thread(target)//target为Runnable接口类型。
    3.Runnable中只有一个方法：
      public void run();用以定义线程运行体
    4.使用Runnable接口可以为多个线程提供共享的数据
    5.在实现Runnable接口的类的run方法定义中可以使用Thread的静态方法：
      public static Thread currentThread（）获取当前线程的引用
第二种：
    1.可以定义一个Thread的子类并重写其run方法如：
      class MyThread extends Thread{
          public void run(){...}
      }
    2.然后生成该类的对象：
       MyThread myThread = new MyThread(..)

> #### ▌ 资源下载

> #### ▌ 学习交流


# 一、简介









# 三、设计目标
让开发者专注于应用逻辑的开发，底层<code>复杂的即时通讯算法交由SDK开发人员</code>，从而<code>解偶即时通讯应用开发的复杂性</code>。

# 四、框架组成
<b>整套MobileIMSDK框架由以下4部分组成：</b>



# 五、技术特征



  
:point_right: 您可能需要：[查看更多关于MobileIMSDK的疑问及解答](http://www.52im.net/thread-60-1-1.html)。

# 六、性能测试
压力测试表明，MobileIMSDK用于推送场景时，理论单机负载可接近千万级。用于聊天应用时，单机负载也可达数十万。

> 当然，每款应用都有各自的特点和差异，请视具体场景具体评估之，测试数据仅供参考。


# 七、演示程序


# 八、应用案例
#### ① 基于MobileIMSDK的产品级聊天APP：

#### ② MobileIMSDK在高网络延迟下的案例：


# 九、资源下载


# 十、典型应用场景
### :triangular_flag_on_post: 场景1：聊天APP

### :triangular_flag_on_post: 场景2：消息推送


### :triangular_flag_on_post: 场景3：企业OA


### :triangular_flag_on_post: 场景4：企业OA的增强型
。

# 十一、开发指南


# 十二、授权方式


# 十三、联系方式

# 十四、关注作者


# 附录1：Demo截图

