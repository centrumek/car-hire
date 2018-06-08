package pl.edu.agh.carhire.service;

import pl.edu.agh.carhire.model.Car;
import java.util.List;

public interface CarService {

	/**
	 * Metoda wyszukująca na podstawie ID dany obiekt auta z bazy danych.
	 * @param id auta
	 * @return znaleziony auto
	 */
	Car findOne(Long id);

	/**
	 * Metoda wyszukująca wszystkie auta z bazy danych.
	 * @return wyszukana Lista aut
	 */
	List<Car> findAll();

	/**
	 * Metoda wyszukująca auta po nazwie modelu.
	 * @param carModel nazwa modelu
	 * @return znaleziona Lista aut
	 */
	List<Car> findByCarModel(String carModel);

	/**
	 * Metoda zapisujaca dany stan obiektu auta do bazy danych.
	 * @param car obiekt auta
	 * @return uaktualnione auto.
	 */
	Car save(Car car);

	/**
	 * Metoda usuwajaca auto na podstawie jego ID z bazy danych.
	 * @param id auta
	 * @throws IllegalArgumentException w przypadku niepoprawnego ID.
	 */
	void remove(Long id) throws IllegalArgumentException;
}
