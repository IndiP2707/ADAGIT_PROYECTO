package GIT;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;




import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import java.awt.Color;
public class Principal extends JFrame {

	private JPanel contentPane;
	private JTextField textcliente;
	private JTextField textfecha;
	private JTextField textprecio;
	
	lista lista1 =new lista();
	DefaultListModel modelo = new DefaultListModel();
	DefaultListModel modelocitas= new DefaultListModel();
	int indice =0;
	private DefaultComboBoxModel modelocombo = new DefaultComboBoxModel();
	private String arreglo[]= {"SELECCIONA UN DESTINO","ACAPULCO", "HOLBOX", "ISLA MUJERES", "RIO LAGARTOS"};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 496, 383);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(136, 217, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setTitle("Destinos_México.com");
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList list = new JList();
		list.setBounds(301, 110, 161, 221);
		contentPane.add(list);
		list.setModel(modelocitas);
		
		
		JLabel lblNewLabel = new JLabel("¡ R E S E R V A R    Y A !");
		lblNewLabel.setForeground(new Color(0, 128, 192));
		lblNewLabel.setFont(new Font("Impact", Font.PLAIN, 24));
		lblNewLabel.setBounds(82, 11, 208, 35);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("CLIENTE");
		lblNewLabel_1.setFont(new Font("HP Simplified", Font.BOLD, 12));
		lblNewLabel_1.setForeground(new Color(0, 128, 192));
		lblNewLabel_1.setBounds(37, 93, 61, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("DESTINO");
		lblNewLabel_1_1.setFont(new Font("HP Simplified", Font.BOLD, 12));
		lblNewLabel_1_1.setForeground(new Color(0, 128, 192));
		lblNewLabel_1_1.setBounds(37, 133, 73, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("FECHA");
		lblNewLabel_1_1_1.setFont(new Font("HP Simplified", Font.BOLD, 12));
		lblNewLabel_1_1_1.setForeground(new Color(0, 128, 192));
		lblNewLabel_1_1_1.setBounds(37, 202, 61, 14);
		contentPane.add(lblNewLabel_1_1_1);
		
		textcliente = new JTextField();
		textcliente.setForeground(new Color(0, 0, 0));
		textcliente.setBounds(93, 90, 176, 20);
		contentPane.add(textcliente);
		textcliente.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String Seleccionada = comboBox.getSelectedItem().toString();
				if(Seleccionada.equals("ACAPULCO")) 
					textprecio.setText("2020");
					
			 if(Seleccionada.equals("HOLBOX")) 
					textprecio.setText("1500");
					
			 if(Seleccionada.equals("ISLA MUJERES")) 
					textprecio.setText("1890.50");
						
			 if(Seleccionada.equals("RIO LAGARTOS")) 
					textprecio.setText("1380");
			}
		});
		comboBox.setToolTipText("ACAPULCO\r\nHOLBOX\r\nISLA MUJERES\r\nRIO LAGARTOS");
		comboBox.setBounds(93, 130, 176, 22);
		contentPane.add(comboBox);
		for (int i=0; i<arreglo.length; i++)
			modelocombo.addElement(arreglo[i]);
		comboBox.setModel(modelocombo);
		
		textfecha = new JTextField();
		textfecha.setBounds(93, 200, 176, 20);
		contentPane.add(textfecha);
		textfecha.setColumns(10);
		
		JButton Buttonreservar = new JButton("GUARDAR");
		Buttonreservar.setBackground(new Color(255, 255, 255));
		Buttonreservar.setFont(new Font("HP Simplified", Font.BOLD, 12));
		Buttonreservar.setForeground(new Color(0, 128, 192));
		Buttonreservar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cliente1 = textcliente.getText();
		        String servicio1 = comboBox.getSelectedItem().toString();
		        float precio1 = Float.parseFloat(textprecio.getText());
		        String fecha1 = textfecha.getText();

		        reserva nuevo = new reserva(cliente1, servicio1, precio1, fecha1);
		        lista1.insertaordenadamente(nuevo);
		        
		        // Limpiar el modelo actual
		        modelocitas.clear();
		        
		        // Recorrer la lista enlazada ordenada y añadir al modelo del JList
		        reserva temp = lista1.primero;
		        indice = 0;
		        while (temp != null) {
		            String listaa = temp.getCliente() + "--" + temp.getFecha();
		            modelocitas.add(indice, listaa);
		            indice++;
		            temp = temp.siguiente;
		        }
		        
		        textcliente.setText("");
		        textprecio.setText("");
		        textfecha.setText("");

				/*

				String listaa = cliente1+"--"+fecha1;
				modelocitas.add(indice, listaa);
				indice++;
				textcliente.setText("");
				textprecio.setText("");
				textfecha.setText("");*/
				
			}
		});
		Buttonreservar.setBounds(114, 234, 131, 25);
		contentPane.add(Buttonreservar);
		
		JButton btnBuscarCita = new JButton("BUSCAR");
		btnBuscarCita.setBackground(new Color(255, 255, 255));
		btnBuscarCita.setFont(new Font("HP Simplified", Font.BOLD, 12));
		btnBuscarCita.setForeground(new Color(0, 128, 192));
		btnBuscarCita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnBuscarCita.setBounds(114, 270, 131, 25);
		contentPane.add(btnBuscarCita);
		
		JButton btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		       
			}
		});
		btnEliminar.setForeground(new Color(0, 128, 192));
		btnEliminar.setFont(new Font("HP Simplified", Font.BOLD, 12));
		btnEliminar.setBackground(Color.WHITE);
		btnEliminar.setBounds(114, 306, 131, 25);
		contentPane.add(btnEliminar);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("PRECIO");
		lblNewLabel_1_1_1_2.setForeground(new Color(0, 128, 192));
		lblNewLabel_1_1_1_2.setFont(new Font("HP Simplified", Font.BOLD, 12));
		lblNewLabel_1_1_1_2.setBounds(37, 165, 61, 14);
		contentPane.add(lblNewLabel_1_1_1_2);
		
		textprecio = new JTextField();
		textprecio.setBounds(93, 163, 176, 20);
		contentPane.add(textprecio);
		textprecio.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Conoce Destinos México");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("HP Simplified", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(100, 46, 169, 22);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("RESERVAS DEL DÍA");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("HP Simplified", Font.PLAIN, 12));
		lblNewLabel_2_1.setBounds(301, 89, 169, 22);
		contentPane.add(lblNewLabel_2_1);

		
	}
}
