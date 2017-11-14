package com.narcielitonlopes.professor.document;

import java.time.LocalTime;

public class DetalhesErro {

    private String titulo;

    private Long status;

    private LocalTime timestamp;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public LocalTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalTime timestamp) {
        this.timestamp = timestamp;
    }


}
