package com.noCountry.petConnect.infra.errores;

public class ApplicationException extends RuntimeException{

    public ApplicationException(String mensaje) {super(mensaje);}
}
