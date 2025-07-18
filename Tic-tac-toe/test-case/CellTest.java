package com.aurionpro.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CellTest {
	
	Cell cell;
	
	@BeforeEach
	void init() {
		cell = new Cell();
	}

	@Test
	void testCell() {
		assertEquals(' ', cell.getValue());
	}

	@Test
	void testGetValue() {
		cell.setValue('X');
		assertEquals('X', cell.getValue());
	}

	@Test
	void testSetValue() {
		cell.setValue('O');
//		cell.setValue('X');
		assertEquals('O', cell.getValue());
		assertThrows(IllegalStateException.class, ()->{cell.setValue('O');});
	}

}
