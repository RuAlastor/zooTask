package Alastor.Animal.Herbivorous;

import Alastor.Animal.Animal;
import Alastor.Status.WeatherStatus;

public class Herbivorous extends Animal {

//-----------------------------------------------------------------------------
//-----------------------------------------------------------------------------

    //-----------------------------------------------------------------------------------------------
    public Herbivorous() { }
    public Herbivorous( String name, String noiseType, Integer amount ) { super( name, noiseType, amount ); }
    //-----------------------------------------------------------------------------------------------
    @Override
    public void react( WeatherStatus weatherStatus,
                       boolean isZooNoisy, boolean isMasterIn, boolean isFeedingTime ) {
        reactOnMaster( isMasterIn );
        reactOnWeather( weatherStatus, isZooNoisy );
        reactOnFood( isFeedingTime );
    }
    //-----------------------------------------------------------------------------------------------

//-----------------------------------------------------------------------------
//-----------------------------------------------------------------------------


}
