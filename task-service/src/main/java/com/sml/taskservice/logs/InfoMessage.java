package com.sml.taskservice.logs;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("info")
public class InfoMessage implements LogMessage {
    @Override
    public String getMessage() {
        return "info message";
    }
}
