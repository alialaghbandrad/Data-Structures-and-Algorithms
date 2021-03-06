/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day06circlesfractalali;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 *
 * @author alagh
 */
public class CirclesFractalPanel extends javax.swing.JPanel {

    /**
     * Creates new form CirclesFractalPanel
     */
    
    public CirclesFractalPanel() {
        //initComponents();
    }

    private Color [] colorArray = {
        new Color(255, 90, 90),
        new Color(0, 200, 0),
        new Color(90, 90, 255),
        new Color(10, 10, 84),
        new Color(22, 21, 61),
        new Color(21, 98, 69),
        new Color(217, 146, 54),
        new Color(63, 121, 186),
        new Color(131, 121, 11)
    };
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        int widthCanv = getWidth(); // canvas width
        int heightCanv = getHeight(); // canvas height
        int padding = 20;
        int x = widthCanv / 2;
        int y = x;
        int radius = x - padding;
        drawCircle(g2d, x, y, radius);  // the big circle
        drawFractal(g2d, x, y, radius, 0);
    }
    
    private void drawFractal(Graphics2D g2d, int x, int y, int radius, int level) {
        // 1. recursion must end at some point
        if (radius < 6) {
            return;
        }
        // xy1: left circle center, radius1 of it
        int x1 = x - radius / 2;
        int y1 = y;
        int radius1 = radius / 2;
        // xy2: right circle center, radius2 of if
        int x2 = x + radius / 2;
        int y2 = y;
        int radius2 = radius / 2;
        // xy3: top circle center, radius3 of it
        int x3 = x;
        int y3 = y - radius * 2 / 3;
        int radius3 = radius / 3;
        // xy4: bottom circle center, radius4 of it
        int x4 = x;
        int y4 = y + radius * 2 / 3;
        int radius4 = radius / 3;
        //
        g2d.setColor(colorArray[level]);
        drawCircle(g2d, x1, y1, radius1);
        drawCircle(g2d, x2, y2, radius2);
        drawCircle(g2d, x3, y3, radius3);
        drawCircle(g2d, x4, y4, radius4);
        // two recursive calls
        drawFractal(g2d, x1, y1, radius1, level+1);  // inside the left circle
        drawFractal(g2d, x2, y2, radius2, level+1); // inside the right circle

    }
    
    private void drawCircle(Graphics2D g2d, int x, int y, int radius) {
        int cornerX = x - radius;
        int cornerY = y - radius;
        int width = 2 * radius;
        int height = width;
        g2d.drawOval(cornerX, cornerY, width, height);
        
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
