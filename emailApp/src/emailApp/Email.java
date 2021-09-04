package emailApp;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Email {

  /** User's name(s). */
  private final String firstName;

  /** User's surname. */
  private final String lastName;

  /** User's company e-mail's password. */
  private final String password;

  /** User's company department. */
  private final String department;

  /** Default password length of user's company e-mail. */
  private final int defaultPasswordLength = 12;

  /** User's company e-mail address. */
  private final String email;

  /** Maximum mailbox capacity (in MB). */
  private final int mailboxCapacity = 500;

  /** User's alternate e-mail address. */
  private String alternateEmail;

  /** Suffix for user's company e-mail. */
  private final String companySuffix = "aeycompany.com";

  /**
   * Public constructor which creates an user's company e-mail (without an alternate e-mail).
   *
   * @param firstName user's name
   * @param lastName user's surname
   */
  public Email(String firstName, String lastName) {

    this.firstName = firstName;
    this.lastName = lastName;
    // System.out.println("\nEMAIL CREATED: " + this.firstName + " " + this.lastName);

    this.department = setDepartment();
    // System.out.println("\nDEPARTMENT: " + this.department);

    this.password = generateRandomPassword(defaultPasswordLength);
    // System.out.println("\nYour password is: " + this.password);

    this.email = createEmail();
    // System.out.println("\nYour email is: " + this.email);
  }

  /**
   * Public constructor which creates an user's company e-mail (with an alternate e-mail).
   *
   * @param firstName user's name
   * @param lastName user's surname
   * @param alternateEmail alternate user's e-mail
   */
  public Email(String firstName, String lastName, String alternateEmail) {

    this(firstName, lastName);

    this.alternateEmail = alternateEmail;
  }

  /**
   * This method creates a company email for user.
   *
   * @return A company email for user.
   */
  private String createEmail() {
    return firstName.toLowerCase()
        + "."
        + lastName.toLowerCase()
        + "@"
        + department
        + "."
        + companySuffix;
  }

  /**
   * This interactive method assigns a department for user.
   *
   * @return An user's department.
   */
  private String setDepartment() {

    System.out.print(
        "\nDEPARTMENT CODES\n1 for Sales\n2 for Development\n3 for Accounting\nSomething different for None\nEnter department code: ");
    Scanner in = new Scanner(System.in);

    int deptChoice = 0;

    //noinspection finally
    try {
      deptChoice = in.nextInt();
    } catch (InputMismatchException inputMismatchException) {
      // System.out.println("Input different from 1, 2 and 3. Thus, value of 0 is assumed.");
    } finally {

      switch (deptChoice) {
        case 1:
          //noinspection ReturnInsideFinallyBlock
          return "sales";

        case 2:
          //noinspection ReturnInsideFinallyBlock
          return "development";

        case 3:
          //noinspection ReturnInsideFinallyBlock
          return "accounting";

          default:
            //noinspection ReturnInsideFinallyBlock
            return "none";
      }
    }
  }

  /**
   * This method generates a random password for an user.
   *
   * @param passwordLength A length of a generated password.
   * @return A newly-generated random password for an user.
   */
  private String generateRandomPassword(int passwordLength) {

    String passwordSet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";

    // System.out.println("Password set length = " + passwordSet.length());

    //Random rand = new Random();
    char[] password = new char[passwordLength];

    for (int i = 0; i < passwordLength; ++i) {

      // int idx = (  (rand.nextInt() % passwordLength) + passwordLength  ) % passwordLength;
      int idx = (int) (Math.random() * passwordSet.length());

      password[i] = passwordSet.charAt(idx);
    }

    return new String(password);
    // return password.toString();
  }

  /**
   * This method gets user's company password.
   *
   * @return A user's password.
   */
  public String getPassword() {
    return password;
  }

  /**
   * This method gets a user's alternate e-mail.
   *
   * @return A user's alternate e-mail.
   */
  public String getAlternateEmail() {
    return alternateEmail;
  }

  /**
   * This method sets a user's alternate e-mail with a new one.
   *
   * @param alternateEmail A user's new alternate e-mail.
   */
  public void setAlternateEmail(String alternateEmail) {
    this.alternateEmail = alternateEmail;
  }

  /**
   * This method creates an info about the user and his company e-mail.
   *
   * @return An info about the user and his company e-mail.
   */
  public String showInfo() {
    return "\nA USER INFO"
        + "\nDISPLAY NAME: "
        + firstName
        + " "
        + lastName
        + "\nCOMPANY E-MAIL: "
        + email
        + "\nMAILBOX CAPACITY: "
        + mailboxCapacity
        + " MB\n";
  }

  /** This method prints information about user and his company e-mail. */
  public void printEmailInfo() {
    System.out.println(this.showInfo());
  }
}
