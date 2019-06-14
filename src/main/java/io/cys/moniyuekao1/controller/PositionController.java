package io.cys.moniyuekao1.controller;

import io.cys.moniyuekao1.dao.PositionMapper;
import io.cys.moniyuekao1.po.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Null;
import java.util.List;

@RestController
@RequestMapping("/position")
@EnableAutoConfiguration
@CrossOrigin
public class PositionController {

    @Autowired
    private PositionMapper positionMapper;

    @GetMapping("/getPositionAll")
    public List<Position> getPositionAll(){
        List<Position> positions = positionMapper.getSelectPositionAll();
        return positions;
    }
}
