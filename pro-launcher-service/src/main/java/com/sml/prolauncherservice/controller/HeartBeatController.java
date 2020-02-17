package com.sml.prolauncherservice.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sml.prolauncherservice.model.HeartBeat;
import com.sml.prolauncherservice.service.HeartBeatService;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
//import org.springframework.cloud.stream.messaging.Source;
//import org.springframework.messaging.Message;
//import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/proLauncher")
@RefreshScope
public class HeartBeatController {

    @HystrixCommand(fallbackMethod = "fallBackHello", commandKey = "pro-launcher-service", groupKey = "pro-launcher-service")
    @GetMapping("/fallback")
    public String getName() throws Exception {

        if(RandomUtils.nextBoolean()){
            throw new Exception("Failed");
        }
        return "Hello from pro-launcher-service";
    }

    /**
     * fall back method
     * @return
     */
    private String fallBackHello() {
        return "fallback method initiated";
    }

}