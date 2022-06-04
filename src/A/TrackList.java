package A;

/**
 * Models a single linked list with music tracks as its elements.
 * @author ugpsy
 * @version 1.0
 */
class TrackList {
    private int size; // Number of elements in the list

    // The following section is inspired from the lecture material.

    /**
     * Models a ListCell with its content and the following ListCell as its attributes.
     * @author ugpsy
     * @version 1.0
     */
    private class ListCell {
        Track content; // contains the attributes of a music track
        ListCell next; // leads to the next element in the list.
        ListCell(Track p, ListCell n) {
            this.content = p;
            this.next = n;
        }
    }
    private ListCell head; // The head of the list, its first element.

    /**
     * Constructor for the class TrackList.
     */
    public TrackList() {
        this.size = 0;
        this.head = null; // empty list
    }

    /**
     * Adds a new track to the end of the list.
     */
    public void addLast(Track track) {
        this.size ++; // Increment the size of the list by one.
        if (this.head == null) { // If the list is empty then set the track as the first element aka the head.
            this.head = new ListCell(track, null);
            return;
        }
        ListCell c = this.head;
        while (c.next!=null) { // Iterate through the list, until the end is reached.
            c = c.next;
        }
        c.next = new ListCell(track, null); // Add a new list cell to the end with its content being our new track.

    }

    /**
     * Finds the track with the given id.
     * @return the track object with the given id.
     */
    public Track getByIndex(int i) {
        ListCell c = this.head;
        int j = 0; // We use j as our incrementing index in the while loop.
        while (c != null) {
            if (i == j) {
                break; // Found it. Now stop the loop.
            }
            c = c.next;
            j++;
        }
        return c.content;
    }

    /**
     * Removes the track(s) with the given id from the priority queue. Inspired from the example in the lecture material.
     * @param id the id of the track(s).
     * @param allInstances if true then every track with the given id will be removed,
     *                     if false only the first track on the priority queue will be removed
     * @return the track object with the given id.
     */
    public int removeById(int id, boolean allInstances) {
        int removed = 0; // Counter for the number of removed tracks
        ListCell c = this.head;
        while (c != null && c.content.getId() == id) { //if the track is at the beginning of the playlist, apply this.
            this.head = c = c.next;
            if (!allInstances) { // If we are removing a single track, then we stop the loop.
                this.size -= 1;
                return 1;
            }
            removed++;
        }
        if (c == null) { // If we reach the end of the play list, stop.
            this.size -= removed;
            return removed;
        }

        while (c.next != null) {
            if (c.next.content.getId() == id) {
                c.next = c.next.next;
                removed++;
                if (!allInstances) { // If we are removing a single track, then we stop the loop.
                    this.size -= 1;
                    return 1;
                }
            } else {
                c = c.next;
            }
        }
        this.size -= removed; // Readjust the size of the tracklist.
        return removed;
    }

    /**
     * Gets the number of elements in the list.
     * @return The size of the list.
     */
    public int getSize() {
        return this.size;
    }
}