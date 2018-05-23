package spring.pintura.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

import spring.pintura.entity.FacturasMateriales;


/**
 * QFacturasMateriales is a Querydsl query type for FacturasMateriales
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QFacturasMateriales extends EntityPathBase<FacturasMateriales> {

    private static final long serialVersionUID = -276324567L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QFacturasMateriales facturasMateriales = new QFacturasMateriales("facturasMateriales");

    public final NumberPath<Integer> cantidad = createNumber("cantidad", Integer.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final QMaterial relacionIdMateriales;

    public final QFactura relacionIdFactura;

    public QFacturasMateriales(String variable) {
        this(FacturasMateriales.class, forVariable(variable), INITS);
    }

    public QFacturasMateriales(Path<? extends FacturasMateriales> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QFacturasMateriales(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QFacturasMateriales(PathMetadata metadata, PathInits inits) {
        this(FacturasMateriales.class, metadata, inits);
    }

    public QFacturasMateriales(Class<? extends FacturasMateriales> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.relacionIdMateriales = inits.isInitialized("relacionIdMateriales") ? new QMaterial(forProperty("relacionIdMateriales")) : null;
        this.relacionIdFactura = inits.isInitialized("relacionIdFactura") ? new QFactura(forProperty("relacionIdFactura"), inits.get("relacionIdFactura")) : null;
    }

}

