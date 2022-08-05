package com.Bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

public class AddAccountBean {
@NotBlank(message="please Enter Account mode")
	String accountMode;
	Integer accountid;
	String upiId;
    public String getUpiId() {
		return upiId;
	}
	public void setUpiId(String upiId) {
		this.upiId = upiId;
	}
	public Integer getAccountid() {
		return accountid;
	}
	public void setAccountid(Integer accountid) {
		this.accountid = accountid;
	}
	Integer userId;
	/*
	 * @NotNull(message="please Enter digits")
	 * 
	 * @Range(min = 1000,max = 9999,message = "Please Enter 4 digit")
	 */
	Integer accountNumber;
	@NotBlank(message="plaese Enter Account Type")
	String accountType;
	 @NotNull(message="please Enter Account Balance")
	Integer accountBalance;
	
	
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getAccountMode() {
		return accountMode;
	}
	public void setAccountMode(String accountMode) {
		this.accountMode = accountMode;
	}
	public Integer getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Integer accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public Integer getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(Integer accountBalance) {
		this.accountBalance = accountBalance;
	}
	
	
	
}
