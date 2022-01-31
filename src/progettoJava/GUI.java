/*
		TODO

*/

package progettoJava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class GUI {

	private JFrame frame;
	
    private String DB_URL="jdbc:mysql://localhost:3306/progettoesame";
    private String USER="root";
    private String PASS="1234"; 
	
	private String query1 = "SELECT * \r\n"
	    		+ "FROM Tennista as t\r\n"
	    		+ "WHERE t.Eta >= 18 AND (t.Sesso = \"Maschio\" OR t.Sesso = \"Femmina\")\r\n"
	    		+ "ORDER BY t.Eta;";
	    
	private String query2 = "SELECT m.MatricolaConi, m.Nome, m.Cognome\r\n"
			+ "FROM Maestro as m JOIN Insegnamento as i ON m.MatricolaConi = i.MatricolaConi\r\n"
			+ "WHERE i.Codice = 1001\r\n"
			+ ";";
	    
	private String query3 = "SELECT Sum(t.IncassoTotale)\r\n"
	    		+ "FROM Torneo as t\r\n"
	    		+ ";";
	    
	private String query4 = "SELECT AVG(t.Eta)\r\n"
	    		+ "FROM Tennista as t\r\n"
	    		+ "GROUP BY t.Sesso\r\n"
	    		+ ";";
	    
	private String query5 = "SELECT t.Nome, t.Citta, t.IncassoTotale\r\n"
	    		+ "FROM Torneo as t\r\n"
	    		+ "GROUP BY t.Nome, t.Citta\r\n"
	    		+ "HAVING t.IncassoTotale > 50\r\n"
	    		+ ";";
	    
	private String query6 = "SELECT t.Citta, t.Nome, t.IncassoTotale\r\n"
	    		+ "FROM Torneo as t\r\n"
	    		+ "GROUP BY t.Nome, t.Citta\r\n"
	    		+ "HAVING t.IncassoTotale >= ALL (\r\n"
	    		+ "	SELECT t1.IncassoTotale\r\n"
	    		+ "    FROM Torneo as t1\r\n"
	    		+ "    GROUP BY t1.Nome, t1.Citta\r\n"
	    		+ "    )";
	    
	private String query7 = "SELECT t.Nome, t.Citta\r\n"
	    		+ "FROM Torneo as t\r\n"
	    		+ "WHERE t.giorno NOT IN (\r\n"
	    		+ "	SELECT t1.giorno\r\n"
	    		+ "    FROM Torneo as t1\r\n"
	    		+ "    WHERE t1.giorno >= \"2022-03-01\" AND t1.giorno <= \"2022-03-31\"\r\n"
	    		+ "    )\r\n"
	    		+ ";";
	    
	private String query8 = "SELECT Tennista.Tessera, Tennista.Nome, Tennista.Cognome\r\n"
	    		+ "FROM Tennista\r\n"
	    		+ "WHERE NOT EXISTS (\r\n"
	    		+ "	SELECT *\r\n"
	    		+ "    FROM Torneo\r\n"
	    		+ "    WHERE Torneo.Citta = \"Pagani\" AND NOT EXISTS (\r\n"
	    		+ "			SELECT *\r\n"
	    		+ "            FROM Partecipare\r\n"
	    		+ "            WHERE Partecipare.Tessera = Tennista.Tessera AND Torneo.Citta = Partecipare.Citta AND Torneo.Nome = Partecipare.Nome\r\n"
	    		+ "		)\r\n"
	    		+ "    )\r\n"
	    		+ ";\r\n"
	    		+ "";
	private JTextField textFieldTessera;
	private JTextField textFieldEta;
	    
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 574, 385);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Query 1", "Query 2", "Query 3", "Query 4", "Query 5", "Query 6", "Query 7", "Query 8"}));
		comboBox.setBounds(10, 11, 100, 30);
		frame.getContentPane().add(comboBox);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 146, 538, 189);
		frame.getContentPane().add(textArea);
		
		JButton submitButton = new JButton("Submit");
		submitButton.setBounds(10, 58, 89, 23);
		frame.getContentPane().add(submitButton);
		
		JTextArea textAreaTop = new JTextArea();
		textAreaTop.setBounds(10, 116, 538, 30);
		frame.getContentPane().add(textAreaTop);
		
		JButton stampaButton = new JButton("Stampa");
		stampaButton.setBounds(260, 58, 81, 23);
		frame.getContentPane().add(stampaButton);
		
		JButton editButton = new JButton("Modifica");
		editButton.setBounds(351, 58, 85, 23);
		frame.getContentPane().add(editButton);
		
		JButton removeButton = new JButton("Rimozione");
		removeButton.setBounds(449, 58, 99, 23);
		frame.getContentPane().add(removeButton);
		
		textFieldTessera = new JTextField();
		textFieldTessera.setBounds(344, 21, 72, 20);
		frame.getContentPane().add(textFieldTessera);
		textFieldTessera.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Tessera: ");
		lblNewLabel.setBounds(282, 27, 62, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Eta: ");
		lblNewLabel_1.setBounds(452, 27, 34, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		textFieldEta = new JTextField();
		textFieldEta.setBounds(486, 21, 62, 20);
		frame.getContentPane().add(textFieldEta);
		textFieldEta.setColumns(10);
		
		JButton addButton = new JButton("Aggiungi");
		addButton.setBounds(159, 58, 90, 23);
		frame.getContentPane().add(addButton);
		
		JTextArea descriptionArea = new JTextArea();
		descriptionArea.setBounds(10, 95, 538, 22);
		frame.getContentPane().add(descriptionArea);

		
		
		
		// CONNESSIONE
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textArea.setText("");
				textAreaTop.setText("");
				String queryExecuted ="";
				String descrizione ="";
				
				switch (comboBox.getSelectedItem().toString()) {
				case "Query 1" ->{
					queryExecuted = query1;
					descrizione = "Stampare tutti i tennisti con età maggiore/uguale di 18";
				}

				case "Query 2" ->{					
					queryExecuted = query2;
					descrizione = "Stampare i maestri che insegnano alla lezione con codice 1001\r\n"
							+ "";
				}

				case "Query 3" ->{
					queryExecuted = query3;
					descrizione = "Stampare la somma di tutti gli incassi totali dei tornei\r\n"
							+ "";
				}

				case "Query 4" ->{
					queryExecuted = query4;
					descrizione = "Stampare la media di età tra i tennisti maschi e tennisti femmine\r\n"
							+ "";
				}
				
				case "Query 5" ->{
					queryExecuted = query5;
					descrizione = "Stampare i tornei il cui Incasso Totale è maggiore di 50\r\n"
							+ "";
				}
				
				case "Query 6" ->{
					queryExecuted = query6;
					descrizione = "Stampare il torneo che possiede l'incasso totale più alto\r\n"
							+ "";
				}
				
				case "Query 7" ->{
					queryExecuted = query7;
					descrizione = "Selezionare il nome e la città dei tornei che non si svolgono a Marzo\r\n"
							+ "";
				}
				
				case "Query 8" ->{
					queryExecuted = query8;
					descrizione = "Tessera, nome e cognome di tutti i tennisti che partecipano ai tornei di Pagani\r\n"
							+ "";
				}
				
				default ->
				throw new IllegalArgumentException("Unexpected value: " + comboBox);
				}
				
		
				try {
					Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);	
					PreparedStatement statement = connection.prepareStatement(queryExecuted);
					ResultSet result = statement.executeQuery(queryExecuted);
					ResultSetMetaData rsmd = result.getMetaData();
					
					int k = 1;
					
					while (result.next()) {						
						for (int i = 1; i <= rsmd.getColumnCount(); i++) {
							if (k == i) {
								textAreaTop.append(rsmd.getColumnName(k) + "\t");								
								k++;
							}
							
							textArea.append(result.getString(i) + "\t");
						}
						
						textArea.append("\n");
					}
					
					descriptionArea.setText("Descrizione: " + descrizione);
					
					statement.close();
					connection.close();
				} catch (SQLException ex) {
					System.out.println("Cannot connect");
					ex.printStackTrace();
				}
				
			}
		});
	    
		
		// STAMPA TUTTI I TENNISTI
		stampaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String queryStampa = "SELECT * FROM Tennista;";
				
				textArea.setText("");
				textAreaTop.setText("");
				descriptionArea.setText("Stampa di tutti i tennisti");
				
				try {
					Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);	
					PreparedStatement statement = connection.prepareStatement(queryStampa);
					ResultSet result = statement.executeQuery(queryStampa);
					ResultSetMetaData rsmd = result.getMetaData();
					
					int k = 1;
					
					while (result.next()) {						
						for (int i = 1; i <= rsmd.getColumnCount(); i++) {							
							if (k == i) {
								textAreaTop.append(rsmd.getColumnName(k) + "\t");								
								k++;
							}
							
							textArea.append(result.getString(i) + "\t");
						}
						
						textArea.append("\n");
					}
					
					
					statement.close();
					connection.close();
				} catch (SQLException ex) {
					System.out.println("Cannot connect");
					ex.printStackTrace();
				}
			}
		});
		
		
		
		// MODIFICA
		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int tessera = Integer.parseInt(textFieldTessera.getText());
				int eta  = Integer.parseInt(textFieldEta.getText());
				
				String updateQuery = "UPDATE Tennista\r\n"
						+ "SET Tennista.Eta = " + eta + "\r\n" 
						+ "WHERE Tennista.Tessera = " + tessera + ";";
				
				String queryRichiestaTessera = "SELECT t.Tessera FROM Tennista as t WHERE t.Tessera = \"" + tessera + "\" ;" ;
				
				try {
					Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);	
					
					PreparedStatement verificaTessera = connection.prepareStatement(queryRichiestaTessera);
					ResultSet result = verificaTessera.executeQuery(queryRichiestaTessera);
					
					// evento che triggera l'exception
					if (result.next())
						System.out.println(result.getString(1));						
					
					PreparedStatement editStatement = connection.prepareStatement(updateQuery);
					editStatement.executeUpdate();
										
					
					JOptionPane.showMessageDialog(null, "Modifica avvenuta");
					
					editStatement.close();
					connection.close();
					stampaButton.doClick();
				} catch (SQLException ex) {
					JOptionPane.showMessageDialog(null, "Tessera non valida");
					ex.printStackTrace();
				} catch (NumberFormatException n) {
					JOptionPane.showMessageDialog(null, "Formato tessera non valida");
					n.printStackTrace();
				}
				
			}
		});

		
		
		
		// RIMOZIONE
		removeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try {
					int tessera = Integer.parseInt(textFieldTessera.getText());
					
					String update1 = "SET FOREIGN_KEY_CHECKS=0;";
					String sql = "DELETE FROM Tennista WHERE Tennista.Tessera = " + tessera + ";";
					String update2 = "SET FOREIGN_KEY_CHECKS=1;";
					String queryRichiestaTessera = "SELECT t.Tessera FROM Tennista as t WHERE t.Tessera = \"" + tessera + "\" ;" ;

					
					Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);	

					PreparedStatement verificaTessera = connection.prepareStatement(queryRichiestaTessera);
					ResultSet result = verificaTessera.executeQuery(queryRichiestaTessera);		
					
					PreparedStatement statementUpd1 = connection.prepareStatement(update1);
					PreparedStatement statement = connection.prepareStatement(sql);
					PreparedStatement statementUpd2 = connection.prepareStatement(update2);
					
					statementUpd1.executeUpdate();					
					statement.executeUpdate();
					statementUpd2.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "Rimozione avvenuta");
					
					statement.close();
					connection.close();
					result.close();
					stampaButton.doClick();
				} catch (SQLException ex) {
					JOptionPane.showMessageDialog(null, "Tessera non valida");
					ex.printStackTrace();
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Formato tessera non valida");
					ex.printStackTrace();
				}
			
			}
		});
	
	
		// AGGIUNTA TENNISTA
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addFrame frameAggiunta = new addFrame();
				frameAggiunta.setVisible(true);
				
			}
		});
	
	
	
	
	}
}
