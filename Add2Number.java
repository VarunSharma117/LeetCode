class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp,head;
        boolean carry = false;
        if(l1 == null){
            head = new ListNode(l1.val);
            carry = false;
        }
        else if(l2 == null){
            head = new ListNode(l2.val);
            carry = false;
        }else{
            head = new ListNode((l2.val + l1.val)%10);
            carry = (l2.val + l1.val) >= 10;
        }
        l1 = l1.next;
        l2 = l2.next;
        temp = head;
        while(l1!=null || l2!=null){
            int  c = (carry?1:0);
            if(l1 == null){
                temp.next = new ListNode((l2.val + c)%10);
                carry = (l2.val+c) >=10;
                l2 = l2.next;
            }
            else if(l2 == null){
                temp.next = new ListNode((l1.val+c)%10);
                carry = (l1.val+c) >=10;
                l1 = l1.next;
            }else{
                temp.next = new ListNode((l2.val + l1.val +c)%10);
                carry = (l2.val + l1.val + c) >= 10;
                l1 = l1.next;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        if(carry){
            temp.next= new ListNode(1);
        }
        return head;
    }
}