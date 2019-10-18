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
        _name       = "unknown animal(s)";
        _noiseType  = "make(s) inaudible noise...";
        _amount     = 0;
    }
    public Animal( String name, String noiseType, Integer amount ) {
        _isSleeping = false;
        _isNoisy    = false;
        _name       = name;
        _noiseType  = noiseType;
        _amount     = amount;
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
        if ( isMasterIn && isWake() ) {
            _becomeNoisy();
            System.out.println( _name + " react(s) when master enters cell" );
        }
    }
    //-----------------------------------------------------------------------------------------------
    public void reactOnFood( boolean isFeedingTime ) {
        if ( isFeedingTime ) {
            _calmDown();
            System.out.println( _name + " eats" );
        }
    }
    //-----------------------------------------------------------------------------------------------
    public boolean makeNoise() {
        if ( isNoisy() ) {
            System.out.println( _amount.toString() + " " + _name + " " + _noiseType );
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
    private Integer _amount;

//-----------------------------------------------------------------------------
//-----------------------------------------------------------------------------

}
