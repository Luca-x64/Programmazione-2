/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package it.unimi.di.prog2.e18;

import java.util.StringJoiner;


abstract class CelestialBody {
    public static class ThreeDimensionalPoint {
        private long norm;
        protected int x,y,z;
        protected ThreeDimensionalPoint(int x, int y, int z){
            this.x = x;
            this.y= y;
            this.z=z;
            evaluateNorm();
        }

        private void evaluateNorm(){
            norm = Math.abs(x)+Math.abs(y)+Math.abs(z);
        }

        protected long getNorm(){
            evaluateNorm();
            return norm;
        }

        protected void sum(ThreeDimensionalPoint dp){
            this.x+=dp.x;
            this.y+=dp.y;
            this.z+=dp.z;

        }
    }

    private final String name;
    protected final ThreeDimensionalPoint position;
    protected long energy;

    public String getName(){return this.name;}

    public CelestialBody(String name,int x,int y,int z){
        this.name=name;
        this.position = new ThreeDimensionalPoint(x, y, z);
        this.energy = this.position.norm;
    }

    protected long getEnergy(){
        return position.getNorm();
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(", ");
        sj.add("name:".concat(name));
        sj.add("pos: ".concat(position.toString()));
        return sj.toString();
    }

}
