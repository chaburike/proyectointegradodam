package spring.pintura.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

import spring.pintura.entity.Factura;
import spring.pintura.entity.FacturasMateriales;


/**
 * QFactura is a Querydsl query type for Factura
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QFactura extends EntityPathBase<Factura> {

    private static final long serialVersionUID = 2135421538L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QFactura factura = new QFactura("factura");

    public final QCliente cliente;

    public final SetPath<FacturasMateriales, QFacturasMateriales> facturasMaterialesEntity = this.<FacturasMateriales, QFacturasMateriales>createSet("facturasMaterialesEntity", FacturasMateriales.class, QFacturasMateriales.class, PathInits.DIRECT2);

    public final NumberPath<Integer> idFactura = createNumber("idFactura", Integer.class);

    public final NumberPath<Double> precio = createNumber("precio", Double.class);

    public QFactura(String variable) {
        this(Factura.class, forVariable(variable), INITS);
    }

    public QFactura(Path<? extends Factura> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QFactura(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QFactura(PathMetadata metadata, PathInits inits) {
        this(Factura.class, metadata, inits);
    }

    public QFactura(Class<? extends Factura> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.cliente = inits.isInitialized("cliente") ? new QCliente(forProperty("cliente")) : null;
    }

}

