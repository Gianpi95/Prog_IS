package entity;

import database.AggiungiPaninoDAO;
import database.OrdineDAO;
import exception.DBConnectionException;
import exception.OperationException;

public class EntityAggiungiPanino {
	
	private int id;
	private int quantità;
	private int codPanino;
	private int codOrdine;
	
	public EntityAggiungiPanino() {
		super();
	}

	public EntityAggiungiPanino(int id, int quantità, int codPanino, int codOrdine) {
		super();
		this.id = id;
		this.quantità = quantità;
		this.codPanino = codPanino;
		this.codOrdine = codOrdine;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getQuantità() {
		return quantità;
	}
	
	public void setQuantità(int quantità) {
		this.quantità = quantità;
	}
	
	public int getCodPanino() {
		return codPanino;
	}
	
	public void setCodPanino(int codPanino) {
		this.codPanino = codPanino;
	}
	
	public int getCodOrdine() {
		return codOrdine;
	}
	
	public void setCodOrdine(int codOrdine) {
		this.codOrdine = codOrdine;
	}
	
public void saveAggiungiPanino() throws OperationException,DBConnectionException{
		
		AggiungiPaninoDAO.insertAggiungiPanino(this);
		
	}

	
}