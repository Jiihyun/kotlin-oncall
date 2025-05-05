# 📝 List of Features

## ▪︎ Input

- [] Read the Month and start day of the week
    - [] Throw an `IllegalArgumentException` if the value is null or blank
    - [] Throw an `IllegalArgumentException` if the month value is not a number
    - [] Throw an `IllegalArgumentException` if the value cannot separate by comma
    - [] Re-prompt input whenever an `IllegalArgumentException` occurs, resuming the process. ([ERROR] 유효하지 않은 입력 값입니다.
      다시 입력해 주세요.)

- [] Read the weekday and weekend emergency service order
    - [] Throw an `IllegalArgumentException` if the value is null or blank
    - [] Throw an `IllegalArgumentException` if the value cannot separate by comma
    - [] Re-prompt input whenever an `IllegalArgumentException` occurs, resuming the process from the weekday input
      step. ([ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.)

## ▪︎ Output

- [] Show the oncall schedule
    - [] `(휴일)` marked after the day of the week only on weekdays and legal holidays

## ▪︎ Domain

- [] Assign Emergency workdays in order
    - []  change order if the worker works in a row
    - []  emergency workers must be organized once each on weekdays and holidays schedule.

## ▪︎ Exception

### ▪︎ Month

- [] Throw an `IllegalArgumentException` if the month value is not between 1 and 12

### ▪︎ Day of Week

- [] Throw an `IllegalArgumentException` if the value is not between Sun and Sat

### ▪︎ Name

- [] Throw an `IllegalArgumentException` if the usernames are duplicated.
- [] Throw an `IllegalArgumentException` if the length of username exceeds 5.

### ▪︎ Team Size

- [] Throw an `IllegalArgumentException` if the length of sequence is not between 5 and 35
