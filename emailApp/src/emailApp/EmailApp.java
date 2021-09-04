/**
 * Source:
 * https://www.youtube.com/watch?v=U3Ibvu0htNs&t=5s
 * */


package emailApp;


/** Main class of all the application. */
public class EmailApp {

  /** This method presents the application functionalities and its operation.
   * @param args Input arguments.
   * */
  public static void main(String[] args) {

      Email eml = new Email("John", "Smith", "");

      eml.setAlternateEmail("js@gmail.com");
      System.out.println("\nYour newly-set alternate email is: " + eml.getAlternateEmail());

      eml.printEmailInfo();
  }
}
