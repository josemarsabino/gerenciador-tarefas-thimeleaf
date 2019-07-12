package br.com.sada.twgerenciadortarefas.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Tarefa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tar_id")
	private Long id;

	@Column(name = "tar_titulo", length = 50, nullable = false)
	@NotNull(message = "O título é obrigatório")
	@Length(max = 50, min = 3, message = "O título deve conter entre 3 e 50 caracteres")
	private String titulo;

	@Column(name = "tar_descricao", length = 100, nullable = true)
	@Length(max = 100, message = "A descrição deve conter até 100 caracteres")
	private String descricao;

	@Column(name = "tar_data_expiracao", nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd") // TRANSFORMA A DATA EM FORMATO BRASILEIRO
	private Date dataExpiracao;

	@Column(name = "tar_concluida", nullable = false)
	private Boolean concluida = false;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataExpiracao() {
		return dataExpiracao;
	}

	public void setDataExpiracao(Date dataExpiracao) {
		this.dataExpiracao = dataExpiracao;
	}

	public Boolean getConcluida() {
		return concluida;
	}

	public void setConcluida(Boolean concluida) {
		this.concluida = concluida;
	}

	public Tarefa() {
		
	}

	public Tarefa(Long id,
			@NotNull(message = "O título é obrigatório") @Length(max = 50, min = 3, message = "O título deve conter entre 3 e 50 caracteres") String titulo,
			@Length(max = 100, message = "A descrição deve conter até 100 caracteres") String descricao,
			Date dataExpiracao, Boolean concluida) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.dataExpiracao = dataExpiracao;
		this.concluida = concluida;
	}

	@Override
	public String toString() {
		return "Tarefa [id=" + id + ", titulo=" + titulo + ", descricao=" + descricao + ", dataExpiracao="
				+ dataExpiracao + ", concluida=" + concluida + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tarefa other = (Tarefa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	

}
