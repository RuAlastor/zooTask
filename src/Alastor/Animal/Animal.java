package Alastor.Animal;

public abstract class Animal {

//-----------------------------------------------------------------------------
//-----------------------------------------------------------------------------
    public Animal() {
        _isSleeping = false;
        _isNoisy    = false;
    }

    public void goToSleep() { _isSleeping = true; }
    public void wakeUp()    { _isSleeping = false; };

    public abstract void makeNoise();
    public          void becomeNoisy() { _isNoisy = true; }
    public          void calmDown()    { _isNoisy = false; }

    public void eat() { calmDown(); }

//-----------------------------------------------------------------------------
//-----------------------------------------------------------------------------

//-----------------------------------------------------------------------------
//-----------------------------------------------------------------------------
    private boolean _isSleeping;
    private boolean _isNoisy;
//-----------------------------------------------------------------------------
//-----------------------------------------------------------------------------

}
