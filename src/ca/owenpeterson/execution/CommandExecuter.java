package ca.owenpeterson.execution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ca.owenpeterson.builder.CommandBuilder;
import ca.owenpeterson.utils.FormatUtils;

public class CommandExecuter {
	
	private static Logger logger = LogManager.getLogger(CommandExecuter.class);
	
	public CommandExecuter(){};
	
	public String executeCommand(String command) throws IllegalArgumentException {
		if (StringUtils.isBlank(command)) {
			throw new IllegalArgumentException("Command cannot be blank!");
		}
		logger.debug("CommandExecuter(): executeCommand(): begin executing command: " + command);
		CommandBuilder commandBuilder = new CommandBuilder();
		logger.debug("converting command string into string array.");
		List<String> commandFragments = commandBuilder.buildCommandArrayFromString(command);
		logger.debug("running command using command array.");
		String output = buildStringFromCommandArray(commandFragments);
		logger.debug("Command execution complete. returning output.");
		return output;
	}
	
	public static String buildStringFromCommandArray(List<String> command) {
		String line;
		int lineCount = 0;
		StringBuilder cmdOutput = new StringBuilder();
		ProcessBuilder pb = new ProcessBuilder(command);

		try {
			Process proc = pb.start();
			logger.debug("Executing command " + command.toString());
			BufferedReader stdOut = new BufferedReader(new InputStreamReader(
					proc.getInputStream()));
			logger.debug("Input Stream created");

			while ((line = stdOut.readLine()) != null) {
				cmdOutput.append(FormatUtils.reduceWhitespace(line) + "\n");
				
				if (command.toString().contains("sensors") && line.length() == 0) {
					cmdOutput.append(";");
				}
				
				lineCount++;
			}
			proc.waitFor();
			logger.debug("Waiting for process to complete.");

			stdOut.close();

		} catch (IOException iox) {
			logger.error("Could not establish input stream.");
		} catch (NoSuchElementException nsex) {
			logger.error(nsex);
		} catch (Exception e) {
			logger.error(e);
		}
		logger.debug("Number of lines processed: " + lineCount);

		return cmdOutput.toString();
	}

}
