class Solution {
    public int getDecimalValue(ListNode head) {
        int sum = 0;
        while (head != null) {
            sum = (sum << 1) + head.val;
            head = head.next;
        }

        return sum;
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode()
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        {
    }
}
