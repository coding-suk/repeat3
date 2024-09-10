package com.web.sundragon3.service;

import com.web.sundragon3.dto.*;
import com.web.sundragon3.entity.Member;
import com.web.sundragon3.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public MemberSaveResponseDto saveMember(MemberSaveResquestDto requestDto) {
        Member newMember = new Member(requestDto.getName());

        Member savedMember = memberRepository.save(newMember);

        return new MemberSaveResponseDto(savedMember.getId(), savedMember.getName());
    }

    public List<MemberSimpleResponseDto> getMembers() {
        List<Member> memberList = memberRepository.findAll();

        List<MemberSimpleResponseDto> dtoList = new ArrayList<>();
        for (Member member : memberList) {
            MemberSimpleResponseDto dto = new MemberSimpleResponseDto(member.getName());
            dtoList.add(dto);
        }
        return dtoList;
    }

    public MemberDetailResponseDto getMember(Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(()-> new NullPointerException("멤버가 없습니다"));

        return new MemberDetailResponseDto(member.getId(), member.getName());
    }


    @Transactional
    public MemberUpdateResponseDto updateMember(Long memberId, MemberUpdateRequestDto requestDto) {
        Member member = memberRepository.findById(memberId).orElseThrow(()-> new NullPointerException("멤버가 없습니다"));

        member.update(requestDto.getName());

        return new MemberUpdateResponseDto(member.getId(), member.getName());
    }

    @Transactional
    public void deleteMember(Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(()-> new NullPointerException("멤버가 없습니다"));

        memberRepository.delete(member);
    }
}
