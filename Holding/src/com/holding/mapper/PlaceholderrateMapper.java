package com.holding.mapper;

import com.holding.po.Placeholderrate;
import com.holding.po.PlaceholderrateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface PlaceholderrateMapper {
    long countByExample(PlaceholderrateExample example);

    int deleteByExample(PlaceholderrateExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Placeholderrate record);

    int insertSelective(Placeholderrate record);

    List<Placeholderrate> selectByExample(PlaceholderrateExample example);

    Placeholderrate selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Placeholderrate record, @Param("example") PlaceholderrateExample example);

    int updateByExample(@Param("record") Placeholderrate record, @Param("example") PlaceholderrateExample example);

    int updateByPrimaryKeySelective(Placeholderrate record);

    int updateByPrimaryKey(Placeholderrate record);
    
    
    //根据图书馆ID查询最近一条记录
    @Select("SELECT * from placeholderrate where id = (SELECT max(id) FROM placeholderrate where libraryId=#{libraryId})")
    Placeholderrate getPlaceholderrateByMaxId(Integer libraryId) throws Exception;
}