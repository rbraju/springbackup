package com.spring.integration.linkmodule;

public class Keyword {

	private String keyword;

	private long popScore;

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public long getPopScore() {
		return popScore;
	}

	public void setPopScore(long popScore) {
		this.popScore = popScore;
	}
	
	public String toString() {
		return this.getKeyword() + ", " + this.getPopScore();
	}
}
