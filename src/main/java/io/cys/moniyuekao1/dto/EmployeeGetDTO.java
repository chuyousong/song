package io.cys.moniyuekao1.dto;

import io.cys.moniyuekao1.po.Employee;

import java.util.List;

public class EmployeeGetDTO extends Employee{
      private List<Integer> areaIds;

    public List<Integer> getAreaIds() {
        return areaIds;
    }

    public void setAreaIds(List<Integer> areaIds) {
        this.areaIds = areaIds;
    }
}
