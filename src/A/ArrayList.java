package A;

class ArrayList {
    private int size;
    private class ListCell {
        Track content;
        ListCell next;
        ListCell(Track p, ListCell n) {
            this.content = p;
            this.next = n;
        }
    }
    private ListCell head;

    public ArrayList() {
        this.size = 0;
        this.head = null; // empty list
    }

    public void addFirst(Track track) {
        this.head = new ListCell(track, this.head);
    }
    public void addLast(Track track) {
        this.size ++;
        if (this.head == null) {
            this.head = new ListCell(track, null);
            return;
        }
        ListCell c = this.head;
        while (c.next!=null) {
            c = c.next;
        }
        c.next = new ListCell(track, null);
        System.out.println(c);

    }
    public Track getByIndex(int i) {
        ListCell c = this.head;
        int j = 0;
        while (j != i) {
            c = c.next;
            j++;
        }
        return c.content;
    }
    public int getSize() {
        return this.size;
    }
}
