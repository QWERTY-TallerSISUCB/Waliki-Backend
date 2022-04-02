package bo.edu.ucb.sis.WalikiBackend.api;

import bo.edu.ucb.sis.WalikiBackend.bl.ProductoBl;
import bo.edu.ucb.sis.WalikiBackend.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProductoApi {

    @Autowired
    public DataSource dataSource;
    @Autowired
    private ProductoBl productoBl;

    //Mostrar catalogo de productos
    @GetMapping(path = "/catalogo")
    public ResponseDto  paginaPrincipal() {
        return new ResponseDto( true, productoBl.findAllProyectos(), "Catalogo de productos");
    }

}
