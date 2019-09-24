# Weight-Lifting-BE

TDD - https://docs.google.com/document/d/1GZSK3VbwwB-0ZrGDnn95W36WeZnucJy_4mmDeHqRpUs/edit

Base URL: https://weight-lifting-journal-bw.herokuapp.com/

Front End: TBD

## Register & Login

Method | Endpoint | Description 
------ | -------- | -----------
POST | `/auth/register` | accepts `username`, `password`, and creates a  `user`, and returns an id number
POST | `/auth/login` | accepts `username` and `password` and returns a message welcoming user, and a token if username and passwords match


### Accepted Register & Login Schema
```
 {
   "username": string,
   "password": string
 }
```

## Exercises
#### all endpoints require authorization token

Method | Endpoint | Description
------ | -------- | -----------
PUT | `/exercise/{exerciseid}` | returns the updated exercise
DELETE | `/exercise/{exerciseid}` | returns whether or not the exercise has been deleted

### Accepted Exercise Schema
```
```

## Workouts
#### all endpoints require authorization token

Method | Endpoint | Description
------ | -------- | -----------
GET | `/workouts/all` | returns all previous workouts
GET | `/workouts/{workoutid}` | returns workout with specified id
POST | `/workouts/current` | creates a new workout
POST | `/workouts/{workoutid}` | adds a new exercise to the specified workout

### Accepted Workouts Schema

#### POST `/workouts/current`
```
{
	"workoutname": "Pull-ups & chin-ups",
	"workoutlength": "2 minutes"
}
```
#### POST `workouts/{workoutid}`
```
{
	"exercisename": "Pull-ups",
	"weightlifted": "Body weight",
	"reps": "3 x 10",
	"restperiod": "3 minutes",
	"exerciseregion": "Upper Body"
}
```