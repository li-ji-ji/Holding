package com.holding.mapper;

import com.holding.po.Placeholderrate;
import com.holding.po.PlaceholderrateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

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
}