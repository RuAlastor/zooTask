package Alastor.Zoo;

import Alastor.Animal.Animal;
import Alastor.Animal.Herbivorous.Herbivorous;
import Alastor.Animal.Predator.Predator;
import Alastor.Status.WeatherStatus;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Zoo {

//-----------------------------------------------------------------------------
//-----------------------------------------------------------------------------

    //-----------------------------------------------------------------------------------------------
    public Zoo() {
        _isZooNoisy    = false;
        _isMasterIn    = false;
        _isFeedingTime = false;

        _weatherStatus = new WeatherStatus();
        _weatherStatus.startDay();
        _weatherStatus.stopThunder();

        _animalCells = new ArrayList<>();
    }
    //-----------------------------------------------------------------------------------------------
    public void mainLoop() {
        addAnimal( "Herbivorous", "Zebra(s)", "screech(es)...", 2);
        addAnimal( "Predator", "Tiger(s)", "growl(s)...", 3 );
        addAnimal( "Predator", "Bear(s)", "roar(s)...", 1 );
        addAnimal( "Herbivorous", "Giraffe(s)", "screech(es)...", 5 );

        while ( true ) {
            System.out.println( "New iteration!" );
            for ( int i = 0; i < _animalCells.size(); ++i ) {
                if ( i == 0 ) _isMasterIn = true;
                else _isMasterIn = false;
                _animalCells.get( i ).react( _weatherStatus, _isZooNoisy, _isMasterIn, _isFeedingTime );
            }

            _isZooNoisy = false;
            for ( int i = 0; i < _animalCells.size(); ++i ) {
                if ( _animalCells.get( i ).makeNoise() ) _isZooNoisy = true;
            }

            try {
                TimeUnit.SECONDS.sleep(2);
            }
            catch ( InterruptedException err ) {
                System.out.println( "Interrupted!" );
                System.exit( -1 );
            }
        }
    }
    //-----------------------------------------------------------------------------------------------

//-----------------------------------------------------------------------------
//-----------------------------------------------------------------------------

    //-----------------------------------------------------------------------------------------------
    public void addAnimal( String type, String name, String sound, Integer amount ) {
        if ( type.equals( "Herbivorous" ) )
        { _animalCells.add( _createHerbivorous( name, sound, amount ) ); }
        else
        { _animalCells.add( _createPredator( name, sound, amount ) ); }
    }
    //-----------------------------------------------------------------------------------------------

//-----------------------------------------------------------------------------
//-----------------------------------------------------------------------------

    //-----------------------------------------------------------------------------------------------
    private Herbivorous _createHerbivorous( String name, String sound, Integer amount ) {
        return new Herbivorous( name, sound, amount );
    }
    //-----------------------------------------------------------------------------------------------
    private Predator _createPredator( String name, String sound, Integer amount ) {
        return new Predator( name, sound, amount );
    }
    //-----------------------------------------------------------------------------------------------

//-----------------------------------------------------------------------------
//-----------------------------------------------------------------------------

    //-----------------------------------------------------------------------------------------------
    private boolean       _isZooNoisy;
    private boolean       _isMasterIn;
    private boolean       _isFeedingTime;
    private WeatherStatus _weatherStatus;
    //-----------------------------------------------------------------------------------------------
    private ArrayList< Animal > _animalCells;
    //-----------------------------------------------------------------------------------------------

//-----------------------------------------------------------------------------
//-----------------------------------------------------------------------------

}
