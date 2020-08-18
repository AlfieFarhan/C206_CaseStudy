import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	
	private MoneyHolding mh1;
	private MoneyHolding mh2;
	private ArrayList<MoneyHolding> MoneyHoldingList;
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}
	
	public void addMoneyHolding() {
		// Item list is not null, so that can add a new item - boundary
		assertNotNull("Check if there is valid MoneyHolding arraylist to add to", MoneyHoldingList);
		//Given an empty list, after adding 1 item, the size of the list is 1 - normal
		//The item just added is as same as the first item of the list
		C206_CaseStudy.addMoneyHolding(MoneyHoldingList, mh1);
		assertEquals("Check that moneyholder arraylist size is 1", 1, MoneyHoldingList.size());
		assertSame("Check that money holder is added", mh1, MoneyHoldingList.get(0));
		
		//Add another item. test The size of the list is 2? -normal
		//The item just added is as same as the second item of the list
		C206_CaseStudy.addMoneyHolding(MoneyHoldingList, mh2);
		assertEquals("Check that MoneyHolding arraylist size is 2", 2, MoneyHoldingList.size());
		assertSame("Check that MoneyHolding is added", mh2, MoneyHoldingList.get(1));
	}

}
