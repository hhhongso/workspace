package friend.bean;

public class FriendDTO {
	private int seq; // 대표값. 중복불가 
	private String name; //중복가능 
	String tel1, tel2, tel3;
	private int sex, read, movie, music, game, shopping;
	
	public void setSeq(int seq) {
		this.seq = seq;
	}
	
	public int getSeq() {
		return seq;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel1() {
		return tel1;
	}

	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}

	public String getTel2() {
		return tel2;
	}

	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}

	public String getTel3() {
		return tel3;
	}

	public void setTel3(String tel3) {
		this.tel3 = tel3;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public int getRead() {
		return read;
	}

	public void setRead(int read) {
		this.read = read;
	}

	public int getMovie() {
		return movie;
	}

	public void setMovie(int movie) {
		this.movie = movie;
	}

	public int getMusic() {
		return music;
	}

	public void setMusic(int music) {
		this.music = music;
	}

	public int getGame() {
		return game;
	}

	public void setGame(int game) {
		this.game = game;
	}

	public int getShopping() {
		return shopping;
	}

	public void setShopping(int shopping) {
		this.shopping = shopping;
	}

	@Override
	public String toString() {
		return name;
	}

	
	

}
