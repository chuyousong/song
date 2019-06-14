package io.cys.moniyuekao1.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.cys.moniyuekao1.api.EmployeeApi;
import io.cys.moniyuekao1.dao.AreaMapper;
import io.cys.moniyuekao1.dao.EmployeeMapper;
import io.cys.moniyuekao1.dto.AreaNode;
import io.cys.moniyuekao1.dto.EmployeeGetDTO;
import io.cys.moniyuekao1.dto.EmployeeListDTO;
import io.cys.moniyuekao1.po.Area;
import io.cys.moniyuekao1.po.Employee;
import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/employee")
@EnableAutoConfiguration
@CrossOrigin
public class EmployeeController {

    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private AreaMapper areaMapper;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Reference(check = false,timeout = 10000)
    private EmployeeApi employeeApi;

    @GetMapping("/getPageAndName")
    private PageInfo<EmployeeListDTO> getPageAndName(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer areaId,
            @RequestParam(required = false) Integer positionId,
            @RequestParam(required = false,defaultValue = "1") Integer pageNum
    ){
        PageInfo<EmployeeListDTO> employeePageInfo = employeeApi.getPageAndName(name, areaId, positionId, pageNum);
        return  employeePageInfo;
    }


    @PostMapping("/creat")
    public void creat(@RequestBody Employee employee){
       logger.info("employee value {},employee id {}",employee,employee.getEmployeeId());
       rabbitTemplate.convertAndSend("mydirect","employee1",employee);
    }

    @PostMapping("/update")
    public void update(@RequestBody Employee employee){
     employeeApi.update(employee);
    }

    @PostMapping("/bathDelete")
    public Employee bathDelete(@RequestBody List<Integer> employeeIds){
        Employee employee = employeeApi.bathDelete(employeeIds);
        return employee;
    }

    // 通过id来进行回显接口
    @GetMapping("/getById")
    public EmployeeGetDTO getById(@RequestParam Integer employeeId){
        EmployeeGetDTO employeeGetDTO = employeeApi.getById(employeeId);
        return employeeGetDTO;
    }
}
