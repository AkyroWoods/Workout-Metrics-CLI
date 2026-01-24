package com.akyro;

import static org.junit.Assert.*;
import org.junit.Test;

public class WorkoutTest {

    @Test
    public void testTotalWorkoutVolume() {
        Workout workout = new Workout("Test Workout");

        Exercise squat = new Exercise("Squat", 5, 5, 225, "legs");
        Exercise deadlift = new Exercise("Deadlift", 5, 5, 225, "pull");
        Exercise benchPress = new Exercise("Bench Press", 5, 5, 225, "chest");

        workout.addExercise(squat);
        workout.addExercise(deadlift);
        workout.addExercise(benchPress);

        double expectedVolume = 16875;
        assertEquals(expectedVolume, workout.calculateTotalWorkoutVolume(), 0.001);
    }

    @Test
    public void testEmptyWorkout() {
        Workout workout = new Workout("Test Workout");
        assertEquals(0.0, workout.calculateTotalWorkoutVolume(), .001);
    }

}
