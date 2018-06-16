package com.jeff.learn.hellospringboot;

import java.io.Serializable;
import javax.persistence.*;

import org.apache.ibatis.type.Alias;

import java.util.Date;


/**
 * The persistent class for the sending_command database table.
 * 
 */
@Alias("sendCom")
public class SendingCommand implements Serializable {
	private static final long serialVersionUID = 1L;

	private long id;

	private String commandId;

	private byte[] commandObj;

	private String commandType;

	private String details;

	private String lotteryType;

	private Date sendTime;
	
	private Date returnTime;

	public SendingCommand() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCommandId() {
		return this.commandId;
	}

	public void setCommandId(String commandId) {
		this.commandId = commandId;
	}

	public byte[] getCommandObj() {
		return this.commandObj;
	}

	public void setCommandObj(byte[] commandObj) {
		this.commandObj = commandObj;
	}

	public String getCommandType() {
		return this.commandType;
	}

	public void setCommandType(String commandType) {
		this.commandType = commandType;
	}

	public String getDetails() {
		return this.details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getLotteryType() {
		return this.lotteryType;
	}

	public void setLotteryType(String lotteryType) {
		this.lotteryType = lotteryType;
	}

	public Date getSendTime() {
		return this.sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	public Date getReturnTime() {
		return returnTime;
	}

	public void setReturnTime(Date returnTime) {
		this.returnTime = returnTime;
	}

}