package com.blumar.entity;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QUsuario is a Querydsl query type for Usuario
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QUsuario extends EntityPathBase<Usuario> {

    private static final long serialVersionUID = 2106380945L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUsuario usuario = new QUsuario("usuario");

    public final BooleanPath acesso = createBoolean("acesso");

    public final StringPath cpf_cnpj = createString("cpf_cnpj");

    public final DatePath<java.sql.Date> dt_atualizacao = createDate("dt_atualizacao", java.sql.Date.class);

    public final DatePath<java.sql.Date> dt_criacao = createDate("dt_criacao", java.sql.Date.class);

    public final StringPath email = createString("email");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath nome = createString("nome");

    public final StringPath senha = createString("senha");

    public final NumberPath<Long> usuario_id = createNumber("usuario_id", Long.class);

    public final QUsuarioNivel usuarioNivel;

    public QUsuario(String variable) {
        this(Usuario.class, forVariable(variable), INITS);
    }

    public QUsuario(Path<? extends Usuario> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QUsuario(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QUsuario(PathMetadata<?> metadata, PathInits inits) {
        this(Usuario.class, metadata, inits);
    }

    public QUsuario(Class<? extends Usuario> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.usuarioNivel = inits.isInitialized("usuarioNivel") ? new QUsuarioNivel(forProperty("usuarioNivel")) : null;
    }

}

