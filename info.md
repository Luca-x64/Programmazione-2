# Prog2@UniMI Handouts

[![License: GPL v3](https://img.shields.io/badge/License-GPL%20v3-blue.svg)](http://www.gnu.org/licenses/gpl-3.0)
[![License: CC BY-SA 4.0](https://img.shields.io/badge/License-CC%20BY--SA%204.0-blue.svg)](http://creativecommons.org/licenses/by-sa/4.0/)
[![Workflow results](https://github.com/prog2-unimi/handouts/actions/workflows/gradle.yml/badge.svg)](https://github.com/prog2-unimi/handouts/actions/workflows/gradle.yml)

Questo repository contiene gli *handout* dell'insegnamento di [Programmazione
II](https://prog2.di.unimi.it/) del corso di laurea in
[Informatica](https://informatica.cdl.unimi.it/it) dell'[Università degli Studi
di Milano](http://www.unimi.it/).

## TODO-LIST
- e09.Poly.sum() javadoc and ERM
- e09.PolySparse Fix, javadoc and ERM
- e10.* javadoc and ERM

### Come compilare ed eseguire i test e il codice

**compilare** il codice con: `./gradlew build`

 i **test** specificati nella directory `tests`.

Può eseguire il codice di una specifica classe, ad esempio
`it.unimi.di.prog2.h02.SalveMondo` con il comando

    ./gradlew runClass -PmainClass=it.unimi.di.prog2.h02.SalveMondo


### Come generare la documentazione

Può generare la documentazione in locale con il comando:

    ./gradlew javadoc

tale comando è configurato per riportare un errore in caso di *warning*, al fine
di aiutarla nel comprendere se la documentazione è, almeno dal punto di vista
sintattico, completa.

È possibile accedere direttamente ad una copia già compilata della
[documentazione del codice in questo repository](https://prog2-unimi.github.io/handouts/).

### Approcci alternativi

> **NOTA BENE**: *nel caso del progetto* non sarà valutato alcun codice che
> presenti *errori* (o *warning*) di compilazione (sia nella parte di *Java* che
> di *Javadoc*).

## Il materiale degli scorsi anni accademici

* branch dell'[AA 2019/20](../../tree/aa1920),
* branch dell'[AA 2020/21](../../tree/aa2021),
* branch dell'[AA 2021/22](../../tree/aa2122),
* branch dell'[AA 2022/23](../../tree/aa2223),
* branch dell'[AA 2023/24](../../tree/aa2324).
