package uniandes.dpoo.taller4.interfaz;


import uniandes.dpoo.taller4.modelo.RegistroTop10;
import uniandes.dpoo.taller4.modelo.Top10;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.Collection;

public class Ventana extends JFrame {

	private static final long serialVersionUID = 1L;

	public Ventana() {
        super("Top 10");
    }
    
    public void mostrarVentana() {

        Top10 top10 = new Top10();
        top10.cargarRecords(new File("data/top10.csv"));
        Collection<RegistroTop10> registros = top10.darRegistros();


        JPanel panelRegistros = new JPanel();
        panelRegistros.setLayout(new BoxLayout(panelRegistros, BoxLayout.Y_AXIS));
        panelRegistros.setBackground(Color.WHITE);

        JPanel panelTitulo = new JPanel();
        panelTitulo.setLayout(new GridLayout(1, 3));
        JLabel labelPosicion = new JLabel("#", SwingConstants.CENTER);
        JLabel labelNombre = new JLabel("Nombre", SwingConstants.LEFT);
        JLabel labelPuntos = new JLabel("Puntos", SwingConstants.LEFT);
        labelPosicion.setFont(labelPosicion.getFont().deriveFont(Font.BOLD, 16f));
        labelNombre.setFont(labelNombre.getFont().deriveFont(Font.BOLD, 16f));
        labelPuntos.setFont(labelPuntos.getFont().deriveFont(Font.BOLD, 16f));
        panelTitulo.add(labelPosicion);
        panelTitulo.add(labelNombre);
        panelTitulo.add(labelPuntos);
        panelTitulo.setBackground(new Color(160, 190, 230));
        panelRegistros.add(panelTitulo);


        int i = 1;
        Color[] colores = {Color.GREEN.darker(), Color.GREEN.darker(), Color.GREEN.darker(), Color.BLUE.darker(), Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK};
        for (RegistroTop10 registro : registros) {
            JPanel panelRegistro = new JPanel(new GridLayout(1, 3));
            JLabel posicionLabel = new JLabel(i + ".", SwingConstants.CENTER);
            JLabel nombreLabel = new JLabel(registro.darNombre(), SwingConstants.LEFT);
            JLabel puntosLabel = new JLabel(registro.darPuntos() + " puntos", SwingConstants.LEFT);

            
            posicionLabel.setForeground(colores[i-1]);
            nombreLabel.setForeground(colores[i-1]);
            puntosLabel.setForeground(colores[i-1]);
            posicionLabel.setFont(posicionLabel.getFont().deriveFont(Font.BOLD, 16f));
            nombreLabel.setFont(nombreLabel.getFont().deriveFont(Font.BOLD, 16f));
            puntosLabel.setFont(puntosLabel.getFont().deriveFont(Font.BOLD, 16f));
            panelRegistro.add(posicionLabel);
            panelRegistro.add(nombreLabel);
            panelRegistro.add(puntosLabel);

            panelRegistros.add(panelRegistro);
            i++;
        }


        JScrollPane scrollPane = new JScrollPane(panelRegistros);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);


        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.add(scrollPane, BorderLayout.CENTER);


        setContentPane(panelPrincipal);
        setSize(350, 240);
        setLocationRelativeTo(null);
        setVisible(true);
    }        
  
}


