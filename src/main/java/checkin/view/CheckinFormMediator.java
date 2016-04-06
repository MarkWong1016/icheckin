package checkin.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.puremvc.java.multicore.interfaces.INotification;
import org.puremvc.java.multicore.patterns.mediator.Mediator;

import checkin.CheckinAppFacade;
import checkin.view.components.CheckinForm;

public class CheckinFormMediator extends Mediator implements ActionListener {
	private static final String NAME = "CheckinMediator";
	
	public CheckinFormMediator(CheckinForm viewComponent) {
		super(NAME, viewComponent);
		viewComponent.textField.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		CheckinForm checkinForm = (CheckinForm)viewComponent;
		//checkinForm.textField.setText(checkinForm.textField.getText().toUpperCase());
		this.sendNotification(CheckinAppFacade.DATA_SUBMITTED, checkinForm, checkinForm.textField.getText());
	}
	
	@Override
    public String[] listNotificationInterests()
    {
        return new String[] {CheckinAppFacade.DATA_CHANGED};
    }
	
	@Override
    public void handleNotification(INotification notification)
    {    
        if(notification.getName().equals(CheckinAppFacade.DATA_CHANGED))
        {
            System.out.println("handleNotification (mediator) " + notification.getType());

            String mydata = (String) notification.getType();
            CheckinForm form = (CheckinForm) viewComponent;
            form.textField.setText(mydata);
        }
    }

}
