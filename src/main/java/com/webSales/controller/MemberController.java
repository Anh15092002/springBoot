package com.webSales.controller;

import com.webSales.dto.MemberDto;
import com.webSales.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/members")
public class MemberController {
    private MemberService memberService;
    //Build Create Member REST API
    @PostMapping
    public ResponseEntity<MemberDto> createMember(@RequestBody MemberDto memberDto) {
        MemberDto savedMember = memberService.createMember(memberDto);
        return new ResponseEntity<>(savedMember, HttpStatus.CREATED);
    }

    //Build Get Member REST API
    @GetMapping("{id}")
    public ResponseEntity<MemberDto> getMemberById(@PathVariable("id") Integer memberId) {
        MemberDto memberDto = memberService.getMemberById(memberId);
        return ResponseEntity.ok(memberDto);
    }

    //Build Get All Member REST API
    @GetMapping
    public ResponseEntity<List<MemberDto>> getAllMembers() {
        List<MemberDto> members = memberService.getAllMembers();
        return ResponseEntity.ok(members);
    }

    //Build Put Member REST API
    @PutMapping("{id}")
    public ResponseEntity<MemberDto> updateMember(@PathVariable("id") Integer memberId,
                                                  @RequestBody MemberDto updateMember) {
        MemberDto memberDto = memberService.updateMember(memberId, updateMember);
        return  ResponseEntity.ok(memberDto);
    }

    //Build Delete Member REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteMember(@PathVariable("id") Integer memberId) {
        memberService.deleteMember(memberId);
        return ResponseEntity.ok("Member deleted successfully!.");
    }
}
