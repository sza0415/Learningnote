package com.sza.test;

import com.sza.pojo.Brand;
import com.sza.mapper.BrandMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    @Test
    public void testSelectAll() throws IOException {
        // 1.加载mybatis的核心配置文件，获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);


        // 2.获取sqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3.1 获取BrandMapper接口的代理对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = mapper.selectAll();
        System.out.println(brands);
        // 4.释放资源
        sqlSession.close();
    }

    @Test
    public void testSelectById() throws IOException {
        // 1.加载mybatis的核心配置文件，获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);


        // 2.获取sqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3.1 获取BrandMapper接口的代理对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        int id = 1;
        Brand brand = mapper.selectById(id);
        System.out.println(brand);
        // 4.释放资源
        sqlSession.close();
    }

    @Test
    public void testSelectByCondition() throws IOException {
        int status = 1;
        String companyName = "三只";
        String brandName = "松鼠";

        Brand brand = new Brand();
        brand.setBrandName(brandName);
        brand.setStatus(status);
        brand.setCompanyName(companyName);

//        Map map = new HashMap();
//        map.put("status", status);
//        map.put("companyName", conpanyName);
//        map.put("brandName", brandName);

        // 1.加载mybatis的核心配置文件，获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);


        // 2.获取sqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3.1 获取BrandMapper接口的代理对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
//        List<Brand> brands = mapper.selectByCondition(status, conpanyName, brandName);
        List<Brand> brands = mapper.selectByCondition(brand);
//        List<Brand> brands = mapper.selectByCondition(map);
        System.out.println(brands);
        // 4.释放资源
        sqlSession.close();
    }


    @Test
    public void testSelectByDynamicCondition() throws IOException {
        int status = 1;
        String companyName = "三只";
        String brandName = "松鼠";


        Brand brand = new Brand();
//        brand.setStatus(status);
//        brand.setCompanyName(companyName);
//        brand.setBrandName(brandName);

        // 1.加载mybatis的核心配置文件，获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);


        // 2.获取sqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3.1 获取BrandMapper接口的代理对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        List<Brand> brands = mapper.selectByDynamicCondition(brand);
        System.out.println(brands);
        // 4.释放资源
        sqlSession.close();
    }

    @Test
    public void testSelectByConditionSingle() throws IOException {
        int status = 1;
        String companyName = "三只";
        String brandName = "松鼠";


        Brand brand = new Brand();
//        brand.setStatus(status);
        brand.setCompanyName(companyName);
//        brand.setBrandName(brandName);

        // 1.加载mybatis的核心配置文件，获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);


        // 2.获取sqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3.1 获取BrandMapper接口的代理对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        List<Brand> brands = mapper.selectByConditionSingle(brand);
        System.out.println(brands);
        // 4.释放资源
        sqlSession.close();
    }

    @Test
    public void testAddBrand() throws IOException {
        int status = 1;
        String companyName = "szzzaaaaaaa";
        String brandName = "ssssszzzzzaaaa";
        String description = "无";
        int order = 1;




        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setDescription(description);
        brand.setOrdered(order);
        // 1.加载mybatis的核心配置文件，获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);


        // 2.获取sqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        // 3.1 获取BrandMapper接口的代理对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        mapper.addBrand(brand);
        // 提交事务
        sqlSession.commit();
        System.out.println(brand.getId()); // null
        // 4.释放资源
        sqlSession.close();
    }
}
