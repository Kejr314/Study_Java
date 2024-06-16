package collection.arraylist;

import java.util.ArrayList;

class MyQueue {
	private ArrayList<String> arrayQueue = new ArrayList<String>();
	
	// 큐의 맨 뒤에 추가
	public void enQueue(String data) {
		arrayQueue.add(data);
	}
	
	// 큐의 맨 앞에서 꺼냄
	public String deQueue() {
		int len = arrayQueue.size();
		if(len == 0) {
			System.out.println("큐가 비었습니다.");
			return null;
		}
	return(arrayQueue.remove(0)); //  맨 앞의 자료 반환하고 배열에서 제거
	}
}

public class QueueTest {
	public static void main(String [] args) {
		MyQueue queue = new MyQueue();
		
		queue.enQueue("A"); // A 추가
		queue.enQueue("B"); // B 추가
		queue.enQueue("C"); // C 추가
		
		System.out.println(queue.deQueue()); // A 출력
		System.out.println(queue.deQueue()); // B 출력
		System.out.println(queue.deQueue()); // C 출력
	}
}