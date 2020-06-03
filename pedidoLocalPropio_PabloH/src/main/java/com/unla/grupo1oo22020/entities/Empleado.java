package com.unla.grupo1oo22020.entities;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Empleado extends Persona{
	
	@Column(name="sueldoBasico")
	private float sueldoBasico;
	
	@Column(name="comision")
	private float comision;
	
	@Column(name="horarioTrabajoE")
	private LocalTime horarioTrabajoE;
	
	@Column(name="horarioTrabajoS")
	private LocalTime horarioTrabajoS;
	
	@Column(name="gerente")
	private boolean gerente;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "idLocal")
	private Local local;


	public Empleado() {

	}

	public Empleado(long idPersona, long dni, String apellido, String nombre, Date fechaNacimiento, 
			float sueldoBasico, float comision, LocalTime horarioTrabajoE, LocalTime horarioTrabajoS, 
			boolean gerente, Local local) {
		super(idPersona, dni, apellido, nombre, fechaNacimiento);
		this.sueldoBasico = sueldoBasico;
		this.comision = comision;
		this.horarioTrabajoE = horarioTrabajoE;
		this.horarioTrabajoS = horarioTrabajoS;
		this.gerente = gerente;
		this.local = local;
	}


	public float getSueldoBasico() {
		return sueldoBasico;
	}

	public void setSueldoBasico(float sueldoBasico) {
		this.sueldoBasico = sueldoBasico;
	}
	
	public float getComision() {
		return comision;
	}

	public void setComision(float comision) {
		this.comision = comision;
	}

	public LocalTime getHorarioTrabajoE() {
		return horarioTrabajoE;
	}

	public void setHorarioTrabajoE(LocalTime horarioTrabajoE) {
		this.horarioTrabajoE = horarioTrabajoE;
	}

	public LocalTime getHorarioTrabajoS() {
		return horarioTrabajoS;
	}

	public void setHorarioTrabajoS(LocalTime horarioTrabajoS) {
		this.horarioTrabajoS = horarioTrabajoS;
	}

	public boolean isGerente() {
		return gerente;
	}

	public void setGerente(boolean gerente) {
		this.gerente = gerente;
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

}