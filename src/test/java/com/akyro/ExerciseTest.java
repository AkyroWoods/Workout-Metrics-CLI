package com.akyro;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import model.Exercise;

public class ExerciseTest {

    @Test
    public void testInvalidExerciseParameters() {
        try {
            new Exercise("Bench", -1, 5, 225, "chest");
            fail("Expected Illegal Argument Exception for negative sets");

        } catch (IllegalArgumentException e) {
        }
        try {
            new Exercise("Bench", 5, -5, 225, "chest");
            fail("Expected Illegal Argument Exception for negative reps");

        } catch (IllegalArgumentException e) {
        }
        try {
            new Exercise("Bench", 5, 5, -225, "chest");
            fail("Expected Illegal Argument Exception for negative weight");

        } catch (IllegalArgumentException e) {
        }
        try {
            new Exercise("", 5, 5, 225, "chest");
            fail("Expected Illegal Argument Exception for blank name");

        } catch (IllegalArgumentException e) {
        }
        try {
            new Exercise("Bench", 5, 5, 225, "");
            fail("Expected Illegal Argument Exception for blank muscle group");

        } catch (IllegalArgumentException e) {
        }

    }

    @Test
    public void testExerciseClassification() {
        Exercise exercise = new Exercise("Bench", 5, 5, 225, "chest");
        assertEquals("Push", exercise.classifyExercise());
    }
}
