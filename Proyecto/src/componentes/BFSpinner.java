package componentes;

import java.awt.Rectangle;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class BFSpinner extends JSpinner {
	public BFSpinner(Rectangle bounds) {
		super();
		setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));	//	El menor valor es 0
		setBounds(bounds);
	
	}
}
