package collection.arraylist;

import java.util.ArrayList;
import collection.Member;

public class MemberArrayList {

	private ArrayList<Member> arrayList; // ArrayList 선언 
	
	public MemberArrayList() {
		arrayList = new ArrayList<Member>();  // Member형으로 선언한 ArrayList 생성
	}
	
	public void addMember(Member member) {
		arrayList.add(member); // ArrayList에서 회원을 추가하는 메서드
	}
	
	// 해당 아이디를 가진 회원을 ArrayList에서 찾아 제거하기
	public boolean removeMember(int memberId) {
		for(int i = 0; i < arrayList.size(); i++) {
			Member member = arrayList.get(i); // get() 메서드로 회원을 순차적으로 가져옴
			int tempId = member.getMemberId();
			if(tempId == memberId) { // 회원 아디가 매개변수와 일치하면
				arrayList.remove(i); // 해당 회원을 삭제
				return true;
			}
		}
		System.out.println(memberId + "가 존재하지 않습니다."); // 반복문이 끝날 때까지 찾지 못한 경우
		return false;
	}
	
	// 특정 위치에 회원 추가하기
	public void insertMember(Member member, int index) {
		if(index < 0 || index > arrayList.size()+1) { // index+1인 이유 : 사용자가 1부터 시작하는 인덱스를 입력할 수 있게끔
			System.out.println("지정된 자리에 추가할 수 없습니다.");
			return;
		}
		// ArrayList.add(int index, E e) = (원하는 위치, 값)
		arrayList.add(index-1, member); // index-1인 이유 : 인덱스가 0부터 시작하기 때문에
	}
	
	// 전체 회원을 출력하는 메서드
	public void showAllMember() {
		for(Member member : arrayList) {
			System.out.println(member);
		}
		System.out.println();
	}

}
