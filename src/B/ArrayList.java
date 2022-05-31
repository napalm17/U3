package B;

class ArrayList {
    private class ListCell {
        int[] content;
        ListCell next;
        ListCell(int[] p, ListCell n) {
            this.content = p;
            this.next = n;
        }
    }
    private ListCell head;

    public ArrayList() {
        this.head = null; // empty list
    }

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
    public void addFirst(int[] p) {
        this.head = new ListCell(p, this.head);
    }
}
