package com.sza.mapper;

import com.sza.pojo.Brand;

import java.util.List;

public interface BrandMapper {
    List<Brand> selectAll();

    Brand selectById(int id);

//    @Param("xxx") 是为了匹配 sql语句中#{xxx}的占位符
//    List<Brand> selectByCondition(@Param("status")int status,@Param("companyName")String companyName,@Param("brandName")String brandName);

//  如果参数都属于同一个对象，那么其实可以封装成一个对象作为参数  那么sql语句中 #{xxx} 就会去找该对象中的属性
    List<Brand> selectByCondition(Brand brand);

//  当然也可以传入键值对 sql语句中的#{xxx}就会找map中对应的key
//    List<Brand> selectByCondition(Map map);

    List<Brand> selectByDynamicCondition(Brand brand);

    List<Brand> selectByConditionSingle(Brand brand);

    void addBrand(Brand brand);

}
