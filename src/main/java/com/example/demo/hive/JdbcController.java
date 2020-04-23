package com.example.demo.hive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("jdbc")
public class JdbcController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("select")
    public String select(){
        List<Map<String, Object>> lists = jdbcTemplate.queryForList("select * from t1 limit 1 ,10");
        for (int i = 0; i < lists.size(); i++) {
            Map<String, Object> objectMap = lists.get(i);
            System.out.println(objectMap.get("t1.id") + objectMap.get("t1.name").toString());
        }
        return "ok";
    }
}