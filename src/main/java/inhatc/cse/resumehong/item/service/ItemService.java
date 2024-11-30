package inhatc.cse.resumehong.item.service;

import inhatc.cse.resumehong.item.dto.ItemFormDto;
import inhatc.cse.resumehong.item.entity.Item;
import inhatc.cse.resumehong.item.entity.ItemImg;
import inhatc.cse.resumehong.item.repository.ItemImgRepository;
import inhatc.cse.resumehong.item.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ItemService {

    private ItemRepository itemRepository;
    private ItemImgService itemImgService;
    private ItemImgRepository itemImgRepository;

    public Long saveItem(ItemFormDto itemFormDto, List<MultipartFile> itemImgList ) throws IOException {

        //Item Info Save
        Item item = itemFormDto.createItem();
        itemRepository.save(item);

        //Item Img Save
        for (int i = 0; i < itemImgList.size(); i++) {
            ItemImg itemImg = new ItemImg();
            itemImg.setItem(item);

            if(i == 0)
                itemImg.setRepImgYn("Y");
            else
                itemImg.setRepImgYn("N");

            itemImgService.saveItemImg(itemImg, itemImgList.get(i));
        }

        return item.getId();
    }
}
