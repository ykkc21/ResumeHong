package inhatc.cse.resumehong.item.entity;

import inhatc.cse.resumehong.common.entity.BaseEntity;
import inhatc.cse.resumehong.item.constant.ItemSellStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Item extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="item_id")
    private Long id;

    @Column(nullable = false)
    private String itemNm;

    private int price;

    @Column(name="stock")
    private int stockNumber;

    @Lob
    @Column(nullable = false)
    private String itemDetail;

    @Enumerated(EnumType.STRING)
    private ItemSellStatus itemSellStatus;

    private LocalDateTime regTime;      // 등록일 (추후 제거)
    private LocalDateTime updateTime;   // 수정일 (추후 제거)

}
