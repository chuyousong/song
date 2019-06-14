package io.cys.moniyuekao1.consumer;

import io.cys.moniyuekao1.dao.EmployeeMapper;
import io.cys.moniyuekao1.po.Employee;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

@Component
public class EmployeeConsumer {

    @Autowired
    private EmployeeMapper employeeMapper;

    @RabbitListener(queues = "employee1")
    public void creat(Employee employee){
        employeeMapper.insert(employee);
    }
}
