package com.sml.workorderservice.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sml.workorderservice.service.ProlauncherClient;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
@RequestMapping("/api/workOrder")
public class WorkOrderController {

    @Autowired
    private ProlauncherClient prolauncherClient;

    @HystrixCommand(fallbackMethod = "fallBackHello", commandKey = "work-order-controller", groupKey = "work-order-controller")
    @GetMapping("/fallBack")
    public String getName() throws Exception {

        if(RandomUtils.nextBoolean()){
            throw new Exception("Failed");
        }
        return "Hello from work-order-service !";
    }

    /**
     * fallback hello method
     * @return a message
     */
    private String fallBackHello() {
        return "fallback method initiated from work order";
    }

    /**
     * Demo of Feign client
     *
     */
    @GetMapping("/getWorkOrder")
    public String getWorkOrder(){
        return prolauncherClient.executeWorkOrder();
    }

}
