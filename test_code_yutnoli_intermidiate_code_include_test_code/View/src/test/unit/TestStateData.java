package test.unit;

import Model.StateData;
import java.util.Iterator;

import javax.naming.NameNotFoundException;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import junit.framework.JUnit4TestAdapter;

public class TestStateData {
	private StateData stateData; // test fixture variable.
	
	/* setUp method using @Before syntax. */
	/* @Before methods are run before each test. */
	/* initializes test fixture variables(stateData). */
	@Before 
	public void runBeforeEachTest(){
		System.out.println("Before testing.");
		stateData = new StateData();
	}
	
	/* check if essential member variables of PlayerData Class exists 
	 * and if shortly after creating the object, the member variables are initialized correctly. */
	@Test
	public void testInitialMemberVars(){
		assertEquals(9, stateData.getTeam());
		assertEquals(0, stateData.getNumber());
	}
	
	/* tear-down method using @After. */
	/* @After methods are run after each test. */
	/* frees test fixture variables(stateData). */
	@After 
	public void runAfterEachTest() {
		System.out.println("After testing.");
		stateData = null;
		
		/* execute garbage collection. */
		System.gc();
	}
	
}