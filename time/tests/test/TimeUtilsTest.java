package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import time.TimeUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;


class TimeUtilsTest {

	private TimeUtils tu = new TimeUtils();
	
	@ParameterizedTest(name="timeToSec")
	@CsvSource({ "0, 0:00:00", "-1, -1", "56, 0:00:56", "120, 0:02:00", "5556, 1:32:36", "86399, 23:59:59", "86400, -1"})
	void testTimeToSec(int luku, String tulos) {
		assertEquals(tulos, TimeUtils.secToTime(luku), "Syöte ei vastannut odotettua tulosta");
		
	}

}
