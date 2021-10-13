package com.witcher.bestario.controller.form;



import com.witcher.bestario.modelos.Monstro;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


public class MonstroForm {

    @NotNull @NotEmpty @Length(min = 3)
    private String nomeMonstro;
    @NotNull @NotEmpty @Length(min = 3)
    private String tipoDoMonstro;
    @NotNull @NotEmpty
    private String fraquesa ;



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

    public Monstro converter() {
        return new Monstro(nomeMonstro,tipoDoMonstro,fraquesa);
    }
}
