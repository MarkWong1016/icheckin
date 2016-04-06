package checkin;

import org.puremvc.java.multicore.patterns.facade.Facade;

import checkin.controller.DataSubmittedCommand;
import checkin.controller.StartupCommand;
import checkin.view.components.CheckinForm;

public class CheckinAppFacade extends Facade {

	public static final String DATA_SUBMITTED = "DATA_SUBMITTED";
	public static final String DATA_CHANGED = "DATA_CHANGED";
	public static final String STARTUP = "START_UP";
	
	public static final String NAME = "iCheckinFacade";
	
	protected CheckinAppFacade(String key) {
		super(key);
	}
	
	public static CheckinAppFacade getInst(String key)
    {
        if (instanceMap.get(key) == null) {
            instanceMap.put(key, new CheckinAppFacade(key));
        }
        return (CheckinAppFacade) instanceMap.get(key);
    }
	
	@Override
	protected void initializeController(){
		
		super.initializeController();

		registerCommand(STARTUP, new StartupCommand());
		registerCommand(DATA_SUBMITTED, new DataSubmittedCommand());
	}
	
	public void startup(CheckinForm app) {
		this.sendNotification(STARTUP, app, null);
	}
}
