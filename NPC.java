
/**
 * Class that represents a Non-Player Character(NPC)
 * 
 * @author Kenny Castro-Monroy
 * @version 10.26.2021
 */
public class NPC {
  private String dialog;

  NPC(String wordsToSay) {
    dialog = wordsToSay;
  }

  /**
   * Prints out NPC's dialog text
   */
  public void speak() {
    System.out.println(dialog);
  }
}
