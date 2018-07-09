package Services;

import java.awt.GridBagConstraints;
import java.awt.Insets;

public class MyGridBagConstraints extends GridBagConstraints {
	public MyGridBagConstraints(int x,int y,int width,int height) {
		super();
		insets = new Insets(5, 5, 5, 5);
		gridx = x;
		gridy = y;
		gridheight = height;
		gridwidth = width;
	}
}
