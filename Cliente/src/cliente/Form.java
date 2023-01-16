package cliente;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

//esta clase es el modelo del cliente
public class Form extends javax.swing.JPanel {

    private double position;

    public Form() {
        initComponents();
        setBounds(1, 1, 288, 288);

        position = 0;

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        int width=200;
        int height=200;
                
        //calculo de la posicion del triangulo en el panel
        int centroX = (int) (getWidth() / 2);
        int centroY = (int) (getHeight() / 2);

        int[] x = {(int) (width / 2), 0, width};
        int[] y = {0, height, height};

        //casteo para poder ulizar metodos de graficos 2d
        Graphics2D g2d = (Graphics2D) g;

        //animación
        g2d.rotate(position, centroX, centroY);
        g2d.translate((int) ((getWidth() - width) / 2), (int) ((getHeight() - height) / 2));

        //creacion de dibujo
        g2d.setColor(Color.green);
        g2d.fillPolygon(x, y, 3);
        g2d.drawPolygon(x, y, 3);
    }

    //modifica la posicion de la imagen
    public void setPosition(double position) {
        this.position = position;
        repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 323, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 283, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
