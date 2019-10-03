package my.example.service;

import java.util.List;

import my.example.data.Member;

public interface MemberServiceable {
	public void createMember(Member member);
	public List<Member> listMember();
}
