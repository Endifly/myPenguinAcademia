package application;

import javafx.application.Platform;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import util.controlable;
import util.fireable;

public class Barrier1 extends Penguin implements fireable,controlable{
	
	private Penguin p;
	private static Thread controlb;
	private static boolean controlRun = true;
	private static boolean cTriggerd = false;
	public Barrier1(GraphicsContext gc,Penguin e) {
		// TODO Auto-generated constructor stub
		super(gc);
		this.p = e;
		this.controlThread();
		
	}
	@Override
	public void fire() {
		System.out.println("barrier was fired");
		this.h = p.getH();
		this.k = p.getK();
		this.r =  150;

	}
	public void controlThread() {
		// TODO Auto-generated method stub
		controlb = new Thread(() -> {
			try {
				while(controlRun) {
					Thread.sleep(16);
					if (EventManager.V == true && !cTriggerd) {
						this.fire();
						cTriggerd = true;
					}
					if (EventManager.V == false) {
						cTriggerd = false;
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		controlb.start();
	}
	

}
