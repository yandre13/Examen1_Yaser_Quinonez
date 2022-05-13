package com.idat.ExamenI.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Table(name = "MallasCurriculares")
@Entity
public class MallaCurricular {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idMallaCurricular;
	private String anio;
	
	@OneToOne
	@JoinColumn(name = "id_universidad", nullable = false, unique = true,
	foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_universidad) references universidades (id_universidad)"))
	private Universidad universidad;
	
	@OneToMany(mappedBy = "mallaCurricular")
	private List<Curso> curso = new ArrayList<Curso>();
	
	public Integer getIdMallaCurricular() {
		return idMallaCurricular;
	}
	public void setIdMallaCurricular(Integer idMallaCurricular) {
		this.idMallaCurricular = idMallaCurricular;
	}
	public String getAnio() {
		return anio;
	}
	public void setAnio(String anio) {
		this.anio = anio;
	}
	
}
