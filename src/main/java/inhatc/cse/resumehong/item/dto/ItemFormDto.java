package inhatc.cse.resumehong.item.dto;


import inhatc.cse.resumehong.item.constant.ItemSellStatus;
import inhatc.cse.resumehong.item.entity.Item;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemFormDto {

    private Long id;            //Product ID

    @NotBlank(message = "상품명은 필수항목 입니다.")
    private String itemNm;      //Product Name

    @NotNull(message = "가격은 필수항목 입니다.")
    private int price;          //Product Price

    @NotNull(message = "재고수량은 필수항목 입니다.")
    private int stockNumber;    //Product Stock

    @NotBlank(message = "상품설명은 필수항목 입니다.")
    private String itemDetail;  //Product Detail Information

    private ItemSellStatus itemSellStatus; //Sales Status

    private List<ItemImgDto> itemImgDtoList = new ArrayList<>(); //Product Image List

    private List<Long> itemImgIds = new ArrayList<>(); //Product Image ID List


    private static ModelMapper modelMapper = new ModelMapper();


    public static ItemFormDto of (Item item) {
        return modelMapper.map(item, ItemFormDto.class);
    }

    public Item createItem() {
        return modelMapper.map(this, Item.class);
    }

}
