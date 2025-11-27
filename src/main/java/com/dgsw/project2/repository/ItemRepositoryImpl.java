package com.dgsw.project2.repository;

import com.dgsw.project2.domain.ItemEntity;
import com.dgsw.project2.domain.QItemEntity;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemRepositoryImpl implements ItemRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public ItemRepositoryImpl(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }

    /**
     * title이 null이 아니면 제목 포함 조건을 추가
     * minPrice가 null이 아니면 가격 >= minPrice 조건 추가
     * maxPrice가 null이 아니면 가격 <= maxPrice 조건 추가
     * sortBy 값에 따라 결과를 정렬
     *  - "priceAsc": 가격 오름차순
     *  - "priceDesc": 가격 내림차순
     *  - 그 외(null 포함): 기본값으로 최신순(createAt 내림차순)
     */
    @Override
    public List<ItemEntity> search(String title, Long minPrice, Long maxPrice, String sortBy) {
        QItemEntity item = QItemEntity.itemEntity;
        BooleanBuilder builder = new BooleanBuilder();

        if (title != null) builder.and(item.title.contains(title));
        if (minPrice != null) builder.and(item.price.goe(minPrice));
        if (maxPrice != null) builder.and(item.price.loe(maxPrice));

        var query = queryFactory.selectFrom(item).where(builder);

        if ("priceAsc".equals(sortBy)) query.orderBy(item.price.asc());
        else if ("priceDesc".equals(sortBy)) query.orderBy(item.price.desc());
        else query.orderBy(item.createAt.desc());

        return query.fetch();
    }
}