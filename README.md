# luhnalgorithm

## Assumptions

- I have assumed that to be a valid account number it must be of non-zero length and if a zero length account number is handed to the program it should exit with an error.
- Other than being empty the account number string can be of carrying length
- The full luhn sum total will be able to fit in a 64 bit signed integer
- The user will pass the account number as first command line argument and if no arguments are passed then we should treat as empty string passed and return false
