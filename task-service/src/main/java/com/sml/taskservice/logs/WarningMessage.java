package com.sml.taskservice.logs;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("warning")
public class WarningMessage implements LogMessage {
    @Override
    public String getMessage() {
        return "Warning message";
    }
}
