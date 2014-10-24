package ca.owenpeterson.builder;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ca.owenpeterson.utils.FormatUtils;

public class CommandBuilder {
	
	Logger logger = LogManager.getLogger(CommandBuilder.class);
	
	public List<String> buildCommandArrayFromString(String inputCommand) {
		logger.debug("Builing array for command: " + inputCommand);
		String command = inputCommand;
		List<String> commandFragments = new ArrayList<String>();
		
		command = FormatUtils.reduceWhitespace(command);
		
		while(StringUtils.contains(command, " ")) {
			String fragment = StringUtils.substringBefore(command, " ");
			fragment = StringUtils.remove(fragment, " ");
			commandFragments.add(fragment);
			logger.debug("Added: " + fragment);
			
			command = StringUtils.substringAfter(command, " ");
		}
		
		if (command.length() != 0 || null != command) {
			commandFragments.add(command);
			logger.debug("Added: " + command); 
		}
		
		return commandFragments;
		
	}

}
