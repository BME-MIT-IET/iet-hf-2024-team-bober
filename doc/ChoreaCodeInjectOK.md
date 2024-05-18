Manuális tesztelés napló
1.
    1.	 A tesztelt funkció megnevezése, leírása:
    1.1. ChoreaCode - Random lépteti maximum 3-szor a fertőzőtt játékost.


    2.	 Az adott funkcióhoz tartozó tesztesetek:
    2.1. "A" karakter megfertőz "B" karaktert a Chorea kóddal. Ezután "B" annyit lép, ahány maradék akciója van.
    2.2. "A" karakter megfertőzi magát Chorea kóddal. Ezután "A" karakter 2-t lép véletlenszerűen.


    3.	 Az adott teszteset elvárt kimenetele:
    3.1. "B" karakter elmozdul a mezőről egy másik véletlenszerűre a közelben.
    3.2. "A" karakter másik mezőre kerül, ha pedig nem, akkor elfogynak a hátralévő akciói. 
         (3-1 az inject, maradék kettőt léphet azonos irányba, ekkor máshova kerül, vagy léphet egyet oda egyet vissza, 
         ekkor ottmarad, de az akciói elfogynak)


    4.	 Az adott teszteset tényleges kimenetele:
    4.1. "B" karakter átkerült a másik mezőre (Max mozgáson volt, és Field2-ről Field5-re került.)
    4.2. "A" karakter más mezőre került
    4.3. "A" karakter ugyan ott maradt, de elfogyott a maradék kettő akciója.


    5.	 Észrevételek az adott tesztesettel kapcsolatban:
    5.1. A ChoreaCode inject megfelelően működik.


