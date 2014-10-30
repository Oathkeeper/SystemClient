package ca.owenpeterson.test.builder;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import ca.owenpeterson.builder.CommandBuilder;

public class CommandBuilderTest {
	
	CommandBuilder commandBuilder = new CommandBuilder();
	private final String TEST_COMMAND = "date | grep Oct";
	private final String[] EXPECTED_COMMAND_ARRAY = {"date", "|", "grep","Oct"};
	private final String[] EXPECTED_COMMAND_ARRAY_SPACES = {"date    ", " |      " , "   grep","   Oct"};

	@Test
	public void test_happyPath() {
		List<String> actual = commandBuilder.buildCommandArrayFromString(TEST_COMMAND);
		
		assertNotNull(actual);
		assertEquals(actual.size(), EXPECTED_COMMAND_ARRAY.length);
		
		for (int i = 0; i < EXPECTED_COMMAND_ARRAY.length; i++) {
			assertEquals(actual.get(i), EXPECTED_COMMAND_ARRAY[i]);
		}
		
	}
	
	@Test
	public void test_hasExtraSpaces() {
		List<String> actual = commandBuilder.buildCommandArrayFromString(TEST_COMMAND);
		
		assertNotNull(actual);
		assertEquals(actual.size(), EXPECTED_COMMAND_ARRAY_SPACES.length);
		
		//check that the values match the array with no spaces.
		for (int i = 0; i < EXPECTED_COMMAND_ARRAY.length; i++) {
			assertEquals(actual.get(i), EXPECTED_COMMAND_ARRAY[i]);
		}
		
	}
	
	

}
