package com.sml.prolauncherservice.service;

import com.sml.prolauncherservice.model.HeartBeat;
import com.sml.prolauncherservice.repository.HeartBeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.stream.Stream;

@Component
public class HeartBeatService implements CommandLineRunner {

    @Autowired
    private HeartBeatRepository heartBeatRepository;

    /**
     * This is only for testing purposes
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {

        Stream.of("One", "Two", "Three", "Four", "Five")
                .forEach(name -> heartBeatRepository.save(new HeartBeat(name)));
        heartBeatRepository.findAll().forEach(System.out::println);
    }
}
