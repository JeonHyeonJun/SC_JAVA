package com.swim4.swim.board.vo;

public class Reply {
	private int replynum;
	private int boardnum;
	private String id;
	private String text;
	private String inputdate;
	private int groupnum;
	private int groupseq;
	private int parentnum;
	private String replydel;
	
	public Reply() {}

	public Reply(int replynum, int boardnum, String id, String text, String inputdate, int groupnum, int groupseq,
			int parentnum, String replydel) {
		this.replynum = replynum;
		this.boardnum = boardnum;
		this.id = id;
		this.text = text;
		this.inputdate = inputdate;
		this.groupnum = groupnum;
		this.groupseq = groupseq;
		this.parentnum = parentnum;
		this.replydel = replydel;
	}

	public int getReplynum() {
		return replynum;
	}

	public void setReplynum(int replynum) {
		this.replynum = replynum;
	}

	public int getBoardnum() {
		return boardnum;
	}

	public void setBoardnum(int boardnum) {
		this.boardnum = boardnum;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getInputdate() {
		return inputdate;
	}

	public void setInputdate(String inputdate) {
		this.inputdate = inputdate;
	}

	public int getGroupnum() {
		return groupnum;
	}

	public void setGroupnum(int groupnum) {
		this.groupnum = groupnum;
	}

	public int getGroupseq() {
		return groupseq;
	}

	public void setGroupseq(int groupseq) {
		this.groupseq = groupseq;
	}

	public int getParentnum() {
		return parentnum;
	}

	public void setParentnum(int parentnum) {
		this.parentnum = parentnum;
	}

	public String getReplydel() {
		return replydel;
	}

	public void setReplydel(String replydel) {
		this.replydel = replydel;
	}

	@Override
	public String toString() {
		return "Reply [replynum=" + replynum + ", boardnum=" + boardnum + ", id=" + id + ", text=" + text
				+ ", inputdate=" + inputdate + ", groupnum=" + groupnum + ", groupseq=" + groupseq + ", parentnum="
				+ parentnum + ", replydel=" + replydel + "]";
	}
	
}
