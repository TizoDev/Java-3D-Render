package render;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import figures.PrismaR;
import figures.Pyramid;

public class GeneratorWindow implements ActionListener 
{
	private JFrame frmGenerator;
	private JPanel upPanel = new JPanel();
	private JPanel downPanel = new JPanel();
	private JPanel centerPanel = new JPanel();
	private final JLabel label1 = new JLabel("Seleccion de Objetos");
	private final JButton generatorButton = new JButton("Generar");
	private final JPanel centerDownPanel = new JPanel();
	private final JPanel panel = new JPanel();
	private final JLabel lblNewLabel = new JLabel("Seleccionar Propiedades");
	private final JPanel panel_1 = new JPanel();
	private final JPanel linea1 = new JPanel();
	private final JPanel panel_2 = new JPanel();
	private final JPanel panel_3 = new JPanel();
	private final JLabel lblNewLabel_1 = new JLabel("1- Posicion X");
	private final JTextField tf1 = new JTextField();
	private final JPanel linea1_1 = new JPanel();
	private final JPanel panel_2_1 = new JPanel();
	private final JLabel lblNewLabel_1_1 = new JLabel("2- Posicion Y");
	private final JPanel panel_3_1 = new JPanel();
	private final JTextField tf2 = new JTextField();
	private final JPanel linea1_2 = new JPanel();
	private final JPanel panel_2_2 = new JPanel();
	private final JLabel lblNewLabel_1_2 = new JLabel("3- Posicion Z");
	private final JPanel panel_3_2 = new JPanel();
	private final JTextField tf3 = new JTextField();
	private final JPanel linea1_3 = new JPanel();
	private final JPanel panel_2_3 = new JPanel();
	private final JLabel lblNewLabel_1_3 = new JLabel("4- Color");
	private final JPanel panel_3_3 = new JPanel();
	private final JTextField tf4 = new JTextField();
	private final JPanel linea1_4 = new JPanel();
	private final JPanel panel_2_4 = new JPanel();
	private final JLabel lblNewLabel_1_4 = new JLabel("5- Altura");
	private final JPanel panel_3_4 = new JPanel();
	private final JTextField tf5 = new JTextField();
	private final JPanel linea1_5 = new JPanel();
	private final JPanel panel_2_5 = new JPanel();
	private final JLabel lblNewLabel_1_5 = new JLabel("6- Anchura");
	private final JPanel panel_3_5 = new JPanel();
	private final JTextField tf6 = new JTextField();
	private final JPanel linea1_6 = new JPanel();
	private final JPanel panel_2_6 = new JPanel();
	private final JLabel lblNewLabel_1_6 = new JLabel("7- Profundidad");
	private final JPanel panel_3_6 = new JPanel();
	private final JTextField tf7 = new JTextField();
	private final JPanel linea1_7 = new JPanel();
	private final JPanel panel_2_7 = new JPanel();
	private final JLabel lblNewLabel_1_7 = new JLabel("8- Tamaño");
	private final JPanel panel_3_7 = new JPanel();
	private final JTextField tf8 = new JTextField();
	private final JPanel linea1_9 = new JPanel();
	private final JLabel errors = new JLabel("...");
	
