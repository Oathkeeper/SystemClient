package ca.owenpeterson.execution;

import java.util.List;

import ca.owenpeterson.builder.CommandBuilder;

public class CommandExecuter {
	public CommandExecuter(){};
	
	public String executeCommand(String command) {
		CommandBuilder commandBuilder = new CommandBuilder();
		List<String> commandFragments = commandBuilder.buildCommandArrayFromString(command);
		return "";
	}

}
