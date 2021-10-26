import java.util.Set;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. "World of Zuul" is a
 * very simple, text based adventure game.
 *
 * A "Room" represents one location in the scenery of the game. It is connected
 * to other rooms via exits. For each existing exit, the room stores a reference
 * to the neighboring room.
 * 
 * @author Kenny Castro-Monroy
 * @version 10.26.2021
 */

public class Room {
    private String description;
    private HashMap<String, Room> exits; // stores exits of this room.
    private ArrayList<Item> items;
    public int healthModifier;
    private NPC npc = null;
    public boolean isLocked;

    /**
     * Create a room described "description". Initially, it has no exits.
     * "description" is something like "a kitchen" or "an open court yard".
     * 
     * @param description The room's description.
     */
    public Room(String description) {
        this.description = description;
        exits = new HashMap<>();
        items = new ArrayList<Item>();
        healthModifier = 0;
    }

    /**
     * Create a room described "description". Initially, it has no exits.
     * "description" is something like "a kitchen" or "an open court yard".
     * 
     * @param description  The room's description.
     * @param healthChange The amount of hp the player will gain/lose by entering
     *                     the room
     */
    public Room(String description, int healthChange) {
        this.description = description;
        exits = new HashMap<>();
        items = new ArrayList<Item>();
        healthModifier = healthChange;
    }

    /**
     * A copy constructor
     * 
     * @param other the Room instance to be copied into constructued instance
     */
    public Room(Room other) {
        this.description = other.description;
        this.exits = other.exits;
        this.items = other.items;
    }

    /**
     * Adds an item to the room
     * 
     * @param newItem the item to be added to the room
     */
    public void addItem(Item newItem) {
        items.add(newItem);
    }

    /**
     * Setter for npc member
     * 
     * @param newGuy the new value of npc
     */
    public void setNPC(NPC newGuy) {
        npc = newGuy;
    }

    /**
     * Getter for npc member
     * 
     * @return the value stored in npc
     */
    public NPC getNPC() {
        return npc;
    }

    /**
     * Take the first item in the list of items from the room
     * 
     * @return the first item listed in the room
     */
    public Item takeItem() {
        if (items.size() > 0) {
            Item item = items.get(0);
            items.remove(0);
            return item;
        } else {
            return null;
        }
    }

    /**
     * Define an exit from this room.
     * 
     * @param direction The direction of the exit.
     * @param neighbor  The room to which the exit leads.
     */
    public void setExit(String direction, Room neighbor) {
        exits.put(direction, neighbor);
    }

    /**
     * @return The short description of the room (the one that was defined in the
     *         constructor).
     */
    public String getShortDescription() {
        return description;
    }

    /**
     * Return a description of the room in the form: You are in the kitchen. Exits:
     * north west
     * 
     * @return A long description of this room
     */
    public String getLongDescription() {
        return "You are " + description + ".\n" + getExitString() + getItemString()
                + (npc == null ? "No NPCs in the room" : "Look! A person! I wonder if he has any tendies on him?");
    }

    /**
     * Return a string describing the room's exits, for example "Exits: north west".
     * 
     * @return Details of the room's exits.
     */
    private String getExitString() {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for (String exit : keys) {
            returnString += " " + exit;
        }
        return returnString + "\n";
    }

    /**
     * Returns a string to display all items in Room
     * 
     * @return
     */
    private String getItemString() {
        String string = "Items: \n";

        if (items.size() != 0) {
            for (Item item : items) {
                string += item.toString() + " ";
            }

            string += "\n";
        } else {
            string += "There are no items in this room.\n";
        }

        return string;
    }

    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     * 
     * @param direction The exit's direction.
     * @return The room in the given direction.
     */
    public Room getExit(String direction) {
        return exits.get(direction);
    }
}
