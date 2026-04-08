package com.pedro.picpaychallenge.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import com.pedro.picpaychallenge.domain.enums.UserType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter //cria getters
@Setter //cria setters
@NoArgsConstructor //cria o construtor sem argumentos
@AllArgsConstructor //cria o construtor com todos os argumentos

@Entity
@Table(name = "tb_user")
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String fullName;
	@Column(nullable = false, unique = true)
	private String cpf;
	@Column(nullable = false, unique = true)
	private String email;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false)
	private BigDecimal balance;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private UserType type;
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}
}
