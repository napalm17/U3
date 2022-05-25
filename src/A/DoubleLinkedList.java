package A;

public class DoubleLinkedList {
    private class ListCell {
        Track content;
        ListCell prev; // Vorgänger
        ListCell next; // Nachfolger

        ListCell(Track t, ListCell p, ListCell n) {
            this.content = t;
            this.prev = p;
            this.next = n;
        }
    }
    private ListCell first, last;

    public DoubleLinkedList() {
        this.first = this.last = null; // leere Liste
    }

    public void insert(Track track) {
        ListCell cell = this.first;
        while(cell != null && track.getPriority() >= cell.content.getPriority()) {
            cell = cell.next;
        }
        if(cell == null) {
            cell = new ListCell(track, this.last, null);
            this.last = cell;
        }
        else {
            cell = new ListCell(track, cell.prev, cell.next);
            cell.prev.next = cell;
            cell.next.prev = cell;

        }
    }

    public void remove() {

    }


}