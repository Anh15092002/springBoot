package com.webSales.service;

import com.webSales.dto.MemberDto;

import java.util.List;

public interface MemberService {
    MemberDto createMember(MemberDto memberDto);

    MemberDto getMemberById(Integer memberId);

    List<MemberDto> getAllMembers();

    MemberDto updateMember(Integer memberId, MemberDto updateMember);
    void deleteMember(Integer memberId);
}
