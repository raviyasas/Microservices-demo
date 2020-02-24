package com.sml.prolauncherservice.controller;

import com.sml.prolauncherservice.model.HeartBeat;
import com.sml.prolauncherservice.service.FileProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.PropertySource;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@RestController
@RefreshScope
@RequestMapping("/api/proLauncher")
public class FileProducerController {

    @Autowired
    private FileProducerService fileProducerService;

    @Value("${file.source.path}")
    private String fileSource;

    @Autowired
    @Output(Source.OUTPUT)
    private MessageChannel messageChannel;

    @PostMapping
    public void write(@RequestBody HeartBeat heartBeat){
        this.messageChannel.send(MessageBuilder.withPayload(heartBeat.getName()).build());
    }

//    @GetMapping("/rabbitMQ/sendMessage")
//    public String sendMsg(@RequestParam("msg") String msg) {
//        fileProducerService.produceMsg(msg);
//        return "Message has been sent !";
//    }
//
//    @GetMapping("/rabbitMQ/sendFile")
//    public String sendFileToQueue() throws IOException {
//
//        File file = new File(fileSource);
//
//        if(file.exists()) {
//            byte[] content = Files.readAllBytes(file.toPath());
//            fileProducerService.sendFile(content);
//        }
//        return "File has been sent !";
//    }

    @GetMapping("/executeWorkOrder")
    public String executeWorkOrder() {
        return "execute work order from Prolauncher service !";
    }

}
