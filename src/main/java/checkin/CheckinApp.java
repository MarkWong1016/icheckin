package checkin;
import java.awt.EventQueue;

import checkin.view.components.CheckinForm;


public class CheckinApp {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckinForm window = new CheckinForm();
					window.frame.setVisible(true);
					//Facade mvcFacade = Facade.getInstance("iCheckinFacade");
					CheckinAppFacade mvcFacade = CheckinAppFacade.getInst(CheckinAppFacade.NAME);
					//mvcFacade.registerMediator(new CheckinFormMediator(window));
					//mvcFacade.registerProxy(new DataModelProxy());
					mvcFacade.startup(window);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
