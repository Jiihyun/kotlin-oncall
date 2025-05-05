# 📝 List of Features

## ▪︎ Input

- [x] Read the Month and start day of the week
    - [x] Throw an `IllegalArgumentException` if the value is null or blank
    - [x] Throw an `IllegalArgumentException` if the month value is not a number
    - [x] Throw an `IllegalArgumentException` if the value cannot separate by comma
    - [] Re-prompt input whenever an `IllegalArgumentException` occurs, resuming the process. ([ERROR] 유효하지 않은 입력 값입니다.
      다시 입력해 주세요.)

- [x] Read the weekday and weekend emergency service order
    - [x] Throw an `IllegalArgumentException` if the value is null or blank
    - [x] Throw an `IllegalArgumentException` if the value cannot separate by comma
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

- [x] Throw an `IllegalArgumentException` if the month value is not between 1 and 12

### ▪︎ Day of Week

- [x] Throw an `IllegalArgumentException` if the value is not between Sun and Sat

### ▪︎ Name

- [x] Throw an `IllegalArgumentException` if the usernames are duplicated.
- [x] Throw an `IllegalArgumentException` if the length of username exceeds 5.

### ▪︎ Team Size

- [] Throw an `IllegalArgumentException` if the length of sequence is not between 5 and 35
