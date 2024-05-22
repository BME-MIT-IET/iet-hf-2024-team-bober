# Statikus analízis használata

## Sonarcloud beüzemelése a projekthez.
A CI futtassa a statikus analízis eszközt.

## Sonarcloud által jelzett hibák javítása
Az általam javított hiba a következő volt:
Több osztályon fellül volt írva az equals() úgy, hogy a hashCode() nem, pedig javaban elvárt viselkedés, hogy ha két objektum egyenlő az equals() szerint, akkor a hashCode()-nak ugyanazt az eredményt kell adnia mindkét objektumon meghívva.
