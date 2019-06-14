package io.cys.moniyuekao1.provider;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.cys.moniyuekao1.api.EmployeeApi;
import io.cys.moniyuekao1.dao.AreaMapper;
import io.cys.moniyuekao1.dao.EmployeeMapper;
import io.cys.moniyuekao1.dto.EmployeeGetDTO;
import io.cys.moniyuekao1.dto.EmployeeListDTO;
import io.cys.moniyuekao1.po.Area;
import io.cys.moniyuekao1.po.Employee;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Service
public class EmployeeProvider implements EmployeeApi {

    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private AreaMapper areaMapper;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public PageInfo<EmployeeListDTO> getPageAndName(String name, Integer areaId, Integer positionId, Integer pageNum) {
        PageHelper.startPage(pageNum,2);
        Page<EmployeeListDTO> employees = employeeMapper.getSelectEmployeePageAndName(name,areaId,positionId);

        for (EmployeeListDTO employee : employees) {
            // 创建集合 通过根节点进行查询，并且存入集合当中
            LinkedList<Area> list = new LinkedList<>();
            Area area = areaMapper.selectByPrimaryKey(employee.getAreaId());
            list.add(area);

            // 获取子节点
            Integer parentId = area.getParentId();
            if(parentId != null && parentId != 0){
                area = areaMapper.getSelectParent(parentId);
                list.add(area);
                parentId = area.getParentId();
            }
            Collections.reverse(list);
            employee.setAreas(list);
        }
        PageInfo<EmployeeListDTO> employeePageInfo = employees.toPageInfo();
        return  employeePageInfo;
    }

    @Override
    public void update(Employee employee) {
        employeeMapper.updateByPrimaryKey(employee);
    }

    @Override
    public Employee bathDelete(List<Integer> employeeIds) {
        Employee employee = employeeMapper.getDeleteByEmployeeId(employeeIds);
        return employee;
    }

    @Override
    public EmployeeGetDTO getById(Integer employeeId) {
        EmployeeGetDTO employeeGetDTO = employeeMapper.selectByPrimaryKey2(employeeId);
        // 创建集合
        LinkedList<Integer> list = new LinkedList<>();
        Area area = areaMapper.selectByPrimaryKey(employeeGetDTO.getAreaId());
        list.add(employeeGetDTO.getAreaId());

        // 对象获取子节点
        Integer parentId = area.getParentId();
        if(parentId != null && parentId != 0){
            area = areaMapper.getSelectParent(parentId);
            list.add(area.getParentId());
            parentId = area.getParentId();
        }
        Collections.reverse(list);
        employeeGetDTO.setAreaIds(list);
        return employeeGetDTO;
    }
}
