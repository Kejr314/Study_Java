package collection.hashset;

import collection.Member;

public class MemberHashSetTest {

	public static void main(String[] args) {
		// HashSet
		// 중복 허용 X
		MemberHashSet memberHashSet = new MemberHashSet();
		
		Member memberLee = new Member(1001, "이지원");
		Member memberSon = new Member(1002, "손민국");
		Member memberPark = new Member(1003, "박서훤");
	
		memberHashSet.addMember(memberLee);
		memberHashSet.addMember(memberSon);
		memberHashSet.addMember(memberPark);
		memberHashSet.showAllMember();
		
		// 아이디 중복 회원 추가
		// Member 클래스에 같은 객체를 처리하는 방법이 구현되어 있지않아 Id가 같은 홍길동이 출력됨
		// >> Member 클래스에 equals()와 hashCode() 메서드를 재정의 해야 중복되어 출력되지 않음
		Member memberHong = new Member(1003, "홍길동");
		memberHashSet.addMember(memberHong);
		memberHashSet.showAllMember();
	}

}
