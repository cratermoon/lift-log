package com.cmdev.lifting

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


case class Exercise(name: String, sets: ListBuffer[WorkSet]) {
  def volume: Int = sets.foldLeft(0) { (total, n) => total + n.volume }
  def addSet(set: WorkSet) = sets.append(set)
}

case class WorkSet(reps: Int, weight: Int) {
  def volume: Int = reps * weight
}

case class Workout(
  date: DateTime,
  exercises: ListBuffer[Exercise],
  restIntervals: Long,
  tempo: String,
  difficultyEffort: String
) {
  def volume = exercises.foldLeft(0) { (total, n) => total + n.volume }
}


class WorkoutRecord {

  val date = new DateTime()
  val workout = Workout(date, ListBuffer(), 0, "", "")

  def addExercise(exercise: Exercise) = {
    workout.exercises.append(exercise)
  }

  def makeSet(reps: Int, weight: Int) :WorkSet = {
    WorkSet(reps, weight)
  }

  def volume: Int = workout.volume
}
