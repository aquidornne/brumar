package com.blumar.entity;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QProdutos is a Querydsl query type for Produtos
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QProdutos extends EntityPathBase<Produtos> {

    private static final long serialVersionUID = -307225193L;

    public static final QProdutos produtos = new QProdutos("produtos");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath nm_produto = createString("nm_produto");

    public final ListPath<OcupacoesProdutos, QOcupacoesProdutos> ocupacoesProdutos = this.<OcupacoesProdutos, QOcupacoesProdutos>createList("ocupacoesProdutos", OcupacoesProdutos.class, QOcupacoesProdutos.class, PathInits.DIRECT2);

    public final NumberPath<java.math.BigDecimal> preco = createNumber("preco", java.math.BigDecimal.class);

    public QProdutos(String variable) {
        super(Produtos.class, forVariable(variable));
    }

    public QProdutos(Path<? extends Produtos> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProdutos(PathMetadata<?> metadata) {
        super(Produtos.class, metadata);
    }

}

