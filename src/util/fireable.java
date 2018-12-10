package util;

import javafx.scene.canvas.GraphicsContext;

public interface fireable {
	//firer for return some value such as point to firer when buttel is attacked to target
	//penguin and monster should import this
	//drawer is graphiccontext of battleStage use for drawer any bullet
	public void fire();
	public int getH();
	public int getK();
}
