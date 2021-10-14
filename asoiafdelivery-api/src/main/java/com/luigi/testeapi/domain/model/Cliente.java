package com.luigi.testeapi.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter 
@Setter 
@Entity 
public class Cliente {
@EqualsAndHashCode.Include
@Id 
@NotNull(groups = ValidationGroups.ClienteId.class)
@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	@NotBlank //javaxvalidation
	@Size(max = 60)
	public String nome;
	
	@NotBlank
	@Email
	@Size(max=255)
	public String email;
	
	@NotBlank
	@Size(max = 20)
	@Column(name = "fone")
	public String telefone;
	
	
	
}
