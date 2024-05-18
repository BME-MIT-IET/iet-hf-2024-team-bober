# UI Tesztek

A UI teszteket JUnit, és a Java beépített Robot osztálya segítségével írtam. A JUnit futtatja a teszteket, és végzi az állapotváltozás ellenőrzéseket, míg a Robot osztály lehetővé teszi, hogy az egér működését szimuláljuk. Ehhez szükség van arra, hogy a játék ténylegesen fusson, mivel a Robot a kurzort manipulálja.

A tesztek mind ugyanabban a környezetben futnak, egy játékot elindítva, tényleges akciókat hajtanak végre a játékosok. A tesztek egymás után vannak kötve, így nem szükséges mindegyikhez külön játékot indítani, vagy szituációt beállítani, azonban ennek az az ára, hogy nem tényleges unit tesztekről van szó. Inkább arra valók, hogy gyorsan végig kattintatják a UI-on levő gombokat és menüket, ellenőrizve ezzel, hogy azok helyesen működnek-e és a megfelelő akciók végrehajtódnak-e a kattintásra. A futás alatt az egérhez nem szabad nyúlni, mert előfordulhat, hogy a robot emiatt rossz helyen kattint.

A teszteket mind a map3-ra építettem, és a sorrendfüggőség miatt jó eséllyel másik pályára nem is futnának le jól, de elméletileg ez nem kéne, hogy gondot jelentsen, mivel úgyis a működést teszteljük, ami minden pályára azonos kéne, hogy legyen. A teszteken akkor kell változtatni, ha a UI-hoz is hozzányúlunk, például új elemeket adunk hozzá, vagy átrendezzük.

Az ellenőrzéshez egyszerű asserteket használtam, amik az akciótól elvárt állapotváltozást vizsgálják a megfelelő okjektumokon. Állapot alatt itt mindig egy változót értek, például a lépés esetén a körön levő játékos helyzetét, a robot futtatása előtt elmentem, aztán az akció végrehajtása után összehasonlítom az új helyzettel.

