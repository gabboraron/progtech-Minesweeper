# Programozási technológia próba ZH  
Készítsük el az Akna egyszerű logikai játékot. Ehhez adott egy tábla (6x6 méretű), amelynek a mezői alá véletlenszerűen elhelyezünk egy-két aknát. A játékos kezdetben a tábla bal felső sarkában áll. Felrobbanás nélkül át kell jutnia a jobb alsó sarokba. Ha aknára lép, akkor vesztett, ha átért, akkor nyert.    
### 2. Hozza létre kódból a 6x6 darab gombot tartalmazó táblát, és az eseménykezelőt a gombokhoz. Kezdetben a bal felső gomb címkéje legyen ’X’. Ha rákattintunk egy szomszédos gombra, akkor kerüljön át a jel erre a gombra. Nem szomszédos gombra kattintva ne törtjén semmi. Amelyik gombon már jártunk egyszer annak színe legyen más, mint kezdetben volt.  
### 3. Hozzunk létre egy menüpontot, amellyel újrakezdhetjük a játékot. Ha sikerült átérni a táblán felrobbanás nélkül, akkor gratuláljunk egy dialógus ablakon megjelenített ’Gratulálok, nyertél!’ felirattal, majd indítsuk újra a játékot. Ha aknára léptünk, akkor egy dialógus ablakon megjelenített ’Felrobbantál !’ felirattal fejezzük be a játékot, majd indítsuk újra.  
### 4. Hozzunk létre egy menüpontot, amivel megállíthatjuk a játékot. Ekkor semmire sem lehet kattintani (vagy nincs hatása a kattintásnak). Jelezzük, hogy éppen ’pause’ állapotban vagyunk. A menüpont újbóli használatával lehessen folytatni a játékot. Valósítsuk meg a játékot MV architektúrát alkalmazva, azaz egy külön osztályban legyen implementálva a játék táblájának modellje és az egyes műveletei (lépések, sikerült-e bejárni a táblát).   
### 5. Készítsünk egy időzítőt és számlálót, mely alapján tájékozódhat a játékos, hogy mennyi idő telt el az aktuális játék kezdete óta. Ha lejárt az idő, akkor vesztett a játékos.   

Használható segédanyagok: Könyv, nyomtatott jegyzet, tárgy honlapja és a rajta elérhető projektek, JavaDoc.   
