package my.example.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import my.example.data.Member;
import my.example.service.MemberServiceable;

public class MemberService implements MemberServiceable {

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
