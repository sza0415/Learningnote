package org.sza;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.sza.mapper.AccountMapper;
import org.sza.entity.Account;

import java.io.IOException;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) throws IOException {
//        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
//        DataSource dataSource = ctx.getBean(DataSource.class);
//        System.out.println(dataSource);

        // 1. 创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        // 2. 加载mybatis-config.xml配置文件
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        // 3. 创建SqlSessionFactory对象
        SqlSessionFactory factory = sqlSessionFactoryBuilder.build(inputStream);
        // 4. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        // 5. 获取mapper
        AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);
        //6. 执行方法进行查询
        Account account = mapper.findById(2);
        System.out.println(account);
        //7. 释放资源
        sqlSession.close();
    }
}