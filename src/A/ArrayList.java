package A;

class ArrayList {
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
        this.head = null; // empty list
    }

    public void addFirst(Track track) {
        this.head = new ListCell(track, this.head);
    }

    public void insert(Track track) {
        ListCell cell = this.head;
        while(cell != null && track.getPriority() >= cell.next.content.getPriority()) {
            cell = cell.next;
        }
        if(cell == null) {
            cell = new ListCell(track, null);
        }
        else {
            ListCell temp = cell.next;
            cell.next = new ListCell(track, temp);
        }
    }
}
