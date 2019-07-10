package com.blumar.entity;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QOcupacoes is a Querydsl query type for Ocupacoes
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QOcupacoes extends EntityPathBase<Ocupacoes> {

    private static final long serialVersionUID = 1855684239L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QOcupacoes ocupacoes = new QOcupacoes("ocupacoes");

    public final DateTimePath<java.util.Date> dt_checkin = createDateTime("dt_checkin", java.util.Date.class);

    public final DateTimePath<java.util.Date> dt_checkout = createDateTime("dt_checkout", java.util.Date.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final BooleanPath in_ativo = createBoolean("in_ativo");

    public final ListPath<OcupacoesPessoas, QOcupacoesPessoas> ocupacoesPessoas = this.<OcupacoesPessoas, QOcupacoesPessoas>createList("ocupacoesPessoas", OcupacoesPessoas.class, QOcupacoesPessoas.class, PathInits.DIRECT2);

    public final NumberPath<Integer> qtd_dias = createNumber("qtd_dias", Integer.class);

    public final QQuartos quartos;

    public final NumberPath<Integer> tp_ocupacao = createNumber("tp_ocupacao", Integer.class);

    public QOcupacoes(String variable) {
        this(Ocupacoes.class, forVariable(variable), INITS);
    }

    public QOcupacoes(Path<? extends Ocupacoes> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QOcupacoes(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QOcupacoes(PathMetadata<?> metadata, PathInits inits) {
        this(Ocupacoes.class, metadata, inits);
    }

    public QOcupacoes(Class<? extends Ocupacoes> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.quartos = inits.isInitialized("quartos") ? new QQuartos(forProperty("quartos")) : null;
    }

}

