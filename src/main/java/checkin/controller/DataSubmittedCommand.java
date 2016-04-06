package checkin.controller;

import org.puremvc.java.multicore.interfaces.ICommand;
import org.puremvc.java.multicore.interfaces.INotification;
import org.puremvc.java.multicore.patterns.command.SimpleCommand;

import checkin.CheckinAppFacade;
import checkin.model.DataModelProxy;

public class DataSubmittedCommand extends SimpleCommand implements ICommand {
	public void execute(INotification notification){
		String myData = (String) notification.getType();
		//CheckinForm checkinForm = (CheckinForm)notification.getBody();
		//checkinForm.textField.setText(myData.toUpperCase());
		
		//this.sendNotification(CheckinAppFacade.DATA_CHANGED, null, myData.toUpperCase());
		DataModelProxy dataModelProxy = (DataModelProxy)CheckinAppFacade.getInst(CheckinAppFacade.NAME).retrieveProxy(DataModelProxy.NAME);
		dataModelProxy.setData(myData.toUpperCase());
	}
}
