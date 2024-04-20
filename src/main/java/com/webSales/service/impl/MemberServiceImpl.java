package com.webSales.service.impl;

import com.webSales.dto.MemberDto;
import com.webSales.entity.Member;
import com.webSales.exception.ResourceNotFoundException;
import com.webSales.mapper.MemberMapper;
import com.webSales.repository.MemberRepository;
import com.webSales.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MemberServiceImpl implements MemberService {
    private MemberRepository memberRepository;

    @Override
    public MemberDto createMember(MemberDto memberDto) {
        Member member = MemberMapper.mapToMember(memberDto);
        Member savedMember = memberRepository.save(member);
        return MemberMapper.mapToMemberDto(savedMember);
    }

    @Override
    public MemberDto getMemberById(Integer memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Member is not exist with given id: " + memberId));
        return MemberMapper.mapToMemberDto(member);
    }

    @Override
    public List<MemberDto> getAllMembers() {
        List<Member> members = memberRepository.findAll();
        return members.stream().map((member -> MemberMapper.mapToMemberDto(member)))
                .collect(Collectors.toList());
    }

    @Override
    public MemberDto updateMember(Integer memberId, MemberDto updateMember) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Member is not exist with given id: " + memberId));
        member.setName(updateMember.getName());
        member.setPassword(updateMember.getPassword());
        member.setConfirmpassword(updateMember.getConfirmpassword());
        member.setEmail(updateMember.getEmail());
        member.setPhone(updateMember.getPhone());
        member.setAddress(updateMember.getAddress());
        member.setCity(updateMember.getCity());
        member.setCountry(updateMember.getCountry());

        Member updateMemberObj = memberRepository.save(member);
        return MemberMapper.mapToMemberDto(updateMemberObj);
    }

    @Override
    public void deleteMember(Integer memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Member is not exist with given id: " + memberId));
        memberRepository.deleteById(memberId);
    }
}
