public class SwapNodesInPairs {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // Solution "Recursive"
    static class Solution {
        public ListNode swapPairs(ListNode head) {
            // Base: 0 or 1 node left — nothing to swap
            if (head == null || head.next == null) return head;

            ListNode first = head;          // A
            ListNode second = head.next;    // B

            // Swap A and B, then recursively swap the rest
            first.next = swapPairs(second.next);
            second.next = first;

            // B becomes new head of this segment
            return second;
        }
    }

    // Solution "Non-Recursive"
    static class SolutionNonRecursive {
        public ListNode swapPairs(ListNode head) {
            // Dummy node to simplify edge cases (e.g., swap at head)
            ListNode dummy = new ListNode(0, head);
            ListNode curr = dummy;

            // Need at least two nodes ahead to swap
            while (curr.next != null && curr.next.next != null) {
                // Identify the pair
                ListNode first  = curr.next;         // node A
                ListNode second = curr.next.next;    // node B

                // Rewire links to swap A and B:
                // curr -> B -> A -> nextPair
                first.next = second.next;  // A -> nextPair
                second.next = first;       // B -> A
                curr.next = second;        // curr -> B

                // Move curr to the node just swapped to (A),
                // so the next pair starts after A
                curr = first;
            }
            return dummy.next;
        }
    }

    // --- Helper: build linked list from array ---
    public static ListNode buildList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        for (int val : arr) {
            tail.next = new ListNode(val);
            tail = tail.next;
        }
        return dummy.next;
    }

    // --- Helper: print linked list ---
    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val);
            if (curr.next != null) System.out.print(" -> ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        SolutionNonRecursive solutionNonRecursive = new SolutionNonRecursive();

        // Test 1
        int[] data1 = {1, 2, 3, 4};
        ListNode head1 = buildList(data1);
        System.out.print("Original: ");
        printList(head1);
        ListNode swapped1 = sol.swapPairs(head1);
        System.out.print("Swapped:  ");
        printList(swapped1);
        System.out.println();

        // Test 1 (Non-Recursive)
        int[] data4 = {1, 2, 3, 4};
        ListNode head4 = buildList(data1);
        System.out.print("Original: ");
        printList(head4);
        ListNode swapped4 = solutionNonRecursive.swapPairs(head4);
        System.out.print("Swapped (Non-Recursive):  ");
        printList(swapped4);
        System.out.println();

        // Test 2: odd number of nodes
        int[] data2 = {1, 2, 3};
        ListNode head2 = buildList(data2);
        System.out.print("Original: ");
        printList(head2);
        ListNode swapped2 = sol.swapPairs(head2);
        System.out.print("Swapped:  ");
        printList(swapped2);
        System.out.println();

        // Test 3: single node
        int[] data3 = {1};
        ListNode head3 = buildList(data3);
        System.out.print("Original: ");
        printList(head3);
        ListNode swapped3 = sol.swapPairs(head3);
        System.out.print("Swapped:  ");
        printList(swapped3);
        System.out.println();

        // Test 4: empty list
        ListNode swapped5 = sol.swapPairs(null);
        System.out.print("Swapped (empty): ");
        printList(swapped5);
    }

}
