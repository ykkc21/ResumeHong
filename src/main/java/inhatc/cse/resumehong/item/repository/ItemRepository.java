package inhatc.cse.resumehong.item.repository;

import inhatc.cse.resumehong.item.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.util.*;


public interface ItemRepository extends JpaRepository<Item, Long>, QuerydslPredicateExecutor<Item> {

    List<Item> findByItemNm(String itemNm);

    List<Item> findByPriceLessThanOrderByPriceDesc(int price);

    List<Item> findByItemNmLike(String itemNm);

    @Query(value = "select i.itemNm, i.price from Item i where i.itemDetail like %:itemDetail% " +
            "order by i.price desc")
    List<Item> findItemDetail(@Param("itemDetail") String itemDetail);

    @Query(value = "select * from item i where i.item_detail like %:itemDetail% " +
            "order by i.price desc", nativeQuery = true)
    List<Item> findItemDetailNative(@Param("itemDetail") String itemDetail);
}
