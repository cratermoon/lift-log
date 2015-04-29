package com.cmdev.lifting

import scala.collection.mutable.ListBuffer

import org.joda.time._

import org.specs2.mutable._

class WorkoutSpec extends Specification {
  "A workout" should {
    "have a date" in {
      val workout = new WorkoutRecord
      workout.date must not be null
    }
    "have the volume equal to all exercise volumes" in {
      val workout = new WorkoutRecord
      val set1 = WorkSet(3,10)
      val bench = Exercise("bench", ListBuffer(set1))
      val set2 = WorkSet(5,5)
      bench.addSet(set2)
      val setA = WorkSet(5,100)
      val setB = WorkSet(3,120)
      val squat = Exercise("squat", ListBuffer(setA, setB))
      workout.addExercise(bench)
      workout.addExercise(squat)
      workout.volume === bench.volume + squat.volume
    }
  }

  "An exercise" should {
    "have at least one set" in {
      val testSet = WorkSet(3,10)
      val testExercise = Exercise("bench", ListBuffer(testSet))
      testExercise.name === "bench"
      testExercise.sets.size === 1
      val set2 = WorkSet(5,5)
      testExercise.addSet(set2)
      testExercise.volume ==== testSet.volume + set2.volume
    }
  }

  "A working set" should {
    "have a volume" in {
      val testSet = WorkSet(3,10)
      testSet.volume mustEqual 30 
    }
  }
}
