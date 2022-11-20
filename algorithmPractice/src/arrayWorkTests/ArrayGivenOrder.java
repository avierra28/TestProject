package arrayWorkTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArrayGivenOrder {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		LinkedList<Integer> numbers = arrayWork.ArrayGivenOrder.insertArrayMethod(new int[] { 0, 1, 2, 3, 4 },
				new int[] { 0, 1, 2, 2, 1 });
		LinkedList<Integer> actuaLinkedList = new LinkedList<>();
		actuaLinkedList.add(0);
		actuaLinkedList.add(4);
		actuaLinkedList.add(1);
		actuaLinkedList.add(3);
		actuaLinkedList.add(2);
		System.out.println(actuaLinkedList);
		System.out.println(numbers);
		assertEquals(actuaLinkedList, numbers);
	}

}
