package entity;

import java.sql.Time;
import database.OrdineDAO;
import exception.DAOException;
import exception.DBConnectionException;
import exception.OperationException;

public class EntityOrdine {

	private int idOrdine;
	private Time oraNotidicaRider;
	private Time oraConsegna;
	private float costoTotale;
	private int codCliente;
	private int codRider;
	
	public EntityOrdine() {
		super();
	}
	
	public EntityOrdine(int idOrdine, Time oraNotidicaRider, Time oraConsegna, float costoTotale, int codRider, int codCliente) {
		super();
		this.idOrdine = idOrdine;
		this.oraNotidicaRider = oraNotidicaRider;
		this.oraConsegna = oraConsegna;
		this.costoTotale = costoTotale;
		this.codRider = codRider;
		this.codCliente = codCliente;
	}
	
	public int getIdOrdine() {
		return idOrdine;
	}

	public void setIdOrdine(int idOrdine) {
		this.idOrdine = idOrdine;
	}

	public Time getOraNotidicaRider() {
		return oraNotidicaRider;
	}

	public void setOraNotidicaRider(Time oraNotidicaRider) {
		this.oraNotidicaRider = oraNotidicaRider;
	}

	public Time getOraConsegna() {
		return oraConsegna;
	}

	public void setOraConsegna(Time oraConsegna) {
		this.oraConsegna = oraConsegna;
	}

	public float getCostoTotale() {
		return costoTotale;
	}

	public void setCostoTotale(float costoTotale) {
		this.costoTotale = costoTotale;
	}
	
	public int getCodRider() {
		return codRider;
	}

	public void setCodRider(int codRider) {
		this.codRider = codRider;
	}

	public int getCodCliente() {
		return codCliente;
	}

	public void setCodCliente(int codCliente) {
		this.codCliente = codCliente;
	}
	
	public void saveOrdine() throws OperationException,DBConnectionException{
		
		OrdineDAO.createOrdine(this);
		
	}

}