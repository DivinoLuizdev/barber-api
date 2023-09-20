package com.api.barberdata.domain.enums;

 
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusAgendamento  {

    ABERTO("Aberto"),
    CANCELADO("Cancelado"),
    CONFIRMADO("Confirmado");

    private String status;

}
