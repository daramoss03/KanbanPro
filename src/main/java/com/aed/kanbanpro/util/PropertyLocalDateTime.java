package com.aed.kanbanpro.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Juan Romero Collazos
 */
public class PropertyLocalDateTime {
    public String nowLocalDateTime() {
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss dd MMM yyyy");
        return ldt.format(dtf);
    }
}
