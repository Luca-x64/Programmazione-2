/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package it.unimi.di.prog2.e18;

import java.util.StringJoiner;


public class Planet extends CelestialBody {

    private final CelestialBody.ThreeDimensionalPoint velocity;

    public Planet(String name, int x, int y,int z){
        super(name,x,y,z);
        velocity = new CelestialBody.ThreeDimensionalPoint(0,0,0); 
        super.energy*=velocity.getNorm();
    }

    protected void compareVelocity(CelestialBody cb){
        velocity.x += evaluateVelocity(super.position.x ,cb.position.x);
        velocity.y += evaluateVelocity(super.position.y ,cb.position.y);
        velocity.z += evaluateVelocity(super.position.z ,cb.position.z);
    }

    private int evaluateVelocity(int x, int x2) {
        if (x > x2) return -1;
        else if (x < x2) return 1;
        return 0;
    }
    
    protected void updatePosition(){
        super.position.sum(velocity);
    }

    @Override
    protected long getEnergy() {
        return super.getEnergy()*velocity.getNorm();
    }

    @Override
    public String toString() {

        StringJoiner sj = new StringJoiner(", ");
        sj.add("Planet");
        sj.add(super.toString());
        sj.add("Vel: ".concat(velocity.toString()));
        return sj.toString();
    }

 
}
