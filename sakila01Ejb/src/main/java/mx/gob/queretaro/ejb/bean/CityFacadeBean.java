package mx.gob.queretaro.ejb.bean;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import mx.gob.queretaro.ejb.ICityFacadeLocal;
import mx.gob.queretaro.model.City;

@Stateless(name = "CityFacade", mappedName = "CityFacade")
@Transactional
public class CityFacadeBean implements ICityFacadeLocal {

	@PersistenceContext(unitName = "sakila")
	private EntityManager em;

	@Override
	public <T> T guardar(T entity) {
		em.persist(entity); // Insert

		return entity;
	}

	@Override
	public <T> T actualizar(T entity) {
		em.merge(entity); // Update es necesario que este seteado el id

		return entity;
	}

	@Override
	public List<City> obtenerTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public City obtenerPorIdJpql(short cityId) { // JPQL
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public City obtenerPorIdClase(short cityId) {
		// TODO Auto-generated method stub
		return null;
	}

}
