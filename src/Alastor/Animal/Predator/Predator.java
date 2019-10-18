package Alastor.Animal.Predator;

import Alastor.Animal.Animal;
import Alastor.Status.WeatherStatus;

public class Predator extends Animal {

//-----------------------------------------------------------------------------
//-----------------------------------------------------------------------------

    //-----------------------------------------------------------------------------------------------
    public Predator() { }
    public Predator( String name, String noiseType, Integer amount ) { super( name, noiseType, amount ); }
    //-----------------------------------------------------------------------------------------------
    @Override
    public void react( WeatherStatus weatherStatus,
                       boolean isZooNoisy, boolean isMasterIn, boolean isFeedingTime ) {
        reactOnNoise( isZooNoisy );
        reactOnMaster( isMasterIn );
        reactOnWeather( weatherStatus, isZooNoisy );
        reactOnFood( isFeedingTime );
    }
    //-----------------------------------------------------------------------------------------------
    public void reactOnNoise( boolean isZooNoisy ) {
        if ( isZooNoisy ) _becomeNoisy();
    }
    //-----------------------------------------------------------------------------------------------

//-----------------------------------------------------------------------------
//-----------------------------------------------------------------------------

}
