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

}
