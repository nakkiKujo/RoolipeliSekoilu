### Aihe
Roolipeli, jossa käyttäjä pääsee seikkailemaan luolassa kohdaten hirviöitä ja löytäen aarteita. Tavoitteena on tehdä melko kattava peli, jonka parissa pelaaja voi hyvinkin käyttää jonkin verran aikaa. Pelissä käytetään alkeellista grafiikkaa kuvastamaan luolastoa sekä sen erilaisia kohteita.

### Toimintoja
Pelaaja saa pelin alussa valita, minkälaisen hahmon hän haluaa luoda. Hän antaa tässä vaiheessa hahmolleen myös nimen. Hahmon ammatin valinta vaikuttaa siihen, millaiset ominaisuudet hahmolla on peli alussa:
* Soturilla on pelin alussa enemmän voimaa kuin muilla hahmoilla. Soturi saa peli alussa käyttöönsä myös muutaman parantavan voiteen.
* Velholla on peli alussa enemmän taikapuolustusta ja taikavoimaa kuin muilla hahmoilla. Loitsujen loihtimiseen velho saa pelin alussa muutaman riimun.
* Druidilla on pelin alussa enemmän ketteryyttä ja elämäpisteitä kuin muilla hahmoilla. Druidi saa pelin alussa käyttöönsä yhden parantavan voiteen ja riimun.

Sekvenssikaavio hahmon luomisesta:
![sekvenssikaavioHahmonluonti](/dokumentaatio/sekvenssiHahmonluonti.png)

Pelaaja pystyy liikkumaan luolastossa neljään suuntaan, ja liikkuessaan hän kohtaa luolan erilaisia kohteita. Kun pelaaja kohtaa jonkin kohteen, aktivoituu kohteeseen liittyvä tapahtuma (jos kohteella sellainen on).

Sekvenssikaavio hahmon liikuttamisesta:
![sekvenssikaavioHahmonliikutus](/dokumentaatio/sekvenssiHahmonliikuttaminen.png)

Luolastossa olevia kohteita ovat:
* *Hirviöt*: Pelaaja pystyy taistelemaan luolaston hirviöitä vastaan. Voittaessaan hän saa mahdollisesti palkintoja. Häviöstä seuraa pelin päättyminen.
* *Ansat*: Ansaan joutuessaan pelaajan hahmo kokee jotain ikävää, mahdollisesti kuoleman.
* *Aarteet*: Keräämällä aarteita parantaa pelaaja hahmonsa kykyjä. Aarteet sisältävät esineitä, joita pelaaja pystyy käyttämään hyödykseen luolastossa selvitäkseen.
* *Ovet*: Pelaaja kohtaa luolastossa ovia, joista jotkut ovat lukittuja ja jotkut avoimia. Lukittujen ovien avaamiseen tarvitsee pelaaja avaimen.
* *Portaat*: Pelaaja pystyy portaita pitkin kulkemaan syvemmälle luolaan.

### Ohjelman rakenne

![luokkakaavioRooliPeli](/dokumentaatio/luokkakaavioRooliPeli.png)

Ohjelman sovelluslogiikan ja käyttöliittymän välikätenä toimii Peli-luokka. Peli-luokalla on oliomuuttujina Hahmonluoja ja Hahmonliikuttaja -luokat, joita se käyttää pelaajan hahmon luomiseen ja liikutteluun. Lisäksi Peli-luokalla on oliomuuttujina pelaajan hahmo eli abstraktin Hahmo-luokan perivä olio sekä Luolasto-luokan olio.

Luolaston vastuulla on luoda ja ylläpitää pelin maailmaa. Se ylläpitää koordinaatistossa tietoa luolassa olevista Kohteista, joita se luo käyttäen Kohteidenluoja-luokan sekä HirvionLuoja-luokan staattisia metodeja. Kohde on abstrakti luokka, ja sen periviä luokkia ovat Ansa, Portaat, Ovi, Aarre, Seina, Kaytava ja Hirvio. Näiden luokkien olioita pelaaja kohtaa peliä pelatessaan.

Kohteisiin myös liittyy Tapahtumia, jotka aktivoituvat pelaajan kohdatessa Kohteen. Seiniin ja käytäviin ei liity tapahtumia. Tapahtumista ehkä oleellisin on hirviöihin liittyvä Taistelu, joka Taistelulaskin-olion avulla toteuttaa hahmon ja hirviön välisen taistelun.

Kohteiden ja pelaajan hahmon sijainnista pysytään tietoisena Sijainti-luokan avulla. Jokaisella kohteella ja hahmolla on oliomuuttujana oma Sijainti-olio, joka kertoo, missä koordinaatiston pisteessä kyseinen otus sijaitsee.

Hahmoon liittyy myös Reppu-luokan olio, joka voi sisältää erilaisia Esineitä. Reppu säilöö esineet listaan, johon voidaan asettaa enintään kuusi esinettä. Nämä esineet löytyvät joko luolaston hirviöltä tai aarteista. Hirviöillä ja aarteilla on siis oliomuuttujana lista niissä olevista esineistä.

Taisteluesineillä ja hahmoilla on profiili, joka kuvastaa hahmon tai esineen ominaisuuksia. 
