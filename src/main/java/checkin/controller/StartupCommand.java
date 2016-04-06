package checkin.controller;

import org.puremvc.java.multicore.interfaces.ICommand;
import org.puremvc.java.multicore.interfaces.INotification;
import org.puremvc.java.multicore.patterns.command.SimpleCommand;
import org.puremvc.java.multicore.patterns.facade.Facade;

import checkin.CheckinAppFacade;
import checkin.model.DataModelProxy;
import checkin.view.CheckinFormMediator;
import checkin.view.components.CheckinForm;

public class StartupCommand extends SimpleCommand implements ICommand {
	public StartupCommand() {
		this.initializeNotifier("STARTUP_COMMAND_NOTIFIER");
	}
	public void execute(INotification notification){
		System.out.println("startup execute (command) " + notification.getBody());
		CheckinForm window = (CheckinForm) notification.getBody();
		Facade mvcFacade = CheckinAppFacade.getInst(CheckinAppFacade.NAME);
		mvcFacade.registerMediator(new CheckinFormMediator(window));
		mvcFacade.registerProxy(new DataModelProxy());
	}
}
