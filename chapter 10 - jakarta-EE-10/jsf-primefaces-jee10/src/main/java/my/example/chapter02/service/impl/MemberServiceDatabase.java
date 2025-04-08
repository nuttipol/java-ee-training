package my.example.chapter02.service.impl;

import java.util.ArrayList;
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import my.example.chapter02.data.Member;
import my.example.chapter02.service.MemberServiceable;
import my.example.chapter02.service.qualifier.Repository;

@ApplicationScoped
@Repository(name = Repository.DATABASE)
public class MemberServiceDatabase implements MemberServiceable {

	
	@Override
	public void createMember(Member member) {
		// do with database
	}

	@Override
	public List<Member> listMember() {
		List<Member> memberList = new ArrayList<>();
		// do with database
		return memberList;
	}

}
