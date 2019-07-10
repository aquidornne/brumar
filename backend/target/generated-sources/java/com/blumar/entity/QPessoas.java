package com.blumar.entity;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QPessoas is a Querydsl query type for Pessoas
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPessoas extends EntityPathBase<Pessoas> {

    private static final long serialVersionUID = 1561707791L;

    public static final QPessoas pessoas = new QPessoas("pessoas");

    public final DateTimePath<java.util.Date> dt_nascimento = createDateTime("dt_nascimento", java.util.Date.class);

    public final StringPath email = createString("email");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath nm_pessoa = createString("nm_pessoa");

    public final StringPath nu_cpf = createString("nu_cpf");

    public final ListPath<OcupacoesPessoas, QOcupacoesPessoas> ocupacoesPessoas = this.<OcupacoesPessoas, QOcupacoesPessoas>createList("ocupacoesPessoas", OcupacoesPessoas.class, QOcupacoesPessoas.class, PathInits.DIRECT2);

    public final StringPath telefone = createString("telefone");

    public QPessoas(String variable) {
        super(Pessoas.class, forVariable(variable));
    }

    public QPessoas(Path<? extends Pessoas> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPessoas(PathMetadata<?> metadata) {
        super(Pessoas.class, metadata);
    }

}

