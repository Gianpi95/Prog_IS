package boundary;

import java.util.ArrayList;
import java.util.Scanner;


import control.GestionePanineriaOnline;
import database.ClienteDAO;
import database.PanineriaDAO;
import database.PaninoDAO;
import entity.EntityCliente;
import entity.EntityPanineria;
import entity.EntityPanino;
import exception.DBConnectionException;
import exception.OperationException;

public class BoundaryCliente {

	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) throws OperationException {
		
	boolean exit = false;
		
		while(!exit) {
			System.out.println("Cliente Registrato");
			System.out.println("1. Registrazione cliente");
			System.out.println("2. Visualizza panini");
			System.out.println("3. Effetua ordine");
			System.out.println("4. Esci");
			
			String op = scan.nextLine();

			if(op.equals("3")) {
				effettuaOrdine();
				exit = true;
			} else if(op.equals("4")){
				exit = true;
			}else{
				System.out.println("Operazione non disponibile");
				System.out.println();
			}
		}	
		
		System.out.println("Arrivederci!");
		
	}
	
	private static void effettuaOrdine() throws OperationException{
		
		EntityCliente eCliente = null;
		EntityPanino ePanino = null;
		EntityPanineria ePanineria = null;
		ArrayList<String> panino = new ArrayList<String>();
		ArrayList<Integer> quantità = new ArrayList<Integer>();
		GestionePanineriaOnline gestionePanineriaOnline = GestionePanineriaOnline.getInstance();
		String panineria = null;
		boolean inputValido = false;
		int codCliente = 0;
		int idOrdine = 0;
		int i = 0;
		float prezzoSingolo = 0;
		float prezzoTotale = 0;
		int idPanineria = 0;
		
		try {
			
			while(!inputValido) {
				System.out.println("Inserisci il codice cliente");
				codCliente = Integer.parseInt(scan.nextLine());
				eCliente = ClienteDAO.readCliente(codCliente);
				if(eCliente == null) {
					System.out.println("Il codice cliente inserito non esite, riprovare...");
				}else {
					inputValido = true;
				}
			}
			
			while(!inputValido) {
				System.out.println("Inserisci la panineria");
				panineria = scan.nextLine();
				ePanineria = PanineriaDAO.getPanineria(panineria);
				if(ePanineria == null) {
					System.out.println("La panineria inserita non esite, riprovare...");
				}else {
					inputValido = true;
					idPanineria = ePanineria.getIdPanineria();
				}
			}

			inputValido = false;
			while(!inputValido) {
			    System.out.println("Inserisci panino");
			    String paninoInput = scan.nextLine();
			    ePanino = PaninoDAO.getPanino(paninoInput);

			    if(ePanino == null || ePanino.getCodPanineria() != idPanineria) {
			        System.out.println("Il panino inserito non esiste nella panineria " + panineria);
			        inputValido = false;
			    }else {
			    	panino.add(paninoInput);
			        System.out.println("Il prezzo del panino selezionato è: " + ePanino.getPrezzo() + "€");
			        System.out.println("Inserisci quantità");
			        quantità.add(Integer.parseInt(scan.nextLine()));
			        prezzoSingolo = ePanino.getPrezzo();
			        prezzoTotale = (prezzoTotale + (prezzoSingolo * quantità.get(i)));
			        System.out.println("Digita 'S' o 's' per inserire altri panini o qualunque altro carattere per annullare..");
			        String risposta = scan.nextLine();

			        if(risposta.equalsIgnoreCase("S")) {
			            inputValido = false;
			            i++;
			        }else {
			            inputValido = true;
			        }
			    }
			}
		}catch (IllegalArgumentException iE) {
			System.out.println("Errore nell'inserimento dei dati, riprovare..");
			System.out.println();
		}
		
		int size = panino.size();
		
		try {
			idOrdine = gestionePanineriaOnline.prenotaOrdine(codCliente, panineria, panino, quantità, size );
			System.out.println("Il costo totale della spesa è: " + prezzoTotale);
			System.out.println("Digita 'S' o 's' per confermare l'ordine o qualunque altro carattere per annullare..");
			String risposta1 = scan.nextLine();
			if(risposta1.equalsIgnoreCase("S")) {
				gestionePanineriaOnline.emettiOrdine(panino, quantità, size, idOrdine);
				System.out.println("ORDINE EFFETTUATO CON SUCCESSO");
			}else {
			System.out.println("L'ordine non è stato confermato!");
			}
		}catch (OperationException e) {
			e.printStackTrace();
		}catch (DBConnectionException e) {
		e.printStackTrace();
		}
	}
		
}