package com.aed.kanbanpro.util;

import java.util.UUID;

/**
 * Clase para generar identificadores únicos.
 * @author Juan Romero Collazos
 */
public class UniqueIDGenerator {
    
    /**
     * Genera un identificador único utilizando la clase UUID.
     * @return El identificador único generado.
     */
    public String idGenerator() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
