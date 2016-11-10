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
  }
}
