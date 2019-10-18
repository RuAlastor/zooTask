package Alastor;

import Alastor.Animal.Animal;
import Alastor.Animal.Herbivorous.Herbivorous;
import Alastor.Animal.Predator.Predator;
import Alastor.Status.WeatherStatus;
import Alastor.Zoo.Zoo;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Zoo zoo = new Zoo();
        zoo.mainLoop();
    }
}
