package B;

/**
 * Models a single linked list with integer arrays as its elements.
 * @author ugpsy
 * @version 1.0
 */
class ArrayList {

    // The following section is inspired from the lecture material.

    /**
     * Models a ListCell with its content and the following ListCell as its attributes.
     * @author ugpsy
     * @version 1.0
     */
    private class ListCell {
        int[] content;
        ListCell next;
        ListCell(int[] p, ListCell n) {
            this.content = p;
            this.next = n;
        }
    }
    private ListCell head;

    /**
     * Constructor for the class ArrayList.
     */
    public ArrayList() {
        this.head = null; // empty list
    }

    /**
     * Checks whether an integer(planet id) is contained in the list.
     * @return true, if there is connection from a planet to the one with index i, else false.
     */
    public boolean contains(int i) {
        ListCell cell = this.head;
        while (cell != null) {
            for (int planetId : cell.content) {
                if (planetId == i) {
                    return true;
                }
            }
            cell = cell.next;
        }
        return false;
    }

    /**
     * Adds a new integer array to the beginning of the list.
     */
    public void addFirst(int[] p) {
        this.head = new ListCell(p, this.head);
    }
}
