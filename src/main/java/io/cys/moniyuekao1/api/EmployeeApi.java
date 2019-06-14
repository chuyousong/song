package io.cys.moniyuekao1.api;

import com.github.pagehelper.PageInfo;
import io.cys.moniyuekao1.dto.EmployeeGetDTO;
import io.cys.moniyuekao1.dto.EmployeeListDTO;
import io.cys.moniyuekao1.po.Employee;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface EmployeeApi {

    PageInfo<EmployeeListDTO> getPageAndName(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer areaId,
            @RequestParam(required = false) Integer positionId,
            @RequestParam(required = false,defaultValue = "1") Integer pageNum
    );
    void update(@RequestBody Employee employee);

    Employee bathDelete(@RequestBody List<Integer> employeeIds);

    EmployeeGetDTO getById(@RequestParam Integer employeeId);
}
