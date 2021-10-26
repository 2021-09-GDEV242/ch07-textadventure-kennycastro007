/**
 * Represents a single item that the player can pick up
 * 
 * @author Kenny Castro-Monroy
 * @version 10.26.2021
 */
public class Item {

  public String itemName;
  public int weight;

  public String key = ""; // For use with only key items

  /**
   * Constructor for a named Item
   * 
   * @param name    the name of the constructed item
   * @param _weight the weight of constructued item
   */
  public Item(String name, int _weight) {
    itemName = name;
    weight = _weight;
  }

  /**
   * Constructor for a named Item
   * 
   * @param name    the name of the constructed item
   * @param _weight the weight of constructued item
   * @param _key    the description of the room this key/item will unlock
   */
  public Item(String name, int _weight, String _key) {
    itemName = name;
    weight = _weight;
    key = _key;
  }

  /**
   * @return the name of the item as a string
   */
  public String toString() {
    return itemName + " weighs(oz): " + weight;
  }
}
