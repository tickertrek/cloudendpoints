package com.tickertrek.cloudendpoints.api;

import com.tickertrek.cloudendpoints.EMF;
import com.tickertrek.cloudendpoints.entity.Order;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.response.CollectionResponse;
import com.google.appengine.api.datastore.Cursor;
import com.google.appengine.datanucleus.query.JPACursorHelper;

import java.util.List;

import javax.annotation.Nullable;
import javax.inject.Named;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityManager;
import javax.persistence.Query;

@Api(name = "orderendpoint", namespace = @ApiNamespace(ownerDomain = "tickertrek.com", ownerName = "tickertrek.com", packagePath = "cloudendpoints.entity"))
public class OrderEndpoint {

	/**
	 * This method lists all the entities inserted in datastore.
	 * It uses HTTP GET method and paging support.
	 *
	 * @return A CollectionResponse class containing the list of all entities
	 * persisted and a cursor to the next page.
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	@ApiMethod(name = "listOrder")
	public CollectionResponse<Order> listOrder(
			@Nullable @Named("cursor") String cursorString,
			@Nullable @Named("limit") Integer limit) {

		EntityManager mgr = null;
		Cursor cursor = null;
		List<Order> execute = null;

		try {
			mgr = getEntityManager();
			Query query = mgr.createQuery("select from Order as Order");
			if (cursorString != null && cursorString != "") {
				cursor = Cursor.fromWebSafeString(cursorString);
				query.setHint(JPACursorHelper.CURSOR_HINT, cursor);
			}

			if (limit != null) {
				query.setFirstResult(0);
				query.setMaxResults(limit);
			}

			execute = (List<Order>) query.getResultList();
			cursor = JPACursorHelper.getCursor(execute);
			if (cursor != null)
				cursorString = cursor.toWebSafeString();

			// Tight loop for fetching all entities from datastore and accomodate
			// for lazy fetch.
			for (Order obj : execute)
				;
		} finally {
			mgr.close();
		}

		return CollectionResponse.<Order> builder().setItems(execute)
				.setNextPageToken(cursorString).build();
	}

	/**
	 * This method gets the entity having primary key id. It uses HTTP GET method.
	 *
	 * @param id the primary key of the java bean.
	 * @return The entity with primary key id.
	 */
	@ApiMethod(name = "getOrder")
	public Order getOrder(@Named("id") Long id) {
		EntityManager mgr = getEntityManager();
		Order order = null;
		try {
			order = mgr.find(Order.class, id);
		} finally {
			mgr.close();
		}
		return order;
	}

	/**
	 * This inserts a new entity into App Engine datastore. If the entity already
	 * exists in the datastore, an exception is thrown.
	 * It uses HTTP POST method.
	 *
	 * @param order the entity to be inserted.
	 * @return The inserted entity.
	 */
	@ApiMethod(name = "insertOrder")
	public Order insertOrder(Order order) {
		EntityManager mgr = getEntityManager();
		try {
			if (containsOrder(order)) {
				throw new EntityExistsException("Object already exists");
			}
			mgr.persist(order);
		} finally {
			mgr.close();
		}
		return order;
	}

	/**
	 * This method is used for updating an existing entity. If the entity does not
	 * exist in the datastore, an exception is thrown.
	 * It uses HTTP PUT method.
	 *
	 * @param order the entity to be updated.
	 * @return The updated entity.
	 */
	@ApiMethod(name = "updateOrder")
	public Order updateOrder(Order order) {
		EntityManager mgr = getEntityManager();
		try {
			if (!containsOrder(order)) {
				throw new EntityNotFoundException("Object does not exist");
			}
			mgr.persist(order);
		} finally {
			mgr.close();
		}
		return order;
	}

	/**
	 * This method removes the entity with primary key id.
	 * It uses HTTP DELETE method.
	 *
	 * @param id the primary key of the entity to be deleted.
	 */
	@ApiMethod(name = "removeOrder")
	public void removeOrder(@Named("id") Long id) {
		EntityManager mgr = getEntityManager();
		try {
			Order order = mgr.find(Order.class, id);
			mgr.remove(order);
		} finally {
			mgr.close();
		}
	}

	private boolean containsOrder(Order order) {
		EntityManager mgr = getEntityManager();
		boolean contains = true;
		try {
			Order item = mgr.find(Order.class, order.getKey());
			if (item == null) {
				contains = false;
			}
		} finally {
			mgr.close();
		}
		return contains;
	}

	private static EntityManager getEntityManager() {
		return EMF.get().createEntityManager();
	}

}
