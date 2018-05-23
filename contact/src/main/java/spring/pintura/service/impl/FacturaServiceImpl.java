package spring.pintura.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import spring.pintura.entity.Factura;
import spring.pintura.repository.FacturaRepository;
import spring.pintura.service.FacturaService;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturaServiceImpl.
 */
@Service("facturaServiceImpl")
public class FacturaServiceImpl implements FacturaService {
	
	/** The factura repository. */
	@Autowired
	@Qualifier("facturaRepository")
	public FacturaRepository facturaRepository;
	

	/* (non-Javadoc)
	 * @see spring.pintura.service.FacturaService#listaAllFacturas()
	 */
	@Override
	public List<Factura> listaAllFacturas() {
		// TODO Auto-generated method stub
		return facturaRepository.findAll();
	}

	/* (non-Javadoc)
	 * @see spring.pintura.service.FacturaService#addFactura(spring.pintura.entity.Factura)
	 */
	@Override
	public Factura addFactura(Factura factura) {
		// TODO Auto-generated method stub
		
		return facturaRepository.save(factura);
		
	}

	/* (non-Javadoc)
	 * @see spring.pintura.service.FacturaService#removeFactura(int)
	 */
	@Override
	public int removeFactura(int id) {
		// TODO Auto-generated method stub
		facturaRepository.delete(id);
		return 0;
	}

	/* (non-Javadoc)
	 * @see spring.pintura.service.FacturaService#updateFactura(spring.pintura.entity.Factura)
	 */
	@Override
	public Factura updateFactura(Factura factura) {
		// TODO Auto-generated method stub
		return facturaRepository.save(factura);
	}

	/* (non-Javadoc)
	 * @see spring.pintura.service.FacturaService#findFacturaById(int)
	 */
	@Override
	public Factura findFacturaById(int id) {
		// TODO Auto-generated method stub
		return facturaRepository.findByIdFactura(id);
	}

}
