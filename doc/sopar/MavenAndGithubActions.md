# Build rendszer és CI beüzemelése

## Maven
A projket kezdetben nem használt semmilyen build rendszert (kézzell kellett fordítani). Ezért készítettem hozzá egy pom.xml fájlt, illetve átstruktúráltam a fájlokat és csomagokat a maven konvencióknak megfelelően.

## Github actions
Létrehoztam egy github actions-t a projektnek, hogy a tesztek minden 'main' ágra érkező commit esetén lefussanak.

