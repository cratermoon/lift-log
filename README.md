The basic concept is the Workout. A workout has, at a minimum, a date/time and one or more Exercise. Each Exercise has one or more Working Sets that consists of a weight and a number of reps.

Optionally, the Workout can record the following:

* tempo of the workout
* the difficulty, or effort, as a subjective measure
* the duration of rest intervals
* an orthopedic index of any pain
* the rate of perceived exertion (RPE) is as follows (RPE below 6 is considered "warm up", not a work set:
	+ @10: Maximal Effort. No reps left in the tank.
	+ @9: Heavy Effort. Could have done one more rep.
	+ @8: Could have done two or three more reps.
	+ @7: Bar speed is "snappy" if maximal force is applied.
	+ @6: Bar speed is "snappy" with moderate effort.


https://www.t-nation.com/training/log-your-training-like-a-boss

``workout {
Date
1..n of exercise { 1..n of set: weight x reps }
rest intervals
tempo
difficulty/effort
Volume = sets x weight x reps
Intensity = volume / total reps
orthopedic index
RPE
}``


