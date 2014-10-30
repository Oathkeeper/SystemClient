package ca.owenpeterson.systeminterface;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ca.owenpeterson.exception.CommandExecutionException;
import ca.owenpeterson.exception.CommandOutputException;
import ca.owenpeterson.execution.CommandExecuter;

public class SystemInterface {
	
	Logger logger = LogManager.getLogger(SystemInterface.class);

	public SystemInterface(){};
	
	public String getCommandOutput(String inputCommand) throws CommandExecutionException, CommandOutputException {
		if (StringUtils.isBlank(inputCommand)) {
			throw new IllegalArgumentException("Input command cannot be blank!");
		}
		logger.debug("SystemInterface(): getCommandOutput(): beginning command execution for command: " + inputCommand);
		CommandExecuter commandExecuter = new CommandExecuter();
		String output = commandExecuter.executeCommand(inputCommand);
		
		if (StringUtils.isBlank(output)) {
			logger.error("Command execution did not produce any output!");
			throw new CommandOutputException("Command has not produced any output!");
		}
		
		logger.debug("SystemInterface(): getCommandOutput(): finished execution for command: " + inputCommand);
		return output;
		 
	}
	
	
	
}
