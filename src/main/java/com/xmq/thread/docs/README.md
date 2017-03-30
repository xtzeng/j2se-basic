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
       
* [sleep / join / yield 方法]
* [1.sleep方法：可以调用Thread的静态方法：public static void sleep(long millis)throws InterruptedException
			     使得当前线程休眠（暂停执行mills毫秒） ]
			  由于是静态方法，sleep可以由类名直接调用：Thread.sleep(...)
* [2.join方法：合并某个线程]
* [3.yield方法：让出CPU,给其他线程执行的机会]

线程的优先级别：
Java提供一个线程调度器来监控程序中启动后进入就绪状态的所有线程。
线程调度器按照线程的优先级觉得应调度哪个线程来执行。
线程的优先级用数字来表示，范围从1到10，一个线程的缺省优先级是5.
   Thread.MIN_PRIORITY = 1
   Thread.MAX_PRIORITY = 10
   Thread.NORM_PRIORITY = 5
使用下面的方法获得或设置线程对象的优先级
   int getPrioriry();
   void setPriority(int newPriority)

1.1 Java中的线程可以分为守护线程（Daemon Thread）和用户线程(User Thread).
	用户线程会阻止JVM的正常停止（即通过System.exit调用停止JVM，而非强行停止JVM(如在linux系统下使用kill命令停止java进程)）
	即JVM正常停止前应用程序中的所有用户线程必须先停止完毕；否则JVM无法停止。

	而守护线程则不会影响JVM的正常停止，即应用程序中有守护线程在运行也不会影响JVM的正常停止。
	因此，守护线程通常用于执行一些重要性不是很高的任务，例如用于监视其他线程的运行情况。

1.2 线程的创建与运行：
	创建一个Thread实例与创建其他类的实例有所不同的是，JVM会为一个Thread实例分配两个调用栈（Call Stack）所需的内存空间。
	这两个调用栈一个用于跟踪Java代码间的调用关系，另一个用于跟踪Java代码对本地代码（即Native代码，通常是C代码）的调用关系。

1.3 线程的状态与上下文切换
	Java线程的状态可以通过调用相应的Thread实例的getState方法获取。该方法的返回值类型Thread.State是一个枚举类型。
	Thread.State所定义的线程状态包括以下几种：
	·NEW:一个刚创建而未启动的线程处于该状态。由于一个线程实例只能够被启动一次，因此一个线程只可能有一次处于该状态。
	·RUNNABLE:该状态可以看成是一个复合的状态。它包括两个子状态：READY和RUNNING。前者表示处于该状态的线程可以被JVM的
	             线程调度器（Scheduler）进行调度而使之处于RUUNING状态。后者表示处于该状态的线程正在运行，即相应线程对象的run
	             方法中的代码所对应的指令正在由CPU执行.当Thread实例的yield方法被调用时或者由于线程调度器的原因，相应线程的状态
	             会由RUNNING转换为READY.
	·BLOCKED:一个线程发起一个阻塞式I/O(Blocking I/O)操作（如文件读写和阻塞式Socket读写）后，或者试图去获得一个由其他
	             线程持有的锁时，相应的线程会处于该状态。处于该状态的线程并不会占用CPU资源。当相应的I/O操作完成后，或者相应的锁被
	             其他线程释放后，该线程的状态又可以转换为RUNNABLE.
	·WAITING: 一个线程执行了某些方法调用之后就会处于这种无限等待其他线程执行特定操作的状态。这些方法包括：Object.wait()、
		 Thread.join()和LockSupport.park().能够使相应线程从WAITING转换到RUNNABLE的相应方法包括：
		 Object.notify()、Object.notifyAll()和LockSupport.unpart(thread).
	·TIMED_WAITING:该状态和WAITING类似，差别在于处于该状态的线程并非无限等待其他线程执行特定操作，而是处于带有时间限制
		  的等待状态。当其他线程没有在指定时间内执行该线程所期望的特定操作时，该线程的状态自动转换为RUNNABLE.
	·TERMINATED:已经执行结束的线程处于该状态。由于一个线程实例只能够被启动一次，因此一个线程也只可能有一次处于该状态。
	     Thread实例的run方法正常返回或者由于抛出异常而提前终止都会导致相应线程处于该状态.
	     
	summary： 一个线程在其整个生命周期中，只可能一次处于NEW状态和TERMINATED状态。而一个线程从RUNNABLE状态转换为BLOCKED、
	WAITING和TIMED_WAITING这几个状态中的任何一个状态都意味着上下文切换（Context Switch）的产生。
	多线程环境中，当一个线程的状态由RUNNABLE转换为非RUNNABLE(BLOCKED、WAITING或者TIMED_WAITING)时，相应线程的上下文
	（即所谓的Context，包括CPU的寄存器和程序计数器在某一时间点的内容等）需要被保存，以便相应线程稍后再次进入RUNNABLE状态
	时能够在之前的执行进度的基础上继续前进。而一个线程的状态由非RUNNABLE状态进入RUNNABLE状态时可能涉及恢复之前保存的线程
	上下文信息并在此基础上前进。这个对线程的上下文信息进行保存和恢复的过程就被称为上下文切换。
	
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

