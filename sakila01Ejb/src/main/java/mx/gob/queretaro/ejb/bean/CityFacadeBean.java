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

	@PersistenceContext(unitName = "sakila") // Inyección de dependencias
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

	@SuppressWarnings("unchecked")
	@Override
	public List<City> obtenerTodos() {
		return em.createNamedQuery("City.findAll").getResultList();
	}

	@Override
	public City obtenerPorIdJpql(short cityId) { // JPQL objetos
		return (City) em
				.createQuery("SELECT NEW City(c.cityId, c.city, c.lastUpdate) FROM City c WHERE c.cityId = :cityId")
				.setParameter("cityId", cityId)
				.getSingleResult();
	}

	@Override
	public City obtenerPorIdClase(short cityId) {
		return em.find(City.class, cityId);
	}

}
