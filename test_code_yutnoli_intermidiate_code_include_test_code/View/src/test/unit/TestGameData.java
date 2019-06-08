package test.unit;

import Model.GameData;
import java.util.Iterator;

import javax.naming.NameNotFoundException;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import junit.framework.JUnit4TestAdapter;

public class TestGameData {
	private GameData gameData; // test fixture variable.
	
	/* setUp method using @Before syntax. */
	/* @Before methods are run before each test. */
	/* initializes test fixture variables(gameData). */
	@Before 
	public void runBeforeEachTest(){
		System.out.println("Before testing.");
		gameData = GameData.getInstance();
	}
	
	
	/* check if initGameData works correctly. */
	@Test 
	public void testInitGameData(){
		for(int i = 1; i <= 3; i++) {
			for(int j = 1; j<=5; j++) {
				gameData.initGameData(i, j);
				assertEquals(i, gameData.getNumOfPlayers());
				assertEquals(j, gameData.getNumOfStones());
			}
		}
	}	
	
	
	/* tear-down method using @After. */
	/* @After methods are run after each test. */
	/* frees test fixture variables(gameData). */
	@After 
	public void runAfterEachTest() {
		System.out.println("After testing.");
		gameData = null;
		
		/* execute garbage collection. */
		System.gc();
	}
	
}