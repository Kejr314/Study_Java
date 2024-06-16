package collection.treeset;

import collection.Member;

public class MemberTreeSetTest {

	public static void main(String[] args) {
		MemberTreeSet memberTreeSet = new MemberTreeSet();
		
		Member memberPark = new Member(1001, "박서훤");
		Member memberLee = new Member(1002, "이지원");
		Member memberSon = new Member(1003, "손민국");
		
		memberTreeSet.addMember(memberLee);
		memberTreeSet.addMember(memberSon);
		memberTreeSet.addMember(memberPark);
		memberTreeSet.showAllMember();
		
		Member memberHong = new Member(1003, "홍길동");
		memberTreeSet.addMember(memberHong);
		memberTreeSet.showAllMember();
		// 어떤 기준으로 노드를 비교하여 트리를 형성해야 하는지 구현하지 않아 오류 발생
		// 회원을 추가할 때 어떤 기준으로 비교할 것인지 구현해야 함 
		// >> Comparable or Comparator 사용
	}

}
