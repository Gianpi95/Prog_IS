package entity;

public class EntityPanineria {

	private int idPanineria;
	private String nome;
	private String città;
	private String via;
	private int nrCivico;
	private int CAP;
	private long recapitoTelefonico;
	private String IBAN;
	
	public EntityPanineria() {
		super();
	}
	
	public EntityPanineria(int idPanineria, String nome, String città, String via, int nrCivico, int CAP,long recapitoTelefonico, String IBAN) {
		super();
		this.idPanineria = idPanineria;
		this.nome = nome;
		this.città = città;
		this.via = via;
		this.nrCivico = nrCivico;
		this.CAP = CAP;
		this.recapitoTelefonico = recapitoTelefonico;
		this.IBAN = IBAN;
	}
	
	public int getIdPanineria() {
		return idPanineria;
	}

	public void setIdPanineria(int idPanineria) {
		this.idPanineria = idPanineria;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCittà() {
		return città;
	}

	public void setCittà(String città) {
		this.città = città;
	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public int getNrCivico() {
		return nrCivico;
	}

	public void setNrCivico(int nrCivico) {
		this.nrCivico = nrCivico;
	}

	public int getCAP() {
		return CAP;
	}

	public void setCAP(int CAP) {
		this.CAP = CAP;
	}

	public long getRecapitoTelefonico() {
		return recapitoTelefonico;
	}

	public void setRecapitoTelefonico(long recapitoTelefonico) {
		this.recapitoTelefonico = recapitoTelefonico;
	}

	public String getIBAN() {
		return IBAN;
	}

	public void setIBAN(String IBAN) {
		this.IBAN = IBAN;
	}	
	
}