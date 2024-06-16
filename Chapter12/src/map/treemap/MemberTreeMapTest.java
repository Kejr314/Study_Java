package map.treemap;

import collection.Member;

public class MemberTreeMapTest {

	public static void main(String[] args) {
		MemberTreeMap memberhashMap = new MemberTreeMap();
		
		Member memberPark = new Member(1003, "박서훤");
		Member memberLee = new Member(1001, "이지원");
		Member memberHong = new Member(1004, "홍길동");
		Member memberSon = new Member(1002, "손민국");
		
		memberhashMap.addMember(memberPark);
		memberhashMap.addMember(memberLee);
		memberhashMap.addMember(memberHong);
		memberhashMap.addMember(memberSon);
		memberhashMap.showAllMember();
		
		memberhashMap.removeMember(1004);
		memberhashMap.showAllMember();
	}

}
