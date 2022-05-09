package dataStructure;

import java.util.ArrayDeque;
import java.util.Stack;

public class Queue_Reverse_FirstKth {



    public static void main(String[] args) {


     //   PriorityQueue p = new PriorityQueue();

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        queue.add(50);

        ArrayDeque<Integer> result = new ArrayDeque<>();

        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i<=4; i++) {
            stack.push(queue.getFirst());
            queue.removeFirst();
        }

        while (!stack.isEmpty()){
            result.add(stack.pop());
        }

        while (queue.size()>0){
            result.add(queue.getFirst());
            queue.removeFirst();
        }

        System.out.println(result);
    }




}
