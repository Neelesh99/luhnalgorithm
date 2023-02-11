# luhnalgorithm

## Introduction
I have implemented the Luhn sum algorithm in the Kotlin language and with the gradle build system

## Instructions to get running
1. Clone the repo
2. Open up the folder in an IDE like IntelliJ with the Kotlin plugin installed
3. Use the build.gradle.kts file with the gradle wrapper to download dependencies (should be automatic in intelliJ)
4. run tests and acceptanceTests

## Assumptions

- I have assumed that to be a valid account number it must be of non-zero length and if a zero length account number is handed to the program it should exit with an error.
- Other than being empty the account number string can be of carrying length
- The full luhn sum total will be able to fit in a 64 bit signed integer
- The user will pass the account number as first command line argument and if no arguments are passed then we should treat as empty string passed and return false

## Structure
- The program starts from the main() function which accepts the account number as a string command line argument
- The account number string is passed to the StandardLuhnAccountValidator which implements the LuhnAccountValidator interface
- Account string validation is completed by the StandardAccountNumberValidator
- Luhn sum calculation is completed by the StandardLuhnSumCalculator
- The StandardLuhnAccountValidator uses these dependencies to deliver verdict on the validation
- I have used the arrows library to help ripple through exceptions and make the data flow clearer
