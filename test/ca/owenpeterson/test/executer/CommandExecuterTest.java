package ca.owenpeterson.test.executer;

import static org.junit.Assert.*;

import org.junit.Test;

import ca.owenpeterson.execution.CommandExecuter;

public class CommandExecuterTest {
	
	//private String commandString = "uptime";
	CommandExecuter commandExecuter = new CommandExecuter();

	@Test
	public void testCommandExecuter_HappyPath() {
		String commandString = "uptime";
		
		String actual = commandExecuter.executeCommand(commandString);
		
		assertNotNull(actual);
		System.out.println(actual);		
	}
	
	@Test
	public void testCommandExecuter_soMuchSpace() {
		String commandString = "date      -u";
		String actual = commandExecuter.executeCommand(commandString);
		
		assertNotNull(actual);
		System.out.println(actual);		
		
		
	}

}
