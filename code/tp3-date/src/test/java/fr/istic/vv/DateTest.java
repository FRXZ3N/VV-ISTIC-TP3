package fr.istic.vv;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DateTest {


  @Test
  void isValidDateLeapYear() {
    assertTrue(Date.isValidDate(29, 2, 2000));
    assertTrue(Date.isValidDate(15, 2, 2000));
    assertFalse(Date.isValidDate(30, 2, 2000));
  }

  @Test
  void exceptionWhenInvalidDate() {
    assertThrows(IllegalArgumentException.class, () -> new Date(29, 2, 2001));
  }

  @Test
  void isValidDateNotLeapYear() {
    assertFalse(Date.isValidDate(29, 2, 2001));
    assertTrue(Date.isValidDate(28, 2, 2001));
  }

  @Test
  void isValidDateWithMonthInferiorTo1() {
    assertFalse(Date.isValidDate(1, 0, 2000));
  }

  @Test
  void isValidDateWithMonthSuperiorTo12() {
    assertFalse(Date.isValidDate(1, 13, 2000));
  }

  @Test
  void isValidDateWith31DaysMonth() {
    assertTrue(Date.isValidDate(31, 1, 2000));
    assertTrue(Date.isValidDate(31, 3, 2000));

    assertFalse(Date.isValidDate(31, 4, 2000));
    assertFalse(Date.isValidDate(31, 6, 2000));

  }

  @Test
  void isValidDateWith30DaysMonth() {
    assertTrue(Date.isValidDate(30, 4, 2000));
    assertTrue(Date.isValidDate(30, 6, 2000));

    assertFalse(Date.isValidDate(31, 4, 2000));
    assertFalse(Date.isValidDate(31, 6, 2000));
  }

  @Test
  void isValidDateWithDayInferiorTo1() {
    assertFalse(Date.isValidDate(0, 2, 2000));
  }

  @Test
  void isValidDateWithDaySuperiorTo31() {
    assertFalse(Date.isValidDate(32, 2, 2000));
  }

  @Test
  void isLeapYearWhenYearIsDivisibleBy4AndBy100OrBy400() {
    assertTrue(Date.isLeapYear(2000));
    assertTrue(Date.isLeapYear(1600));
  }

  @Test
  void isLeapYearWhenYearIsDivisibleBy4AndBy100ButNotBy400() {
    assertFalse(Date.isLeapYear(1900));
    assertFalse(Date.isLeapYear(1800));
  }

  @Test
  void isLeapYearWhenYearIsDivisibleBy4ButNotBy100() {
    assertTrue(Date.isLeapYear(4));
    assertTrue(Date.isLeapYear(16));
  }

  @Test
  void isLeapYearWhenYearIsNotDivisibleBy4() {
    assertFalse(Date.isLeapYear(2001));
    assertFalse(Date.isLeapYear(2002));
  }

  @Test
  void compareToWhenDateAreEquals() {
    assertEquals(0, new Date(1, 1, 2000).compareTo(new Date(1, 1, 2000)));
  }

  @Test
  void compareToWhenDateIsSuperior() {
    assertEquals(1, new Date(1, 1, 2001).compareTo(new Date(1, 1, 2000)));
  }

  @Test
  void compareToWhenDateIsInferior() {
    assertEquals(-1, new Date(1, 1, 2000).compareTo(new Date(1, 1, 2001)));
  }

  @Test
  void nextDateWhenNextYear() {
    assertEquals(0, new Date(1, 1, 2001).compareTo(new Date(31, 12, 2000).nextDate()));
  }

  @Test
  void nextDateWhenNextMonthFor31DaysMonth() {
    assertEquals(0, new Date(1, 2, 2000).compareTo(new Date(31, 1, 2000).nextDate()));
  }

  @Test
  void nextDateWhenNextMonthFor30DaysMonth() {
    assertEquals(0, new Date(1, 12, 2000).compareTo(new Date(30, 11, 2000).nextDate()));
    assertNotEquals(0, new Date(1, 11, 2000).compareTo(new Date(30, 10, 2000).nextDate()));
  }

  @Test
  void nextDateWhenNextMonthFor28DaysMonth() {
    assertEquals(0, new Date(1, 3, 2001).compareTo(new Date(28, 2, 2001).nextDate()));
  }

  @Test
  void nextDateWhenNextMonthFor29DaysMonth() {
    assertEquals(0, new Date(1, 3, 2000).compareTo(new Date(29, 2, 2000).nextDate()));
  }

  @Test
  void testNextDate() {
    assertEquals(0, new Date(2, 2, 200).compareTo(new Date(1, 2, 200).nextDate()));
  }

  @Test
  void previousDateWhenPreviousYear() {
    assertEquals(0, new Date(31, 12, 2000).compareTo(new Date(1, 1, 2001).previousDate()));
  }

  @Test
  void previousDateWhenPreviousMonthFor31DaysMonth() {
    assertEquals(0, new Date(30, 6, 2000).compareTo(new Date(1, 7, 2000).previousDate()));
  }

  @Test
  void previousDateWhenPreviousMonthFor30DaysMonth() {
    assertEquals(0, new Date(31, 8, 2000).compareTo(new Date(1, 9, 2000).previousDate()));
    assertNotEquals(0, new Date(31, 8, 2010).compareTo(new Date(1, 10, 2010).previousDate()));
  }

  @Test
  void previousDateWhenPreviousMonthFor28DaysMonth() {
    assertEquals(0, new Date(28, 2, 2001).compareTo(new Date(1, 3, 2001).previousDate()));
    assertNotEquals(0, new Date(28, 2, 2000).compareTo(new Date(1, 3, 2000).previousDate()));
  }

  @Test
  void previousDateWhenPreviousMonthFor29DaysMonth() {
    assertEquals(0, new Date(29, 2, 2000).compareTo(new Date(1, 3, 2000).previousDate()));
    assertNotEquals(0, new Date(27, 2, 2001).compareTo(new Date(1, 3, 2001).previousDate()));
  }

  @Test
  void testPreviousDate() {
    assertEquals(0, new Date(2, 4, 200).compareTo(new Date(3, 4, 200).previousDate()));
  }

}