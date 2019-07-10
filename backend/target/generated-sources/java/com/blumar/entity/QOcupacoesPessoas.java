package com.blumar.entity;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QOcupacoesPessoas is a Querydsl query type for OcupacoesPessoas
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QOcupacoesPessoas extends EntityPathBase<OcupacoesPessoas> {

    private static final long serialVersionUID = 314134557L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QOcupacoesPessoas ocupacoesPessoas = new QOcupacoesPessoas("ocupacoesPessoas");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QOcupacoes ocupacoes;

    public final QPessoas pessoas;

    public QOcupacoesPessoas(String variable) {
        this(OcupacoesPessoas.class, forVariable(variable), INITS);
    }

    public QOcupacoesPessoas(Path<? extends OcupacoesPessoas> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QOcupacoesPessoas(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QOcupacoesPessoas(PathMetadata<?> metadata, PathInits inits) {
        this(OcupacoesPessoas.class, metadata, inits);
    }

    public QOcupacoesPessoas(Class<? extends OcupacoesPessoas> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.ocupacoes = inits.isInitialized("ocupacoes") ? new QOcupacoes(forProperty("ocupacoes"), inits.get("ocupacoes")) : null;
        this.pessoas = inits.isInitialized("pessoas") ? new QPessoas(forProperty("pessoas")) : null;
    }

}

