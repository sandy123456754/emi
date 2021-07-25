package com.ledger.emi.model;

public enum CommandsEnum {

	LOAN("CREATE_LOAN"), PAYMENT("LUMPSUM_PAYMENT"), BALANCE("BALANCE_CHECK");

	private String command;

	private CommandsEnum(String command) {
		this.command = command;
	}

	public String getCommand() {
		return command;
	}

}
