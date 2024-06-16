package collection.hashset;

import java.util.HashSet;
import java.util.Iterator;

import collection.Member;

public class MemberHashSet {
	
	// HashSet 선언
	private HashSet<Member> hashSet;
	
	// HashSet 생성
	public MemberHashSet() {
		hashSet = new HashSet<Member>();
	}
	
	// HashSet에 회원 추가
	public void addMember(Member member) {
		hashSet.add(member);
	}
	
	// 매개변수로 받은 회원 아이디에 해당하는 회원 삭제
	public boolean removerMember(int memberId) {
		// Iterator를 활용해 순회함
		Iterator<Member> ir = hashSet.iterator();
	
		while(ir.hasNext()) {
			Member member = ir.next(); // 회원을 하나씩 가져오기
			int tempId = member.getMemberId(); // 아이디 비교
			if(tempId == 0) { // 같은 아이디인 경우
				hashSet.remove(member); // 회원 삭제
				return true;
			}
		}
		System.out.println(memberId + "가 존재하지 않습니다.");
		return false;
	}
	
	// 모든 회원 출력
	public void showAllMember() {
		for(Member member : hashSet) {
			System.out.println(member);
		}
		System.out.println();
	}
}
