package Alastor.Animal;

import Alastor.Status.WeatherStatus;

public abstract class Animal {

//-----------------------------------------------------------------------------
//-----------------------------------------------------------------------------

    public Animal() {
        _isSleeping = false;
        _isNoisy    = false;
    }

    public abstract void reactOnWeather( WeatherStatus weatherStatus );

//-----------------------------------------------------------------------------
//-----------------------------------------------------------------------------

    protected void _goToSleep() { _isSleeping = true; }
    protected void _wakeUp()    { _isSleeping = false; };

    protected abstract void _makeNoise();
    protected          void _becomeNoisy() { _isNoisy = true; }
    protected          void _calmDown()    { _isNoisy = false; }

    protected void _eat() { _calmDown(); }

//-----------------------------------------------------------------------------
//-----------------------------------------------------------------------------

    private boolean _isSleeping;
    private boolean _isNoisy;

//-----------------------------------------------------------------------------
//-----------------------------------------------------------------------------

}
