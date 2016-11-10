# Notes on Scala

## Variable identifiers
var - variable contents can change
val - constant variable, similar to java final

## Data types
Byte, Boolean, Char, Short, Int, Long, Float, Double

## Big datatypes
BigInt, BigDecimal (constructor takes in a string of either a huge int or a huge decimal)

## Conditional and Logical 
Same as java

## If/else statements
Can return a value similar to a java ternary operator

Ex: val canVote = if(age >= 18) "yes" else "no"

with multiple conditions and outcomes

if((age >=5) && (age <= 6)){
  println("Go to kindergarten")
} else if((age > 6) && (age <= 7)){
  println("Go to grade 1")
} else {
  println("Go to grade " + (age-5))
}
