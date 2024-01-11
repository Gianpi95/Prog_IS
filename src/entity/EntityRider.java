package entity;

public class EntityRider {
	
	private int idRider;
	private String nome;
	private String cognome;
	private long recapitoTelefonico;

	public EntityRider() {
		super();
	}
	

	public EntityRider(int idRider, String nome, String cognome, long recapitoTelefonico) {
		super();
		this.idRider = idRider;
		this.nome = nome;
		this.cognome = cognome;
		this.recapitoTelefonico = recapitoTelefonico;
	}
	
	public int getIdRider() {
		return idRider;
	}

	public void setIdRider(int idRider) {
		this.idRider = idRider;
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

	public long getRecapitoTelefonico() {
		return recapitoTelefonico;
	}

	public void setRecapitoTelefonico(long recapitoTelefonico) {
		this.recapitoTelefonico = recapitoTelefonico;
	}
	
}