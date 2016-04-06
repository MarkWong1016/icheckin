package checkin.model;

import org.puremvc.java.multicore.patterns.proxy.Proxy;

import checkin.CheckinAppFacade;

public class DataModelProxy extends Proxy {
	public final static String NAME = "DataModelProxy";
	//private String data;
	
	private Data realData;
	
	public DataModelProxy() {
		super(NAME, null);
		//this.data = "";
		this.realData = new Data();
		//multi core can not access facade from within the constructor of a Notifier subclass.
		//so we move it to onRegister
		//http://forums.puremvc.org/index.php?topic=1365.0;prev_next=prev
		//this.sendNotification(CheckinAppFacade.DATA_CHANGED, null, this.realData.data);
	}
	
	@Override
	public void onRegister() {
		//initial text for view component HERE!!
		this.sendNotification(CheckinAppFacade.DATA_CHANGED, null, this.realData.data);
	}
	
	public void setData(String data) {
		//this.data = data;
		realData.data = data;
		System.out.println("setData (model) " + data);
		this.sendNotification(CheckinAppFacade.DATA_CHANGED, null, this.realData.data);
	}
}
