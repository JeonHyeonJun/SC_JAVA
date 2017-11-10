package board.vo;

import java.sql.Date;

public class Board {
	private int boardnum;
	private String name;
	private String title;
	private String content;
	private int hits;
	private String indate;
	
	public Board() {}

	public Board(String name, String title, String content) {
		this.name = name;
		this.title = title;
		this.content = content;
	}

	public int getBoardnum() {
		return boardnum;
	}

	public void setBoardnum(int boardnum) {
		this.boardnum = boardnum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
	}

	public String getIndate() {
		return indate;
	}

	public void setIndate(String indate) {
		this.indate = indate;
	}

	@Override
	public String toString() {
		return "글번호: " + boardnum + ",글쓴이: " + name + ", 제목: " + title + ", 내용: " + content
				+ ", 조회수: " + hits + ", 글쓴날짜: " + indate + "";
	}
	
	
}
