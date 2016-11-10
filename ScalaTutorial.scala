import scala.io.StdIn.{readLine, readInt};
//object serves a similar purpose to the java file's main class of the file
object ScalaTutorial{
  //Main method, similar to the java main method
  def main(args: Array[String]){
    //Semi-colon is not required but Java does, so :P
    var i = 0;
    
    println("While loop:");
    //While loop like java
    while(i <= 10){
      //println works as System.out.println
      println(i);
      i += 1;
    }

    i = 0;
    println("\nDo while loop:");
    //Similar to java's do while
    do{
      println(i);
      i += 1;
    }while(i <= 10);

    //For loop iteration (i <- 1 sets i as 1 in the loop)
    println("\nFor loop:");
    for(i <- 1 to 10){
      println(i);
    }
    
    //For loop 'until' keyword
    println("\nFor loop with strings:");
    val randLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    for(i <- 0 until randLetters.length){
      //different than java(oh my)
      println(randLetters(i));
    }

    //For-each loop
    println("\nFor each loop with List:");
    val aList = List(1,2,3,4,5);
    for(i <- aList){
      println("List items " + i);
    }

    //Filter example
    //Yield stores the value(s) of i in the filter
    println("\nFilter example (prints only even numbers from 1-20");
    var evenList = for {i <- 1 to 20
      if (i % 2) == 0
    } yield i;

    for(i <- evenList){
      println(i);
    }
    
    //Nested for loop
    println("\nNested for loop:");
    for(i <- 1 to 5; j <- 6 to 10){
      println("i: " + i);
      println("j: " + j);
    }

    //Function example
    def printPrimes(){
      println("\nFunction example:");
      val primeList = List(1,2,3,5,7,11);
      for(i <- primeList){
        if(i == 11){
          //return statement
          return;
        }

        if(i != 1){
          println(i);
        }
      }
    }
    printPrimes;

    //Input example
    println("\nInput example:");
    var numberGuess = 0;

    do{
      //toInt converts string (in this case, readLine) to an integer
      //readInt reads the line as an integer straight up
      //Imported from the import line above
      numberGuess = readLine("Guess the number: ").toInt;
    }while(numberGuess != 15);

    printf("You guessed the secret number %d\n", 15);

    //arrays
    val favNums = new Array[Int](20);
    val friends = Array("Bob", "Tom");

    friends(0) = "Sue";
    println("\nBest friends " + friends(0));

    //ArrayBuffer is an array whose size can change
    val friends2 = ArrayBuffer[String]();
    
    //Different ways to add values to the ArrayBuffer
    friends2.insert(0, "Phil");
    friends2 += "Mark";
    friends2 ++= Array("Susy", "Paul");
    
    //(startIndex, numOfItems) => removes the given number of items from the given start index
    friends2.remove(1,2);
    var friend : String = " ";
    for(friend <- friends2){
      println(friend);
    }

    //Map example
    val favNumsTimes2 = for(num <- favNums) yield 2 *num

    //for each shorthand
    favNumsTimes2.foreach(println);
  }
}
