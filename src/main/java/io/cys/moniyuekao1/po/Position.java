package io.cys.moniyuekao1.po;

import java.io.Serializable;

public class Position implements Serializable {
    private Integer positionId;

    private String name;

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}