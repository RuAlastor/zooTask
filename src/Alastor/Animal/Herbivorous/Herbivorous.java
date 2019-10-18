package Alastor.Animal.Herbivorous;

import Alastor.Animal.Animal;
import Alastor.Status.WeatherStatus;

public class Herbivorous extends Animal {

//-----------------------------------------------------------------------------
//-----------------------------------------------------------------------------

    //-----------------------------------------------------------------------------------------------
    public Herbivorous() { }
    public Herbivorous( String name, String noiseType ) { super( name, noiseType ); }
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
