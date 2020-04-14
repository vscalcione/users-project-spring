package it.intersistemi.corso.gestioneAttivita.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the ATTIVITA database table.
 * 
 */
@Entity
@Table(name="ATTIVITA")
@NamedQuery(name="Attivita.findAll", query="SELECT a FROM Attivita a")
public class Attivita implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_ATTIVITA", unique=true, nullable=false, length=36)
	private String idAttivita;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_FINE")
	private Date dataFine;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_INIZIO", nullable=false)
	private Date dataInizio;

	@Column(name="NOME_ATTIVITA", nullable=false, length=100)
	private String nomeAttivita;

	//bi-directional many-to-many association to Dipendente
	@ManyToMany
	@JoinTable(
		name="ATTIVITA_DIPENDENTE"
		, joinColumns={
			@JoinColumn(name="ID_ATTIVITA", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="ID_MATRICOLA", nullable=false)
			}
		)
	private Set<Dipendente> dipendentes;

	public Attivita() {
	}

	public String getIdAttivita() {
		return this.idAttivita;
	}

	public void setIdAttivita(String idAttivita) {
		this.idAttivita = idAttivita;
	}

	public Date getDataFine() {
		return this.dataFine;
	}

	public void setDataFine(Date dataFine) {
		this.dataFine = dataFine;
	}

	public Date getDataInizio() {
		return this.dataInizio;
	}

	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}

	public String getNomeAttivita() {
		return this.nomeAttivita;
	}

	public void setNomeAttivita(String nomeAttivita) {
		this.nomeAttivita = nomeAttivita;
	}

	public Set<Dipendente> getDipendentes() {
		return this.dipendentes;
	}

	public void setDipendentes(Set<Dipendente> dipendentes) {
		this.dipendentes = dipendentes;
	}

}