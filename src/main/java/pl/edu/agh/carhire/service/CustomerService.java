package pl.edu.agh.carhire.service;

import pl.edu.agh.carhire.model.Customer;

import java.util.Collection;
import java.util.List;


public interface CustomerService {

	/**
	 * Metoda wyszukująca na podstawie ID dany obiekt klienta z bazy danych.
	 * @param id klienta
	 * @return znaleziony klient
	 */
	Customer findOne(Long id);

	/**
	 * Metoda wyszukująca wszystkich klientow z bazy danych.
	 * @return wyszukana Lista klientow
	 */
	List<Customer> findAll();

	/**
	 * Metoda wyszukująca klientow po imieniu i nazwisku z bazy danych.
	 * @param lastName nazwisko klienta
	 * @param firstName imie klienta
	 * @return znaleziona Lista klientow
	 */
	Collection<Customer> findByLastNameAndFirstName(String lastName, String firstName);

	/**
	 * Metoda zapisujaca dany stan obiektu klienta do bazy danych.
	 * @param customer obiekt klienta
	 * @return uaktualniony klient
	 */
	Customer save(Customer customer);

	/**
	 * Metoda usuwajaca klienta na podstawie jego ID z bazy danych.
	 * @param id klienta
	 * @throws IllegalArgumentException w przypadku niepoprawnego ID.
	 */
	void remove(Long id) throws IllegalArgumentException;

	/**
	 * Metoda wyszukująca klienta ktory posiada wypozyczenia samochodu na
	 * podstawie jego ID.
	 * @param id klienta
	 * @return znaleziony klient
	 */
	Customer findOneWithHires(Long id);
}
