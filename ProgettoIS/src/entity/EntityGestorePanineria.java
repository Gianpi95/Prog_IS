package entity;

public class EntityGestorePanineria {

	private int idGestore;
	private String nome;
	private String cognome;
	
	public EntityGestorePanineria() {
		// TODO Auto-generated constructor stub
		super();
	}

	public EntityGestorePanineria(int idGestore, String nome, String cognome) {
		super();
		this.idGestore = idGestore;
		this.nome = nome;
		this.cognome = cognome;
	}
	
	public int getIdGestore() {
		return idGestore;
	}

	public void setIdGestore(int idGestore) {
		this.idGestore = idGestore;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

}