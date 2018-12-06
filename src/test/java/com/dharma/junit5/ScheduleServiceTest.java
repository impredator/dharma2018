package com.dharma.junit5;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import java.util.Locale;
import java.util.TimeZone;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@RunWith(JUnitPlatform.class)
public class ScheduleServiceTest {


    @Test
    public void doScheduleSingleTimeZone() {

        TimeZone tzone = TimeZone.getDefault();
        System.out.println(tzone.getDisplayName());
        assumeTrue(tzone.getDisplayName().equals("China Standard Time"));

        ScheduleService scheduleService = new ScheduleService();
        assertTrue(scheduleService.doSchedule());

    }

    @Test
    public void doScheduleLocaleNonUS() {

        Locale currentLocale = Locale.getDefault();
        System.out.println(currentLocale);
        assumeTrue(currentLocale.equals(Locale.US));

        ScheduleService scheduleService = new ScheduleService();
        assertTrue(scheduleService.doSchedule());

    }

    @Test
    public void backupCalendarMacos() {

        System.out.println(System.getProperty("os.name"));
        assumeTrue(System.getProperty("os.name").startsWith("Mac OS X"));

        ScheduleService scheduleService = new ScheduleService();
        assertTrue(scheduleService.backupCalendar());

    }
}
