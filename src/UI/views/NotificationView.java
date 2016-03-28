package UI.views;

import java.awt.Container;

import javax.swing.JLabel;

import UI.core.ViewInterface;

public class NotificationView implements ViewInterface {

	@Override
	public String getLayout() {
		// TODO Auto-generated method stub
		return "main";
	}

	@Override
	public void render(Container contentPane) {
		// TODO Auto-generated method stub
		contentPane.add(new JLabel("notifications"));
	}

}
