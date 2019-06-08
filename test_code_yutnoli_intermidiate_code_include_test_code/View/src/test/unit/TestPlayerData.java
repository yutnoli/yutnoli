package test.unit;

import Model.PlayerData;
import java.util.Iterator;

import javax.naming.NameNotFoundException;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import junit.framework.JUnit4TestAdapter;

public class TestPlayerData {
	private PlayerData playerData; // test fixture variable.
	
	/* setUp method using @Before syntax. */
	/* @Before methods are run before each test. */
	/* initializes test fixture variables(playerData). */
	@Before 
	public void runBeforeFindMoveTest(){
		System.out.println("Before testing.");
		playerData = new PlayerData();
	}
	
	/* check if essential member variables of PlayerData Class exists 
	 * and if shortly after creating the object, the member variables are initialized correctly. */
	@Test
	public void testInitialMemberVars(){
		assertEquals(9, playerData.getTeam());
		assertEquals(0, playerData.getNumber());
		assertEquals(1, playerData.getThrowCount());
		assertEquals(0, playerData.getFinish());
	}

	
	/* check if findMove works correctly. */
	@Test 
	public void testFindMove(){
		ArrayList<Integer> moves = playerData.getMoves();
		
		moves.add(1);
		moves.add(3);
		moves.add(4);
		
		assertEquals(true, playerData.findMove(1));
		assertEquals(false, playerData.findMove(2));
		assertEquals(true, playerData.findMove(3));
		assertEquals(true, playerData.findMove(4));
		assertEquals(false, playerData.findMove(5));
	}
	
	/* tear-down method using @After. */
	/* @After methods are run after each test. */
	/* frees test fixture variables(playerData). */
	@After 
	public void runAfterFindMoveTest() {
		System.out.println("After testing.");
		
		playerData = null;
		
		/* execute garbage collection. */
		System.gc();
	}
	
}
