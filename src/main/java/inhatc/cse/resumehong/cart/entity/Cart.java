package inhatc.cse.resumehong.cart.entity;

import inhatc.cse.resumehong.common.entity.BaseEntity;
import inhatc.cse.resumehong.member.entity.Member;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cart extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private Long id;            //CartID

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;      //UserID
}
