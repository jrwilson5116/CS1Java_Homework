
/**Joey Wilson
 * 3/28/2017
 * Outputs animal and class subclasses with instructions to eat for some
 * Practice with super/subclasses and implementing interfaces
 */

public class Lab10A {

    public static void main(String[] args) {

        //object declarations
        Elephant elephant = new Elephant();
        Tiger tiger = new Tiger();
        Chicken chicken = new Chicken();
        Apple apple = new Apple();
        Orange orange = new Orange();

        //Use showObject function for each object
       showObject(elephant);
       showObject(tiger);
       showObject(chicken);
       showObject(apple);
       showObject(orange);
    }

    //Function that prints string for an object and Eatible if
    //instance of eatable
    public static void showObject(Object object){
        System.out.println(object);
        if(object instanceof Eatable){
        ((Eatable)object).howToEat();
        }
    }

}

//Interface implemented by chicken, fruit and orange
interface Eatable{
    public void howToEat();
 }

//Super class
class Animal{
    public String toString(){
        return "Animal";
    }
}

 //Sub classes
class Elephant extends Animal{
      //empty class so output will not include "Elephant"
}

class Tiger extends Animal{
    public String toString(){
        return "Tiger";
    }
}

class Chicken extends Animal implements Eatable{
    //Output will include instructions to eat
   public void howToEat(){
        System.out.println("Eat hot");
    }
    public String toString(){
        return "Chicken";
    }
}

//Super class
class Fruit implements Eatable {
    public void howToEat(){
        System.out.println("Wash and taka a bite");
    }
    public String toString(){
        return "Fruit";
    }
}

//Sub classes
 class Apple extends Fruit  {
    //empty class...output will not include "Apple"
}

class Orange extends Fruit implements Eatable {
    //ouput will include instructions to eat
    public void howToEat(){
        System.out.println("Peel and eat with fingers");
    }
    public String toString(){
        return "Orange";
    }
}

/**Sample Output
  Animal
  Tiger
  Chicken
  Eat hot
  Fruit
  Wash and taka a bite
  Orange
  Peel and eat with fingers
*/
