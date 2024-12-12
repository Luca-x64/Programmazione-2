/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package it.unimi.di.prog2.e18;


public class Star extends CelestialBody {

    public Star(String name, int x, int y,int z){
    super(name,x,y,z);
    }

    @Override
    public String toString() {
        return "Star, ".concat(super.toString());
    }

}
