package com.uade.repartidorback.enums;

public enum TipoEnum {
    PEDIDO ("pedido"),
    ACTUALIZACION_PEDIDO ("actualizacion-pedido"),
    REINTEGRO ("REINTEGRO"),
    RECLAMO ("RECLAMO");


    public final String label;

    private TipoEnum (String label) {
        this.label = label;
    }
}
