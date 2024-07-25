package br.com.api.Info4.dtos;

import java.time.LocalDateTime;

public class ItemsRespostaDTO {

	private Integer id;
	private String nome;
	private String descricao;
	private String data;

	
	public ItemsRespostaDTO() {
		super();
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

}
