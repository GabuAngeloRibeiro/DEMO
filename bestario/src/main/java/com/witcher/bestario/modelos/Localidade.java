package com.witcher.bestario.modelos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
@Entity
public class Localidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String localEncontrado;
    private LocalDateTime dataDoEncontro = LocalDateTime.now();

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Localidade other = (Localidade) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocalEncontrado() {
        return localEncontrado;
    }

    public void setLocalEncontrado(String localEncontrado) {
        this.localEncontrado = localEncontrado;
    }

    public LocalDateTime getDataDoEncontro() {
        return dataDoEncontro;
    }

    public void setDataDoEncontro(LocalDateTime dataDoEncontro) {
        this.dataDoEncontro = dataDoEncontro;
    }
}
