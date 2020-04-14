package it.intersistemi.corso.gestioneAttivita.model;

public class DipendenteDto {
	private Integer idMatricola;
	private String cognome;
	private String nome;

	public Integer getIdMatricola() {
		return idMatricola;
	}
	public void setIdMatricola(int idMatricola) {
		this.idMatricola = idMatricola;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

}