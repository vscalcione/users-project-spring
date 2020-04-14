package it.intersistemi.corso.todo.model;

public class TodoDTO {
	private String idAttivita;
	private String descrizione;
	private int ordineAttivita;


	public String getIdAttivita() {
		return idAttivita;
	}
	public void setIdAttivita(String idAttivita) {
		this.idAttivita = idAttivita;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public int getOrdineAttivita() {
		return ordineAttivita;
	}
	public void setOrdineAttivita(int ordineAttivita) {
		this.ordineAttivita = ordineAttivita;
	}


}
