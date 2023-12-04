package com.example.demo.domain.usuario;

public enum UsuarioRegras {
    ADMIN("ADMIN"),
    USER("USER");

    private String regra;

    UsuarioRegras(String regras){
        this.regra = regra;
    }

    public String getRegra(){
        return regra;
    }
}
