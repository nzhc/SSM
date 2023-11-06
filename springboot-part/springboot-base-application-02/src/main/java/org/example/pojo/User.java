package org.example.pojo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@Data
@ConfigurationProperties(prefix = "ww.info")
public class User {
//    @Value("${ww.info.name}")
    private String username;

//    @Value("${ww.info.password}")
    private String password;

//    @Value("${gfs}")
    private List<String> gfs;
}
