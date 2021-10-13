package com.witcher.bestario.controller.form;

import com.witcher.bestario.modelos.Monstro;
import com.witcher.bestario.repository.MonstroRepository;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AtualizacaoMonstroForm {

    @NotNull @NotEmpty @Length(min = 3)
    private String nomeMonstro ;



    public String getFraquesa() {
        return nomeMonstro;
    }

    public void setFraquesa(String fraquesa) {
        this.nomeMonstro = fraquesa;
    }



    public Monstro atualizar(Long id, MonstroRepository monstroRepository) {
        Monstro monstro = monstroRepository.getOne(id);

        monstro.setNomeMonstro(this.nomeMonstro);

        return monstro;
    }
}
