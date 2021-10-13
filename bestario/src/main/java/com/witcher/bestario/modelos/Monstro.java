package com.witcher.bestario.modelos;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Monstro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String nomeMonstro;
    private String tipoDoMonstro;
    private String fraquesa ;
    @ManyToOne
    private Localidade localidade;
    private LocalDateTime dataDoEncontro = LocalDateTime.now();

    public Monstro() {
    }

    public Monstro(String nomeMonstro, String tipoDoMonstro, String fraquesa) {
        this.nomeMonstro = nomeMonstro;
        this.tipoDoMonstro = tipoDoMonstro;
        this.fraquesa = fraquesa;
    }

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
        Monstro other = (Monstro) obj;
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

    public String getNomeMonstro() {
        return nomeMonstro;
    }

    public void setNomeMonstro(String nomeMonstro) {
        this.nomeMonstro = nomeMonstro;
    }

    public String getTipoDoMonstro() {
        return tipoDoMonstro;
    }

    public void setTipoDoMonstro(String tipoDoMonstro) {
        this.tipoDoMonstro = tipoDoMonstro;
    }

    public String getFraquesa() {
        return fraquesa;
    }

    public void setFraquesa(String fraquesa) {
        this.fraquesa = fraquesa;
    }

    public com.witcher.bestario.modelos.Localidade getLocalidade() {
        return localidade;
    }

    public void setLocalidade(com.witcher.bestario.modelos.Localidade localidade) {
        this.localidade = localidade;
    }

    public LocalDateTime getDataDoEncontro() {
        return dataDoEncontro;
    }

    public void setDataDoEncontro(LocalDateTime dataDoEncontro) {
        this.dataDoEncontro = dataDoEncontro;
    }
}
