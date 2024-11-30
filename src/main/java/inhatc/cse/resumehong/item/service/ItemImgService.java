package inhatc.cse.resumehong.item.service;


import inhatc.cse.resumehong.item.entity.ItemImg;
import inhatc.cse.resumehong.item.repository.ItemImgRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.util.StringUtils;

import java.io.IOException;

@Service
@RequiredArgsConstructor
@Transactional

public class ItemImgService {

    private final ItemImgRepository itemImgRepository;
    private final FileService fileService;

    @Value(value = "${itemImgLocation}")
    private String itemImgLocation;

    public void saveItemImg(ItemImg itemImg, MultipartFile itemImgFile) throws IOException {

        String oriImgName = itemImgFile.getOriginalFilename();
        String imgName = "";
        String imgUrl = "";

        if(!StringUtils.isEmpty(oriImgName)){
            imgName = fileService.uploadFile(itemImgLocation, oriImgName, itemImgFile.getBytes());
            imgUrl = "/images/item/" + imgName;
        }

        itemImg.updateItemImg(oriImgName, imgName, imgUrl);
        itemImgRepository.save(itemImg);

    }

}
