package uniandes.dpoo.taller4.interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import uniandes.dpoo.taller4.modelo.Tablero;

public  class TableroPanel extends JPanel {

private static final long serialVersionUID = 1L;
	private static final int TAMANO_SEPARACION = 4;
	private int TAMANO_TABLERO;
	private int TAMANO_CELDA;
	private Tablero tablero;

    public TableroPanel(int TAMANO_TABLERO, int TAMANO_CELDA, Tablero tablero) {
    	this.TAMANO_TABLERO = TAMANO_TABLERO;
    	this.TAMANO_CELDA = TAMANO_CELDA;
    	this.tablero = tablero;
        setPreferredSize(new Dimension(270, 270)); 
        setBackground(Color.WHITE);
    }
    
    public void setTablero (Tablero tablero) {
    	this.tablero = tablero;
    }
    public void setTAMANO_TABLERO (int tamano) {
    	this.TAMANO_TABLERO = tamano;
    }
    public void setTAMANO_CELDA (int tamano) {
    	this.TAMANO_CELDA = tamano;
    }
  

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        boolean[][] estadoTablero = tablero.darTablero(); 

        for (int i = 0; i < TAMANO_TABLERO; i++) {
            for (int j = 0; j < TAMANO_TABLERO; j++) {
                int x = j * (TAMANO_CELDA + TAMANO_SEPARACION);
                int y = i * (TAMANO_CELDA + TAMANO_SEPARACION); 

                if (estadoTablero[i][j]) {
                    ImageIcon iconoLuz = new ImageIcon("data/luz.png"); 
                    g.setColor(new Color(255, 247, 74 )); 
                    g.fillRoundRect(x, y, TAMANO_CELDA, TAMANO_CELDA, 2, 2); 
                    g.drawImage(iconoLuz.getImage(), x, y, null);

                } else {
                    ImageIcon iconoLuz = new ImageIcon("data/luz.png"); 
                    g.setColor(new Color(214, 213, 205)); 
                    g.fillRoundRect(x, y, TAMANO_CELDA, TAMANO_CELDA, 2, 2); 
                    g.drawImage(iconoLuz.getImage(), x, y, null); 
                }
            }
        }
    }
    
}




