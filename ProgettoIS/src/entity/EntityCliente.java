package entity;

public class EntityCliente {
	
	private int idCliente;
	private String nome;
	private String cognome;
	private String indirizzo;
	private int CAP;
	private long nrTelefono;
	private String cartaDiCredito;
	
	public EntityCliente() {
		super();
	}
	
	public EntityCliente(int idCliente, String nome, String cognome, String indirizzo, int CAP, long nrTelefono, String cartaDiCredito) {
		super();
		this.idCliente = idCliente;
		this.nome = nome;
		this.cognome = cognome;
		this.indirizzo = indirizzo;
		this.CAP = CAP;
		this.nrTelefono = nrTelefono;
		this.cartaDiCredito = cartaDiCredito;
	}
	
	public int getIdCliente() {
		return idCliente;
	}
	
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setIdClienteRegistrato(String nome) {
		this.nome = nome;
	}
	
	public String getCognome() {
		return cognome;
	}
	
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	public String getIndirizzo() {
		return indirizzo;
	}
	
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	
	public int getCAP() {
		return CAP;
	}
	
	public void setCAP(int CAP) {
		this.CAP = CAP;
	}
	
	public long getNrTelefono() {
		return nrTelefono;
	}
	
	public void setNrTelefono(long nrTelefono) {
		this.nrTelefono = nrTelefono;
	}
	
	public String getCartaDiCredito() {
		return cartaDiCredito;
	}
	
	public void setCartaDiCredito(String cartaDiCredito) {
		this.cartaDiCredito = cartaDiCredito;
	}
	
}