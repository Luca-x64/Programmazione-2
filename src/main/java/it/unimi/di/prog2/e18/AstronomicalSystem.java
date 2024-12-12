package it.unimi.di.prog2.e18;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringJoiner;


public class AstronomicalSystem {

    private  final ArrayList<CelestialBody> bodies= new ArrayList<>();

    public void insert(CelestialBody element){
        bodies.add(element);
    }

    public void updatePosition(){
        for (int i = 0; i < bodies.size() && bodies.get(i) instanceof Planet planet; i++) {
            for (int j = 0; i!=j && j < bodies.size(); j++) {
                planet.compareVelocity(bodies.get(j));
            }
        }
        for (int i = 0; i < bodies.size() && bodies.get(i) instanceof Planet planet; i++) {
            for (int j = 0; i!=j && j < bodies.size(); j++) {
                planet.updatePosition();
            }
        }
    }

    

    private long getTotalEnergy(){
        long sum = 0;
        for (CelestialBody body : bodies) {
            sum+=body.getEnergy();
        }
        return sum;
    }

    @Override
    public String toString() {

        Collections.sort(bodies, Comparator.comparing(e -> e.getName()));

        StringJoiner sj = new StringJoiner("\n");
        for (CelestialBody elem : bodies) {
            sj.add(elem.toString());
        }
        sj.add(Long.toString(getTotalEnergy()));

        return sj.toString();
    }

}
