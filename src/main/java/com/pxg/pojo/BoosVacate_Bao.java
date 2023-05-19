package com.pxg.pojo;

import lombok.Data;

@Data
public class BoosVacate_Bao {
    private BoosVacate[] boosVacate;

    public BoosVacate_Bao(BoosVacate[] boosVacate) {
        this.boosVacate = boosVacate;
    }
}
