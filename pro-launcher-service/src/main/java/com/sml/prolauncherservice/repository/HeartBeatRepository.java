package com.sml.prolauncherservice.repository;

import com.sml.prolauncherservice.model.HeartBeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface HeartBeatRepository extends JpaRepository<HeartBeat, Long> {

}