	private final JList<String> list = new JList<String>();
	private DefaultListModel<String> modeloLista = new DefaultListModel<String>();

	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() {
				try {
					GeneratorWindow window = new GeneratorWindow();
					window.frmGenerator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public GeneratorWindow() 
	{
		initialize();
	}


	private void initialize() 
	{
		tf1.setText("0");
		tf1.setColumns(10);
		frmGenerator = new JFrame();
		frmGenerator.setTitle("Generator");
		frmGenerator.setResizable(false);
		frmGenerator.setBounds(920, 0, 450, 720);
		frmGenerator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		upPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		frmGenerator.getContentPane().add(upPanel, BorderLayout.NORTH);
		
		upPanel.add(label1);
		downPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		frmGenerator.getContentPane().add(downPanel, BorderLayout.SOUTH);
		generatorButton.addActionListener(this);
		
		downPanel.add(generatorButton);
		centerPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		frmGenerator.getContentPane().add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(new GridLayout(2, 1, 0, 0));
		
		centerPanel.add(list);
		
		centerPanel.add(centerDownPanel);
		centerDownPanel.setLayout(new BorderLayout(0, 0));
		
		centerDownPanel.add(panel, BorderLayout.NORTH);
		
		panel.add(lblNewLabel);
		
		centerDownPanel.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(9, 1, 0, 0));
		
		panel_1.add(linea1);
		linea1.setLayout(new GridLayout(1, 2, 0, 0));
		
		linea1.add(panel_2);
		
		panel_2.add(lblNewLabel_1);
		
		linea1.add(panel_3);
		
		panel_3.add(tf1);
		
		panel_1.add(linea1_1);
		linea1_1.setLayout(new GridLayout(1, 2, 0, 0));
		
		linea1_1.add(panel_2_1);
		
		panel_2_1.add(lblNewLabel_1_1);
		
		linea1_1.add(panel_3_1);
		tf2.setText("0");
		tf2.setColumns(10);
		
		panel_3_1.add(tf2);
		
		panel_1.add(linea1_2);
		linea1_2.setLayout(new GridLayout(1, 2, 0, 0));
		
		linea1_2.add(panel_2_2);
		
		panel_2_2.add(lblNewLabel_1_2);
		
		linea1_2.add(panel_3_2);
		tf3.setText("0");
		tf3.setColumns(10);
		
		panel_3_2.add(tf3);
		
		panel_1.add(linea1_3);
		linea1_3.setLayout(new GridLayout(1, 2, 0, 0));
		
		linea1_3.add(panel_2_3);
		
		panel_2_3.add(lblNewLabel_1_3);
		
		linea1_3.add(panel_3_3);
		tf4.setText("RED");
		tf4.setColumns(10);
		
		panel_3_3.add(tf4);
		
		panel_1.add(linea1_4);
		linea1_4.setLayout(new GridLayout(1, 2, 0, 0));
		
		linea1_4.add(panel_2_4);
		
		panel_2_4.add(lblNewLabel_1_4);
		
		linea1_4.add(panel_3_4);
		tf5.setText("1");
		tf5.setColumns(10);
		
		panel_3_4.add(tf5);
		
		panel_1.add(linea1_5);
		linea1_5.setLayout(new GridLayout(1, 2, 0, 0));
		
		linea1_5.add(panel_2_5);
		
		panel_2_5.add(lblNewLabel_1_5);
		
		linea1_5.add(panel_3_5);
		tf6.setText("1");
		tf6.setColumns(10);
		
		panel_3_5.add(tf6);
		
		panel_1.add(linea1_6);
		linea1_6.setLayout(new GridLayout(1, 2, 0, 0));
		
		linea1_6.add(panel_2_6);
		
		panel_2_6.add(lblNewLabel_1_6);
		
		linea1_6.add(panel_3_6);
		tf7.setText("1");
		tf7.setColumns(10);
		
		panel_3_6.add(tf7);
		
		panel_1.add(linea1_7);
		linea1_7.setLayout(new GridLayout(1, 2, 0, 0));
		
		linea1_7.add(panel_2_7);
		
		panel_2_7.add(lblNewLabel_1_7);
		
		linea1_7.add(panel_3_7);
		tf8.setText("1");
		tf8.setColumns(10);
		
		panel_3_7.add(tf8);
		
		panel_1.add(linea1_9);
		linea1_9.setLayout(new GridLayout(1, 2, 0, 0));
		errors.setHorizontalAlignment(SwingConstants.CENTER);
		
		linea1_9.add(errors);
		
		this.list.setModel(modeloLista);
		modeloLista.add(0, "Prisma Rectangular");
		modeloLista.add(1, "Piramide");
		modeloLista.add(2, "Plano");
		modeloLista.add(3, "Esfera");
	}

	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource() == generatorButton) 
		{
			do_generatorButton_actionPerformed(e);
		}
	}
	
	protected int do_generatorButton_actionPerformed(ActionEvent e) 
	{
		errors.setText("...");
		if(list.isSelectionEmpty())
		{
			errors.setText("Error, seleccionar figura");
			return 0;
		}
		
		double x, y, z, width, height, depth, size;
		Color c;
		
		if(list.isSelectedIndex(0)) //Rectangulo
		{
			try
			{
				x = Integer.parseInt(tf1.getText());
			}catch(Exception p)
			{
				errors.setText("Error, valor incorrecto en campo de texto 1");
				x = 0;
				return 0;
			}
			try
			{
				y = Integer.parseInt(tf2.getText());
			}catch(Exception p)
			{
				errors.setText("Error, valor incorrecto en campo de texto 2");
				y = 0;
				return 0;
			}
			try
			{
				z = Integer.parseInt(tf3.getText());
			}catch(Exception p)
			{
				errors.setText("Error, valor incorrecto en campo de texto 3");
				z = 0;
				return 0;
			}
			try 
			{
			    Field field = Class.forName("java.awt.Color").getField(tf4.getText());
			    c = (Color)field.get(null);
			}catch (Exception p) 
			{
				errors.setText("Error, valor incorrecto en campo de texto 5");
			    c = null; 
			    return 0;
			}
			try
			{
				height = Integer.parseInt(tf5.getText());
			}catch(Exception p)
			{
				errors.setText("Error, valor incorrecto en campo de texto 5");
				height = 0;
				return 0;
			}
			try
			{
				width = Integer.parseInt(tf6.getText());
			}catch(Exception p)
			{
				errors.setText("Error, valor incorrecto en campo de texto 6");
				width = 0;
				return 0;
			}
			try
			{
				depth = Integer.parseInt(tf7.getText());
			}catch(Exception p)
			{
				errors.setText("Error, valor incorrecto en campo de texto 7");
				depth = 0;
				return 0;
			}
			try
			{
				size = Integer.parseInt(tf8.getText());
			}catch(Exception p)
			{
				errors.setText("Error, valor incorrecto en campo de texto 8");
				size = 0;
				return 0;
			}
			
			new PrismaR(x,y,z,depth,width,height,c,size);
		}
		if(list.isSelectedIndex(1)) //Piramide
		{
			try
			{
				x = Integer.parseInt(tf1.getText());
			}catch(Exception p)
			{
				errors.setText("Error, valor incorrecto en campo de texto 1");
				x = 0;
				return 0;
			}
			try
			{
				y = Integer.parseInt(tf2.getText());
			}catch(Exception p)
			{
				errors.setText("Error, valor incorrecto en campo de texto 2");
				y = 0;
				return 0;
			}
			try
			{
				z = Integer.parseInt(tf3.getText());
			}catch(Exception p)
			{
				errors.setText("Error, valor incorrecto en campo de texto 3");
				z = 0;
				return 0;
			}
			try 
			{
			    Field field = Class.forName("java.awt.Color").getField(tf4.getText());
			    c = (Color)field.get(null);
			}catch (Exception p) 
			{
				errors.setText("Error, valor incorrecto en campo de texto 5");
			    c = null; 
			    return 0;
			}
			try
			{
				height = Integer.parseInt(tf5.getText());
			}catch(Exception p)
			{
				errors.setText("Error, valor incorrecto en campo de texto 5");
				height = 0;
				return 0;
			}
			try
			{
				width = Integer.parseInt(tf6.getText());
			}catch(Exception p)
			{
				errors.setText("Error, valor incorrecto en campo de texto 6");
				width = 0;
				return 0;
			}
			try
			{
				depth = Integer.parseInt(tf7.getText());
			}catch(Exception p)
			{
				errors.setText("Error, valor incorrecto en campo de texto 7");
				depth = 0;
				return 0;
			}
			try
			{
				size = Integer.parseInt(tf8.getText());
			}catch(Exception p)
			{
				errors.setText("Error, valor incorrecto en campo de texto 8");
				size = 0;
				return 0;
			}
			
			new Pyramid(x,y,z,depth,width,height,c,size);
		}
		
		
		
		return 1;
	}
}
