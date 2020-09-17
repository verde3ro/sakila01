package mx.gob.queretaro.ejb;

import java.util.List;

import javax.ejb.Local;

import mx.gob.queretaro.model.City;

@Local
public interface ICityFacadeLocal {

	<T> T guardar(T entity);

	<T> T actualizar(T entity);

	List<City> obtenerTodos();

	City obtenerPorIdJpql(short cityId);

	City obtenerPorIdClase(short cityId);

}
