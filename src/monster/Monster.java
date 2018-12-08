package monster;

public abstract class Monster {
	private int hp;
	private int atk;
	private String imagepath;
	private int score;
	
	public Monster() {
		this.hp = 1;
		this.atk = 1;
		this.imagepath = "";
		this.score = 100;
	}
	public Monster(int hp,int atk,String imagepath,int score) {
		this.hp = hp;
		this.atk = atk;
		this.imagepath = imagepath;
		this.score = score;
	}
	public boolean destroy() {
		return hp==0;
	}
	public void update() {
		
	}
}