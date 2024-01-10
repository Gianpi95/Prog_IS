package boundary;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainMenu {

	static JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu window = new MainMenu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainMenu() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblMultiscreen = new JLabel("Vendita panini");
		lblMultiscreen.setForeground(Color.RED);
		lblMultiscreen.setFont(new Font("Lucida Grande", Font.PLAIN, 28));
		lblMultiscreen.setBounds(138, 6, 183, 64);
		frame.getContentPane().add(lblMultiscreen);
		
		JButton btnAcquistaBiglietto = new JButton("Effettua ordine");
		btnAcquistaBiglietto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Gui window = new Gui();
					window.frame.setVisible(true);
					frame.setVisible(false);
				} catch (Exception exc) {
					System.out.println("Errore nella creazione della finestra");
				}
			}
		});
		btnAcquistaBiglietto.setBounds(96, 187, 270, 29);
		frame.getContentPane().add(btnAcquistaBiglietto);
		
		JButton btnRicercaFilm = new JButton("Registrazione cliente");
		btnRicercaFilm.setBounds(96, 83, 270, 29);
		frame.getContentPane().add(btnRicercaFilm);
		
		JButton btnVisualizzaProgrammazioneMensile = new JButton("Visualizza panini");
		btnVisualizzaProgrammazioneMensile.setBounds(96, 134, 270, 29);
		frame.getContentPane().add(btnVisualizzaProgrammazioneMensile);
	}

}