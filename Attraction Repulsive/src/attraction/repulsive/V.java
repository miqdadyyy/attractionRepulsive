/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attraction.repulsive;

import java.awt.Point;

/**
 *
 * @author Myf
 */
public class V {

    double x, y;
    double length, sina, cosa;

    public V() {
        this.x = 0;
        this.y = 0;
    }

    public V(double x, double y) {
        this.x = x;
        this.y = y;
        this.length = Math.sqrt(x * x + y * y);

        this.sina = (double) y / length;
        this.cosa = (double) x / length;
    }

    public V add(V V2) {
        return new V(this.x + V2.x, this.y + V2.y);
    }

    public V minus(V V2) {
        return new V(this.x - V2.x, this.y - V2.y);
    }

    public V multiply(V V2) {
        return new V(this.x * V2.x, this.y * V2.y);
    }

    public V divide(V V2) {
        return new V(this.x / V2.x, this.y / V2.y);
    }

    public double getLength() {
        return this.length * this.length;
    }

    public void setLength(double length) {
        this.length = length;
        this.x = cosa * length;
        this.y = sina * length;

//        double div = length/2;
//        this.x = Math.sqrt(div);
//        this.y = Math.sqrt(div);
    }
}
