package com.webSales.mapper;

import com.webSales.dto.MemberDto;
import com.webSales.entity.Member;

public class MemberMapper {
    public static MemberDto mapToMemberDto(Member member) {
        return new MemberDto(
                member.getId(),
                member.getName(),
                member.getPassword(),
                member.getConfirmpassword(),
                member.getEmail(),
                member.getPhone(),
                member.getAddress(),
                member.getCity(),
                member.getCountry()
        );
    }

    public static Member mapToMember(MemberDto memberdto) {
        return new Member(
                memberdto.getId(),
                memberdto.getName(),
                memberdto.getPassword(),
                memberdto.getConfirmpassword(),
                memberdto.getEmail(),
                memberdto.getPhone(),
                memberdto.getAddress(),
                memberdto.getCity(),
                memberdto.getCountry()
        );
    }
}
