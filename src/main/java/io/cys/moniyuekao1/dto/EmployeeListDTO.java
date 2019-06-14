package io.cys.moniyuekao1.dto;

import io.cys.moniyuekao1.po.Area;
import io.cys.moniyuekao1.po.Employee;
import io.cys.moniyuekao1.po.Position;

import java.util.List;

public class EmployeeListDTO extends Employee{

    private Position position;

    private List<Area> areas;

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public List<Area> getAreas() {
        return areas;
    }

    public void setAreas(List<Area> areas) {
        this.areas = areas;
    }
}
