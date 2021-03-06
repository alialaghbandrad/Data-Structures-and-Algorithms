/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day06trianglefractalharderali;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 *
 * @author alagh
 */
public class TriangleHarderPanel extends javax.swing.JPanel {
    
    private Color [] colorArray = {
        new Color(255, 90, 90), // level 0 color: red
        new Color(0, 200, 0),   // level 1 color: green
        new Color(90, 90, 255), // level 2 color: blue
        new Color(10, 10, 84),  // level 3 color: dark blue
        new Color(22, 21, 61),
        new Color(21, 98, 69),
        new Color(217, 146, 54),
        new Color(63, 121, 186),
        new Color(131, 121, 11)
    };

    /**
     * Creates new form TriangleHarderPanel
     */
    public TriangleHarderPanel() {
        // initComponents();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        int x1 = 5, x2 = getWidth()-5; // base is 300
        int y1 = getHeight()-5, y2 = getHeight()-5;
        int x3 = (x1 +x2)/2;
        var y3 = Math.min(5, (int)(Math.sqrt(3)/2*(x2-x1)));
        g2d.drawLine(x1, y1, x2, y2);
        g2d.drawLine(x1, y1, x3, y3);
        g2d.drawLine(x3, y3, x2, y2);
        drawTriangleFractal(g2d, x1, y1, x2, y2, x3, y3, 0); 
    }
    
     private void drawTriangleFractal(Graphics2D g2d, int x1, int y1, int x2, int y2, int x3, int y3, int level) {
        // 1. condition when the recurion ends
        // if (level >= 3) return; // just for testing
        double edgeLen = Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
        if (edgeLen < 20) return;
        // 2. draw this iteration
        int xA = (x1+x2)/2;
        int yA = (y1+y2)/2;        
        int xB = (x2+x3)/2;
        int yB = (y2+y3)/2;
        int xC = (x1+x3)/2;
        int yC = (y1+y3)/2;
        g2d.setColor(colorArray[level]);
        g2d.drawLine(xA, yA, xB, yB);
        g2d.drawLine(xA, yA, xC, yC);
        g2d.drawLine(xC, yC, xB, yB);
        // go on to the next iteration
        drawTriangleFractal(g2d, x1, y1, xA, yA, xC, yC, level+1);  // draw lower left triangle
        drawTriangleFractal(g2d, xA, yA, x2, y2, xB, yB, level+1);  // draw lower right triangle
        drawTriangleFractal(g2d, xC, yC, xB, yB, x3, y3, level+1);  // draw upper triangle
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
