package inhatc.cse.resumehong.item.controller;


import inhatc.cse.resumehong.item.dto.ItemFormDto;
import inhatc.cse.resumehong.item.service.ItemService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @PostMapping("/admin/item/add")
    public String itemAdd(@Valid ItemFormDto itemFormDto,
                         BindingResult bindingResult,
                         @RequestParam("itemImgFile") List<MultipartFile> itemImgList,
                          Model model) {
        if(bindingResult.hasErrors())
            return "item/add";

        if(itemImgList.get(0).isEmpty() && itemFormDto.getId() == null){
            model.addAttribute("errorMessage", "상품 이미지는 필수입니다.");
            return "item/add";
        }

        try {
            itemService.saveItem(itemFormDto, itemImgList);
        } catch (Exception e) {
            model.addAttribute("errorMessage", "파일 저장에 실패했습니다.");
            return "item/add";
        }

        return "redirect:/";
    }


    @GetMapping("/admin/item/add")
    public String itemFrom(Model model) {
        model.addAttribute("itemFormDto", new ItemFormDto());
        return "item/add";
    }

    @GetMapping("/admin/items")
    public String itemList() {
        return "item/list";
    }


}
