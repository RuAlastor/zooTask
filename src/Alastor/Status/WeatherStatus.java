package Alastor.Status;

public class WeatherStatus {

//-----------------------------------------------------------------------------
//-----------------------------------------------------------------------------

    public WeatherStatus() {
        _isThunder = false;
        _isDay     = true;
    }

    public void startThunder() { _isThunder = true; }
    public void stopThunder()  { _isThunder = false; }
    public boolean isThunder() { return  _isThunder; }

    public void startDay()     { _isDay = true; }
    public void startNight()   { _isDay = false; }
    public boolean isDay()     { return _isDay; }
    public boolean isNight()   { return  !_isDay; }

//-----------------------------------------------------------------------------
//-----------------------------------------------------------------------------

    private boolean _isThunder;
    private boolean _isDay;

//-----------------------------------------------------------------------------
//-----------------------------------------------------------------------------

}
