package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.pojo.Schedule;
import org.example.service.ScheduleService;
import org.example.utils.PageBean;
import org.example.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@CrossOrigin   // 允许其他源访问，浏览器就不再拦截了
@Controller
@ResponseBody
@RequestMapping("schedule")
@Slf4j
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;
    @GetMapping("{pageSize}/{currentPage}")
    @ResponseBody
    public R page(@PathVariable int pageSize, @PathVariable int currentPage){
        R r = scheduleService.page(pageSize, currentPage);
        System.out.println("controller: "+r.getCode() + " " + r.getData());
        // slf4j日志
        log.info("查询的数据为：{}", r);
        return r;
    }
    @DeleteMapping("/{id}")
    public R remove(@PathVariable Integer id){
        R r = scheduleService.remove(id);
        return r;
    }

    @PostMapping
    public R save(@Validated @RequestBody Schedule schedule, BindingResult result){
        if (result.hasErrors()){
            return R.fail("参数为null,不能保存！");
        }
        R r = scheduleService.save(schedule);
        return r;
    }

    @PutMapping
    public R update(@Validated @RequestBody Schedule schedule, BindingResult result){
        if (result.hasErrors()){
            return R.fail("参数为null,不能修改！");
        }
        R r = scheduleService.update(schedule);
        return r;
    }

}
