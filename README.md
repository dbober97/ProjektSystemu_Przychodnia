# SYSTEM DO OBSŁUGI SIECI PRZYCHODNI LEKARSKICH 

Autorzy:
Dorota Bober,
Anna Nielepiec

Informatyka, niestacjonarne, 3 rok, grupa 2






1. Cel projektu (wspólnie)
   
Przedmiotem projektu jest system przeznaczony do obsługi sieci przychodni lekarskich. Wdrożenie oprogramowania ma na celu usprawnienie funkcjonowania rejestracji i gabinetu lekarskiego w przychodniach. Aplikacja umożliwi pacjentom na samodzielny zapis do lekarza poprzez kalendarz dostępny online. Dodatkowo będzie dostępna dokumentacja medyczna, e-zwolnienia i e-recepty.
Lekarze będą mieli ułatwienie w tworzeniu dokumentacji medycznej. Szybki dostęp do informacji na temat przebytych chorób pacjentów, przyjmowanych leków. 
Projekt przyspieszy obsługę pacjentów czekających w kolejce i umożliwi przyjęcie większej ilości osób.
Adres repozytorium projektu: https://github.com/dbober97/ProjektSystemu_Przychodnia.git

2. Szczegółowy opis wymagań (wspólnie)
   
a) Wymagania funkcjonalne: 

    • system umożliwia rejestrację i logowanie użytkowników, 
    • system wymaga podania roli każdego użytkownika, determinującej jego uprawnienia, 
    • system umożliwia personelowi dodanie pacjenta do Rejestru pacjentów poprzez ręczne wpisanie jego danych,
    • pacjent może uzyskać dostęp do systemu w celu umawiania wizyt poprzez uzyskanie danych do logowania od personelu,
      Terminarz 
    • na początku każdego miesiąca lekarze/personel tworzą terminarze, gdzie podawany jest id lekarza, jego dostępność i numer gabinetu,
    • na podstawie terminarzy personel tworzy listę terminów możliwych do rezerwacji,
    • pacjent samodzielnie (jeśli ma utworzone konto w systemie) lub w rejestracji może planować wizyty z puli dostępnych terminów udostępnionych online,
    • system wysyła powiadomienia SMS do zaplanowanych pacjentów dzień przez zaplanowaną wizytą, 
    • w systemie dostępny jest podgląd terminarza dla lekarzy z możliwością anulowania zaplanowanych wizyt oraz zmianą ich terminu i wysłaniem powiadomienia SMS do pacjenta, 
    • system obsługuje dodanie do terminarza godzin otwarcia gabinetu w poszczególne dni przez użytkownika o roli lekarz, 
    • system umożliwia anulowanie zaplanowanego terminu przez pacjenta (z podaniem powodu),
      Realizacja wizyty 
    • system umożliwia lekarzowi przyjęcie zaplanowanego pacjenta z terminarza, 
    • system umożliwia wprowadzenie godzin rozpoczęcia i zakończenia wizyty, 
    • w systemie dostępne jest wybranie rozpoznania ze słownika rozpoznań - słownik może być uzupełniany ręcznie lub poprzez pobranie go ze strony NFZ, 
    • w systemie jest możliwość uzupełnienia ręcznie opisu wizyty, 
    • w systemie jest możliwość wybrania opisu wizyty z dostępnych szablonów - szablony dodają lekarze i są one widoczne oraz edytowalne dla wszystkich użytkowników o roli lekarz, 
    • w systemie jest możliwość skopiowania opisu i rozpoznania z poprzedniej wizyty pacjenta
      Recepta 
    • w systemie jest możliwość wystawienia e-recepty (zgodnie z wytycznymi NFZ) oraz recepty papierowej przez użytkownika o roli lekarz, 
    • w oknie dodawania recepty możliwe jest dodawanie leków z oficjalnego słownika leków wczytywanego z pliku, 
    • na recepcie jest możliwość wyboru poziomu refundacji leku, 
    • w systemie użytkownik o roli lekarz ma dostęp do podglądu dotychczas wypisywanych pacjentowi leków, które może wybrać do skopiowania na nową receptę, 
    • w systemie użytkownik ma możliwość wydruku recepty w wymaganych przez NFZ formatach na dostępnej drukarce, 
    • w systemie lekarz ma dostęp do zapisanych leków recepturowych i system umożliwia mu dodanie do recepty leku ze słownika zapisanych leków recepturowych, 
    • użytkownik o roli lekarz ma możliwość dopisania własnego leku recepturowego do słownika poprzez użycie odpowiedniego przycisku w oknie dodawania recepty 
      Zwolnienie 
    • w systemie użytkownik o roli lekarz ma możliwość wystawiania e-zwolnień i wysyłania bezpośrednio do pracodawcy na postawie wytycznych NFZ 
    • system umożliwia lekarzowi wystawianie papierowych zwolnień 
    • w systemie lekarz ma możliwość wydruku zwolnienia zgodnie z wymaganym szablonem 
      Skierowanie 
    • system udostępnia lekarzowi wystawianie skierowania do szpitala, pracowni, gabinetu oraz wydruk tego skierowania na dostępnej drukarce, 
      Rozliczenia 
    • system udostępnia użytkownikowi z odpowiednimi uprawnieniami informacje o ubezpieczeniu pacjenta poprzez odpowiednie oznaczenie go na liście Rejestru pacjentów,
    • w systemie jest możliwość dodania rozliczenia pacjenta na podstawie dostępnych umów przez użytkownika o odpowiednich uprawnieniach, 
    • system obsługuje wysłanie rozliczeń do NFZ.

