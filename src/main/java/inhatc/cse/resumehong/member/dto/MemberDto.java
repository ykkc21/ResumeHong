package inhatc.cse.resumehong.member.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class MemberDto {

    @NotBlank(message = "이름은 필수항목 입니다.")
    private String name;        //UserName

    @NotEmpty(message = "이메일은 필수항목 입니다.")
    @Email(message = "이메일 형식이 아닙니다.")
    private String email;       //UserEmail

    @NotEmpty(message = "비밀번호는 필수항목 입니다.")
    @Length(min = 4, max = 16 ,message = "비밀번호는 4자 이상, 16자 이하로 입력해주세요.")
    private String password;    //UserPassword

    @NotEmpty(message = "주소는 필수항목 입니다.")
    private String address;     //UserAddress

    @NotBlank(message = "전화번호는 필수항목 입니다.")
    @Length(max = 13, message = "올바른 전화번호를 입력해주세요.")
    private String phone;

    @NotBlank(message = "성별은 필수항목 입니다.")
    private String gender;


}
