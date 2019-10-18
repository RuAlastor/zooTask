package Alastor;

import Alastor.Animal.Animal;
import Alastor.Animal.Herbivorous.Herbivorous;
import Alastor.Animal.Predator.Predator;
import Alastor.Status.WeatherStatus;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ArrayList< Animal > Zoo = new ArrayList< Animal >();
        Zoo.add( new Predator( "Tiger", "growls..." ) );
        Zoo.add( new Herbivorous( "Zebra", "screeches..." ) );
        Zoo.add( new Predator() );

        WeatherStatus weather = new WeatherStatus();
        weather.startThunder();
        weather.startDay();

        boolean isZooNoisy    = false;
        boolean isMasterIn    = false;
        boolean isFeedingTime = false;
        for ( int i = 0; i < Zoo.size(); ++i ) {
            Zoo.get( i ).react( weather, isZooNoisy, isMasterIn, isFeedingTime );
            Zoo.get( i ).makeNoise();
        }
    }
}
