/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package plugins.quorum.Libraries.Robots;
import cbccore.Botball;
import cbccore.Device;

/**
 *
 * @author sahana
 */
public class Controller {
    public java.lang.Object $me = null;
    cbccore.Botball cbc = new cbccore.Botball();
    cbccore.sensors.analog.Analog s = null;     
    
    public void ShutDownIn(double seconds) 
    {
        cbc.shutDownIn(seconds);
    }
    
    public void Wait(double s) 
    {
        try{
            int seconds = (int) s;
            Thread.currentThread().sleep(seconds*1000);}
        catch(InterruptedException ie){}
    }
    
    public void WaitUntilLightDetectedInPort(int port)  
    {
        s = new cbccore.sensors.analog.Analog(port);
        cbc.waitForLight(s);
    }
    
    public void Beep()
    {   
        Device.getLowSoundController().beep();
    }
}
