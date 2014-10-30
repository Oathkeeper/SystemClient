package ca.owenpeterson.systeminterface;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ca.owenpeterson.execution.CommandExecuter;

public class SystemInterface {
	
	Logger logger = LogManager.getLogger(SystemInterface.class);

	public SystemInterface(){};
	
	public String getCommandOutput(String inputCommand) {
		if (StringUtils.isBlank(inputCommand)) {
			throw new IllegalArgumentException("Input command cannot be blank!");
		}
		logger.debug("SystemInterface(): getCommandOutput(): beginning command execution for command: " + inputCommand);
		CommandExecuter commandExecuter = new CommandExecuter();
		String output = commandExecuter.executeCommand(inputCommand);
		return output;
		 
	}
	
	
	
}
