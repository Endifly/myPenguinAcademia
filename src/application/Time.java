package application;

public class Time {
		private static int currentTime;
		private static Thread timerThread;
		public Time() {
			// TODO Auto-generated constructor stub
			this.currentTime = 0;
			this.timerThread = new Thread(() -> {
				while(true){
					try {
						Thread.sleep(1);
						currentTime++;
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						System.out.println("Stop Timer Thread");
						break;
					}
				}
			});
			this.timerThread.start();
		}
		public static void stop() {
			timerThread.interrupt();
		}


}
