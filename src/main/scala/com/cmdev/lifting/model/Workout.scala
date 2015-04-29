package com.cmdev.lifting.model

import scala.collection.mutable.ListBuffer

import org.joda.time.DateTime

/*
workout {
Date
1..n of exercise { 1..n of set: weight x reps }
rest intervals
tempo
difficulty/effort
Volume = sets x weight x reps
Intensity = volume / total reps
orthopedic index
RPE
}
*/

trait ExerciseTrait {
  def name: String 
  def sets: ListBuffer[WorkSet]
  def volume: Int = sets.foldLeft(0) { (total, n) => total + n.volume }
  def addSet(set: WorkSet) = sets.append(set)
}

case class Exercise(override val name: String, override val sets: ListBuffer[WorkSet]) extends ExerciseTrait
case class BenchPress(override val sets: ListBuffer[WorkSet]) extends ExerciseTrait { override val name = "Bench Press" }
case class Squat(override val sets: ListBuffer[WorkSet], override val name: String = "Squat") extends ExerciseTrait

case class WorkSet(reps: Int, weight: Int) {
  def volume: Int = reps * weight
}

case class Workout(
  date: DateTime,
  exercises: ListBuffer[ExerciseTrait],
  restIntervals: Long,
  tempo: String,
  difficultyEffort: String
) {
  def volume = exercises.foldLeft(0) { (total, n) => total + n.volume }
}


class WorkoutRecord {

  val date = new DateTime()
  val workout = Workout(date, ListBuffer(), 0, "", "")

  def addExercise(exercise: ExerciseTrait) = {
    workout.exercises.append(exercise)
  }

  def makeSet(reps: Int, weight: Int) :WorkSet = {
    WorkSet(reps, weight)
  }

  def volume: Int = workout.volume
}
