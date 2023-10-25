package example;



import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.mapper.EmployeeMapper;
import org.example.pojo.Employee;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class test {

    /**
     * mybatis提供的api进行方法的调用
     *    jdbcTemplate   new  JdbcTemplate -> 使用
     */
    @Test
    public void test_01() throws IOException {

        //1.读取外部配置文件（mybatis-config.xml）
        InputStream ips = Resources.getResourceAsStream("mybatis-config.xml");

        //2.创建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(ips);

        //3.根据sqlSessionFactory创建sqlSession (每次业务创建一个，用完就释放)
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //4.获取接口的代理对象 （代理技术） 调用代理对象的方法，就会查找mapper接口的方法
        //jdk动态代理技术生成的mapper代理对象
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        // 内部拼接接口的全限定符号.方法名  去查找sql语句标签
        //1.拼接 类的全限定符.方法名  整合参数  -》 ibatis对应的方法传入参数
        // mybatis底层依然调用ibatis只不过有固定的模式！
        Employee employee = mapper.queryById(1);
        System.out.println("employee = " + employee);

        //5.提交事务（非DQL）和释放资源
        sqlSession.commit();
        sqlSession.close();

    }


    /**
     * 使用ibatis方式进行数据库调用
     * @throws IOException
     */

}
