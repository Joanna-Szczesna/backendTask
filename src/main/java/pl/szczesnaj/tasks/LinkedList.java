package pl.szczesnaj.tasks;

class LinkedList {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }

        @Override
        public String toString() {
            return Integer.toString(val);
        }
    }
    static int sum(ListNode head) {
        int sum = head.val;
        ListNode current = head;
        while(current.next != null){
            sum += current.next.val;
            current = current.next;
        }
        return sum;
    }

}
