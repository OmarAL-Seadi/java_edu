/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.heartshapepanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Path2D;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.util.Timer;
import java.util.TimerTask;

 class HH extends JPanel {
    private static final long serialVersionUID = 1L;   // mainly for "picky" IDEs
    
    private static final int PANEL_WIDTH = 400;
    private static final int PANEL_HEIGHT = 300;
    private static final int HEART_SIZE = 100;
    private static final int BEAT_INTERVAL = 500; // milliseconds
    private static final float BEAT_FACTOR = 1.2f;
    
    private float currentSize = HEART_SIZE;
    private boolean isExpanding = true;

    public HH() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                beatHeart();
                repaint();
            }
        }, BEAT_INTERVAL, BEAT_INTERVAL);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        int margin = 5;   // just some margin around the heart shape
        int panelWidth = getWidth();
        int panelHeight = getHeight();
        float boxX = (panelWidth - currentSize) / 2.0f;
        float boxY = (panelHeight - currentSize) / 2.0f;

        if (currentSize > 0) {
            // Draw heart shape
            Path2D heartPath = createHeartPath(boxX, boxY, currentSize, currentSize);
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setColor(Color.RED);
            g2d.fill(heartPath);

            // Draw text
            String text = "LOVE U A.l.i ";
            g2d.setColor(Color.BLACK);  // Ensure contrast with white background
            g2d.setFont(new Font("Arial", Font.BOLD, 24)); // Adjust font size
            int textWidth = g2d.getFontMetrics().stringWidth(text);
            int textHeight = g2d.getFontMetrics().getHeight();
            int textX = (panelWidth - textWidth) / 2;
            int textY = (int) (boxY + currentSize + 20 + textHeight); // Position below the heart
            g2d.drawString(text, textX, textY);

            // Append current time
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("");
            String timeText = now.format(formatter);
            int timeTextWidth = g2d.getFontMetrics().stringWidth(timeText);
            int timeTextX = (panelWidth - timeTextWidth) / 2;
            int timeTextY = textY + 20; // Position below the "Happy 20th Birthday Yasser" text
            g2d.drawString(timeText, timeTextX, timeTextY);

            // Draw celebration particles
            drawParticles(g2d, boxX, boxY, currentSize);
        }
    }

    private Path2D createHeartPath(float x, float y, float width, float height) {
        float beX = x + width / 2;  // bottom endpoint X
        float beY = y + height;     // bottom endpoint Y

        float c1DX = width  * 0.968f;  // delta X of control point 1
        float c1DY = height * 0.672f;  // delta Y of control point 1
        float c2DX = width  * 0.281f;  // delta X of control point 2
        float c2DY = height * 1.295f;  // delta Y of control point 2
        float teDY = height * 0.850f;  // delta Y of top endpoint

        Path2D.Float heartPath = new Path2D.Float();
        heartPath.moveTo(beX, beY);       // bottom endpoint
        // left side of heart
        heartPath.curveTo(
                beX - c1DX, beY - c1DY,   // control point 1
                beX - c2DX, beY - c2DY,   // control point 2
                beX       , beY - teDY);  // top endpoint
        // right side of heart
        heartPath.curveTo(
                beX + c2DX, beY - c2DY,   // control point 2
                beX + c1DX, beY - c1DY,   // control point 1
                beX       , beY);         // bottom endpoint
        return heartPath;
    }

    private void drawParticles(Graphics2D g2d, float x, float y, float size) {
        // Draw some circles around the heart as particles with random colors
        int numParticles = 20;
        for (int i = 0; i < numParticles; i++) {
            int particleSize = 5;
            float angle = (float) (Math.random() * 2 * Math.PI);
            float radius = size / 2 + (float) (Math.random() * size / 2); // Random radius within heart size
            float particleX = x + size / 2 + radius * (float) Math.cos(angle);
            float particleY = y + size / 2 + radius * (float) Math.sin(angle);
            Color randomColor = getRandomColor();
            g2d.setColor(randomColor);
            g2d.fillOval((int) particleX, (int) particleY, particleSize, particleSize);
        }
    }

    private Color getRandomColor() {
        // Generate random color
        int r = (int) (Math.random() * 256);
        int g = (int) (Math.random() * 256);
        int b = (int) (Math.random() * 256);
        return new Color(r, g, b);
    }
    
    private void beatHeart() {
        if (isExpanding) {
            currentSize *= BEAT_FACTOR;
            if (currentSize >= HEART_SIZE * 1.5)
                isExpanding = false;
        } else {
            currentSize /= BEAT_FACTOR;
            if (currentSize <= HEART_SIZE)
                isExpanding = true;
        }
    }
 }

    public class HeartShapePanel{
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            HH heartShapePanel = new HH();
            heartShapePanel.setBackground(Color.WHITE);

            JFrame frame = new JFrame("M");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set close operation here
            frame.setSize(400,350);
            frame.add(heartShapePanel);
            frame.setLocationRelativeTo(null);  // centers on screen
            frame.setVisible(true);
        });
    }
}
