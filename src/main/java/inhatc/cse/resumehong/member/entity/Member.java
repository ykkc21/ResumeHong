package inhatc.cse.resumehong.member.entity;

import inhatc.cse.resumehong.common.entity.BaseEntity;
import inhatc.cse.resumehong.member.constant.Role;
import inhatc.cse.resumehong.member.dto.MemberDto;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;            //UserID

    @Column(length = 30, nullable = false)
    private String name;        //UserName

    @Column(unique = true, nullable = false)
    private String email;       //UserEmail

    @Column(nullable = false)
    private String password;    //UserPassword

    @Column(length = 200, nullable = true)
    private String address;     //UserAddress

    @Enumerated(EnumType.STRING)
    private Role role;          //UserRole

    private String phone;

    private String gender;

    public static Member createMember(MemberDto memberDto, PasswordEncoder passwordEncoder) {

        Member member = Member.builder()
                .name(memberDto.getName())
                .email(memberDto.getEmail())
                .password(passwordEncoder.encode(memberDto.getPassword()))
                .address(memberDto.getAddress())
                .role(Role.USER)
                .phone(memberDto.getPhone())
                .gender(memberDto.getGender())
                .build();

        return member;

    }

}
