package collection.arraylist;

import collection.Member;

public class MemberArrayListTest {

	public static void main(String[] args) {
		MemberArrayList memberArrayList = new MemberArrayList();
		
		// 새로운 회원 인스턴스 생성
		Member memberLee = new Member(1001, "이지원");
		Member memberSon = new Member(1002, "손민국");
		Member memberPark = new Member(1003, "박서훤");
		Member memberHong = new Member(1004, "홍길동");
		Member memberYook = new Member(1006, "육성재");
	
		// ArrayList에 회원 추가
		memberArrayList.addMember(memberLee); 
		memberArrayList.addMember(memberSon); 
		memberArrayList.addMember(memberPark); 
		memberArrayList.addMember(memberHong); 
		
		// 전체 회원 추가
		memberArrayList.showAllMember();
		
		// 홍길동 회원 삭제
		memberArrayList.removeMember(memberHong.getMemberId());
		
		// 홍길동 회원 삭제 후 전체 회원 출력
		memberArrayList.showAllMember();
		
		memberArrayList.insertMember(memberYook,2); // insertMember(Member member, int index)
		memberArrayList.showAllMember();
	}

}
