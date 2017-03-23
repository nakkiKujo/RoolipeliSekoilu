### Aihe
Roolipeli, jossa käyttäjä pääsee seikkailemaan luolassa kohdaten hirviöitä ja aarteita. Tavoitteena on tehdä melko kattava peli, jonka parissa pelaaja voi hyvinkin käyttää jonkin aikaa.

Pelin on tarkoitus toimia vanhojen tekstipohjaisten roolipelien tapaan, tosin grafiikkaa tietenkin käytetään hyväksi esimerkiksi hahmon
tavaratilanteen ja muistiinpanojen kuvaamiseen. Myös luolaston kartta voidaan toteuttaa yksinkertaisella grafiikalla. Peliä voidaan mahdollisesti laajentaa esimerkiksi antamalla mahdollisuus omien maailmojen luontiin
(tosin tämä ominaisuus saattaa olla liian laaja toteuttaa).

### Rakenne
Ydinluokkana toimii *Peli*-luokka. Täällä tapahtuu itse pelin toiminnot, hahmon liikuttelu yms. Jos luokka kasvaa liian suureksi, voidaan hahmon liikuttelu asettaa jonkin toisen luokan tehtäväksi. Myös hahmon luominen tapahtuu tässä luokassa käyttäen luokkaa *Hahmonluoja*.

Itse pelaajan luomaa hahmoa kuvastaa abstrakti luokka *Hahmo*. Tämän luokan tehtävänä on pitää yllä tietoa hahmon ominaisuuksista ja päivittää niitä tarpeen mukaan. Tämä luokka pitää yllä myös tietoa hahmon sijainnista luokan *Sijainti* avulla. Tämä luokka jakaantuu aliluokkiin, jotka kuvastavat hahmon ammattia (jokaisella ammatilla omat erikoisuutensa)
* Velho
* Soturi
* Druidi
Aluksi ohjelmaa rakennetaan keskittyen ainoastaan Soturi-luokkaan, myöhemmin tarkennetaan muiden ammattien toimintaa.

Hahmon tavarat kuuluvat *Reppuun*, tosin vielä täytyy toteuttaa luokkia esineille. Tämä on kuitenkin murhe myöhemmälle ajalle.

Hahmon seikkailut tapahtuvat *Luolastossa*. Tähän luokkaan on tarkoitus tehdä *Luolia*, jotka toimivat kerroksina (mitä alemmas mennään, sitä vaikeammaksi peli muuttuu). Näin projektin alussa pidetään Luolasto vain yksikerroksisena yksinkertaisuuen vuoksi. Luolastossa on *Kohteita*, jotka voivat olla esimerkiksi ovia, seiniä, aarrearkkuja ja hirviöitä. Näistä pidetään kirjaa kaksiulotteisessa taulukossa, ja hahmon liikkuessa Kohteen päälle tapahtuu jotain.

![luokkakaavioRooliPeli](/dokumentaatio/luokkakaavioRooliPeli.png)
