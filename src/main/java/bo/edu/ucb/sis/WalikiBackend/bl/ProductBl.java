package bo.edu.ucb.sis.WalikiBackend.bl;

import bo.edu.ucb.sis.WalikiBackend.dao.ProductDao;
import bo.edu.ucb.sis.WalikiBackend.dto.ConsultProductsDto;
import bo.edu.ucb.sis.WalikiBackend.dto.ProductCategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductBl {
    @Autowired
    ProductDao productDao;
    //Listado productos todos
    public List<ConsultProductsDto> findAllProyectos () {
        return productDao.findAllProductos();
    }
    //Listado productos por estado
    public List<ProductCategoryDto> findCategoryProduct (Integer estado) {
        return productDao.findProyectoVigente(estado);
    }
}
