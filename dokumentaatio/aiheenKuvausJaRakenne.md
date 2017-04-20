### Aihe
Roolipeli, jossa käyttäjä pääsee seikkailemaan luolassa kohdaten hirviöitä ja löytäen aarteita. Tavoitteena on tehdä melko kattava peli, jonka parissa pelaaja voi hyvinkin käyttää jonkin aikaa. Pelissä käytetään alkeellista grafiikkaa kuvatamaan luolastoa sekä sen erilaisia kohteita.

### Toimintoja
Pelaaja saa pelin alussa valita, minkälaisen hahmon hän haluaa luoda. Hän antaa tässä vaiheessa hahmolleen myös nimen. Hahmonvalinta ja erilaiset hahmot eivät kuitenkaan ole vielä valmiit, joten tällä hetkellä pelaaja pystyy luomaan vain soturin.

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

![luokkakaavioRooliPeli](/dokumentaatio/luokkakaavioRooliPeli.png)
