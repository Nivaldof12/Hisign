package com.example.demo.domain.usuario;

public enum UsuarioRegras {
    ADMIN("admin"),
    USER("user");

    private String regra;

    UsuarioRegras(String regras){
        this.regra = regra;
    }

    public String getRegra(){
        return regra;
    }
}
