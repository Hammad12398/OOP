package uk.ac.aston.oop.calendar;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class DayTest {

    @Test
    public void appointmentStartOfDay() {
        Day ji = new Day(1);
        Appointment ha = new Appointment("meeting", 1);
        boolean appointmentmade = ji.makeAppointment(Day.START_OF_DAY, ha);
        Appointment fetched = ji.getAppointment(Day.START_OF_DAY);
        assertTrue(appointmentmade, "Making an appointment at the start of a new day should work");
        assertSame(ha, fetched, "It should be possible to fetch the appointment we just made");
    }

    @Test
    public void appointmentBeforeStartOfDay() {
        Day day = new Day(1);
        Appointment appointment = new Appointment("early meeting", 1);

        // Act
        boolean success = day.makeAppointment(Day.START_OF_DAY - 1, appointment);
        Appointment fetched = day.getAppointment(Day.START_OF_DAY - 1);

        // Assert
        assertFalse(success, "Making an appointment before the start of the day should not work");
        assertNull(fetched, "There should be no appointment at the specified time");
    }

    @Test
    public void twoAppsOnSameTime() {
        // Arrange
        Day day = new Day(1);
        Appointment appA = new Appointment("meeting A", 1);
        Appointment appB = new Appointment("meeting B", 1);

        // Act
        boolean successA = day.makeAppointment(Day.START_OF_DAY, appA);
        Appointment fetchedA = day.getAppointment(Day.START_OF_DAY);
        boolean successB = day.makeAppointment(Day.START_OF_DAY, appB);
        Appointment fetchedB = day.getAppointment(Day.START_OF_DAY);

        // Assert
        assertTrue(successA, "Making an appointment in an empty slot should work");
        assertSame(appA, fetchedA, "The expected appointment A was fetched back from the Day at the expected time");
        assertFalse(successB, "Making an appointment in an occupied slot should not work");
        assertSame(appA, fetchedB, "The second appointment should not overwrite the existing one");
    }

    @Test
    public void twoHourAppointmentAtStart() {
        // Arrange
        Day day = new Day(1);
        Appointment twoHourAppointment = new Appointment("long meeting", 2);

        // Act
        boolean success = day.makeAppointment(Day.START_OF_DAY, twoHourAppointment);
        Appointment fetched9AM = day.getAppointment(Day.START_OF_DAY);
        Appointment fetched10AM = day.getAppointment(Day.START_OF_DAY + 1);

        // Assert
        assertTrue(success, "Making a 2-hour appointment at the start of the day should work");
        assertSame(twoHourAppointment, fetched9AM, "Fetching the appointment at 9 o'clock should return the 2-hour appointment");
        assertSame(twoHourAppointment, fetched10AM, "Fetching the appointment at 10 o'clock should return the same 2-hour appointment");
    }

    @Test
    public void twoHourAppointmentBeyondEnd() {
        Day day = new Day(1);
        Appointment appointment = new Appointment("Long Meeting", 2);

        // Act
        boolean success = day.makeAppointment(Day.FINAL_APPOINTMENT_TIME - appointment.getDuration(), appointment);
        Appointment fetched5pm = day.getAppointment(Day.FINAL_APPOINTMENT_TIME - 1);
        Appointment fetched6pm = day.getAppointment(Day.FINAL_APPOINTMENT_TIME);

        // Assert
        assertFalse(success, "Making a 2-hour appointment beyond the end of the day should not work");
        assertNull(fetched5pm, "There should be no appointment at 5pm");
        assertNull(fetched6pm, "There should be no appointment at 6pm");
    }

    @Test
    public void overlappingTwoHourAppointments() {
        // Arrange
        Day day = new Day(1);
        Appointment firstTwoHourAppointment = new Appointment("meeting 1", 2);
        Appointment overlappingTwoHourAppointment = new Appointment("meeting 2", 2);

        // Act
        // Book the first 2-hour slot (11-13)
        day.makeAppointment(Day.START_OF_DAY + 2, firstTwoHourAppointment);

        // Try to book an overlapping 2-hour slot (10-12)
        boolean success = day.makeAppointment(Day.START_OF_DAY + 1, overlappingTwoHourAppointment);

        // Assert
        assertFalse(success, "Booking an overlapping 2-hour appointment should not work");
    }
}
