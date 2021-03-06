package com.swim.pswim.vo;

public class Board {
	private int num;
	private String productcode;
	private String id;
	private String title;
	private String content;
	private String indate;
	private int score;
	private String originalfile;
	private String savedfile;
	
	public Board() {
		// TODO Auto-generated constructor stub
	}

	public Board(int num, String productcode, String id, String title, String content, String indate, int score,
			String originalfile, String savedfile) {
		this.num = num;
		this.productcode = productcode;
		this.id = id;
		this.title = title;
		this.content = content;
		this.indate = indate;
		this.score = score;
		this.originalfile = originalfile;
		this.savedfile = savedfile;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getProductcode() {
		return productcode;
	}

	public void setProductcode(String productcode) {
		this.productcode = productcode;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getIndate() {
		return indate;
	}

	public void setIndate(String indate) {
		this.indate = indate;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getOriginalfile() {
		return originalfile;
	}

	public void setOriginalfile(String originalfile) {
		this.originalfile = originalfile;
	}

	public String getSavedfile() {
		return savedfile;
	}

	public void setSavedfile(String savedfile) {
		this.savedfile = savedfile;
	}

	@Override
	public String toString() {
		return "Board [num=" + num + ", productcode=" + productcode + ", id=" + id + ", title=" + title + ", content="
				+ content + ", indate=" + indate + ", score=" + score + ", originalfile=" + originalfile
				+ ", savedfile=" + savedfile + "]";
	}

	

	

	
	
	
}
