//Student: Michael Richards
//Course: CS 140C
//Date: 1/8/19
//Project: Lab #1
//
//This progrom will reproduce the song provided to us.
public class Song {

   //Does the repetitive first sentence for me.
   public static void intro() {
      System.out.print("There was an old woman who swallowed a ");
   } //end method

   //Does the last three sentences and the space and the intro for the next verse for me.
   public static void out() {
      System.out.println("She swallowed the spider to catch the fly,");
      System.out.println("I don't know why she swallowed that fly,");
      System.out.println("Perhaps she'll die.");
      System.out.println();
      intro();
   } //end method
   
   //This prints the first verse.
   public static void verse1() {
      intro();
      System.out.println("fly.");
      System.out.println("I don't know why she swallowed that fly,");
      System.out.println("Perhaps she'll die.");
      out();
   } //end method
   
   //This prints the second verse.
   public static void verse2() {
      System.out.println("spider,");
      System.out.println("That wriggled and iggled and jiggled inside her.");
      out();
   } //end method
   
   //This prints the third verse.
   public static void verse3() {
      System.out.println("bird,");
      System.out.println("How absurd to swallow a bird.");
      System.out.println("She swallowed the bird to catch the spider,");
      out();
   } //end method
   
   //This prints the fourth verse.
   public static void verse4() {
      System.out.println("cat,");
      System.out.println("Imagine that to swallow a cat.");
      System.out.println("She swallowed the cat to catch the bird,");
      System.out.println("She swallowed the bird to catch the spider,");
      out();
   } //end method
   
   //This prints the fifth verse.
   public static void verse5() {
      System.out.println("dog,");
      System.out.println("What a hog to swallow a dog.");
      System.out.println("She swallowed the dog to catch the cat,");
      System.out.println("She swallowed the cat to catch the bird,");
      System.out.println("She swallowed the bird to catch the spider,");
      out();
   } //end method
   
   //This prints the sixth verse.
   public static void verse6() {
      System.out.println("cow,");
      System.out.println("Can you even swallow a cow?");
      System.out.println("She swallowed the cow to catch the dog,");
      System.out.println("She swallowed the dog to catch the cat,");
      System.out.println("She swallowed the cat to catch the bird,");
      System.out.println("She swallowed the bird to catch the spider,");
      out();
   } //end method

   //Main method that calls all of the verse methods.
   public static void main(String[] args) {
      verse1();
      verse2();
      verse3();
      verse4();
      verse5();
      verse6();
      System.out.print("horse,\nShe died of course.");
   } //end method
} //end class