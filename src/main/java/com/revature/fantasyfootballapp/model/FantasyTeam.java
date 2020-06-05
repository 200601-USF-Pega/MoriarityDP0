package com.revature.fantasyfootballapp.model;

public class FantasyTeam {

	private String user;
	private String qb;
	private String rb1;
	private String rb2;
	private String wr1;
	private String wr2;
	private String te;
	private String flex;
	private String dSt;
	private String k;
	
	public FantasyTeam() {
	}
	
	public FantasyTeam(String user, String qb, String rb1, String rb2, String wr1, String wr2, String te,
			String flex, String dSt, String k) {
		this.user = user;
		this.qb = qb;
		this.rb1 = rb1;
		this.rb2 = rb2;
		this.wr1 = wr1;
		this.wr2 = wr2;
		this.te = te;
		this.flex = flex;
		this.dSt = dSt;
		this.k = k;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getQb() {
		return qb;
	}

	public void setQb(String qb) {
		this.qb = qb;
	}

	public String getRb1() {
		return rb1;
	}

	public void setRb1(String rb1) {
		this.rb1 = rb1;
	}

	public String getRb2() {
		return rb2;
	}

	public void setRb2(String rb2) {
		this.rb2 = rb2;
	}

	public String getWr1() {
		return wr1;
	}

	public void setWr1(String wr1) {
		this.wr1 = wr1;
	}

	public String getWr2() {
		return wr2;
	}

	public void setWr2(String wr2) {
		this.wr2 = wr2;
	}

	public String getTe() {
		return te;
	}

	public void setTe(String te) {
		this.te = te;
	}

	public String getFlex() {
		return flex;
	}

	public void setFlex(String flex) {
		this.flex = flex;
	}

	public String getDSt() {
		return dSt;
	}

	public void setDSt(String dSt) {
		this.dSt = dSt;
	}

	public String getK() {
		return k;
	}

	public void setK(String k) {
		this.k = k;
	}

	@Override
	public String toString() {
		return "[user=" + user + ", qb=" + qb + ", rb1=" + rb1 + ", rb2=" + rb2 + ", wr1=" + wr1 + ", wr2="
				+ wr2 + ", te=" + te + ", flex=" + flex + ", d/st=" + dSt + ", k=" + k + "]";
	}
	
	
}
