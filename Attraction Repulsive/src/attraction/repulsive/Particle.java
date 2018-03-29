/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attraction.repulsive;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Stroke;

/**
 *
 * @author Myf
 */
public class Particle {

    Color c;
    V pos;
    V vel;
    V acc;
    int x1, y1;
    double r = Math.random() * 255, g = Math.random() * 255, b = Math.random() * 255;
    double rp = Math.random() * 0.3, rg = Math.random() * 0.3, rb = Math.random() * 0.3;

    public Particle(int x, int y) {
        this.pos = new V(x, y);
        this.vel = randomVector();
        this.acc = new V();

        x1 = 300;
        y1 = 300;

//        x1 = (int) this.pos.x;
//        y1 = (int) this.pos.y;
    }

    public void update() {
        pos = pos.add(vel);
        vel = vel.add(acc);
        r += rp;
        g += rg;
        b += rb;
        r = r >= 255 ? r -= 255 : r;
        g = g >= 255 ? g -= 255 : g;
        b = b >= 255 ? b -= 255 : b;
    }

    public void draw(Graphics2D g) {
        c = new Color((int) this.r, (int) this.g, (int) this.b, 65);
        g.setColor(c);

        g.drawLine(x1, y1, (int) pos.x, (int) pos.y);
//        x1 = (int) pos.x;
//        y1 = (int) pos.y;
//        g.fillOval((int) pos.x, (int) pos.y, 5, 5);
    }

    public void attracted(Attractor a) {
        //dir = a.pos - this.pos
        V force = a.pos.minus(this.pos);
        double dSquare = force.getLength();
        dSquare = constrain(dSquare, 25, 300);
        double G = 50;
        double strength = G / dSquare;
        force.setLength(strength);
        this.acc = force;
        System.out.println(pos.x + " " + pos.y);
    }

    public double constrain(double n, double min, double max) {
        return Math.max(Math.min(n, max), min);
    }

    public V randomVector() {
        double a = Math.random() * 360;
        return new V(Math.cos(a), Math.sin(a));
    }

}
