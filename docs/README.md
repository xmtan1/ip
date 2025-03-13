# Lisa User Guide

Lisa is a chatbot that helps you to keep track of our tasks! 
Here is a short guide on how to use Lisa.

> Notes about the command format:
> - Words within the curly brackets are the parameters to be supplied by the user.
> - Words in `UPPER_CASE` are outputs that depend on the current list. 
> - Words in brackets are stand-ins for expected outputs and are not the actual output.
> - All commands are to be entered in lower case.
> - When inputting dates, use day/time format instead of dd/mm/yyyy format.
>   - e.g. `friday 4pm` instead of `10/01/2025`

## Add todo: `todo`

Adds a todo task to the list. 

Format: `todo {description}`

Examples: 
- `todo homework`
- `todo iron the clothes`

Expected output:
```
Got it! I've added this task:
  [T][ ] {description}
You now have NUMBER_OF_TASKS things in your list. Better get to them!
```
- `[T]` denotes that this task is a todo task.

## Add deadline: `deadline`

Adds a deadline task to the list.

Format: `deadline {description} /by {date}`

Examples:
- `deadline EE2026 code /by Monday`
- `deadline finish project /by Friday 2359`

Expected output:
```
Got it! I've added this task:
  [D][ ] {description} (by: {date})
You now have NUMBER_OF_TASKS things in your list. Better get to them!
```
- `[D]` denotes that this task is a deadline task.

## Add event: `event`

Adds an event task to the list.

Format: `event {description} /from {date/time} /to {date/time}`

Examples:
- `event lecture /from Thursday 4pm /to 6pm`
- `event overseas vacation /from Monday /to Friday`

Expected output:
```
Got it! I've added this task:
  [E][ ] {description} (from: {date} to: {date})
You now have NUMBER_OF_TASKS things in your list. Better get to them!
```
- `[E]` denotes that this task is en event task.

## Mark task: `mark` / `unmark`

Marks a task as complete or incomplete.

Format: `mark {task index}` / `unmark {task index}`
- `[task index]` must be between 1 and the number of tasks currently in the list, inclusive.

Examples:
- `mark 1`
- `unmark 4`

Sample expected output:
```
Okay, task {task index} has been marked. :)
--------------------------------------------------------------
Here's your list of tasks:
1. [T][X] (...)
```
```
Okay, task 2 has been unmarked!
--------------------------------------------------------------
Here's your list of tasks:
1. [T][ ] (...)
```
- Note: `[X]` denotes that the task is marked completed. `[ ]` denotes that the task
 is incomplete.


## Delete task: `delete`

Removes a task from the list.

Format: `delete {task index}`
- `{task index}` must be between 1 and the number of tasks currently in the list, inclusive.

Examples:
- `delete 4`

Sample expected output:

```
Okay! I've removed this task:
 [T][ ] (...)
You now have NUMBER_OF_TASKS things in your list!
```

## Find task: `find`

Finds tasks whose task description contain the given keyword. 

Format: `find {keyword}`

Examples: 
- `find homework`

Sample expected output:
```
Here's the list of matching tasks:
1.[D][ ] homework (...)
2.[T][ ] do homework 
```

## Exit the program: `bye`

Exits the program

Format: `exit`

## Saving the data

Lisa lists are saved in the hard disk automatically after any command that changes the list.
There is no need to save manually.


