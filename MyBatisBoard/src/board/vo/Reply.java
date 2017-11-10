package board.vo;

public class Reply {
	private int replynum;
	private int boardnum;
	private String name;
	private String retext;
	
	public Reply() {}

	public Reply(int boardnum, String name, String retext) {
		this.boardnum = boardnum;
		this.name = name;
		this.retext = retext;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRetext() {
		return retext;
	}

	public void setRetext(String retext) {
		this.retext = retext;
	}

	@Override
	public String toString() {
		return "Reply [replynum=" + replynum + ", boardnum=" + boardnum + ", name=" + name + ", retext=" + retext + "]";
	}
	
	
	
}
