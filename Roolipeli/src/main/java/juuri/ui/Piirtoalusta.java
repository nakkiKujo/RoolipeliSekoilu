package juuri.ui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import juuri.sovelluslogiikka.peli.Peli;

public class Piirtoalusta extends JPanel {

    private Peli peli;

    public Piirtoalusta(Peli epeli) {
        super.setBackground(Color.BLACK);
        this.peli = epeli;
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        peli.piirra(graphics);
    }
}
