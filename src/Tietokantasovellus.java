import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tietokantasovellus extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static JTable taulukko;
	DefaultTableModel dtm;
	
	
//taulukon accessorit
	public static JTable getTaulukko() {
		return taulukko;
	}

	public static void setTaulukko(JTable taulukko) {
		Tietokantasovellus.taulukko = taulukko;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tietokantasovellus frame = new Tietokantasovellus();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	//alunperin windowBuilderilla luotu, sittemmin käsin muutettu taulukkoelementti
	public Tietokantasovellus() {
		setTitle("Kirjasto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		taulukko = new JTable();
		taulukko.setBounds(5, 5, 522, 160);
		String[] row= {"Kirjan Nimi","Tekijä","Julkaisuvuosi","ISBN"};
		String[][] cols= {{"Kirjan Nimi","Tekijä","Julkaisuvuosi","ISBN"}};
		dtm=new DefaultTableModel(cols, row);
		taulukko.setModel(dtm);
		JScrollPane sp = new JScrollPane();
		sp.setViewportView(taulukko);
		add(sp);
		contentPane.add(taulukko);
		
		//Painike kirjan lisäykselle
		JButton btnLisaa = new JButton("Lis\u00E4\u00E4 kirja");
		btnLisaa.setBounds(5, 223, 155, 25);
		btnLisaa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				LisaaKirja.LisaaKirja();
				
			}
		});
		contentPane.add(btnLisaa);
		//Painike kirjan poistamiselle
		JButton btnPoista = new JButton("Poista valittu kirja");
		btnPoista.setBounds(175, 223, 155, 25);
		btnPoista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Connect.poistaKirja();
			}
		});
		contentPane.add(btnPoista);
		
		//Painike taulukon tyhjennykselle
		JButton btnTyhjennys = new JButton("Tyhjennä taulukko");
		btnTyhjennys.setBounds(175, 185, 155, 25);
		btnTyhjennys.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Connect.tyhjennys();
			}
		});
		contentPane.add(btnTyhjennys);
		
		//Taulukon päivitysnappi
		JButton btnNytKirjat = new JButton("N\u00E4yt\u00E4 kirjat");
		btnNytKirjat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Connect.tyhjennys();
				Connect.lataappa();
				
			}
		});
		btnNytKirjat.setBounds(5, 185, 155, 25);
		contentPane.add(btnNytKirjat);
		
		//Tervehdys -nappi
		JButton btnTervehdys = new JButton("Tervehdys!");
		btnTervehdys.setBounds(375, 185, 155, 25);
		btnTervehdys.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JOptionPane.showMessageDialog(null, "Hoi! \n"
						+ "\n"
						+ "Kiitokset mielenkiintoisesta kurssista,\n"
						+ "ja mukavaa joulun odotusta!");
			}
		});
		contentPane.add(btnTervehdys);
	}
	
	
}
