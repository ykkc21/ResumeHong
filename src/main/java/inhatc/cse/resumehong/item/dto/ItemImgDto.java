package inhatc.cse.resumehong.item.dto;

import inhatc.cse.resumehong.item.entity.ItemImg;
import lombok.*;
import org.modelmapper.ModelMapper;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemImgDto {

    private Long id;
    private String imageName;
    private String oriImgName;
    private String imgUrl;
    private String repImgYn;

    private static ModelMapper modelMapper = new ModelMapper();

    //Entity -> DTO
    public static ItemImgDto of(ItemImg itemImg) {
        return modelMapper.map(itemImg, ItemImgDto.class);
    }

    //Reversal(DTO -> Entity)
//    public static ItemImg toEntity(ItemImgDto itemImgDto) {
//        return modelMapper.map(itemImgDto, ItemImg.class);
//    }

}