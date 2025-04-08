package my.example.chapter02.service;

import java.util.List;

import my.example.chapter02.data.Member;

public interface MemberServiceable {
	public void createMember(Member member);
	public List<Member> listMember();
}
