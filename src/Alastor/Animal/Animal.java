package Alastor.Animal;

import Alastor.Status.WeatherStatus;

public abstract class Animal {

//-----------------------------------------------------------------------------
//-----------------------------------------------------------------------------

    //-----------------------------------------------------------------------------------------------
    public Animal() {
        _isSleeping = false;
        _isNoisy    = false;
    }
    //-----------------------------------------------------------------------------------------------
    public abstract void react( WeatherStatus weatherStatus,
                                boolean isZooNoisy, boolean isMasterIn, boolean isFeedingTime );
    //-----------------------------------------------------------------------------------------------
    public void reactOnWeather( WeatherStatus weatherStatus,
                                boolean isZooNoisy ) {
        if      ( weatherStatus.isDay() && isSleeping() )              { _wakeUp(); }
        else if ( weatherStatus.isNight() && isWake() && !isZooNoisy ) { _goToSleep(); }

        if ( weatherStatus.isThunder() ) {
            if ( isSleeping() ) _wakeUp();
            _becomeNoisy();
        }
    }
    //-----------------------------------------------------------------------------------------------
    public void reactOnMaster( boolean isMasterIn ) {
        if ( isMasterIn && isWake() ) _becomeNoisy();
    }
    //-----------------------------------------------------------------------------------------------
    public void reactOnFood( boolean isFeedingTime ) {
        if ( isFeedingTime ) _calmDown(); }
    //-----------------------------------------------------------------------------------------------
    public void makeNoise() {
        if ( isNoisy() ) System.out.println( "Inaudible noise..." );
    }
    //-----------------------------------------------------------------------------------------------
    public boolean isSleeping() { return _isSleeping; }
    public boolean isWake()     { return !_isSleeping; }
    public boolean isNoisy()    { return _isNoisy; }
    //-----------------------------------------------------------------------------------------------

//-----------------------------------------------------------------------------
//-----------------------------------------------------------------------------

    //-----------------------------------------------------------------------------------------------
    protected void _goToSleep() { _isSleeping = true; }
    protected void _wakeUp()    { _isSleeping = false; };
    //-----------------------------------------------------------------------------------------------
    protected void _becomeNoisy() { _isNoisy = true; }
    protected void _calmDown()    { _isNoisy = false; }
    //-----------------------------------------------------------------------------------------------

//-----------------------------------------------------------------------------
//-----------------------------------------------------------------------------

    private boolean _isSleeping;
    private boolean _isNoisy;

//-----------------------------------------------------------------------------
//-----------------------------------------------------------------------------

}
