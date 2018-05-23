package spring.pintura.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

import spring.pintura.entity.FacturasMateriales;
import spring.pintura.entity.Materiales;


/**
 * QMaterial is a Querydsl query type for Material
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMaterial extends EntityPathBase<Materiales> {

    private static final long serialVersionUID = 1814400965L;

    public static final QMaterial material = new QMaterial("material");

    public final SetPath<FacturasMateriales, QFacturasMateriales> materialesFacturasEntity = this.<FacturasMateriales, QFacturasMateriales>createSet("materialesFacturasEntity", FacturasMateriales.class, QFacturasMateriales.class, PathInits.DIRECT2);

    public final NumberPath<Integer> idMateriales = createNumber("idMateriales", Integer.class);

    public final StringPath nombre = createString("nombre");

    public final NumberPath<Double> precio = createNumber("precio", Double.class);

    public QMaterial(String variable) {
        super(Materiales.class, forVariable(variable));
    }

    public QMaterial(Path<? extends Materiales> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMaterial(PathMetadata metadata) {
        super(Materiales.class, metadata);
    }

}

