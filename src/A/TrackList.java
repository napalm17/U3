package A;

class TrackList {
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

    public TrackList() {
        this.size = 0;
        this.head = null; // empty list
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

    }
    public Track getByIndex(int i) {
        ListCell c = this.head;
        int j = 0;
        while (c != null) {
            if (i == j) {
                break;
            }
            c = c.next;
            j++;
        }
        return c.content;
    }

    public int removeById(int id, boolean allInstances) {
        int removed = 0;
        ListCell c = this.head;
        while (c != null && c.content.getId() == id) {
            this.head = c = c.next;
            if (!allInstances) {
                this.size -= 1;
                return 0;
            }
            removed++;
        }
        if (c == null) {
            this.size -= removed;
            return removed; // nothing more to do
        }
        while (c.next != null) {
            if (c.next.content.getId() == id) {
                c.next = c.next.next;
                removed++;
                if (!allInstances) {
                    this.size -= 1;
                    return 0;
                }
            } else {
                c = c.next;
            }
        }
        this.size -= removed;
        System.out.println(size + "size");
        return removed;
    }
    public int getSize() {
        return this.size;
    }
}