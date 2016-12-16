package lettercraze.controller.builder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import lettercraze.model.BuilderModel;
import lettercraze.view.BuilderView;

public class PreviewBoardController implements ActionListener {

	BuilderModel m;
	BuilderView app;
	
	public PreviewBoardController(BuilderModel m, BuilderView app) {
		this.m = m;
		this.app = app;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
