package inhatc.cse.resumehong.item.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import inhatc.cse.resumehong.item.constant.ItemSellStatus;
import inhatc.cse.resumehong.item.entity.Item;
import inhatc.cse.resumehong.item.entity.QItem;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.thymeleaf.util.StringUtils;

import java.util.List;

import static inhatc.cse.resumehong.item.entity.QItem.item;

@SpringBootTest
//@Transactional
class ItemRepositoryTest {

    @Autowired
    private ItemRepository itemRepository;

    @PersistenceContext
    private EntityManager em;

    @Test
    public void test() {
        System.out.println("testsetssetetst");
    }

    public void createItemList(){
        for(int i=1; i<=10; i++){
            Item item = Item.builder()
                    .itemNm("테스트 상품 " + i)
                    .price(10000 + i)
                    .stockNumber(100 + i)
                    .itemDetail("테스트 상품 상세 설명 " + i)
                    .itemSellStatus(ItemSellStatus.SELL)
                    .build();

            itemRepository.save(item);
        }
    }

    @Test
    @DisplayName("상품 등록 테스트")
    public void insertItemTest() {
        Item item = Item.builder()
                .itemNm("신상품2")
                .itemDetail("신상품 상세 설명2")
                .price(20000)
                .stockNumber(120)
                .build();

        Item savedItem = itemRepository.save(item);

        System.out.println(savedItem);
        //assertEquals(savedItem.getId(), 4);
    }

    @Test
    public void findByItemNmTest() {
        List<Item> itemList = itemRepository.findByItemNm("신상품2");
//        for(Item item : itemList) {
//            System.out.println(item);
//        }

        itemList.forEach(item -> System.out.println(item));
        itemList.forEach(System.out::println);
    }

    public void createItemList2(){
        for(int i=1; i<=5; i++){
            Item item = Item.builder()
                    .itemNm("테스트 상품 " + i)
                    .price(10000 + i)
                    .stockNumber(100 + i)
                    .itemDetail("테스트 상품 상세 설명 " + i)
                    .itemSellStatus(ItemSellStatus.SELL)
                    .build();

            itemRepository.save(item);
        }

        for(int i=6; i<=10; i++){
            Item item = Item.builder()
                    .itemNm("테스트 상품 " + i)
                    .price(10000 + i)
                    .stockNumber(100 + i)
                    .itemDetail("테스트 상품 상세 설명 " + i)
                    .itemSellStatus(ItemSellStatus.SOLD_OUT)
                    .build();

            itemRepository.save(item);
        }
    }

    @Test
    @DisplayName("Querydsl 테스트 2")
    public void querydslTest2() {
        createItemList2();

        BooleanBuilder builder = new BooleanBuilder();
        String itemDetail = "테스트";
        int price = 10004;
        String itemSellStatus = "SELL";



        QItem item = QItem.item;

        builder.and(item.itemDetail.like("%" + itemDetail + "%"));
        builder.and(item.price.gt(price));

        if(StringUtils.equals(itemSellStatus, ItemSellStatus.SELL)) {
            builder.and(item.itemSellStatus.eq(ItemSellStatus.SELL));
        }

        Pageable pageable = PageRequest.of(0, 5);

        Page<Item> page = itemRepository.findAll(builder, pageable);
        List<Item> content = page.getContent();
        content.stream().forEach((e) -> {
            System.out.println(e);
        });

    }

    //@BeforeEach
    @Test
    @DisplayName("Querydsl 테스트")
    public void querydslTest() {
        createItemList();
        JPAQueryFactory query = new JPAQueryFactory(em);
        QItem qItem = item;

        List<Item> itemList = query.selectFrom(item)
                            .where(item.itemSellStatus.eq(ItemSellStatus.SELL))
                            .where(item.itemDetail.like("%"+"1"+"%"))
                            .orderBy(item.price.desc())
                            .fetch();


        itemList.forEach(item -> System.out.println(item));
    }


}