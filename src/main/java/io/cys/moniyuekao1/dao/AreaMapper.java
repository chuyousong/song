package io.cys.moniyuekao1.dao;

import io.cys.moniyuekao1.dto.AreaNode;
import io.cys.moniyuekao1.po.Area;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AreaMapper {
    int deleteByPrimaryKey(Integer areaId);

    int insert(Area record);

    int insertSelective(Area record);

    Area selectByPrimaryKey(Integer areaId);

    int updateByPrimaryKeySelective(Area record);

    int updateByPrimaryKey(Area record);

    List<AreaNode> getSelectArea(@Param("areaId") Integer areaId);

    Area getSelectParent(@Param("parentId") Integer parentId);
}