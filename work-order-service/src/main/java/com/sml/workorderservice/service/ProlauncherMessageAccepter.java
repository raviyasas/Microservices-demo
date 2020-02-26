package com.sml.workorderservice.service;

import com.sml.workorderservice.model.WorkOrder;
import com.sml.workorderservice.repository.WorkOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;

@MessageEndpoint
public class ProlauncherMessageAccepter {

    private WorkOrderRepository workOrderRepository;

    @Autowired
    public ProlauncherMessageAccepter(WorkOrderRepository workOrderRepository){
        this.workOrderRepository=workOrderRepository;
    }

    @ServiceActivator(inputChannel = Sink.INPUT)
    public void accept(String msg){
        this.workOrderRepository.save(new WorkOrder(msg));
    }
}
