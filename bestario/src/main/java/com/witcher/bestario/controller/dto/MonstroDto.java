package com.witcher.bestario.controller.dto;

import com.witcher.bestario.modelos.Monstro;

import java.util.List;
import java.util.stream.Collectors;

public class MonstroDto {


    private Long id;
    private String nomeMonstro;
    private String tipoDoMonstro;

    public MonstroDto(Monstro monstro){
        this.id = monstro.getId();
        this.nomeMonstro = monstro.getNomeMonstro();
        this.tipoDoMonstro = monstro.getTipoDoMonstro();
    }


    public Long getId() {
        return id;
    }

    public String getNomeMonstro() {
        return nomeMonstro;
    }

    public String getTipoDoMonstro() {
        return tipoDoMonstro;
    }

    public static List<MonstroDto> converter(List<Monstro> monstros) {
        return monstros.stream().map(MonstroDto::new).collect(Collectors.toList());
    }
}
