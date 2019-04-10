package com.holding.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.holding.po.Admin;
import com.holding.po.AdminExample;

public interface AdminMapper {
    long countByExample(AdminExample example);

    int deleteByExample(AdminExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Admin record);

    int insertSelective(Admin record);

    List<Admin> selectByExample(AdminExample example);

    Admin selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Admin record, @Param("example") AdminExample example);

    int updateByExample(@Param("record") Admin record, @Param("example") AdminExample example);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);
    
    //根据管理员名称查询管理员数据
    @Select("select * from admin where adminname=#{adminname}")
    Admin getAdminByName(String adminname) throws Exception;
    
    //根据管理员名称删除管理员
    @Delete("delete from admin where adminname=#{adminname}")
    int deleteAdminByName(String adminname) throws Exception;
    
    
    
    
}