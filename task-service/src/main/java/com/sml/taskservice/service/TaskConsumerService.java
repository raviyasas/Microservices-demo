package com.sml.taskservice.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

@Component
public class TaskConsumerService {

    @Value("${file.destination.path}")
    private String fileDestination;

    @RabbitListener(queues = "${jsa.rabbitmq.queue}")
    public void receivedMessage(String msg) {
        System.out.println("Received Message 1: " + msg);
    }

    @RabbitListener(queues = "${jsa.rabbitmq.queue}")
    public void receivedFiles(byte[] content) throws IOException {

        ZipInputStream zipStream = new ZipInputStream(new ByteArrayInputStream(content));
        ZipEntry entry = null;
        while ((entry = zipStream.getNextEntry()) != null) {

            String entryName = entry.getName();

            FileOutputStream out = new FileOutputStream(fileDestination + entryName);

            byte[] byteBuff = new byte[4096];
            int bytesRead = 0;
            while ((bytesRead = zipStream.read(byteBuff)) != -1)
            {
                out.write(byteBuff, 0, bytesRead);
            }
            out.close();
            zipStream.closeEntry();
        }
        zipStream.close();
        System.out.println("Content length : " + content.length);
    }
}
