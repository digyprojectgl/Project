package UI.layouts;

import java.awt.Container;

import UI.core.Frame;
import UI.core.LayoutInterface;

public class LoginLayout implements LayoutInterface {
	
	Container contentPane;
	
	@Override
	public Container getContainer() {
		System.out.println("2");
		return contentPane;
	}

	@Override
	public void render(Frame frame) {
		System.out.println("2");
		this.contentPane = frame.getContentPane();
		
	}
	
	

}
