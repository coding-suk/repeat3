package com.web.sundragon3.controller;

import com.web.sundragon3.dto.*;
import com.web.sundragon3.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/members")
    public MemberSaveResponseDto saveMember(@RequestBody MemberSaveResquestDto requestDto) {
        return memberService.saveMember(requestDto);
    }

    @GetMapping("/members")
    public List<MemberSimpleResponseDto> getMembers() {
        return memberService.getMembers();
    }

    @GetMapping("/members/{memberId}")
    public MemberDetailResponseDto datailMamber(@PathVariable Long memberId) {
        return memberService.getMember(memberId);
    }

    @PutMapping("/members/{memberId}")
    public MemberUpdateResponseDto updateMember(@PathVariable Long memberId, @RequestBody MemberUpdateRequestDto requestDto) {
        return memberService.updateMember(memberId, requestDto);
    }

    @DeleteMapping("/members/{memberId}")
    public void deleteMember(@PathVariable Long memberId) {
        memberService.deleteMember(memberId);
    }
}
