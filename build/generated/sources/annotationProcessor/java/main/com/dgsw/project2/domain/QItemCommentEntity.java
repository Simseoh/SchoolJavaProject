package com.dgsw.project2.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.dsl.StringTemplate;

import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.annotations.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QItemCommentEntity is a Querydsl query type for ItemCommentEntity
 */
@SuppressWarnings("this-escape")
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QItemCommentEntity extends EntityPathBase<ItemCommentEntity> {

    private static final long serialVersionUID = 2098445088L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QItemCommentEntity itemCommentEntity = new QItemCommentEntity("itemCommentEntity");

    public final QBaseTimeEntity _super = new QBaseTimeEntity(this);

    public final NumberPath<Long> authorId = createNumber("authorId", Long.class);

    public final StringPath content = createString("content");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createAt = _super.createAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QItemEntity item;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updateAt = _super.updateAt;

    public QItemCommentEntity(String variable) {
        this(ItemCommentEntity.class, forVariable(variable), INITS);
    }

    public QItemCommentEntity(Path<? extends ItemCommentEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QItemCommentEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QItemCommentEntity(PathMetadata metadata, PathInits inits) {
        this(ItemCommentEntity.class, metadata, inits);
    }

    public QItemCommentEntity(Class<? extends ItemCommentEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.item = inits.isInitialized("item") ? new QItemEntity(forProperty("item")) : null;
    }

}

