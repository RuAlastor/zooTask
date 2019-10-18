package Alastor.Animal;

import Alastor.Status.WeatherStatus;

public abstract class Animal {

// Public METHODS
//-----------------------------------------------------------------------------
//-----------------------------------------------------------------------------

    //-----------------------------------------------------------------------------------------------
    public Animal() {
        _isSleeping = false;
        _isNoisy    = false;
        _name       = "Unknown animal";
        _noiseType  = "makes inaudible noise...";
    }
    public Animal( String name, String noiseType ) {
        _isSleeping = false;
        _isNoisy    = false;
        _name       = name;
        _noiseType  = noiseType;
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
    public boolean makeNoise() {
        if ( isNoisy() ) {
            System.out.println( _name + " " + _noiseType );
            return true;
        }
        return false;
    }
    //-----------------------------------------------------------------------------------------------
    public boolean isSleeping() { return _isSleeping; }
    public boolean isWake()     { return !_isSleeping; }
    public boolean isNoisy()    { return _isNoisy; }
    //-----------------------------------------------------------------------------------------------

// Protected METHODS
//-----------------------------------------------------------------------------
//-----------------------------------------------------------------------------

    //-----------------------------------------------------------------------------------------------
    protected void _goToSleep() { _isSleeping = true; }
    protected void _wakeUp()    { _isSleeping = false; };
    //-----------------------------------------------------------------------------------------------
    protected void _becomeNoisy() { _isNoisy = true; }
    protected void _calmDown()    { _isNoisy = false; }
    //-----------------------------------------------------------------------------------------------

// Private VARIABLES
//-----------------------------------------------------------------------------
//-----------------------------------------------------------------------------

    private boolean _isSleeping;
    private boolean _isNoisy;
    private String  _name;
    private String  _noiseType;

//-----------------------------------------------------------------------------
//-----------------------------------------------------------------------------

}
