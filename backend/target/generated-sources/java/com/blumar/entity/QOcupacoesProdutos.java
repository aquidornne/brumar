package com.blumar.entity;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QOcupacoesProdutos is a Querydsl query type for OcupacoesProdutos
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QOcupacoesProdutos extends EntityPathBase<OcupacoesProdutos> {

    private static final long serialVersionUID = -327289783L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QOcupacoesProdutos ocupacoesProdutos = new QOcupacoesProdutos("ocupacoesProdutos");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QOcupacoes ocupacoes;

    public final QProdutos produtos;

    public QOcupacoesProdutos(String variable) {
        this(OcupacoesProdutos.class, forVariable(variable), INITS);
    }

    public QOcupacoesProdutos(Path<? extends OcupacoesProdutos> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QOcupacoesProdutos(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QOcupacoesProdutos(PathMetadata<?> metadata, PathInits inits) {
        this(OcupacoesProdutos.class, metadata, inits);
    }

    public QOcupacoesProdutos(Class<? extends OcupacoesProdutos> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.ocupacoes = inits.isInitialized("ocupacoes") ? new QOcupacoes(forProperty("ocupacoes"), inits.get("ocupacoes")) : null;
        this.produtos = inits.isInitialized("produtos") ? new QProdutos(forProperty("produtos")) : null;
    }

}

