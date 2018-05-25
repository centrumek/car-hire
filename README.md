Rent-a-car
==========

## 1.Wstep
Poniższy dokument zawiera ogólny opis projektu oraz scharakteryzowane wymagania systemowe ze względu na jego przeznaczenie i sposób użycia, a także określenie najważniejszych założeń jego realizacji. Wszelkie decyzje implementacyjne nie są tu podejmowane i opisane zostaną w następnych dokumentach.

## 2.Opis problemu
**Problem:** Dokumentacja papierowa i pomyłki z nią związane.
**Rozwiązanie:** Opracowanie systemu informatycznego z baza danych pozwoli zredukować dokumentacje papierowa do minimum. Umożliwi także sprawdzanie na bieżąco wprowadzanych danych
 
**Problem:** Utrudniona obsługi klienta, konieczność wielokrotnego wprowadzania tych samych danych
**Rozwiązanie:** Dobrze zaprojektowany system pozwala na zautomatyzowanie uzupełniania części danych, a forma aplikacji webowej przeniesie, przynajmniej część, tego procesu na klienta.
 
**Problem:** Utrudniona ewidencja i obsługa pojazdów.
**Rozwiązanie:** Jednolita baza danych pozwoli wyeliminować problem podwójnych wypożyczeń, a moduł kalendarza przypomini o zbliżajacych się wydarzeniach (np. badania techniczne pojazdu)



## 3.Wymagania funkcjonalne

1. Funkcjonalności obowiązkowe:
	- Obsługa konta klienta (pracownik, klient) 
	- Wyszukiwanie klienta (pracownik) 
	- Wypożyczenie samochodu (pracownik) 
	- Informacje o stanie floty oraz wypożyczonych samochodach 	(pracownik, klient) 
	- Obsługa rezerwacji samochodu (pracownik, klient)
2. Funkcjonalności z wysokim priorytetem:
	- Obsługa pojazdów (pracownik,właściciel)
3. Funkcjonalności dodatkowe:
	- Obsługa konta pracownika (administrator)
4. Funkcjonalności do rozpatrzenia w przyszłości:
	- Odbieranie przypomnień o wydarzeniach (pracownik)


## 4.Użyte technologie
- Spring Boot 2.0.1
- Spring MVC 4.3.3
- Spring Data JPA 2.0.6
- Spring Security 5.0.4 
- Apache Tiles 3.0.5
- JSTL 1.2
- Log4j 1.2.12

Pełna dokumentacja moze być znaleźiona [tutaj](https://docs.google.com/document/d/1_HC6NWEPBg7oqwOoQvHzOHhY52nlhk_0lzmbz-PGCJA/edit?usp=sharing) 
