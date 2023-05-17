package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.JpaRepository;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Long join(Member member) {

        long start = System.currentTimeMillis();

        try {
            dublicateCheck(member);
            memberRepository.save(member);
            return member.getId();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("join 시간 : " + timeMs + "ms");
        }
    }

    private void dublicateCheck(Member member) {
        memberRepository.findByName(member.getName())
            .ifPresent(e -> {
                throw new IllegalArgumentException("이름이 중복입니다.");
            });
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long id) {
        return memberRepository.findById(id);
    }

}
