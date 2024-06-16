package collection.arraylist;

import java.util.ArrayList;

class MyStack {
	private ArrayList<String> arrayStack = new ArrayList<String>();

	// 스택의 맨 뒤에 요소를 추가
	public void push(String data) { 
		arrayStack.add(data);
	}
	
	// 스택의 맨 뒤에서 요소 꺼냄
	public String pop() {
		int len = arrayStack.size(); // ArrayList에 저장된 유효한 자료의 개수
		if(len == 0) {
			System.out.println("스택이 비었습니다.");
			return null;
		}
		return(arrayStack.remove(len-1)); // 맨 뒤에 있는 자료 반환하고 배열에서 제거
	}
}

public class StackTest{
	public static void main(String [] args) {
		MyStack stack = new MyStack();
		
		stack.push("A"); // A 넣기
		stack.push("B"); // B 넣기
		stack.push("C"); // C 넣기
	
		System.out.println(stack.pop()); // C 출력
		System.out.println(stack.pop()); // B 출력
		System.out.println(stack.pop()); // A 출력
	}
}