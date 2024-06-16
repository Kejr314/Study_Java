package collection;

public class Member implements Comparable<Member>{
	private int memberId;
	private String memberName;
	
	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	
	public Member(int memberId, String memberName) {
		this.memberId = memberId;
		this.memberName = memberName;
	}

	@Override
	public String toString() {
		return memberName + " 회원님의 아이디는 " + memberId + "입니다.";
	}

	// hashCode() 메서드가 회원 아이디를 반환하도록 재정의
	@Override
	public int hashCode() {
		return memberId; 
	}

	// 매개변수로 받은 회원 아이디가 자신의 회원 아이디와 같다면 true 반환
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Member) {
			Member member = (Member)obj;
			if(this.memberId == member.memberId) 
				return true;
			else 
				return false;
			}
			return false;
	}

	// compareTo() 메서드 재정의
	// 추가한 회원 아이디와 매개변수로 받은 회원 아이디를 비교
	@Override
	public int compareTo(Member member) {
//		return (this.memberId - member.memberId); // 오름차순
//		return (this.memberId - member.memberId) * (-1); // 내림차순
		return this.memberName.compareTo(member.memberName); // 이름순
	}
	
}
