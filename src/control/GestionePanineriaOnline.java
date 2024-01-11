package control;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import database.AggiungiPaninoDAO;
import database.PanineriaDAO;
import database.PaninoDAO;
import database.ClienteDAO;
import database.OrdineDAO;
import entity.EntityCliente;
import entity.EntityAggiungiPanino;
import entity.EntityPanineria;
import entity.EntityPanino;
import exception.DBConnectionException;
import exception.OperationException;
import entity.EntityOrdine;

public class GestionePanineriaOnline {
	
	private static GestionePanineriaOnline gpo = null;
	private ArrayList<EntityOrdine> ordineInAttesa;
	
	protected GestionePanineriaOnline(){
		ordineInAttesa = new ArrayList<EntityOrdine>();
	}

	public static GestionePanineriaOnline getInstance() {
		
		if (gpo == null) {
			gpo = new GestionePanineriaOnline(); 
		}
		
		return gpo; 
	}

	public int prenotaOrdine(int idCliente, String nomePanineria, ArrayList<String> nomePanino, ArrayList<Integer> quantità, int nPanini) {
		
		EntityPanineria ePanineria = null;
		EntityOrdine eo = null;
		EntityPanino ePanino = null;
		EntityAggiungiPanino eap= null;
		EntityCliente ec = null;
		float prezzoTotale = 0;
		float prezzoSingolo = 0;
		int id = 0;
		int id1 = 0;
		
		ePanineria = PanineriaDAO.getPanineria(nomePanineria);
		
		int i=0;
		
		//varie letture nel db
		while(i<nPanini) {
			
			ePanino = PaninoDAO.getPanino(nomePanino.get(i));
		
			eap = AggiungiPaninoDAO.readAggiungiPanino(nomePanino.get(i));
		
			prezzoSingolo = ePanino.getPrezzo();
			
			ec = ClienteDAO.readCliente(idCliente);
			
			
			prezzoTotale = prezzoTotale+(prezzoSingolo*quantità.get(i));
			
			i=i+1;
		
		}
		
        id = generaId();
        eo = OrdineDAO.getOrdine(id);
        if(eo != null) {																		//se eo restituisce null significa che non esiste un ordine con quel id
        	id1 = eo.getIdOrdine();
        	 while(id == id1) {
        		 id = generaId();
        	 }
        }
        
		ordineInAttesa.add(new EntityOrdine(id,null,null,prezzoTotale,0,idCliente));
		
		return id;
       
	}
	
	public float emettiOrdine(ArrayList<String> panino,ArrayList<Integer> quantità,int nPanini, int codOrdine)throws  OperationException,DBConnectionException{
		
		EntityOrdine eo = null;
		EntityAggiungiPanino eap = null;
		EntityPanino ep = null;
		int id, id1 = 0;
		float costoTot = 0;
		
		try {
			for(EntityOrdine elemento : ordineInAttesa) {
				eo = new EntityOrdine(elemento.getIdOrdine(),null,null,elemento.getCostoTotale(),0,elemento.getCodCliente());
			}
			
			eo.saveOrdine();
			
			//salvataggio nel database dell'ordine creato
			
			for(int i=0; i<nPanini; i++) {
				id = generaId();
				eap = AggiungiPaninoDAO.readId(id);
				if(eap != null) {																//se eap restituisce null significa che non esiste una tupla di AggiungiPanino con quel id
					id1 = eo.getIdOrdine();
					while(id == id1) {
						id = generaId();
					}
					eap = null;
				}
				ep = PaninoDAO.getPanino(panino.get(i));
				eap = new EntityAggiungiPanino(id,quantità.get(i),ep.getIdPanino(),codOrdine);
				eap.saveAggiungiPanino();														//salvataggio nel db della tupla di AggiungiPanino
				System.out.println(quantità.get(i) + " " + panino.get(i));
			}
			for(EntityOrdine elemento : ordineInAttesa) {
				costoTot = elemento.getCostoTotale();
				System.out.println("Codice ordine: " + elemento.getIdOrdine() + "; Costo totale: " + costoTot + "€; Codice cliente: " + elemento.getCodCliente());
			}
		}catch(DBConnectionException dbEx) {
			throw new OperationException("\nRiscontrato problema interno applicazione!\n");
		}
		
		return costoTot;
		
	}
	
	public static int generaId() {
		
		Random valore = new Random();
        return valore.nextInt((10000 - 1) + 1);
        
	}

	
}