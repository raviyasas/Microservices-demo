package com.sml.workorderservice.service;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "PROLAUNCHER-SERVICE")
public interface ProlauncherClient {

    @GetMapping("/api/proLauncher/executeWorkOrder")
    String executeWorkOrder();
}
