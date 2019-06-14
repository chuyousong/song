package io.cys.moniyuekao1.controller;

import io.cys.moniyuekao1.dao.AreaMapper;
import io.cys.moniyuekao1.dto.AreaNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/area")
@EnableAutoConfiguration
@CrossOrigin
public class AreaConteoller {

    @Autowired
    private AreaMapper areaMapper;

    @GetMapping("/getAreaAll")
    public List<AreaNode> getAreaAll(@RequestParam Integer areaId){
        List<AreaNode> areaNodes = areaMapper.getSelectArea(areaId);
        return areaNodes;
    }
}
