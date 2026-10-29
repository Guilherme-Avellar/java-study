package com.javarevisao.exercicios.dsa;

// exercicio do leetcode.com
// 82. Remove Duplicates from Sorted List II

class RemoveDuplicates {

    public static void main(String[] args) {
        ListNode list = new ListNode();

        // valores de teste:
        int[] nums1 = {1, 1, 2, 3, 3};
        int[] nums2 = {1, 1, 2, 3, 4, 5, 6, 6, 7};
        int[] nums3 = {1, 1, 1, 2, 3, 4, 5, 5, 5};
        int[] nums4 = new int[0];
        ListNode list2 = null;

        // criar a lista
        fillListNode(list, nums1);

        deleteDuplicates(list);

        showList(list);
    }

    // Definition for singly-linked list
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void fillListNode(ListNode list, int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            list.val = numbers[i];
            list.next = new ListNode();
            list = list.next;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {return head;}
        ListNode list = head;
        while (list.next != null) {
            if (list.val == list.next.val) {
                if (list.next.next != null){
                    list.next = list.next.next;
                } else {
                    list.next = null;
                }
            } else {
                list = list.next;
            }
        }
        return head;
    }

    public static void showList (ListNode list) {
        if (list == null) {return;}
        System.out.print(System.lineSeparator() + "Valores da linked list: ");
        while (list.next != null) {
            System.out.print(list.val + " ");
            list = list.next;
        }
    }
}



