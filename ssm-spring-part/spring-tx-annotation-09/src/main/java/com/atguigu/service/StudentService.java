package com.atguigu.service;

import com.atguigu.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

@Service
@Transactional  // 类中所有方法都加入事务
public class StudentService {
    @Autowired
    private StudentDao studentDao;
    /*
    * 配置事务：Config类中加入具体事务TransactionManager实现 和 @EnableTransactionManagement开启事务注解支持
    * 添加事务：@Transactional
    *    位置：方法/类上
    *    方法：当前方法有事务
    *    类上：类下所有方法都有事务
     * 1.只读模式：只读模式可以提升查询事务的效率！ 推荐事务中只有查询代码，使用只读模式！
     *   默认： boolean readOnly() default false;
     *   解释： 查询不需要事务操作，但readonly基本仅能在查询中用？为啥会存在
     *         一般情况下，查询方法也会放入事务(统一管理)，同时通过类添加注解添加事务(非只读)！类下的所有方法都有事务！
     *         查询方法可以通过再次添加注解，设置为只读模式，提高效率!
     *
     * 2.超时时间
     *   默认： 永远不超时  -1
     *   设置 timeout = 时间 秒数  超过时间，就会回滚事务和释放异常！ TransactionTimedOutException
     *   如果类上设置事务属性(如超时时间)，方法也设置了事务注解！ 方法会不会生效？？
     *   答案是不会生效： 方法上的注解覆盖了类上的注解！
     *
     * 3.指定异常回滚和指定异常不回滚：
     *   默认情况下，指定发生运行时异常事务才会回滚！
     *   我们可以指定Exception异常来控制所有异常都回滚！
     *   rollbackFor = Exception.class
     *   noRollbackFor = 回滚异常范围内，控制某个异常不回滚！
     *
     * 4.隔离级别设置
     *   推荐设置第二个隔离级别！
     *   isolation = Isolation.READ_COMMITTED
     * 5.事务传播行为：父方法调用子方法时如何传播给子方法，只能在子方法中设置isolation = Isolation.?
     *   REQUIRED 默认值 |如果父方法有事务，就加入（子方法抛异常则父方法也回滚，因在同一个事务中），如果没有就新建自己独立！
     *   REQUIRES_NEW   |不管父方法是否有事务，我都新建事务，都是独立的！
     *   注意：在同一个类中@Transactional的方法调用，事务传播行为不会生效。因为Spring使用代理模式实现了事务机制，在同一个类中的方法调用并不经过代理，而是通过对象的方法调用，因此@Transactional注解的设置不会被代理捕获，也就不会产生任何事务传播行为的效果。
    * */

    @Transactional(readOnly = false, timeout = 10, rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED)
    public void changeInfo() throws FileNotFoundException {
        studentDao.updateAgeById(88,1);
        new FileInputStream("xxxx");
        System.out.println("-----------");
        studentDao.updateNameById("test1",1);
    }

    @Transactional(readOnly = true)
    public void query(){
        // ...
    }

    @Transactional(propagation = Propagation.REQUIRED)  // 默认值
    public void changeAge(){
        studentDao.updateAgeById(998,1);
    }
    @Transactional(propagation = Propagation.REQUIRED)
    public void changeName(){
        studentDao.updateNameById("ergouzi",1);
    }
}
