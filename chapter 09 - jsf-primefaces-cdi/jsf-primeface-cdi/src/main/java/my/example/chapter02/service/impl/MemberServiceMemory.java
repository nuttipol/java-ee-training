package my.example.chapter02.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;

import my.example.chapter02.data.Member;
import my.example.chapter02.service.MemberServiceable;

@ApplicationScoped
public class MemberServiceMemory implements MemberServiceable {

	private static HashMap<String,Member> memberMap = new HashMap<>();
	
	@Override
	public void createMember(Member member) {
		member.setId(UUID.randomUUID().toString());
		memberMap.put(member.getId(), member);
	}

	@Override
	public List<Member> listMember() {
		List<Member> memberList = new ArrayList<>();
		for (Map.Entry<String,Member> entry : memberMap.entrySet()) {
			String key = entry.getKey();
			memberList.add(memberMap.get(key));
        }
		return memberList;
	}

}
