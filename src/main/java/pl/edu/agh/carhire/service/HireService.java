package pl.edu.agh.carhire.service;

import pl.edu.agh.carhire.model.Hire;

import java.util.Date;
import java.util.List;


public interface HireService {

	/**
	 * Metoda wyszukująca na podstawie ID dany obiekt wypozyczenia z bazy danych.
	 * @param id wypozyczenia
	 * @return znalezione wypozyczenie
	 */
	Hire findOne(Long id);

	/**
	 * Metoda wyszukująca wszystkie wypozyczenia z bazy danych.
	 * @return wyszukana Lista wypozyczen
	 */
	List<Hire> findAll();

	/**
	 * Metoda wyszukująca wypozyczenia po dacie rozpoczecia z bazy danych.
	 * @param hireDate data rozpoczecia wypozyczenia
	 * @return znaleziona Lista wypozyczen
	 */
	List<Hire> findByHireDate(Date hireDate);

	/**
	 * Metoda zapisujaca dany stan obiektu wypozyczenia do bazy danych.
	 * @param hire obiekt wypozyczenia
	 * @return uaktualnione wypozyczenie
	 */
	Hire save(Hire hire);

	/**
	 * Metoda usuwajaca wypozyczenie na podstawie jego ID z bazy danych.
	 * @param id wypozyczenia
	 * @throws IllegalArgumentException w przypadku niepoprawnego ID.
	 */
	void remove(Long id) throws IllegalArgumentException;
}
