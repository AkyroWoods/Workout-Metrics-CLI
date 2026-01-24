package com.akyro;

import static org.junit.Assert.assertEquals;

import java.util.Scanner;

import org.junit.Test;

public class UserInterfaceTest {

    @Test
    public void testCommand1AddsExercise() {
        Workout workout = new Workout("Test Workout");
        UserInterface interface1 = new UserInterface(new Scanner("Bench Press\n5\n5\n225\nChest"));
        interface1.commandProcessor(workout, "1");

        assertEquals(1, workout.size());
    }

    @Test
    public void testInvalidCommandDoesNotModifyWorkout() {
        Workout workout = new Workout("Test Workout");
        UserInterface interface1 = new UserInterface(new Scanner(""));
        interface1.commandProcessor(workout, "abc");

        assertEquals(0, workout.size());
    }

}
