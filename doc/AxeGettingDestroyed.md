Manuális tesztelés napló
1.
    1.	 A tesztelt funkció megnevezése, leírása:
    1.1.  Támadás - Balta csorbulása


    2.	 Az adott funkcióhoz tartozó tesztesetek:
    2.1.  "A" karakter megtámadja "B" karaktert fegyverrel


    3.	 Az adott teszteset elvárt kimenetele:
    3.1.  “B” karakter meghal a támadás után és a balta kicsorbul.


    4.	 Az adott teszteset tényleges kimenetele:
    4.1.  “B” karakter meghal a támadás után és a balta kicsorbul.



    5.	 Észrevételek az adott tesztesettel kapcsolatban:
    5.3.    Miután használtuk egyszer a fegyvert, és kicsorbul, ennek semmilyen jele nincs. Nem változik az inventoryban, vagy tűnik el onnan.
            A "{target} should be dead by now" szintén megjelenik. Bár hiba nincs a működésben, az elvárt kimenet egyezik a ténylegessel,
            érdemes lehet a felhasználói élmény és átláthatóság szempontjából eltüntetni a baltát a kézből használat után,
            vagy valami textúraváltozást eszközölni rajta.
