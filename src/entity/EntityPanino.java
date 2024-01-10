package entity;

public class EntityPanino {
	
	private int idPanino;
	private String nome;
	private String descrizione;
	private float prezzo;
	private int codPanineria;
	
	public EntityPanino() {
		super();
	}
	
	public EntityPanino(int idPanino, String nome, String descrizione, float prezzo, int codPanineria) {
		super();
		this.idPanino = idPanino;
		this.nome = nome;
		this.descrizione = descrizione;
		this.prezzo = prezzo;
		this.codPanineria = codPanineria;
	}

	public int getIdPanino() {
		return idPanino;
	}
	
	public void setIdPanino(int idPanino) {
		this.idPanino = idPanino;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDescrizione() {
		return descrizione;
	}
	
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	public float getPrezzo() {
		return prezzo;
	}
	
	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}
	
	public int getCodPanineria() {
		return codPanineria;
	}
	
	public void setCodPanineria(int codPanineria) {
		this.codPanineria = codPanineria;
	}
	
}