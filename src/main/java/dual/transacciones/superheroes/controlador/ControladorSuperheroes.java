package dual.transacciones.superheroes.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dual.transacciones.superheroes.modelo.SuperheroeBean;
import dual.transacciones.superheroes.servicio.ImagenException;
import dual.transacciones.superheroes.servicio.ServicioSuperheroes;
import dual.transacciones.superheroes.servicio.SuperheroeException;

@RestController
@RequestMapping("/superheroes")
public class ControladorSuperheroes {
	
	@Autowired
	private ServicioSuperheroes servicio;
	
	@GetMapping
	public List<SuperheroeBean> consultar(){
		return this.servicio.consultar();
	}

	@GetMapping("/{identificador}")
	public ResponseEntity<?> consultar(@PathVariable long identificador) {
		try {
			return new ResponseEntity<>(this.servicio.consultar(identificador),
					HttpStatus.OK);
		} catch (SuperheroeException e) {
			return new ResponseEntity<>(e.getMessage(),
					HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping
	public ResponseEntity<String> crear(@RequestBody SuperheroeBean superheroe) {
		try {
			this.servicio.crear(superheroe);
		
			return new ResponseEntity<>("Se ha creado el superhéroe " 
			+ superheroe.getNombre() + " correctamente.", 
			HttpStatus.OK);

		} catch (ImagenException e) {
			return new ResponseEntity<>("Se ha creado el superhéroe " 
			+ superheroe.getNombre() + " correctamente pero sin imagen.", 
			HttpStatus.OK);
			
		} catch (SuperheroeException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@PatchMapping
	public ResponseEntity<String> modificar(@RequestBody SuperheroeBean superheroe) {
		try {
			this.servicio.modificar(superheroe);

			return new ResponseEntity<>("El superhéroe " 
			+ superheroe.getNombre() + " ha sido actualizado correctamente.", 
			HttpStatus.OK);
			
		} catch (ImagenException e) {
			return new ResponseEntity<>("Se ha modificado el superhéroe " 
			+ superheroe.getNombre() + " correctamente pero sin imagen.", 
			HttpStatus.OK);
			
		} catch (SuperheroeException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/{identificador}")
	public ResponseEntity<String> eliminar(@PathVariable long identificador) {
		try {
			this.servicio.eliminar(identificador);

			return new ResponseEntity<>("El superhéroe con identificador " 
			+ identificador + " ha sido eliminado correctamente.", 
			HttpStatus.OK);
		} catch (SuperheroeException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