b) Wymagania niefunkcjonalne: 

    • hasło powinno zawierać co najmniej 8 znaków, w tym minimum 1 cyfrę, znak specjalny, wielką literę,
    • działanie na różnych urządzeniach (responsywność),
    • spełnienie zasady WCAG 2.1 (dotępność strony dla osób z niepełnosprawnościami),
    • średnic czas otrzymania odpowiedzi do 1 sekundy,
    • możliwość jednoczesnego przeglądu terminarza przez minimum 20 użytkowników,
    • brak możliwości wybrania tego samego terminu przez więcej niż 1 użytkownika,
    • słownik rozpoznań ICD-9 jest pobierany z oficjalnej strony NFZ,
    • lekarz musi posiadać pulę numerów recept żeby wystawić receptę,
    • podgląd wydruków w PDF - obsługa Adobe Reader.

3. Ograniczenia: (wspólnie):
   
    • kompatybilność ze starszymi wersjami przeglądarek internetowych,
   
    • dokumenty i raporty w formacie dostosowanym do OpenOffice,
   
    • ograniczenia wynikające z szyfrowania danych wrażliwych,
   
    • czas realizacji projektu – 10 miesięcy.

5. Użytkownicy systemu (wspólnie)
   
   • administrator systemu – prace konserwacyjne,
   
   • pracownicy recepcji – rejestracja pacjentów w systemie; umawianie na wizyty; przygotowywanie terminarza,
   
   • lekarze – uzupełnianie dokumentacji medycznej; wystawianie recept, skierowań i zwolnień lekarskich,
   
   • pacjenci – umawianie się na wizyty, przeglądanie własnej dokumentacji medycznej

Przy określaniu wymagań kluczowym użytkownikiem jest lekarz kierujący placówką, w drugiej kolejności osoba odpowiedzialna za kierowanie recepcją, pacjenci mają najniższy priorytet.

5. Diagram przypadków użycia (wspólnie)

