package lists;

import annotation.Platform;
import annotation.Site;

@Platform(Site.LEETCODE)
public class AddTwoNumbers {

    private Node addTwoNumbers(Node l1,Node l2){
        int number1=0,number2=0,digit =0;
        Node answer = new Node(-1);
        Node temp = answer ;
    

        while(l1!=null){
            number1 = number1*10 + l1.data;
            l1 = l1.next;
        }

        while(l2!=null){
            number2 = number2*10 + l2.data;
            l2 = l2.next;
        }

        int sum = number1 + number2 ; 

        while(sum!=0){
            digit = sum%10;
            sum = sum/10;
            if(answer == null){
                answer = new Node(digit);
            } else {
                answer.next = new Node(digit);
                answer = answer.next;
            }
        }

        return temp;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);

        n1.next = n2;
        n2.next = n3;

        Node n4 = new Node(1);
        Node n5 = new Node(3);
        Node n6 = new Node(5);
        Node n7 = new Node(7);

        n4.next = n5;
        n5.next = n6;
        n6.next = n7; 

        Node answer = new AddTwoNumbers().addTwoNumbers(n1, n4);

        while(answer!=null){
            System.out.println(answer.data);
            answer = answer.next;
        }
    }
    
}