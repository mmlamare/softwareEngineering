package lettercraze.controller.builder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import lettercraze.model.BuilderModel;
import lettercraze.model.LevelType;
import lettercraze.view.BuilderView;

public class ChangeTypeController implements ActionListener{
	BuilderModel m;
	BuilderView app;
	LevelType t;
	
	public ChangeTypeController(BuilderModel m, BuilderView app, LevelType t){
		this.m = m;
		this.app = app;
		this.t = t;
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		m.getLevel().type = t;
		app.update();
	}
}
