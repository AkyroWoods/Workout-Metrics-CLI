package com.akyro;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import org.junit.Test;

public class AnalyticsEngineTest {
    @Test
    public void testVolumePercentageBreakdown() {
        Workout workout = new Workout("Test Workout");
        AnalyticsEngine engine = new AnalyticsEngine();

        Exercise squat = new Exercise("Squat", 5, 5, 225, "legs");
        workout.addExercise(squat);
        Exercise deadlift = new Exercise("Deadlift", 5, 5, 225, "pull");
        workout.addExercise(deadlift);
        Exercise benchPress = new Exercise("Bench Press", 5, 5, 225, "chest");
        workout.addExercise(benchPress);

        engine.calculateVolumeBreakdown(workout);
        assertEquals(1.0 / 3, engine.getPushPercentage(), .001);
        assertEquals(1.0 / 3, engine.getPullPercentage(), .001);
        assertEquals(1.0 / 3, engine.getLegsPercentage(), .001);
    }

    @Test
    public void TestToAndBottomNExercises() {
        Workout workout = new Workout("Test Workout");
        AnalyticsEngine engine = new AnalyticsEngine();

        Exercise squat = new Exercise("Squat", 5, 5, 225, "legs");
        Exercise deadlift = new Exercise("Deadlift", 5, 5, 405, "pull");
        Exercise benchPress = new Exercise("Bench Press", 5, 3, 315, "chest");
        Exercise skullCrushers = new Exercise("Skull Crusher", 3, 12, 90, "Triceps");

        workout.addExercise(squat);
        workout.addExercise(deadlift);
        workout.addExercise(benchPress);
        workout.addExercise(skullCrushers);

        engine.calculateVolumeBreakdown(workout);
        List<Map.Entry<Exercise, Double>> topTwo = engine.topNExercises(workout, 2);

        assertEquals(2, topTwo.size());
        assertEquals(deadlift, topTwo.get(0).getKey());
        assertEquals(squat, topTwo.get(1).getKey());

        List<Map.Entry<Exercise, Double>> bottomTwo = engine.bottomNExercises(workout, 2);
        assertEquals(2, bottomTwo.size());
        assertEquals(benchPress, bottomTwo.get(0).getKey());
        assertEquals(skullCrushers, bottomTwo.get(1).getKey());

    }
}
