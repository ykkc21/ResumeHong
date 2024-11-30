package inhatc.cse.resumehong.item.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ItemDto {

    private Long id;            //Product ID
    private String itemNm;      //Product Name
    private int price;          //Product Price
    private int stockNumber;    //Product Stock
    private String itemDetail;  //Product Detail Information


}
