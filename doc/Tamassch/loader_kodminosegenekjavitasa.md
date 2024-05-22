Loader osztály
Try catch blocknál try with resources javaslat nem használható mert a scanner osztály deklarációban van és több helyen is használva ezért nem lehet try with resource részben használni. Másrészt így sokszor létrekéne hozni a Scannert.
Ahol útvonal szerűen vannak az osztályok String formában hivatkozva azok ki lettek szervezve változóba. Ezáltalán ha valamelyik osztálynév vagy metódus név változna elég csak a változó értékén módosítani.
Ahol lehet specifikusabb exceptiont dobásra javítottam egy általános helyett. A txt fájlok formatjára nem találtam jobb specifikus exceptiont amit lehetne annak nincs string paramétere, és nem lehet hiba üzenetet dobni vele.
Megvizsgáltam egyéb hibákat.