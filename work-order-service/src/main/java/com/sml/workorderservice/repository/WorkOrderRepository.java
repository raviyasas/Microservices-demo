package com.sml.workorderservice.repository;

import com.sml.workorderservice.model.WorkOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface WorkOrderRepository extends JpaRepository<WorkOrder, Long> {

}
