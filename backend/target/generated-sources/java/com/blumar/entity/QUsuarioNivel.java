package com.blumar.entity;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QUsuarioNivel is a Querydsl query type for UsuarioNivel
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QUsuarioNivel extends EntityPathBase<UsuarioNivel> {

    private static final long serialVersionUID = 1871825905L;

    public static final QUsuarioNivel usuarioNivel = new QUsuarioNivel("usuarioNivel");

    public final StringPath ds_descricao = createString("ds_descricao");

    public final DatePath<java.sql.Date> dt_atualizacao = createDate("dt_atualizacao", java.sql.Date.class);

    public final DatePath<java.sql.Date> dt_criacao = createDate("dt_criacao", java.sql.Date.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<Usuario, QUsuario> usuario = this.<Usuario, QUsuario>createList("usuario", Usuario.class, QUsuario.class, PathInits.DIRECT2);

    public QUsuarioNivel(String variable) {
        super(UsuarioNivel.class, forVariable(variable));
    }

    public QUsuarioNivel(Path<? extends UsuarioNivel> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUsuarioNivel(PathMetadata<?> metadata) {
        super(UsuarioNivel.class, metadata);
    }

}

