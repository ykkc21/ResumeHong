package inhatc.cse.resumehong.member.service;

import inhatc.cse.resumehong.member.entity.Member;
import inhatc.cse.resumehong.member.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class MemberService implements UserDetailsService {

    private final MemberRepository memberRepository;

    public Member saveMember(Member member) {
        validateDuplicateMember(member);
        return memberRepository.save(member);
    }

    private void validateDuplicateMember(Member member) {

        Optional<Member> mem = memberRepository.findByEmail(member.getEmail());
        if (mem.isPresent()) {
            Member m = mem.get();
            System.out.println("이미 가입된 회원");
        }

    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Member member = memberRepository.findByEmail(email)
                .orElseThrow(()-> new UsernameNotFoundException("해당 사용자 존재하지 않음" + email));
        /*
        Optional<Member> optMember = memberRepository.findByEmail(email);
        if(optMember.isPresent()) {
            Member member = optMember.get();
        }
        else {
            throw new UsernameNotFoundException("해당 사용자 존재하지 않음" + email);
        }
        */

        log.info(member.toString());

        return User.builder()
                .username(member.getEmail())
                .password(member.getPassword())
                .roles(member.getRole().toString())
                .build();
    }
}
