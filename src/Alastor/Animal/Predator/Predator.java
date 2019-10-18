package Alastor.Animal.Predator;

import Alastor.Animal.Animal;
import Alastor.Status.WeatherStatus;

public class Predator extends Animal {

//-----------------------------------------------------------------------------
//-----------------------------------------------------------------------------

    //-----------------------------------------------------------------------------------------------
    public Predator() {}
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
    @Override
    public void makeNoise() { System.out.println( "Growls..." ); }
    //-----------------------------------------------------------------------------------------------
    public void reactOnNoise( boolean isZooNoisy ) {
        if ( isZooNoisy ) _becomeNoisy();
    }
    //-----------------------------------------------------------------------------------------------


}
