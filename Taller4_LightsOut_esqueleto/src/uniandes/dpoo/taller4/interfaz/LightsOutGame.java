package uniandes.dpoo.taller4.interfaz;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.formdev.flatlaf.FlatLightLaf;
import uniandes.dpoo.taller4.modelo.Tablero;
import uniandes.dpoo.taller4.modelo.Top10;

public class LightsOutGame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int TAMANO_CELDA = 50; 
	private int TAMANO_TABLERO = 5; 
	private int NIVEL_DIFICULTAD = 10; 
	private Tablero tablero;
	private TableroPanel tableroPanel; 

	
	public LightsOutGame() {
	    setTitle("LightsOut");
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        JPanel etiquetasPanel = new JPanel();
        etiquetasPanel.setLayout(new FlowLayout());
        etiquetasPanel.setBackground(new Color(160, 190, 230));
        JLabel jugadasLabel = new JLabel("Jugadas:     ");
        JTextField contadorJugadas = new JTextField();
        contadorJugadas.setPreferredSize(new Dimension(120, 25));  
	    setLayout(new BorderLayout());
	    JLabel tamanoLabel = new JLabel("Tamaño: ");
	    

	    String[] tamanoOptions = { "5x5", "3x3", "4x4" };
	    JComboBox<String> tamanoComboBox = new JComboBox<>(tamanoOptions);
	    Dimension nuevoTamano = new Dimension(100, 20);
	    tamanoComboBox.setPreferredSize(nuevoTamano);
	    tamanoComboBox.setBackground(Color.WHITE);
	    tamanoComboBox.setForeground(Color.BLACK);
	    tamanoComboBox.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            String tamanoSeleccionado = (String) tamanoComboBox.getSelectedItem();


	            TAMANO_TABLERO = Integer.parseInt(tamanoSeleccionado.substring(0, 1));
	            tableroPanel.setTAMANO_TABLERO(TAMANO_TABLERO);
	            tablero = new Tablero(TAMANO_TABLERO); 
	            tablero.desordenar(NIVEL_DIFICULTAD);
                contadorJugadas.setText(Integer.toString(tablero.darJugadas()));
	            
	        }
	    });
	    JLabel dificultadLabel = new JLabel("Dificultad: ");
	    JRadioButton facilRadioButton = new JRadioButton("Facil");
	    facilRadioButton.setBackground(new Color(160, 190, 230)); 
	    facilRadioButton.setForeground(Color.WHITE);
	    JRadioButton medioRadioButton = new JRadioButton("Medio");
	    medioRadioButton.setBackground(new Color(160, 190, 230)); 
	    medioRadioButton.setForeground(Color.WHITE);
	    JRadioButton dificilRadioButton = new JRadioButton("Dificil");
	    dificilRadioButton.setBackground(new Color(160, 190, 230)); 
	    dificilRadioButton.setForeground(Color.WHITE);

	    ButtonGroup dificultadGroup = new ButtonGroup();
	    dificultadGroup.add(facilRadioButton);
	    dificultadGroup.add(medioRadioButton);
	    dificultadGroup.add(dificilRadioButton);
	    medioRadioButton.setSelected(true);

	    facilRadioButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            NIVEL_DIFICULTAD = 5;
                tablero = new Tablero(TAMANO_TABLERO);
	            tablero.desordenar(NIVEL_DIFICULTAD); 
	            tableroPanel.setTablero(tablero);
	            tableroPanel.repaint();
                contadorJugadas.setText(Integer.toString(tablero.darJugadas()));
	        }
	    });
	    

	    medioRadioButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            NIVEL_DIFICULTAD = 10; 
                tablero = new Tablero(TAMANO_TABLERO);
	            tablero.desordenar(NIVEL_DIFICULTAD); 
	            tableroPanel.setTablero(tablero);
	            tableroPanel.repaint(); 
                contadorJugadas.setText(Integer.toString(tablero.darJugadas()));
	        }
	    });

   
	    dificilRadioButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            NIVEL_DIFICULTAD = 20;
                tablero = new Tablero(TAMANO_TABLERO);
	            tablero.desordenar(NIVEL_DIFICULTAD); 
	            tableroPanel.setTablero(tablero);
	            tableroPanel.repaint();
                contadorJugadas.setText(Integer.toString(tablero.darJugadas()));
	        }
	    });

        JPanel comboBoxPanel = new JPanel();
        comboBoxPanel.setLayout(new FlowLayout());
        comboBoxPanel.setBackground(new Color(160, 190, 230));
        tamanoLabel.setForeground(Color.WHITE); 
        dificultadLabel.setForeground(Color.WHITE); 
	    comboBoxPanel.add(tamanoLabel, BorderLayout.WEST);
        comboBoxPanel.add(tamanoComboBox);
        comboBoxPanel.add(dificultadLabel, BorderLayout.WEST);
        comboBoxPanel.add(facilRadioButton);
        comboBoxPanel.add(medioRadioButton);
        comboBoxPanel.add(dificilRadioButton);
        add(comboBoxPanel, BorderLayout.NORTH);
        
        tablero = new Tablero(TAMANO_TABLERO); 
        tablero.desordenar(NIVEL_DIFICULTAD); 
        contadorJugadas.setText(Integer.toString(tablero.darJugadas()));
        JLabel jugadorLabel = new JLabel("Jugador: ");
        JTextField nombreJugador = new JTextField();
        nombreJugador.setPreferredSize(new Dimension(120, 25));


        etiquetasPanel.add(jugadasLabel, BorderLayout.WEST);
        etiquetasPanel.add(contadorJugadas);
        etiquetasPanel.add(jugadorLabel, BorderLayout.WEST);
        etiquetasPanel.add(nombreJugador);     
        add(etiquetasPanel, BorderLayout.SOUTH);
        tableroPanel = new TableroPanel(TAMANO_TABLERO, TAMANO_CELDA,tablero);
        tableroPanel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {

                int fila = e.getY() / TAMANO_CELDA;
                int columna = e.getX() / TAMANO_CELDA;

                tablero.jugar(fila, columna); 
                tableroPanel.setTablero(tablero);
                tableroPanel.repaint();     

                contadorJugadas.setText(Integer.toString(tablero.darJugadas()));
            
                Top10 top10 = new Top10();
                top10.cargarRecords(new File("data/top10.csv"));

                if (tablero.tableroIluminado()) {
                    JOptionPane.showMessageDialog(null, "�Felicidades! Has completado el juego.");
                    
                    int puntaje = tablero.calcularPuntaje();
                    JOptionPane.showMessageDialog(null, "Tu puntaje es: " + puntaje);

                    if (top10.esTop10(puntaje)) {
                        top10.agregarRegistro(nombreJugador.getText(), puntaje); 
                    }
                    
                    try {
                        top10.salvarRecords(new File("data/top10.csv"));
                    } catch (FileNotFoundException | UnsupportedEncodingException e1) {
                        e1.printStackTrace();
                    }

                    int opcion = JOptionPane.showConfirmDialog(null, "�Quieres jugar de nuevo?", "Jugar de nuevo", JOptionPane.YES_NO_OPTION);
                    if (opcion == JOptionPane.YES_OPTION) {
                        tablero = new Tablero(TAMANO_TABLERO);
        	            tablero.desordenar(NIVEL_DIFICULTAD); 
        	            tableroPanel.setTablero(tablero);
        	            tableroPanel.repaint();
                        contadorJugadas.setText(Integer.toString(tablero.darJugadas()));
                    } else {
                        System.exit(0);
                    }
                } else {

                }
            }
        });
        
        add(tableroPanel, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null); 
        setVisible(true); 

        JPanel panelBotones = new JPanel();
        BoxLayout boxLayout = new BoxLayout(panelBotones, BoxLayout.Y_AXIS);
        panelBotones.setLayout(boxLayout);
        panelBotones.setAlignmentX(Component.CENTER_ALIGNMENT); 
        panelBotones.setBackground(Color.WHITE);
   
        JButton nuevoButton = new JButton("NUEVO");
        nuevoButton.setBackground(new Color(160, 190, 230));
        nuevoButton.setForeground(Color.WHITE);
        nuevoButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        nuevoButton.setMaximumSize(new Dimension(180, 30)); 
        nuevoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tablero = new Tablero(TAMANO_TABLERO);
                tablero.desordenar(NIVEL_DIFICULTAD);
	            tableroPanel.setTablero(tablero);
                tableroPanel.repaint();
                contadorJugadas.setText(Integer.toString(tablero.darJugadas()));
            }
        });
        panelBotones.add(Box.createVerticalStrut(10));
        panelBotones.add(nuevoButton); 

        
        JButton reiniciarButton = new JButton("REINICIAR");
        reiniciarButton.setBackground(new Color(160, 190, 230));
        reiniciarButton.setForeground(Color.WHITE);
        reiniciarButton.setAlignmentX(Component.CENTER_ALIGNMENT); 
        reiniciarButton.setMaximumSize(new Dimension(180, 30)); 
        reiniciarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tablero.reiniciar();
                tableroPanel.setTablero(tablero);
                tableroPanel.repaint();
                contadorJugadas.setText(Integer.toString(tablero.darJugadas()));
            }
        });
        panelBotones.add(Box.createVerticalStrut(10)); 
        panelBotones.add(reiniciarButton); 


        JButton top10Button = new JButton("TOP-10");
        top10Button.setBackground(new Color(160, 190, 230));
        top10Button.setForeground(Color.WHITE);
        top10Button.setAlignmentX(Component.CENTER_ALIGNMENT); 
        top10Button.setMaximumSize(new Dimension(180, 30)); 
        top10Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Ventana ventana = new Ventana();
                ventana.mostrarVentana();
            }
        });

        panelBotones.add(Box.createVerticalStrut(10)); 
        panelBotones.add(top10Button); 
   

        JButton cambiarJugadoresButton = new JButton("CAMBIAR JUGADOR");
        cambiarJugadoresButton.setBackground(new Color(160, 190, 230));
        cambiarJugadoresButton.setForeground(Color.WHITE);
        cambiarJugadoresButton.setAlignmentX(Component.CENTER_ALIGNMENT); 
        cambiarJugadoresButton.setMaximumSize(new Dimension(180, 30)); 
        
        cambiarJugadoresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String nuevoNombre = JOptionPane.showInputDialog(null, "Ingresa tu nombre:", "Cambiar Jugador",
                        JOptionPane.INFORMATION_MESSAGE);

                if (nuevoNombre != null && !nuevoNombre.isEmpty()) {
                    nombreJugador.setText(nuevoNombre);
                } else {

                    JOptionPane.showMessageDialog(null, "A�n no has ingresado tu nombre", "Mensaje",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        
        panelBotones.add(Box.createVerticalStrut(10)); 
        panelBotones.add(cambiarJugadoresButton); 

        add(panelBotones, BorderLayout.EAST); 
        pack(); 
        setLocationRelativeTo(null);     

    }

    public static void main(String[] args) {
    	FlatLightLaf.install();
        LightsOutGame juego = new LightsOutGame();
        juego.setVisible(true);
    }
}




