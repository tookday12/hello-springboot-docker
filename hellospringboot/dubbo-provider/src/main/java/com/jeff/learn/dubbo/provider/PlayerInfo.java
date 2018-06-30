package com.jeff.learn.dubbo.provider;




public class PlayerInfo {
	private static final long serialVersionUID = 1L;
	private int id;
	private int accountId;
	private Integer agentId;
	private String userName;
	private String siteId;

	private String status;

	private int tray;
	
	private String testName;
	
	private SendingCommand sendingCommand;
	
//	@Column(name="wallet_type")
//	private Integer walletType;
	
	public PlayerInfo() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAccountId() {
		return this.accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getSiteId() {
		return this.siteId;
	}

	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getTray() {
		return this.tray;
	}

	public void setTray(int tray) {
		this.tray = tray;
	}

	public int getAgentId() {
		return agentId;
	}

	public void setAgentId(Integer agentId) {
		this.agentId = agentId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public SendingCommand getSendingCommand() {
		return sendingCommand;
	}

	public void setSendingCommand(SendingCommand sendingCommand) {
		this.sendingCommand = sendingCommand;
	}
	
//	public int getWalletType() {
//		return walletType;
//	}
//
//	public void setWalletType(int walletType) {
//		this.walletType = walletType;
//	}
	
}
