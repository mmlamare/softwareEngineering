package lettercraze.controller.builder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import lettercraze.model.BuilderModel;
import lettercraze.model.LevelType;
import lettercraze.view.BuilderView;

/**
 * This is the controller class for changing builder's 
 * type from the boundary's radio button input to the entities
 * @author Ruthenium
 * @version 1.0
 */
public class ChangeTypeController implements ActionListener{
	BuilderModel m;
	BuilderView app;
	LevelType t;
	
	/**
	 * @param m The builder model object
	 * @param app The builder boundary object
	 * @param t The leveltype object
	 */
	public ChangeTypeController(BuilderModel m, BuilderView app, LevelType t){
		this.m = m;
		this.app = app;
		this.t = t;
	}


	@Override
	/**
	 * This gets the level selected from the boundary and sets the entity
	 * Then it refreshes the display.
	 * @param e The action event object
	 */
	public void actionPerformed(ActionEvent arg0) {
		m.getLevel().type = t;
		app.update();
	}
}
