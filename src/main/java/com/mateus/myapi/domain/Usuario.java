package com.mateus.myapi.domain;


import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Objects;

@Entity   //Informa ao banco que será uma tabela

public class Usuario implements Serializable {

   private static final long serialVersionUID = 1L;
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY) //Informando que ID será uma chave primaria no banco.
   private Integer id;

   @NotEmpty(message = "Campo NOME é mandatório") // Informando que o campo NOME não pode ser vazio.
   @Length(min = 3, max = 100, message = "O Nome de ver entre 3 e 100 caracteres") // Definindo tamanho minimo e maximo do caracteres.
   private String nome;
   @NotEmpty(message = "Campo LOGIN é mandatório")
   @Length(min = 3, max = 100, message = "O Nome de ver entre 3 e 100 caracteres")
   private String login;
   @NotEmpty(message = "Campo SENHA é mandatório")
   @Length(min = 3, max = 100, message = "O Nome de ver entre 3 e 100 caracteres")
   private String senha;


   public Usuario(){
       super();
   }

   public Usuario(Integer id, String nome, String login, String senha) {
       this.id = id;
       this.nome = nome;
       this.login = login;                      //Criado construtor
       this.senha = senha;
   }

   public Integer getId() {
       return id;
   }

   public void setId(Integer id) {
       this.id = id;
   }

   public String getNome() {
       return nome;
   }

   public void setNome(String nome) {
       this.nome = nome;
   }

   public String getLogin() {
       return login;
   }

   public void setLogin(String login) {
       this.login = login;
   }

   public String getSenha() {
       return senha;
   }

   public void setSenha(String senha) {
       this.senha = senha;
   }

   @Override
   public boolean equals(Object o) {
       if (this == o) return true;
       if (o == null || getClass() != o.getClass()) return false;
       Usuario usuario = (Usuario) o;
       return Objects.equals(id, usuario.id);
   }

   @Override
   public int hashCode() {
       return Objects.hash(id);
   }
}
