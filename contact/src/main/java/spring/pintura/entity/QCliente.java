package spring.pintura.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

import spring.pintura.entity.Cliente;
import spring.pintura.entity.Factura;


/**
 * QCliente is a Querydsl query type for Cliente
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCliente extends EntityPathBase<Cliente> {

    private static final long serialVersionUID = -207081244L;

    public static final QCliente cliente = new QCliente("cliente");

    public final StringPath apellidos = createString("apellidos");

    public final StringPath dni = createString("dni");

    public final SetPath<Factura, QFactura> facturas = this.<Factura, QFactura>createSet("facturas", Factura.class, QFactura.class, PathInits.DIRECT2);

    public final StringPath nombre = createString("nombre");

    public final StringPath telefono = createString("telefono");

    public QCliente(String variable) {
        super(Cliente.class, forVariable(variable));
    }

    public QCliente(Path<? extends Cliente> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCliente(PathMetadata metadata) {
        super(Cliente.class, metadata);
    }

}

