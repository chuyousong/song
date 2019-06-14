package io.cys.moniyuekao1.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class AreaNode {

    private Integer areaId;

    private String name;

    private List<AreaNode> subAreas;

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AreaNode> getSubAreas() {
        return subAreas;
    }

    public void setSubAreas(List<AreaNode> subAreas) {
        this.subAreas = subAreas;
    }
}
