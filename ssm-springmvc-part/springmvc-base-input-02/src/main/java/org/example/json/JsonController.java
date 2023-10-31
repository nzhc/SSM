package org.example.json;

import org.example.pojo.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("json")
@ResponseBody
public class JsonController {
    @PostMapping("data")
    public String data(@RequestBody Person person){
        System.out.println(person);
        return person.toString();
    }
}




