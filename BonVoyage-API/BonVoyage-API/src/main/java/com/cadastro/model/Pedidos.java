package com.cadastro.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "pedidos")
public class Pedidos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_pedidos;
	
	@Column(name = "hospedagem", nullable = false)
	private String hospedagem;
	
	@Column(name = "qntd_passagem")
	private int qntd_passagem;
	
	@Column(name = "qntd_dias")
	private int qntd_dias;
	
	@Column(name = "destino", nullable = false)
	private String destino;
	
	@Column(name = "data_partida", nullable = false)
	private LocalDate data_partida;

}
