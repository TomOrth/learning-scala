import scala.io.StdIn.{readLine, readInt};
import scala.collection.mutable.ArrayBuffer;
import scala.math._;
import java.io.PrintWriter;
import scala.io.Source;
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
    for(j <- 0 to (favNums.length - 1)) favNums(j) = j;

    //Map example
    val favNumsTimes2 = for(num <- favNums) yield 2 *num

    //for each shorthand
    favNumsTimes2.foreach(println);

    //Multidimensional array
    var multTable = Array.ofDim[Int](10,10);
    //different properties
    println("Sum : " + favNums.sum);
    println("Min : " + favNums.min);
    println("Max : " + favNums.max);

    //Sort Ascending(_<_) or Descending(_>_)
    val sortedNums = favNums.sortWith(_>_);
    //Array to string with a delimiter
    println(sortedNums.deep.mkString(", "));

    //Maps(Java hash maps)
    val employees = Map("Manager" -> "Bob Smith", "Secretary" -> "Sue Brown");
    
    //checks if a key is in map
    if(employees.contains("Manager"))
      printf("Manager : %s\n", employees("Manager"));
    
    for((k,v) <- employees) printf("%s : %s\n", k, v);
     
    //Tuples
    //tuple._#, where # is the item u want(1 is first etc.), returns a tuple item
    var tupleMarge = (103, "Marge", 10.25);
    printf("%s, $%.2f\n", tupleMarge._2, tupleMarge._3);

    //Tuple foreach
    println("For each:");
    tupleMarge.productIterator.foreach{i => println(i)};
    println("tupleMarge: " + tupleMarge.toString());

    //OOP example
    val rover = new Animal;
    rover.setName("Rover");
    rover.setSound("Woof");
    println(rover.toString());

    //OOP extension
    val dog = new Dog;
    println(dog.toString());

    //OOP abstraction
    val fang = new Wolf("Fang");
    println(fang.move);

    //higher order functions
    // _ is log10Func input
    val log10Func = log10 _;
    println(log10Func(1000));

    //.map applys the function to all elements and .foreach is self explanatory
    List(1000.0, 10000.0).map(log10Func).foreach(println);
    List(1,2,3,5).map((x : Int) => x * 50).foreach(println);

    //.filter (_ is every element in the list)
    List(1,2,3,4,5).filter(_ % 2 == 0).foreach(println);
    
    //passing functions
    def times3(num : Int) = num * 3;
    def times4(num : Int) = num * 4;
    //first param takes in a function that has an int input and returns double
    def multIt(func : (Int) => Double, num : Int) = func(num);

    println("3*10: " + multIt(times3, 10));

    //Write to file
    val writer = new PrintWriter("test.txt");
    writer.write("Writing code\nis fun");
    writer.close();

    //Read from file
    val textFromFile = Source.fromFile("test.txt");
    val lineIterator = textFromFile.getLines;

    for(line <- lineIterator) println(line);

    textFromFile.close();

    def divideNums(num1 : Int, num2 : Int) = try{
       (num1/num2)
    } catch {
      case ex : java.lang.ArithmeticException => "Can't divide by zero";
    } finally {
      //clean up exception
    }

    println("3/0: " + divideNums(3,0));
  }
  //class example
  //Default constructor
  class Animal(var name: String, var sound: String){
    this.setName(name);
    //static method - requires companion object that is of the same name
    val id = Animal.newIdNum;

    //protected - can only be accessed by this class or classes that inherent this class
    //protected var name = "No name";

    //getters
    def getName() : String = name;
    def getSound() : String = sound;

    //setters
    def setName(name : String){
      if(!(name.matches(".*\\d+.*")))
        this.name = name;
      else
        this.name = "No name";
    }
    
    def setSound(sound : String){
      this.sound = sound;
    }

    //alternate constructors
    def this(name : String){
      this("No Name", "No Sound");
      this.setName(name);
    }

    def this(){
      this("No Name", "No Sound");
    }

    //overrides methods
    override def toString() : String = {
      return "%s with the id %d say %s".format(this.name, this.id, this.sound);
    }
  }

  object Animal{
    private var idNumber = 0;
    private def newIdNum = {idNumber += 1; idNumber}
  }

  //class extension
  class Dog(name : String, sound : String, growl : String) extends Animal(name, sound){
    def this(name : String, sound : String){
      this("No Name", sound, "No Growl");
      this.setName(name);
    }

    def this(name : String){
      this("No Name", "No Sound", "No Growl");
      this.setName(name);
    }

    def this(){
      this("No Name", "No Sound");
    }

    override def toString() : String = {
      return "%s with the id %d says %s or %s".format(this.name, this.id, this.sound, this.growl);
    }
  }
  //Abstract class
  abstract class Mammal(val name : String){
    //abstract property - no value
    var moveSpeed : Double;

    //abstract method - no body
    def move : String;
  }

  class Wolf(name : String) extends Mammal(name){
    var moveSpeed = 35.0;

    def move = "The wolf %s runs %.2f mph".format(this.name, this.moveSpeed);
  }

  //Traits - like java interfaces
  trait Flyable{
    def fly : String;
  }

  trait BulletProof{
    def hitByBullet : String;

    def ricochet(startSpeed : Double) : String = {
      "The bullet ricochets at a speed of %.1f ft/sec".format(startSpeed * .75);
    }
  }

  //Implementing traits
  class Superhero(val name : String) extends Flyable with BulletProof{
    def fly = "flying";
    def hitByBullet = "hit";
  }
}
