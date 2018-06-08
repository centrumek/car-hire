package pl.edu.agh.carhire.service;

import pl.edu.agh.carhire.model.Role;
import java.util.List;

public interface RoleService {

	/**
	 * Metoda wyszukująca na podstawie ID dany obiekt roli uzytkownika z bazy danych.
	 * @param id roli
	 * @return znaleziona rola
	 */
	Role findOne(Long id);

	/**
	 * Metoda wyszukująca role po nazwie z bazy danych.
	 * @param name nazwa roli
	 * @return znaleziona rola
	 */
	Role findByName(String name);

	/**
	 * Metoda wyszukująca wszystkie role z bazy danych.
	 * @return wyszukana Lista rol
	 */
	List<Role> findAll();

	/**
	 * Metoda zapisujaca dany stan obiektu roli do bazy danych.
	 * @param role obiekt roli
	 * @return uaktualniona rola
	 */
	Role save(Role role);

	/**
	 * Metoda usuwajaca role na podstawie jej ID z bazy danych.
	 * @param id roli
	 * @throws IllegalArgumentException w przypadku niepoprawnego ID.
	 */
	void remove(Long id) throws IllegalArgumentException;
}
