package inhatc.cse.resumehong.item.controller;


import inhatc.cse.resumehong.item.dto.ItemDataDto;
import inhatc.cse.resumehong.item.dto.ItemDto;
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

import java.util.ArrayList;
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

    @GetMapping("/item/thymeleaf1")
    public String thymeleaf1(Model model) {
        ItemDto itemDto = ItemDto.builder()
                .id(1L)
                .itemNm("상품명")
                .itemDetail("상품 상세 설명")
                .price(10000)
                .stockNumber(100)
                .build();
        
        model.addAttribute("item", itemDto);

        return "/item/thymeleaf1";
    }

    @GetMapping("item/thymeleaf2")
    public String thymeleaf2(ItemDataDto ItemDataDto,
                             Model model)  {
        System.out.println("======" + ItemDataDto);

        model.addAttribute("item", ItemDataDto);

        return "/item/thymeleaf2";
    }

    @GetMapping("item/thymeleaf3")
    public String thymeleaf3(ItemDto ItemDto,
                             Model model)  {

        List<ItemDto> itemDtoList = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            ItemDto itemDto =ItemDto.builder()
                    .id((long) i)
                    .itemNm("상품" + i)
                    .itemDetail("상품 상세 설명" + i)
                    .price(10000 * i)
                    .stockNumber(100 + i)
                    .build();

            itemDtoList.add(itemDto);
        }
        model.addAttribute("item", itemDtoList);
        return "/item/thymeleaf3";
    }

    @GetMapping("item/thymeleaf4")
    public String thymeleaf4(ItemDto ItemDto,
                             Model model)  {

        List<ItemDto> itemDtoList = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            ItemDto itemDto =ItemDto.builder()
                    .id((long) i)
                    .itemNm("상품" + i)
                    .itemDetail("상품 상세 설명" + i)
                    .price(10000 * i)
                    .stockNumber(100 + i)
                    .build();

            itemDtoList.add(itemDto);
        }
        model.addAttribute("item", itemDtoList);
        return "/item/thymeleaf4";
    }

    @GetMapping("item/thymeleaf5")
    public String thymeleaf5(ItemDto ItemDto,
                             Model model)  {

        List<ItemDto> itemDtoList = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            ItemDto itemDto =ItemDto.builder()
                    .id((long) i)
                    .itemNm("상품" + i)
                    .itemDetail("상품 상세 설명" + i)
                    .price(10000 * i)
                    .stockNumber(100 + i)
                    .build();

            itemDtoList.add(itemDto);
        }
        model.addAttribute("item", itemDtoList);
        return "/item/thymeleaf5";
    }

}
