package progettoJava;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.awt.event.ActionEvent;

public class addFrame extends JFrame {

	private JPanel contentPane;
	private JTextField tesseraField;
	private JTextField nomeField;
	private JTextField cognomeField;
	private JTextField sessoField;
    private String DB_URL="jdbc:mysql://localhost:3306/progettoesame";
    private String USER="root";
    private String PASS="1234"; 
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addFrame frame = new addFrame();
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
	public addFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 403, 177);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tessera:");
		lblNewLabel.setBounds(10, 32, 59, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 63, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblCognome = new JLabel("Cognome:");
		lblCognome.setBounds(190, 63, 63, 14);
		contentPane.add(lblCognome);
		
		JLabel lblSesso = new JLabel("Sesso:");
		lblSesso.setBounds(190, 29, 46, 14);
		contentPane.add(lblSesso);
		
		JLabel lblEta = new JLabel("Eta:");
		lblEta.setBounds(10, 104, 46, 14);
		contentPane.add(lblEta);
		
		tesseraField = new JTextField();
		tesseraField.setBounds(76, 29, 86, 20);
		contentPane.add(tesseraField);
		tesseraField.setColumns(10);
		
		nomeField = new JTextField();
		nomeField.setBounds(76, 60, 86, 20);
		contentPane.add(nomeField);
		nomeField.setColumns(10);
		
		cognomeField = new JTextField();
		cognomeField.setBounds(263, 60, 86, 20);
		contentPane.add(cognomeField);
		cognomeField.setColumns(10);
		
		sessoField = new JTextField();
		sessoField.setBounds(263, 29, 86, 20);
		contentPane.add(sessoField);
		sessoField.setColumns(10);
		
		JButton submitButton = new JButton("Submit");
		submitButton.setBounds(288, 104, 89, 23);
		contentPane.add(submitButton);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99"}));
		comboBox.setBounds(76, 100, 46, 22);
		contentPane.add(comboBox);

		
		
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tessera = tesseraField.getText();
				String nome = nomeField.getText();
				String cognome = cognomeField.getText();
				int eta = Integer.parseInt(comboBox.getSelectedItem().toString());
				String sesso = sessoField.getText();
				
				
				String sql = String.format("INSERT INTO Tennista values (\"%s\",   \"%s\",   \"%s\",   \"%s\",   %d);", tessera, nome, cognome, sesso, eta);
				
				try {
					Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);	
					PreparedStatement statement = connection.prepareStatement(sql);
					statement.executeUpdate();
										
					System.out.println("Inserted value");
					
					statement.close();
					connection.close();
				} catch (SQLIntegrityConstraintViolationException c) {
					c.printStackTrace();
					JOptionPane.showMessageDialog(null, "Tessera tennista già presente");
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
				
			}
		});
		
		
		this.getRootPane().setDefaultButton(submitButton);
	}
}
