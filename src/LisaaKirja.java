import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class LisaaKirja extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNimi;
	private JTextField textFieldTekija;
	private JTextField textFieldVuosi;
	private JTextField textFieldIsbn;
	
//Accessorit
	public String getTextFieldNimi() {
		String kirjanNimi = textFieldNimi.getText();
		return kirjanNimi;
	}



	public void setTextFieldNimi(JTextField textFieldNimi) {
		this.textFieldNimi = textFieldNimi;
	}



	public String getTextFieldKirjailija() {
		String tekija = textFieldTekija.getText();
		return tekija;
	}



	public void setTextFieldTekija(JTextField textFieldTekija) {
		this.textFieldTekija = textFieldTekija;
	}



	public String getTextFieldVuosi() {
		String vuosi = textFieldVuosi.getText();
		return vuosi;
	}



	public void setTextFieldVuosi(JTextField textFieldVuosi) {
		this.textFieldVuosi = textFieldVuosi;
	}



	public String getTextFieldIsbn() {
		String isbn = textFieldIsbn.getText();
		return isbn;
	}



	public void setTextFieldIsbn(JTextField textFieldIsbn) {
		this.textFieldIsbn = textFieldIsbn;
	}



	/**
	 * Launch the application.
	 */
	public static void LisaaKirja() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LisaaKirja frame = new LisaaKirja();
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
	public LisaaKirja() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(600, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldNimi = new JTextField();
		textFieldNimi.setBounds(140, 13, 116, 22);
		contentPane.add(textFieldNimi);
		textFieldNimi.setColumns(10);
		
		textFieldTekija = new JTextField();
		textFieldTekija.setBounds(140, 48, 116, 22);
		contentPane.add(textFieldTekija);
		textFieldTekija.setColumns(10);
		
		textFieldVuosi = new JTextField();
		textFieldVuosi.setBounds(140, 83, 116, 22);
		contentPane.add(textFieldVuosi);
		textFieldVuosi.setColumns(10);
		
		textFieldIsbn = new JTextField();
		textFieldIsbn.setBounds(140, 118, 116, 22);
		contentPane.add(textFieldIsbn);
		textFieldIsbn.setColumns(10);
		
		//Painike kirjan tietojen lis‰‰miselle ja ikkunan sulku
		JButton btnLisaa = new JButton("Lis\u00E4\u00E4 kirja");
		btnLisaa.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 13));
		btnLisaa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				lisaaKirja();
				dispose();
				
			}
		});
		btnLisaa.setBounds(12, 215, 116, 25);
		contentPane.add(btnLisaa);
		
		JLabel lblNewLabel = new JLabel("Kirjan nimi:");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel.setBounds(12, 16, 97, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblTekij = new JLabel("Tekij\u00E4:");
		lblTekij.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 13));
		lblTekij.setBounds(12, 51, 56, 16);
		contentPane.add(lblTekij);
		
		JLabel lblJulkaisuvuosi = new JLabel("Julkaisuvuosi:");
		lblJulkaisuvuosi.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 13));
		lblJulkaisuvuosi.setBounds(12, 86, 97, 16);
		contentPane.add(lblJulkaisuvuosi);
		
		JLabel lblIsbn = new JLabel("ISBN:");
		lblIsbn.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 13));
		lblIsbn.setBounds(12, 121, 56, 16);
		contentPane.add(lblIsbn);
	}
	
	//  kirjan tietojen lis‰‰minen JTable taulukkoon
	protected void lisaaKirja() {
		
		String kirjanNimi = textFieldNimi.getText();
		String kirjailija = textFieldTekija.getText();
		String vuosi = textFieldVuosi.getText();
		String isbn = textFieldIsbn.getText();
		
		Kirja uusiKirja = new Kirja(kirjanNimi,kirjailija,vuosi,isbn);
		
		Connect.lisaaKirja(uusiKirja);
		
	}
}
