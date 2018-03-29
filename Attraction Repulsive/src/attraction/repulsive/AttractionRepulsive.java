/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attraction.repulsive;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Myf
 */
public class AttractionRepulsive extends JPanel {

    private JFrame f;
    private ArrayList<Particle> p;
    private ArrayList<Attractor> a;

    public AttractionRepulsive() {
        Init();
        p = new ArrayList<Particle>();
        a = new ArrayList<Attractor>();
        for (int i = 0; i < 1; i++) {
            int x = (int) (Math.random() * getWidth());
            int y = (int) (Math.random() * getHeight());
            p.add(new Particle(x, y));
        }
        for (int i = 0; i < 1; i++) {
//            int x = (int) (Math.random() * getWidth());
//            int y = (int) (Math.random() * getHeight());
            int x = 300;
            int y = 300;
            a.add(new Attractor(x, y));
        }

    }

    private void Init() {
        setMinimumSize(new Dimension(600, 600));
        setPreferredSize(new Dimension(600, 600));
        setMaximumSize(new Dimension(600, 600));

        f = new JFrame("Attraction Repulsive Force");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new BorderLayout());
        f.add(this, BorderLayout.CENTER);
        f.pack();
        f.setResizable(false);
        f.setVisible(true);
        f.setBackground(Color.BLACK);
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setColor(new Color(51));
//        g2d.fillRect(0, 0, getWidth(), getHeight());
        for (Particle particle : p) {
            particle.attracted(a.get(0));
            particle.update();
            particle.draw(g2d);
        }
        for (Attractor attractor : a) {
            attractor.draw(g2d);
        }

    }

    public static void main(String[] args) {
        int t = 0;
        AttractionRepulsive ARF = new AttractionRepulsive();
        while (true) {
            try {
                Thread.sleep(10);
                ARF.repaint();
                t++;
                System.out.println(t);
                if (t == 4000) {
                    break;
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        while (true) {

        }
    }

}
