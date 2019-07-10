package com.blumar.entity;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QQuartos is a Querydsl query type for Quartos
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QQuartos extends EntityPathBase<Quartos> {

    private static final long serialVersionUID = -1404337338L;

    public static final QQuartos quartos = new QQuartos("quartos");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Integer> nu_quarto = createNumber("nu_quarto", Integer.class);

    public final ListPath<Ocupacoes, QOcupacoes> ocupacoes = this.<Ocupacoes, QOcupacoes>createList("ocupacoes", Ocupacoes.class, QOcupacoes.class, PathInits.DIRECT2);

    public final BooleanPath ocupado = createBoolean("ocupado");

    public QQuartos(String variable) {
        super(Quartos.class, forVariable(variable));
    }

    public QQuartos(Path<? extends Quartos> path) {
        super(path.getType(), path.getMetadata());
    }

    public QQuartos(PathMetadata<?> metadata) {
        super(Quartos.class, metadata);
    }

}