![przypadki_użycia](https://github.com/user-attachments/assets/551a59ed-6ba1-45a5-921a-fcd5bbcd3fa8)


6. Scenariusze do wszystkich przypadków użycia (wspólnie)
<img width="535" alt="Zrzut ekranu 2025-06-10 o 16 10 22" src="https://github.com/user-attachments/assets/e007e182-02f3-442f-a2b2-2afb35ec7f4d" />
<img width="538" alt="Zrzut ekranu 2025-06-10 o 16 25 57" src="https://github.com/user-attachments/assets/3cb5f018-6dee-4fb4-a903-ac9d19de5df9" />
<img width="548" alt="Zrzut ekranu 2025-06-10 o 16 27 36" src="https://github.com/user-attachments/assets/a1f2465c-7003-4e70-b5bf-c95eb670dc04" />
<img width="532" alt="Zrzut ekranu 2025-06-10 o 16 27 56" src="https://github.com/user-attachments/assets/d46e65f9-d917-4036-9201-45d59e68afb2" />
<img width="517" alt="Zrzut ekranu 2025-06-10 o 16 28 21" src="https://github.com/user-attachments/assets/90bebd92-b342-4305-a478-38c1a798e88a" />
<img width="533" alt="Zrzut ekranu 2025-06-10 o 16 28 44" src="https://github.com/user-attachments/assets/b3b30479-fac5-4e2c-bb19-72b0128a9ab9" />
<img width="529" alt="Zrzut ekranu 2025-06-10 o 16 28 59" src="https://github.com/user-attachments/assets/b6dbc318-e356-4df5-a65b-1970a584b196" />
<img width="531" alt="Zrzut ekranu 2025-06-10 o 16 29 19" src="https://github.com/user-attachments/assets/cc1180d8-bb93-4021-80f3-41c8f1e64195" />


7. Diagramy czynności (wspólnie)

Zaplanowanie wizyty:

![zaplanowanieWizyty](https://github.com/user-attachments/assets/567d4fe5-9aef-4c73-b21d-9c81bc06901e)

Utworzenie terminarza:

![utworzenieTerminarza](https://github.com/user-attachments/assets/2086319f-d931-4cb7-bfcb-341ca3f8caa3)

Rejestracja pacjenta:

![RejestracjaPacjenta](https://github.com/user-attachments/assets/1cf753d5-92f3-45f7-bdd1-78811890c606)

Logowanie do systemu:

![LogowanieSystem](https://github.com/user-attachments/assets/7c5993af-7c5d-4def-b564-6fd92a224b6f)

Przegląd danych pacjenta:

![PrzegladDanychPacjenta](https://github.com/user-attachments/assets/11908e67-958a-4384-8c08-dced97038ec7)

Utworzenie recepty:

![UtworzenieRecepty](https://github.com/user-attachments/assets/e6e7e08a-d134-427d-92d0-f2fe37fdd548)

Utworzenie skierowania:

![UtworzenieSkierowania](https://github.com/user-attachments/assets/143fdd79-5836-4ac4-9487-4a5b105bcfb0)


8. Diagram ERD (wspólnie)

![Logical_przychodnia](https://github.com/user-attachments/assets/10674d26-52ef-463c-b1b7-53f3a0bf92d5)

Kod SQL:

      CREATE TABLE asoc_recepta_lek (
          id                  INTEGER NOT NULL,
          recepty_id          INTEGER NOT NULL,
          leki_id             INTEGER NOT NULL,
          dawkowanie_ustalone CLOB NOT NULL,
          refundacja          INTEGER
      );
      
      ALTER TABLE asoc_recepta_lek ADD CONSTRAINT asoc_recepta_lek_pk PRIMARY KEY ( id );
      
      CREATE TABLE asoc_rola_user (
          id_asoc                    INTEGER NOT NULL,
          użytkownicy_id             INTEGER NOT NULL,
          role_id                    INTEGER NOT NULL,
          zarajestrowani_pacjenci_id INTEGER NOT NULL
      );
      
      ALTER TABLE asoc_rola_user ADD CONSTRAINT asoc_rola_user_pk PRIMARY KEY ( id_asoc );
      
      CREATE TABLE asoc_spec_user (
          id_asoc          INTEGER NOT NULL,
          specjalizacje_id INTEGER NOT NULL,
          użytkownicy_id   INTEGER NOT NULL
      );
      
      ALTER TABLE asoc_spec_user ADD CONSTRAINT asoc_spec_user_pk PRIMARY KEY ( id_asoc );
      
      CREATE TABLE choroby (
          id          INTEGER NOT NULL,
          nazwa       VARCHAR2(100) NOT NULL,
          kod_choroby VARCHAR2(20) NOT NULL
      );
      
      ALTER TABLE choroby ADD CONSTRAINT choroby_pk PRIMARY KEY ( id );
      
      CREATE TABLE gebinety (
          id          INTEGER,
          nr_pokoju   INTEGER NOT NULL,
          urządzenie  VARCHAR2(50) NOT NULL,
          gebinety_id NUMBER NOT NULL
      );
      
      ALTER TABLE gebinety ADD CONSTRAINT gebinety_pk PRIMARY KEY ( gebinety_id );
      
      CREATE TABLE leki (
          id         INTEGER NOT NULL,
          nazwa      VARCHAR2(100) NOT NULL,
          dawkowanie VARCHAR2(100) NOT NULL
      );
      
      ALTER TABLE leki ADD CONSTRAINT leki_pk PRIMARY KEY ( id );
      
      CREATE TABLE recepty (
          id                     INTEGER NOT NULL,
          data_wystawienia       DATE NOT NULL,
          wizyty_zrealizowane_id INTEGER NOT NULL
      );
      
      ALTER TABLE recepty ADD CONSTRAINT recepty_pk PRIMARY KEY ( id );
      
      CREATE TABLE role (
          id    INTEGER NOT NULL,
          nazwa VARCHAR2(50) NOT NULL
      );
      
      ALTER TABLE role ADD CONSTRAINT role_pk PRIMARY KEY ( id );
      
      CREATE TABLE specjalizacje (
          id    INTEGER NOT NULL,
          nazwa VARCHAR2(100) NOT NULL
      );
      
      ALTER TABLE specjalizacje ADD CONSTRAINT specjalizacje_pk PRIMARY KEY ( id );
      
      CREATE TABLE terminarze (
          id                   INTEGER NOT NULL,
          data_rozpoczenia     DATE NOT NULL,
          data_zakonczenia     DATE NOT NULL,
          przedzial_czasu      INTEGER NOT NULL,
          użytkownicy_id       INTEGER NOT NULL,
          gebinety_gebinety_id NUMBER NOT NULL
      );
      
      ALTER TABLE terminarze ADD CONSTRAINT terminarze_pk PRIMARY KEY ( id );
      
      CREATE TABLE terminy (
          id                  INTEGER NOT NULL,
          godzina_rozpoczenia DATE NOT NULL,
          godzina_zakonczenia DATE NOT NULL,
          przedzial_czasu     INTEGER NOT NULL,
          terminarze_id       INTEGER NOT NULL,
          dostepnosc          BLOB NOT NULL
      );
      
      ALTER TABLE terminy ADD CONSTRAINT terminy_pk PRIMARY KEY ( id );
      
      CREATE TABLE użytkownicy (
          id               INTEGER NOT NULL,
          imie             VARCHAR2(50) NOT NULL,
          nazwisko         VARCHAR2(50) NOT NULL,
          login            VARCHAR2(30) NOT NULL,
          haslo            VARCHAR2(70) NOT NULL,
          email            VARCHAR2(100) NOT NULL,
          telefon          VARCHAR2(15) NOT NULL,
          role_id          INTEGER NOT NULL,
          specjalizacje_id INTEGER NOT NULL
      );
      
      ALTER TABLE użytkownicy ADD CONSTRAINT użytkownicy_pk PRIMARY KEY ( id );
      
      CREATE TABLE wizyty (
          id                         INTEGER NOT NULL,
          data_wizyty                DATE NOT NULL,
          rozpoznanie                CLOB,
          uwagi                      CLOB,
          choroby_id                 INTEGER,
          wizyty_zaplanowane_id      INTEGER NOT NULL,
          status_realizacji          CHAR(1) NOT NULL,
          zarajestrowani_pacjenci_id INTEGER NOT NULL,
          terminy_id                 INTEGER NOT NULL
      );
      
      CREATE UNIQUE INDEX wizyty_zrealizowane__idx ON
          wizyty (
              wizyty_zaplanowane_id
          ASC );
      
      CREATE UNIQUE INDEX wizyty__idx ON
          wizyty (
              terminy_id
          ASC );
      
      ALTER TABLE wizyty ADD CONSTRAINT wizyty_zrealizowane_pk PRIMARY KEY ( id );
      
      CREATE TABLE wizyty_zaplanowane (
          id                         INTEGER NOT NULL,
          data                       DATE NOT NULL,
          zarajestrowani_pacjenci_id INTEGER NOT NULL,
          terminy_id                 INTEGER NOT NULL
      );
      
      CREATE UNIQUE INDEX wizyty_zaplanowane__idx ON
          wizyty_zaplanowane (
              terminy_id
          ASC );
      
      ALTER TABLE wizyty_zaplanowane ADD CONSTRAINT wizyty_zaplanowane_pk PRIMARY KEY ( id );
      
      CREATE TABLE zarajestrowani_pacjenci (
          id             INTEGER NOT NULL,
          imie           VARCHAR2(50) NOT NULL,
          nazwisko       VARCHAR2(50) NOT NULL,
          pesel          VARCHAR2(11) NOT NULL,
          adres          VARCHAR2(255) NOT NULL,
          telefon        VARCHAR2(15),
          data_urodzenia DATE NOT NULL,
          email          VARCHAR2(100),
          haslo          VARCHAR2(100)
      );
      
      ALTER TABLE zarajestrowani_pacjenci ADD CONSTRAINT zarajestrowani_pacjenci_pk PRIMARY KEY ( id );
      
      ALTER TABLE asoc_recepta_lek
          ADD CONSTRAINT asoc_recepta_lek_leki_fk FOREIGN KEY ( leki_id )
              REFERENCES leki ( id );
      
      ALTER TABLE asoc_recepta_lek
          ADD CONSTRAINT asoc_recepta_lek_recepty_fk FOREIGN KEY ( recepty_id )
              REFERENCES recepty ( id );
      
      ALTER TABLE asoc_rola_user
          ADD CONSTRAINT asoc_rola_user_role_fk FOREIGN KEY ( role_id )
              REFERENCES role ( id );
      
      ALTER TABLE asoc_rola_user
          ADD CONSTRAINT asoc_rola_user_użytkownicy_fk FOREIGN KEY ( użytkownicy_id )
              REFERENCES użytkownicy ( id );
      
      --  ERROR: FK name length exceeds maximum allowed length(30) 
      ALTER TABLE asoc_rola_user
          ADD CONSTRAINT asoc_rola_user_zarajestrowani_pacjenci_fk FOREIGN KEY ( zarajestrowani_pacjenci_id )
              REFERENCES zarajestrowani_pacjenci ( id );
      
      --  ERROR: FK name length exceeds maximum allowed length(30) 
      ALTER TABLE asoc_spec_user
          ADD CONSTRAINT asoc_spec_user_specjalizacje_fk FOREIGN KEY ( specjalizacje_id )
              REFERENCES specjalizacje ( id );
      
      ALTER TABLE asoc_spec_user
          ADD CONSTRAINT asoc_spec_user_użytkownicy_fk FOREIGN KEY ( użytkownicy_id )
              REFERENCES użytkownicy ( id );
      
      ALTER TABLE recepty
          ADD CONSTRAINT recepty_wizyty_zrealizowane_fk FOREIGN KEY ( wizyty_zrealizowane_id )
              REFERENCES wizyty ( id );
      
      ALTER TABLE terminarze
          ADD CONSTRAINT terminarze_gebinety_fk FOREIGN KEY ( gebinety_gebinety_id )
              REFERENCES gebinety ( gebinety_id );
      
      ALTER TABLE terminarze
          ADD CONSTRAINT terminarze_użytkownicy_fk FOREIGN KEY ( użytkownicy_id )
              REFERENCES użytkownicy ( id );
      
      ALTER TABLE terminy
          ADD CONSTRAINT terminy_terminarze_fk FOREIGN KEY ( terminarze_id )
              REFERENCES terminarze ( id );
      
      ALTER TABLE użytkownicy
          ADD CONSTRAINT użytkownicy_role_fk FOREIGN KEY ( role_id )
              REFERENCES role ( id );
      
      ALTER TABLE użytkownicy
          ADD CONSTRAINT użytkownicy_specjalizacje_fk FOREIGN KEY ( specjalizacje_id )
              REFERENCES specjalizacje ( id );
      
      ALTER TABLE wizyty
          ADD CONSTRAINT wizyty_terminy_fk FOREIGN KEY ( terminy_id )
              REFERENCES terminy ( id );
      
      ALTER TABLE wizyty_zaplanowane
          ADD CONSTRAINT wizyty_zaplanowane_terminy_fk FOREIGN KEY ( terminy_id )
              REFERENCES terminy ( id );
      
      --  ERROR: FK name length exceeds maximum allowed length(30) 
      ALTER TABLE wizyty_zaplanowane
          ADD CONSTRAINT wizyty_zaplanowane_zarajestrowani_pacjenci_fk FOREIGN KEY ( zarajestrowani_pacjenci_id )
              REFERENCES zarajestrowani_pacjenci ( id );
      
      --  ERROR: FK name length exceeds maximum allowed length(30) 
      ALTER TABLE wizyty
          ADD CONSTRAINT wizyty_zarajestrowani_pacjenci_fk FOREIGN KEY ( zarajestrowani_pacjenci_id )
              REFERENCES zarajestrowani_pacjenci ( id );
      
      ALTER TABLE wizyty
          ADD CONSTRAINT wizyty_zrealizowane_choroby_fk FOREIGN KEY ( choroby_id )
              REFERENCES choroby ( id );
      
      --  ERROR: FK name length exceeds maximum allowed length(30) 
      ALTER TABLE wizyty
          ADD CONSTRAINT wizyty_zrealizowane_wizyty_zaplanowane_fk FOREIGN KEY ( wizyty_zaplanowane_id )
              REFERENCES wizyty_zaplanowane ( id );
      
      CREATE SEQUENCE gebinety_gebinety_id_seq START WITH 1 NOCACHE ORDER;
      
      CREATE OR REPLACE TRIGGER gebinety_gebinety_id_trg BEFORE
          INSERT ON gebinety
          FOR EACH ROW
          WHEN ( new.gebinety_id IS NULL )
      BEGIN
          :new.gebinety_id := gebinety_gebinety_id_seq.nextval;
      END;
      /

8'. Wymagane rekordy w bazie:

      insert into specjalizacje values (1, 'Kardiolog')
      insert into specjalizacje values (2, 'Neurolog')
      insert into specjalizacje values (3, 'brak')
      
      insert into role values (3, 'Lekarz')
      insert into role values (2, 'Recepcjonista')
      insert into role values (1, 'Administrator')

      insert into użytkownicy values(1, 'Dorota', 'Bober', 'admin', 'pass', 'db@gmail.com', '999888777', 1, 3);

9. Diagram klas (wspólnie)

![diagramKlas](https://github.com/user-attachments/assets/47882a5c-6be7-4ba5-9626-8489aa8df317)


10. Diagramy sekwencji (wspólnie)

Zaplanowanie wizyty:

![SekwzaplanowanieWizyty](https://github.com/user-attachments/assets/44f74866-75fb-4cf8-8e00-b27a094f5b81)

Przegląd danych pacjenta:

![SekwPrzegladDanychPacjent](https://github.com/user-attachments/assets/905860a6-036a-47da-8a9a-196cd33c121e)

Wystawienie e-recepty:

![SekwWystawienieRecepty](https://github.com/user-attachments/assets/221a7f27-84b9-4bf0-9702-24fd7a93bbff)


11. Diagramy stanów (wspólnie)

Dla obiektu recepta:

![StanRecepta](https://github.com/user-attachments/assets/da4f61ef-6f32-46b8-b0dc-0b3f0561a8ed)

Dla obiektu wizyta:

![StanWizyta](https://github.com/user-attachments/assets/8e2e9f2d-640c-4faf-9e53-dc4b72a2f057)

12. Diagram wdrożenia (wspólnie)

![Wdrozenie](https://github.com/user-attachments/assets/f56f4513-e404-42c0-8faa-44943dae757e)

13. Bezpieczeństwo:
   -regularne aktualizacje systemu
   -protokół HTTPS
   -szyfrowanie wrażliwych danych w bazie danych
   -zasada minimalnych uprawnień
   -monitorowanie oraz analiza logów
   -walidacja danych wejściowych
   -regularne testy penetracyjne
   -wdrożenie Web Application Firewall
   -regularne szkolenia pracowników w zakresie cyberbezpieczeństwa

14. Zastosowane rozwiązania zwiększające dostępność (Deklaracja zgodności z WCAG ):
   -responsywność
   -zastosowanie logicznej struktury treści
   -kontrast kolorystyczny
   -zachowanie czytelności i widoczności tekstu przy min. 200% powiększeniu
   -brak treści, które migają cześciej niż 3 razy na sekundę
   -prosta nawigacja na stronie
   -zrozumiałe komunikaty o błędach


15. Plan procesu testowania (wspólnie)
Cel testowania: Celem procesu testowania jest zapewnienie, że system do obsługi sieci przychodni lekarskich działa zgodnie z wymaganiami funkcjonalnymi i niefunkcjonalnymi oraz spełnia oczekiwania wszystkich grup użytkowników.
Zakres testów:
    1. Testy jednostkowe (Unit Tests):
        ◦ Testowanie poszczególnych modułów aplikacji, takich jak rejestracja pacjentów, terminarz, wystawianie recept, itp. 
        ◦ Weryfikacja poprawności logiki biznesowej (np. sprawdzanie, czy pacjenci mogą umawiać się na wolne terminy). 
    2. Testy integracyjne (Integration Tests):
        ◦ Sprawdzenie komunikacji między modułami, np. rejestr pacjentów zintegrowany z terminarzem. 
        ◦ Testy poprawności przesyłania danych między aplikacją a zewnętrznymi systemami (np. NFZ). 
    3. Testy systemowe (System Tests):
        ◦ Testowanie aplikacji jako całości na różnych urządzeniach i przeglądarkach (zgodnie z wymaganiem responsywności). 
        ◦ Weryfikacja zgodności z zasadami WCAG 2.1. 
    4. Testy wydajnościowe (Performance Tests):
        ◦ Testowanie szybkości działania systemu przy 20 jednoczesnych użytkownikach. 
        ◦ Analiza czasu odpowiedzi na zapytania. 
    5. Testy użyteczności (Usability Tests):
        ◦ Testowanie interfejsu użytkownika z perspektywy lekarzy, recepcjonistów i pacjentów. 
        ◦ Ocena intuicyjności nawigacji. 
    6. Testy regresji (Regression Tests):
        ◦ Weryfikacja, że nowe zmiany w systemie nie wpływają negatywnie na istniejące funkcjonalności. 
    7. Testy akceptacyjne (Acceptance Tests):
        ◦ Testowanie aplikacji przez rzeczywistych użytkowników, aby potwierdzić jej gotowość do wdrożenia. 
Harmonogram testowania:
    1. Testy jednostkowe: 2 tygodnie. 
    2. Testy integracyjne: 1 tydzień. 
    3. Testy systemowe: 2 tygodnie. 
    4. Testy wydajnościowe i użyteczności: 1 tydzień. 
    5. Testy regresji: 1 tydzień. 
    6. Testy akceptacyjne: 1 tydzień. 
Oczekiwane wyniki:
    • Wszystkie kluczowe funkcje działają poprawnie. 
    • żadne krytyczne błędy nie występują w systemie. 

16. Identyfikacja konkurencji: Na rynku dostępne są liczne systemy do zarządzania przychodniami, takie jak:
    • Medchart: System zintegrowany z e-receptami i dokumentacją medyczną, nastawiony na ułatwienie pracy lekarzy. 
    • mMedica: Popularny system oferujący rozliczenia z NFZ oraz zarządzanie dokumentacją pacjentów. 
    • KAMSOFT: Rozwiązanie obsługujące duże sieci przychodni, umożliwiające kompleksowe zarządzanie placówką.

17. Proces testowania
    
    a) przykładowe 2 przypadki testowe:
    
    b) przykładowy test jednostkowy:

    
    Logowanie do systemu - trzech użytkowników o 3 różnych rolach.
    
    Zrzuty z bazy danych: lista pracowników w bazie, lista ról, lista specjalizacji:
    
![listaPracSQLDeveloper](https://github.com/user-attachments/assets/df583ebe-eb88-4fb6-af3e-fc921a633e1a)
![listaRolSQLDeveloper](https://github.com/user-attachments/assets/6a0c1b13-5c21-4a79-95eb-813fd201b72a)
![listaSpecSQLDeveloper](https://github.com/user-attachments/assets/24e70ed7-e1c1-4301-8e8b-5f37f70a12f6)


   Widok strony logowania: 

![stronaLogowania](https://github.com/user-attachments/assets/e14cc470-4b54-4666-9653-78db7a9e0c52)


   Strona logowania po zatwierdzeniu, gdy nie podano loginu i hasła:
![brak](https://github.com/user-attachments/assets/94fcec8f-56f5-451e-a506-fbbf027bcb0e)




   Strona logowanie gdy podane błędny login lub hasło:

   ![stronaLogowaniaZlyLogin](https://github.com/user-attachments/assets/e9bcc185-9174-4bba-b0d3-76b227c8271d)


![stronaLogowaniaZleHaslo](https://github.com/user-attachments/assets/01cc2be4-eae2-40b0-8952-660080c3be73)


   Logowanie, gdy podano prawidłowe dane - przypadek użytkownika o roli recepcjonista:

   ![stronaLogowaniaDobreLogowanie1](https://github.com/user-attachments/assets/eb09fb80-0ae9-4fba-803a-07e20a403ca4)

![stronaLogowaniaDobreLogowanie2](https://github.com/user-attachments/assets/154f66aa-3a0e-4962-934d-f4825f6f7b47)


   Podczas logowania wielkość liter w loginie nie ma znaczenia:

   ![stronaLogowaniaDobreLogowanieDuzeLitery1](https://github.com/user-attachments/assets/3cd85f57-110d-44f5-b39a-6547a79f543f)

![stronaLogowaniaDobreLogowanieDuzeLitery2](https://github.com/user-attachments/assets/fd9eb64b-6ef1-4478-beb4-1a400c310cdb)


   Logowanie użytkownika o roli administrator:

   ![logowanieAdmin1](https://github.com/user-attachments/assets/54fd7c63-e450-40db-9b3f-c752a4d7746c)

![logowanieAdmin2](https://github.com/user-attachments/assets/4f96abf3-2cba-4ada-80ec-4cc5c5d96f41)


   Logowanie użytkownika o roli lekarz:

   ![logowanieLekarz1](https://github.com/user-attachments/assets/64e1cac2-0de4-4423-a988-a6084955c587)

![logowanieLekarz2](https://github.com/user-attachments/assets/50104e66-b3f8-44fe-bfc8-50b978a078b2)



19. Podręcznik użytkownika:
    SPIS TREŚCI
       1. Instalacja i konfiguracja systemu
       2. Administrator jako osoba powołująca system do życia
       3. Zadania recepcjonisty
       4. Zadania lekarza
       5. Udogodnienia dla pacjentów.
   
          ----------------------------------
          1. Instalacja i konfiguracja środowiska.


          2. Zadania recepcjonisty.




