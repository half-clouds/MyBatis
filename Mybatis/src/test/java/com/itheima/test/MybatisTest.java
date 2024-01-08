package com.itheima.test;

import com.itheima.mapper.BrandMapper;
import com.itheima.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

/**
 * @author 陈启佳
 * @version 1.0
 */
public class MybatisTest {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //获取Mapper对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        List<Brand> brands = mapper.selectAll();
        System.out.println(brands);

        sqlSession.close();
    }

    @Test
    public void testSelectAll() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //获取Mapper对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        List<Brand> brands = mapper.selectAll();
        System.out.println(brands);

        sqlSession.close();
    }

    @Test
    public void testSelectById() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //获取Mapper对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        Brand brand = mapper.selectById(1);

        System.out.println(brand);

        sqlSession.close();
    }

    @Test
    public void testselectByCondi() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //获取Mapper对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //接收参数
        int status = 1;
        String companyName = "华为";
        String brandName = "华为";

        // 处理参数
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

        Brand brand = new Brand();
//        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);
//        brand.setStatus(status);


        HashMap<Object, Object> map = new HashMap<>();
        map.put("status", status);
        map.put("companyName", companyName);
        map.put("brandName", brandName);
//        List<Brand> brands = mapper.selectByCondi(status, brandName, companyName);
        List<Brand> brands = mapper.selectByCondiBrand(brand);
//        List<Brand> brands = mapper.selectByCondiMap(map);


        System.out.println(brands);

        sqlSession.close();
    }

    /**
     * 单条件查询，多个条件只有一个条件生效
     *
     * @throws IOException
     */
    @Test
    public void testselectBySingleCondi() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //获取Mapper对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //接收参数
        int status = 1;
        String companyName = "华为";
        String brandName = "华为";

        // 处理参数
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

        Brand brand = new Brand();
//        brand.setBrandName(brandName);
//        brand.setCompanyName(companyName);
        brand.setStatus(status);


//        HashMap<Object, Object> map = new HashMap<>();
//        map.put("status", status);
//        map.put("companyName", companyName);
//        map.put("brandName", brandName);
//        List<Brand> brands = mapper.selectByCondi(status, brandName, companyName);
//        List<Brand> brands = mapper.selectByCondiBrand(brand);
//        List<Brand> brands = mapper.selectByCondiMap(map);
        List<Brand> brands = mapper.selectBySingleCondi(brand);


        System.out.println(brands);

        sqlSession.close();
    }

    //    添加数据
    @Test
    public void testAdd() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //获取Mapper对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //接收参数
        int status = 1;
        String companyName = "原神";
        String brandName = "原神公司";


        Brand brand = new Brand();
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);
        brand.setOrdered(2000);
        brand.setStatus(status);


//        HashMap<Object, Object> map = new HashMap<>();
//        map.put("status", status);
//        map.put("companyName", companyName);
//        map.put("brandName", brandName);
//        List<Brand> brands = mapper.selectByCondi(status, brandName, companyName);
//        List<Brand> brands = mapper.selectByCondiBrand(brand);
//        List<Brand> brands = mapper.selectByCondiMap(map);

        mapper.add(brand);

        Integer id = brand.getId();
        System.out.println(id);

        sqlSession.commit();
        sqlSession.close();
    }

    //    添加数据
    @Test
    public void testUpdate() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //获取Mapper对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);


        Brand brand = new Brand();
//        brand.setBrandName("Vivo");
//        brand.setCompanyName("Vivo公司NO.1");
//        brand.setOrdered(2001);
//        brand.setStatus(1);
        brand.setDescription("垃圾vivo手机");
        brand.setId(5);

        mapper.update1(brand);

        sqlSession.commit();
        sqlSession.close();
    }

    //删除一条数据
    @Test
    public void testdeleteById() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //获取Mapper对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        mapper.deleteById(5);

        sqlSession.commit();
        sqlSession.close();
    }

    //批量删除数据
    @Test
    public void testdeleteByIds() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //获取Mapper对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        int[] ids = {4,7,6,8};
        mapper.deleteByIds(ids);

        sqlSession.commit();
        sqlSession.close();
    }
}
