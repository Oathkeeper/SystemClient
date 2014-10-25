package ca.owenpeterson.systeminterface;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ca.owenpeterson.execution.CommandExecuter;

public class SystemInterface {
	
	Logger logger = LogManager.getLogger(SystemInterface.class);

	public SystemInterface(){};
	
	public String getCommandOutput(String inputCommand) {
		CommandExecuter commandExecuter = new CommandExecuter();
		String output = commandExecuter.executeCommand(inputCommand);
		return output;
		 
	}
	
	
	
}
