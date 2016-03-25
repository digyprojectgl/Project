package UI.layouts;

import java.awt.Container;

import UI.core.Frame;
import UI.core.LayoutInterface;

public class LoginLayout implements LayoutInterface {
	
	Container contentPane;
	
	@Override
	public Container getContainer() {
		return contentPane;
	}

	@Override
	public void render(Frame frame) {
		this.contentPane = frame.getContentPane();
		
	}
	
	

}
