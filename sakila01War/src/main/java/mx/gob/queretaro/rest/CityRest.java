package mx.gob.queretaro.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import mx.gob.queretaro.ejb.ICityFacadeLocal;
import mx.gob.queretaro.model.City;

@RequestScoped
@Path("ciudad") // /api/ciudad end point
public class CityRest {

	@EJB // Inyección de dependencias
	private ICityFacadeLocal cityFacadeLocal;

	@GET
	@Path("obtenerTodos") // /api/ciudad/obtenerTodos
	@Produces(MediaType.APPLICATION_JSON)
	public List<City> obtenerTodos() {
		return cityFacadeLocal.obtenerTodos();
	}

	@GET
	@Path("obtenerPorId/{cityId}") // api/ciudad/obtenerPorId
	@Produces(MediaType.APPLICATION_JSON)
	public City obtenerPorId(@PathParam("cityId") short cityId) {
		return cityFacadeLocal.obtenerPorIdJpql(cityId);
	}

}
