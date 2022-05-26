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





    public void remove() {

    }

    public Track getByIndex(int i) {
        ListCell cell = this.first;
        int j = 0;
        System.out.println(cell.next);
        while (cell.next != null) {

            if (i == j) {
                break;
            }
            cell = cell.next;
        }
        System.out.println(cell.content.getTitle());
        return cell.content;
    }
}