package bo.edu.ucb.sis.WalikiBackend.api;

import bo.edu.ucb.sis.WalikiBackend.bl.ProductBl;
import bo.edu.ucb.sis.WalikiBackend.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductApi {

    @Autowired
    public DataSource dataSource;
    @Autowired
    private ProductBl productBl;

    //Mostrar catalogo de productos
    @GetMapping(path = "/catalogo")
    public ResponseDto  paginaPrincipal() {
        return new ResponseDto( true, productBl.findAllProyectos(), "Catalogo de productos");
    }
    //Listado proyecto por categoria
    @GetMapping(path = "producto/{categoria}")
    public ResponseDto findProyecto(@PathVariable String categoria) {
        if (categoria=="" ) {  // Proyectos vigentes
            return new ResponseDto(true, productBl.findProyectoVigente(estadoId), "Proyectos vigentes");
        }
        if (categoria=="" ) {  // Proyectos en proceso
            return new ResponseDto(true, productBl.findProyectoEnProceso(estadoId), "Proyectos en proceso");
        }
        if (categoria=="" ) {  // Proyectos Finalizados
            return new ResponseDto(true, productBl.findProyectosFinalizado(estadoId), "Proyectos finalizados ");
        }
        if (categoria=="" ) {  // Todos los proyectos
            return new ResponseDto(true, productBl.findAllProyectos(), "Todos los proyectos");
        }
        return new ResponseDto(true, proyectoBl.findProyectoVigente(estadoId), "Proyectos vigentes");
    }

}
