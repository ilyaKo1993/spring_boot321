package ru.kata.spring.boot_security.demo.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotEmpty;

import java.util.Collection;
import java.util.Set;

@Entity
@Data
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    @NotEmpty(message = "Имя не должно быть пустым")
    @Size(min = 3, max = 30, message = "Имя должно быть от 3х до 30 символов")
    @Pattern(message = "Используйте латинский алфавит от A-Z (пример: Ilya): ${validatedValue}",
            regexp = "^[A-Z][a-z]*(\\s(([a-z]{1,3})|(([a-z]+\\')?[A-Z][a-z]*)))*$")
    private String name;

    @Column(name = "last_name")
    @NotEmpty(message = "Фамилия не должна быть пустым")
    @Size(min = 3, max = 30, message = "Фамилия должна быть от 3х до 30 символов")
    @Pattern(message = "Используйте латинский алфавит от A-Z (пример: Ilya): ${validatedValue}",
            regexp = "^[A-Z][a-z]*(\\s(([a-z]{1,3})|(([a-z]+\\')?[A-Z][a-z]*)))*$")
    private String lastName;


    @Min(value = 0, message = "Возраст должен быть больше нуля")
    @Column(name = "age")
    private int Age;

    @NotEmpty(message = "Логин не должен быть пустым")
    @Size(min = 4, max = 30, message = "Логин должен быть от 4х до 30 символов")
    @Column(name = "login")
    private String login;

    @NotEmpty(message = "Пароль не должнен быть пустым")
    @Column(name = "password")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return login;
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
