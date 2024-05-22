Map generátor és játék stressz testelése:

Map generátor által generált pályákon végeztem tesztelést 100,1000,3000 illetve 6000 játékossal. A játékos számfüggvényében a mezők száma exponenciálisan nő.

100 player:
Gyors generálás, és játék indulás.  Drop down menünél nem lehet mindent kiválasztani egérrel csak nyilakkal de bizonyos opciók képernyőn kívülre esnek így nem látható, hogy mikor van kiválasztva.
![](100%20player.png)

1000 player:
Ugyan az mint 100 playernél.

3000 player:
Lassú indulás, a dropdown menü textjei furán jelennek meg egymásra vannak csúszva.
![](3000%20player.png)

6000 player:
már 2.7 giga pálya 31p volt ay indulás, dropdown opciók annyira egymásra vannak csúszva, hogy arab írásnak tűnik. Minden más funkció az elvártnak megfelelően működik. A program nem használ sokkal több memóriát a pálya méreténél jelen esetben 3.2 GB volt.
![](6000%20player.png)

Jmenut használt a megjelenítés ezért felelős része. Ez a swinges menü nem támogat padding-ot, margin használat pedig nem oldja meg a problémát. Ezáltal a problémát csak egy új menürendszer kialakításával lehetne orvosolni.