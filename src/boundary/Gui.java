package boundary;

import control.GestionePanineriaOnline;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import control.GestionePanineriaOnline;
import entity.EntityAggiungiPanino;
import exception.DBConnectionException;
import exception.OperationException;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Window;
import java.awt.Color;

public class Gui {

	JFrame frame;
	JFrame frame1;
	int scelta = 0;
	static char removeChar = '(';
	private JTextField textField;
	private JTextField textField_1;
	static ArrayList<Integer> ordine;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui window = new Gui();
					Gui window1 = new Gui();
					window.frame.setVisible(true);
					window1.frame1.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Gui() throws OperationException {
		
		initialize();
		ordine = new ArrayList<Integer>();
		
	}
	
	private void initialize(){
		
		GestionePanineriaOnline gestionePanineriaOnline = GestionePanineriaOnline.getInstance();
		
		//Sezione del primo frame
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//Sezione secondo frame
		frame1 = new JFrame();
		frame1.setBounds(100, 100, 450, 300);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.getContentPane().setLayout(null);
		frame1.setVisible(false);
		
		JLabel lblMultiscreen = new JLabel("Ordine");
		lblMultiscreen.setForeground(Color.RED);
		lblMultiscreen.setFont(new Font("Lucida Grande", Font.PLAIN, 28));
		lblMultiscreen.setBounds(165, 6, 183, 64);
		frame1.getContentPane().add(lblMultiscreen);
		
		//Sezione idCliente
		textField = new JTextField();
		textField.setBounds(135, 162, 100, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		textField.setText("1");
		
		JLabel lblCliente = new JLabel("Codice cliente");
		lblCliente.setBounds(135, 138, 155, 20);
		frame.getContentPane().add(lblCliente);
		//fine sezione idCliente
		
		//Sezione interfaccia
		DefaultListModel<String> model = new DefaultListModel<>(); 
		JList<String> list = new JList<>(model);
		JScrollPane scroll = new JScrollPane(list);
		
		frame.add(scroll);
		scroll.setBounds(240, 148, 185, 110);
		//fine sezione interfaccia
		
		//Sezione per visualizzare l'ordine confermato
		DefaultListModel<String> model1 = new DefaultListModel<>(); 
		JList<String> list1 = new JList<>(model1);
		JScrollPane scroll1 = new JScrollPane(list1);
				
		frame1.add(scroll1);
		scroll1.setBounds(45, 60, 350, 180);
		//fine sezione dell'ordine confermato
		
		
		//Sezione quantità
		JComboBox comboBox = new JComboBox();
		comboBox.setMaximumRowCount(10);
		comboBox.setBounds(210, 102, 44, 27);
		frame.getContentPane().add(comboBox);
		comboBox.addItem("1");
		comboBox.addItem("2");
		comboBox.addItem("3");
		comboBox.addItem("4");
		comboBox.addItem("5");
		comboBox.addItem("6");
		comboBox.addItem("7");
		comboBox.addItem("8");
		comboBox.addItem("9");
		comboBox.addItem("10");
				
		JLabel lblNumeroPosti = new JLabel("Quantità");
		lblNumeroPosti.setBounds(205, 82, 93, 16);
		frame.getContentPane().add(lblNumeroPosti);
		//fine sezione quantità
		
		//Sezione Panineria
		JLabel lblPanineria = new JLabel("Panineria");
		lblPanineria.setBounds(25, 20, 61, 16);
		frame.getContentPane().add(lblPanineria);
				
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(25, 43, 230, 27 );
		frame.getContentPane().add(comboBox_1);
		comboBox_1.addItem("Fratelli Ferraris");
		comboBox_1.addItem("Puok");
		//fine sezione panineria
				
		//Sezione Panino
		JComboBox comboBox_2 = new JComboBox();
		JComboBox comboBox_3 = new JComboBox();
		comboBox_2.setVisible(false);
		comboBox_3.setVisible(false);
		comboBox_2.setBounds(25, 102, 185, 27);
		frame.getContentPane().add(comboBox_2);
		comboBox_2.addItem("Broccoli e salsiccia");
		comboBox_2.addItem("Porchetta e patatine");
		comboBox_3.setBounds(25, 102, 185, 27);
		frame.getContentPane().add(comboBox_3);
		comboBox_3.addItem("Hamburger e bacon");
		comboBox_3.addItem("Hamburger e formaggio");
		
		JButton btnButtonPanineria = new JButton("Seleziona Panineria");
		btnButtonPanineria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				String s1 = ((String) comboBox_1.getSelectedItem());
				if(s1.equals("Fratelli Ferraris")){
					comboBox_2.setVisible(true);
					comboBox_3.setVisible(false);
					scelta=1;
				}else if(s1.equals("Puok")){
					comboBox_3.setVisible(true);
					comboBox_2.setVisible(false);
					scelta=2;
				}
			}
		});
		btnButtonPanineria.setBounds(268, 43, 154, 27);
		frame.getContentPane().add(btnButtonPanineria);
				
		JLabel lblPanino = new JLabel("Panino");
		lblPanino.setBounds(25, 82, 141, 16);
		frame.getContentPane().add(lblPanino);
		//fine sezione panino
		
		//Sezione conferma ordine
		JButton btnNewButton = new JButton("Conferma Ordine");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					try {
							int size = model.getSize();
							ArrayList<String> panini = new ArrayList<String>();
							ArrayList<Integer> quantità = new ArrayList<Integer>();
							int i=0;
							while(i<size){
								quantità.add(Integer.parseInt(model.getElementAt(i)));
								i=i+1;
								panini.add(model.getElementAt(i));
								i=i+1;
							}
							//System.out.println( "PANINI: " + panini + "; QUANTITA: " + quantità);
							int codOrdine = gestionePanineriaOnline.prenotaOrdine(Integer.parseInt(textField.getText()),comboBox_1.getSelectedItem().toString(),panini,quantità,size/2);
							System.out.println("Attendi che l'ordine sia ricevuto...\nORDINE [Panineria " + comboBox_1.getSelectedItem().toString() + "]");
							float tot = gestionePanineriaOnline.emettiOrdine(panini,quantità,size/2,codOrdine);
							model1.addElement("Panineria " + comboBox_1.getSelectedItem().toString());
							for(int k=0; k<(size/2);k++) {
								String s = panini.get(k);
								String s1 = String.valueOf(quantità.get(k));
								model1.addElement(s1 + " " + s);
							}
							model1.addElement("Codice ordine: " + String.valueOf(codOrdine));
							model1.addElement("Costo totale: " + String.valueOf(tot) + "€");
							model1.addElement("Codice cliente: " + Integer.parseInt(textField.getText()));
							model1.addElement("Ordine effettuato con successo! Arrivederci e grazie.");
							frame.setVisible(false);
							frame1.setVisible(true);
					}catch(NumberFormatException | OperationException | DBConnectionException e1) {
						e1.printStackTrace();
					}
				
			}
		});
		btnNewButton.setBounds(25, 190, 155, 30);
		frame.getContentPane().add(btnNewButton);
		//fine sezione conferma ordine
				
		//Sezione  return
		JButton btnReturn = new JButton("Return");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				MainMenu.frame.setVisible(true);
			}
		});
		btnReturn.setBounds(25, 225, 155, 30);
		frame.getContentPane().add(btnReturn);
		//fine sezione return
				
		//Sezione aggiungi panino
		JButton btnAggPan = new JButton("Aggiungi panino");
		btnAggPan.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				if(scelta==1) {
					String s1 = ((String) comboBox_2.getSelectedItem());
					String s2 = ((String)comboBox.getSelectedItem());
					model.addElement(s2);
					model.addElement(s1);
					btnButtonPanineria.setVisible(false);
				}else if(scelta==2){
					String s1 = ((String) comboBox_3.getSelectedItem());
					String s2 = ((String)comboBox.getSelectedItem());
					model.addElement(s2);
					model.addElement(s1);
					btnButtonPanineria.setVisible(false);
				}
			}
		});
		btnAggPan.setBounds(268, 93, 154, 23);
		frame.getContentPane().add(btnAggPan);
		//fine sezione aggiugni panino
		
		//Sezione rimuovi panino
		JButton btnRimPan = new JButton("Rimuovi panino");
		btnRimPan.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				if(scelta==1) {
					model.removeElement(list.getSelectedValue());
				}else if(scelta==2){
					model.removeElement(list.getSelectedValue());				
				}
			}
		});
		btnRimPan.setBounds(268, 120, 154, 23);
		frame.getContentPane().add(btnRimPan);
		//fine sezione rimuovi panino
		
		//sezione prezzo
		JButton btnPrezzo = new JButton("Prezzo €");
		btnPrezzo.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				String s3 = (String) comboBox_2.getSelectedItem();
				String s4 = (String) comboBox_3.getSelectedItem();
				if(scelta==1) {
					if(s3.equals("Broccoli e salsiccia")) {
						textField_1.setText("6");
					}else if(s3.equals("Porchetta e patatine")){
						textField_1.setText("5");
					}
				}
				if(scelta==2) {
					if(s4.equals("Hamburger e formaggio")) {
						textField_1.setText("6.50");
					}else if(s4.equals("Hamburger e bacon")){
						textField_1.setText("6.50");
					}
				}
			}
		});
		btnPrezzo.setBounds(25, 140, 95, 20);
		frame.getContentPane().add(btnPrezzo);
		
		textField_1 = new JTextField();
		textField_1.setBounds(25, 162, 95, 20);
		textField_1.setColumns(10);
		textField_1.setEditable(false);
		frame.getContentPane().add(textField_1);
		//fine sezione prezzo

	}

}