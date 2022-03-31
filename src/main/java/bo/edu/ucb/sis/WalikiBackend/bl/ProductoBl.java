package bo.edu.ucb.sis.WalikiBackend.bl;

import bo.edu.ucb.sis.WalikiBackend.dao.ProductoDao;
import bo.edu.ucb.sis.WalikiBackend.dto.ConsultaProductosDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoBl {
    @Autowired
    ProductoDao productoDao;
    //Listado productos todos
    public List<ConsultaProductosDto> findAllProyectos () {
        return productoDao.findAllProductos();
    }
}
