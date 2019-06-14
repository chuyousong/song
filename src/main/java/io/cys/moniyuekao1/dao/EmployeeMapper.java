package io.cys.moniyuekao1.dao;

import com.github.pagehelper.Page;
import io.cys.moniyuekao1.dto.EmployeeGetDTO;
import io.cys.moniyuekao1.dto.EmployeeListDTO;
import io.cys.moniyuekao1.po.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapper {
    int deleteByPrimaryKey(Integer employeeId);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(Integer employeeId);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);

    Page<EmployeeListDTO> getSelectEmployeePageAndName(@Param("name") String name, @Param("areaId") Integer areaId, @Param("positionId") Integer positionId);

    Employee getDeleteByEmployeeId(@Param("employeeIds") List<Integer> employeeIds);

    EmployeeGetDTO selectByPrimaryKey2(@Param("employeeId") Integer employeeId);
}