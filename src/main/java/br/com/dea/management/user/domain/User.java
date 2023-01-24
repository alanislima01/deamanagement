package br.com.dea.management.user.domain;

import jakarta.persistence.*;

@Entity
@NamedQuery(name = "myQuery", query = "SELECT u FROM User u WHERE u.name = :name")
public class User {
    //toda classe começa com letra maiuscula. temos que criar sempre os metodos.


    //mapear chave primaria
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //o banco de dados que vai mandar/gerar o ID
    private Long id;

    @Column
    // cada um Column é como se fosse a coluna do dbeaver
    private String name;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private String linkedin;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }
}