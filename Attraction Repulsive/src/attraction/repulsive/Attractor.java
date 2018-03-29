/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attraction.repulsive;

import java.awt.Color;

/**
 *
 * @author Myf
 */
public class Attractor extends Particle{
    public Attractor(int x, int y) {
        super(x, y);
        this.vel = new V();
        c = Color.green;
    }
    
}
