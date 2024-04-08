package com.mowitnow;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mowitnow.service.LawnMowerService;

import java.io.IOException;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MowItNowApplicationTests {

	@Autowired
	private LawnMowerService lawnMowerService;

	@Test
	public void testMowLawnFromFile() throws IOException {
		List<String> finalPositions = lawnMowerService.mowLawnFromFile("src/test/resources/input.txt");

		assertEquals("1 3 N", finalPositions.get(0));
		assertEquals("5 1 E", finalPositions.get(1));

	}
}
