package pl.edu.agh.carhire.service;

import pl.edu.agh.carhire.model.User;
import java.util.List;

/**
 * Serwis zarządzający operacjami bazodanowymi na użytkowniku systemu.
 */
public interface UserService {
	/**
	 * Metoda wyszukująca na podstawie ID dany obiekt użytkownika z bazy danych.
	 * @param id użytkownika
	 * @return znaleziony użytkownik
	 */
	User findOne(Long id);

	/**
	 * Metoda wyszukująca wszystkich użytkowników z bazy danych.
	 * @return wyszukana Lista użytkowników
	 */
	List<User> findAll();

	/**
	 * Metoda wyszukująca użytkownika po nazwie z bazy danych.
	 * @param userName nazwa użytkownika
	 * @return znaleziony użytkownik
	 */
	User findByUserName(String userName);

	/**
	 * Metoda zapisujaca dany stan obiektu użytkownika do bazy danych.
	 * @param user obiekt użytkownika
	 * @return uaktualniony użytkownik
	 */
	User save(User user);

	/**
	 * Metoda usuwajaca uzytkownika na podstawie jego ID z bazy danych.
	 * @param id uzytkownika
	 * @throws IllegalArgumentException w przypadku niepoprawnego ID.
	 */
	void remove(Long id) throws IllegalArgumentException;

	/**
	 * Metoda sprawdzajaca czy dana nazwa uzytkownika jest unikalna w bazie danych.
	 * @param id uzytkownika
	 * @param username nazwa uzytkownika
	 * @return true lub false
	 */
	boolean isUsernameUnique(Long id, String username);
}
