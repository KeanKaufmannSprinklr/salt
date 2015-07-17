package de.hu_berlin.u.saltnpepper.graph.util;

/**
 * An interface to ensure that an object is copyable. This is an alternative to
 * the {@link Cloneable} interface which seems to be very controversial.
 * 
 * @author florian
 *
 */
public interface Copyable<T> {

	/**
	 * Takes a new 'empty' object and sets all its fields by copying by value.
	 * 
	 * @param surrogate empty object to be filled
	 */
	public void copy(T surrogate);
}
