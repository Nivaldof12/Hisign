package com.example.demo.domain.usuario;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.List;

@Table(name="Usuario")
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Email(message = "Email inválido!")
    @Column(name = "email")
    @NotBlank(message = "Email não pode ficar em branco!")
    private String email;
    @Column(name = "senha")
    @NotBlank(message = "Senha não pode ficar em branco!")
    @Size(min = 5, max = 500, message = "Senha inválida!(Deve conter no mínimo 5 caracteres)")
    private String senha;

    @Column(name = "nome")
    @NotBlank(message = "Nome não pode ficar em branco!")
    @Size(min = 3, max = 50, message = "Nome inválido!(Deve conter no mínimo 3 caracteres e no máximo 50)")
    @Pattern(regexp = "^[a-zA-ZÀ-ÿ ]+$", message = "O campo de nome deve conter apenas letras, acentos e espaços.")
    private String nome;
    @Column(name = "regra")
    private String regra;

    public Usuario(String email, String senha, String nome, String regra){
        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.regra = (regra != null && !regra.isEmpty()) ? regra : "USER";
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.regra == "ADMIN") return List.of(new SimpleGrantedAuthority("REGRA_ADMIN"), new SimpleGrantedAuthority("REGRA_USER"));
        else return List.of(new SimpleGrantedAuthority("REGRA_USER"));
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
