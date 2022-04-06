package bo.edu.ucb.sis.WalikiBackend.dao;

import bo.edu.ucb.sis.WalikiBackend.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoDao {

    @Autowired
    private DataSource dataSource2;
    //@Autowired
    //private SequenceDao sequenceDao;

    public List<ConsultaProductosDto> findAllProductos(){
        List<ConsultaProductosDto> result = new ArrayList<>();
        try ( Connection conn2 = dataSource2.getConnection();//cerrado de conexion
              PreparedStatement pstmt = conn2.prepareStatement("" +
                      "SELECT p.id_producto, p.nombre_producto,p.precio, p.caracteristicas, p.tipo_producto, disponible " +
                      "FROM producto p " +
                      "ORDER BY p.id_producto; ")

        ){
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                ConsultaProductosDto producto = new ConsultaProductosDto();
                producto.setProductoId(rs.getInt("id_producto"));
                producto.setNombreProducto(rs.getString("nombre_producto"));
                producto.setStock(rs.getInt("stock"));
                producto.setPrecio(rs.getDouble("precio"));
                result.add(producto);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

}
