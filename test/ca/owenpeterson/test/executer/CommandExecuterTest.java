package ca.owenpeterson.test.executer;

import static org.junit.Assert.*;

import org.jmock.Mockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Before;
import org.junit.Test;

import ca.owenpeterson.execution.CommandExecuter;

public class CommandExecuterTest {
	
	Mockery mockery;	
	CommandExecuter commandExecuter = new CommandExecuter();
	
	@Before
	public void setUp() throws Exception {
		mockery = new Mockery();
		mockery.setImposteriser(ClassImposteriser.INSTANCE);		
	}

	@Test
	public void testCommandExecuter_HappyPath() throws Exception {
		String commandString = "uptime";
		
		String actual = commandExecuter.executeCommand(commandString);
		
		assertNotNull(actual);
		System.out.println(actual);		
	}
	
	@Test
	public void testCommandExecuter_soMuchSpace() throws Exception {
		String commandString = "date      -u";
		String actual = commandExecuter.executeCommand(commandString);
		
		assertNotNull(actual);
		System.out.println(actual);		
	}
	
	@Test
	public void testCommandExecuter_Sensors() throws Exception {
		String commandString = "sensors";
		String actual = commandExecuter.executeCommand(commandString);
		
		assertNotNull(actual);
		System.out.println(actual);		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCommandExecuter_BlankCommand() throws Exception {
		String commandString = "";
		String actual = commandExecuter.executeCommand(commandString);
		
		assertNull("Command results should be null.", actual);
		
	}
	
	

}
