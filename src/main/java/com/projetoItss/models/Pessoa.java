package com.projetoItss.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Pessoa implements Serializable{
		
		private static final long serialVersionUID = 1L;
		
		@Id
		@NotNull
		private Integer rg;
		
		@NotEmpty
		private String nome;
		@NotEmpty
		
		@NotEmpty
		@Column(unique=true)
		private String login;
		
		@NotEmpty
		@Column(unique=true)
		private String email;
		
		@NotEmpty
		private String senha;
		
		@Column(unique=true)
		private String cpf;
	
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

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getCpf() {
			return cpf;
		}

		public void setCpf(String cpf) {
			this.cpf = cpf;
		}

		public Integer getRg() {
			return rg;
		}

		public void setRg(Integer rg) {
			this.rg = rg;
		}
	

}
