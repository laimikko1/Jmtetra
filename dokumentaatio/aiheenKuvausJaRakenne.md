**Aihe**:Tetris-peli. Peli on suoraviivainen Tetris-kopio, jossa alaspäin laskeutuvia tetronomeja asetellaan päällekkäin. Erilaisia tetronomeja on seitsemän ja näitä arvotaan aina satunnaisesti pelaajan käyttöön. Palikoita voi käännellä, liikuttaa sivuttain ja alaspäin, sekä pudottaa suoraan alas. Jos palikoita on vaakatasossa koko pelialueen leveyden verran, rivi tuhoutuu ja kaikki päälle pinotut palikat siirtyvät yhden rivin alaspäin.
Peli on yksinpeli, pisteitä kerätään palojen liikuttamisella alaspäin ja rivien tuhoamisella. Peli vaikeutuu aina kun pelaaja onnistuu tuhoamaan tietyn määrän rivejä. Tällöin tetronomet liikkuvat nopeammin alaspäin, mutta pelaaja saa myös enemmän pisteitä tuhotuista riveistä.


**Käyttäjät**: Pelaaja

**Käyttäjän toiminnot**:

- Aloita uusi peli
- Käännä tetrispalikkaa
- Liikuta tetrispalikkaa sivusuunnassa tai alaspäin
- Pudota tetrispalikka

**Ohjelman rakenne**

Ohjelma koostuu Tetris-peliin tarvittavista komponenteista. Gameboard-luokka tekee pelilaudan, joka luodaan kaksiulotteisen char-taulukon päälle. Pelilauta vastaa pelilaudan tilanteen ylläpidosta ja sisältää aina tiedon pelissä sillä hetkellä liikuteltavasta tetronomesta. Pelilaudalla liikkuu siis tetronomeja, joista jokainen koostuu neljästä Piece-luokan ilmentymästä. Jokainen tetronomen muoto on on oma luokkansa. Erilaisia luokkia on siis seitsemän. Kaikilla seitsemällä luokalla on kaikilla oma enum, Tyyppi, joka kertoo tetronomen muodon. Nämä luokat myös perivät abstraktin Tetronome-luokan. 

Tämän lisäksi pelissä on graafinen käyttöliittymä. Sen ydin on Gameloop-luokka, jossa tapahtuu pelikierroksen pelaaminen. Sen apuna toimii InputListener-luokka, jonka tehtävä on kuunnella käyttäjän syötteitä ja välittää niiden kautta päivitetty pelitilanne Gameboard-luokalle. Tämän jälkeen GameboardDrawer-luokka saa Gameboard-luokasta päivitetyn pelitilanteen ja piirtää pelilaudan graafiseen käyttöliittymään. 
Gameloop käyttää apunaan myös TetronomeRaffler-luokkaa, joka vastaa seuraavan peliin asetettavan tetronomen arpomisesta.


<h2>Luokkakaavio</h2>


![Alt text](https://github.com/laimikko1/Jmtetra/blob/master/dokumentaatio/luokkakaavio(2).jpg)



<h2>Pelaaja liikuttaa palaa sivulle</h2>

![Alt text](https://github.com/laimikko1/Jmtetra/blob/master/dokumentaatio/Pelaaja%20liikuttaa%20palaa%20sivulle.png)



<h2>Pelaaja onnistuu tuhoamaan rivin</h2>

![Alt text](https://github.com/laimikko1/Jmtetra/blob/master/dokumentaatio/T%C3%A4ysi%20rivi%20tuhotaan.png)


