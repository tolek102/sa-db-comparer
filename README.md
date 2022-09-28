# Akademia springa - moduł 9

## Przetestowanie czasów zapisu dany do bazy SQL i NoSQL

### Zadanie

Wczytaj do aplikacji 1000 obiektów pobranych z https://www.mockaroo.com/ (z formatu CSV)   
Stwórz metodę, która będzie zapisywała wszystkie elementy do lokalnej bazy danych.   
Stwórz aspekt, który będzie nasłuchiwać metodę i w momencie startu włączy licznik startu, a po zakończeniu operacji odczytanie zostanie 
czas wykonania operacji.   
Zrób do samo dla operacji wczytywania danych z bazy danych (bez wyświetlania ich, bo to może spowodować przekłamanie wyniku). Odnotuj 
wynik odczytu.   
Zrealizuj to dla relacyjnej bazy danych i nierelacyjnej bazy danych.   

### W projekcie użyto:

* maven 3.8.1
* java11
* springboot 2.7.3
* lombook
* Postgres database
* Mongo database
* Docker

### Info
Do uruchomienia aplikacji potrzebny jest zainstalowany docker.   
W głuwnym katalogu uruchamiany komendą `docker-compose up` i w logach kontenera `sa-db-comparer` zobaczymy dane o czasach zapisu, 
odczytu i usuwania danyz z bazy (kolejno 5 wywołań dla wiekszej ilości danych)

### Przykładowe dane
```
START PROCESSING

run no: 1
StopWatch 'MongoDbService->save': running time = 3657680064 ns; [save] took 3657680064 ns = 100%
StopWatch 'MongoDbService->readAll': running time = 198002406 ns; [readAll] took 198002406 ns = 100%
StopWatch 'MongoDbService->deleteAll': running time = 81660284 ns; [deleteAll] took 81660284 ns = 100%
StopWatch 'PostgresService->save': running time = 1070294173 ns; [save] took 1070294173 ns = 100%
StopWatch 'PostgresService->readAll': running time = 261785300 ns; [readAll] took 261785300 ns = 100%
StopWatch 'PostgresService->deleteAll': running time = 438657787 ns; [deleteAll] took 438657787 ns = 100%
run no: 2
StopWatch 'MongoDbService->save': running time = 2733568769 ns; [save] took 2733568769 ns = 100%
StopWatch 'MongoDbService->readAll': running time = 110877448 ns; [readAll] took 110877448 ns = 100%
StopWatch 'MongoDbService->deleteAll': running time = 98334705 ns; [deleteAll] took 98334705 ns = 100%
StopWatch 'PostgresService->save': running time = 881618584 ns; [save] took 881618584 ns = 100%
StopWatch 'PostgresService->readAll': running time = 28828749 ns; [readAll] took 28828749 ns = 100%
StopWatch 'PostgresService->deleteAll': running time = 434892533 ns; [deleteAll] took 434892533 ns = 100%
run no: 3
StopWatch 'MongoDbService->save': running time = 2542319466 ns; [save] took 2542319466 ns = 100%
StopWatch 'MongoDbService->readAll': running time = 110479290 ns; [readAll] took 110479290 ns = 100%
StopWatch 'MongoDbService->deleteAll': running time = 73921469 ns; [deleteAll] took 73921469 ns = 100%
StopWatch 'PostgresService->save': running time = 836198733 ns; [save] took 836198733 ns = 100%
StopWatch 'PostgresService->readAll': running time = 17713278 ns; [readAll] took 17713278 ns = 100%
StopWatch 'PostgresService->deleteAll': running time = 487642323 ns; [deleteAll] took 487642323 ns = 100%
run no: 4
StopWatch 'MongoDbService->save': running time = 2615644661 ns; [save] took 2615644661 ns = 100%
StopWatch 'MongoDbService->readAll': running time = 75312977 ns; [readAll] took 75312977 ns = 100%
StopWatch 'MongoDbService->deleteAll': running time = 37630926 ns; [deleteAll] took 37630926 ns = 100%
StopWatch 'PostgresService->save': running time = 731938749 ns; [save] took 731938749 ns = 100%
StopWatch 'PostgresService->readAll': running time = 11518442 ns; [readAll] took 11518442 ns = 100%
StopWatch 'PostgresService->deleteAll': running time = 191601790 ns; [deleteAll] took 191601790 ns = 100%
run no: 5
StopWatch 'MongoDbService->save': running time = 2371505418 ns; [save] took 2371505418 ns = 100%
StopWatch 'MongoDbService->readAll': running time = 79120267 ns; [readAll] took 79120267 ns = 100%
StopWatch 'MongoDbService->deleteAll': running time = 86674589 ns; [deleteAll] took 86674589 ns = 100%
StopWatch 'PostgresService->save': running time = 654684393 ns; [save] took 654684393 ns = 100%
StopWatch 'PostgresService->readAll': running time = 19974516 ns; [readAll] took 19974516 ns = 100%
StopWatch 'PostgresService->deleteAll': running time = 293708775 ns; [deleteAll] took 293708775 ns = 100%

STOP PROCESSING 
```
### Średnie czasy na podstawie powyższych watch [metoda/łączny czas[ns]/średni czas[ns]/średni czas[s]]
```
MongoDbService->save 		[13920718378/5] = 2784143675.6 -> 2.78414368
MongoDbService->readAll 	[573792388/5] 	= 114758477.6  -> 0.114758478
MongoDbService->deleteAll 	[378221973/5] 	= 75644394.6   -> 0.0756443946

PostgresService->save		[4174734632/5] 	= 834946926.4  -> 0.834946926
PostgresService->readAll	[339820285/5] 	= 67964057     -> 0.067964057
PostgresService->deleteAll	[1846503208/5] 	= 369300641.6  -> 0.369300642
```