package bo.edu.ucb.sis.WalikiBackend.api;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bo.edu.ucb.sis.WalikiBackend.bl.TransaccionBl;
import bo.edu.ucb.sis.WalikiBackend.dto.ResponseDto;
import bo.edu.ucb.sis.WalikiBackend.dto.TransaccionDto;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "http://localhost:4200")
public class TransaccionApi {
    @Autowired
    public DataSource dataSource;
    @Autowired
    private TransaccionBl transaccionBl;
    @PostMapping(path = "/signup")
    public ResponseDto addProyecto(@RequestBody TransaccionDto transaccion) {
        // Validar que los datos enviados son correctos.
        if (transaccion.getUsername() == null || transaccion.getUsername().trim().equals("") ) {  // usuario: "     "
            return new ResponseDto( false, null, "El nombre del proyecto debe ser obligatorio");
        }
        if (transaccion.getUsername() == null || transaccion.getUsername().trim().equals("") ) {  // password: "     "
            return new ResponseDto( false, null, "El monto a recaudar debe ser obligatorio y mayor a 0");
        }
        if (transaccion.getEmail() == null || transaccion.getEmail().trim().equals("") ) {  // email: "     "
            return new ResponseDto( false, null, "La descripcion debe ser obligatoria");
        }
        return new ResponseDto(true, transaccionBl.addTransaccion(transaccion), "Proyecto agregado con exito");
    }
}
