package com.itheima.mapper;

import com.itheima.pojo.Brand;
import com.itheima.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @author 陈启佳
 * @version 1.0
 */
public interface BrandMapper {

    List<Brand> selectAll();

    Brand selectById(int id);

    List<Brand> selectByCondi(@Param("status") int status, @Param("brandName") String brandName, @Param("companyName") String companyName);

    List<Brand> selectByCondiBrand(Brand brand);

    List<Brand> selectByCondiMap(Map map);

    List<Brand> selectBySingleCondi(Brand brand);

    //增加一条数据
    void add(Brand brand);

    //修改一条数据
    void update(Brand brand);

    //动态修改一条数据
    void update1(Brand brand);

    //删除一条数据
    void deleteById(int id);

    //批量删除
    void deleteByIds(@Param("ids") int[] ids);
}

/**
 * 使用注解开发，比配置文件开发更方便
 *
 * @Select("select * from tb_user where id = #{id}")
 * public User selectByIdUser(int id);
 *
 *
 *package org.mybatis.example;
 * public interface BlogMapper {
 *   @Select("SELECT * FROM blog WHERE id = #{id}")
 *   Blog selectBlog(int id);
 * }
 *
 *
 * @Select @Insert @Update @Delete
 *
 * 主键完成简单功能，配置完成复杂功能
 * 使用注解来映射简单语句会使代码显得更加简洁，但对于稍微复杂一点的语句，Java 注解不仅力不从心，还会让你本就复杂的 SQL 语句更加混乱不堪。 因此，如果你需要做一些很复杂的操作，最好用 XML 来映射语句。
 */
