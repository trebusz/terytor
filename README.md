The library is in early stages of development.

# Introduction

Terytor is a Java library to help handle Teryt data files. It also is to combine Tetryt data with GUGiK (en. Head Office of Geodesy and Cartography, pl. Główny Urząd Geodezji i Kartografii) data about administrative units' borders.

[Teryt](https://pl.wikipedia.org/wiki/TERYT) is a database of the administrative division of Poland. You can download the data from (government) [GUS website](http://eteryt.stat.gov.pl/eTeryt/rejestr_teryt/udostepnianie_danych/baza_teryt/uzytkownicy_indywidualni/pobieranie/pliki_pelne.aspx). 

Teryt contains multiple registries:

 * [TERC](https://pl.wikipedia.org/wiki/TERC),
 * [SIMC](https://pl.wikipedia.org/wiki/SIMC),
 * [ULIC](https://pl.wikipedia.org/wiki/ULIC).

GUGiK data is provided on [its website](http://www.gugik.gov.pl/pzgik/dane-bez-oplat/dane-z-panstwowego-rejestru-granic-i-powierzchni-jednostek-podzialow-terytorialnych-kraju-prg). Terytor currently uses files in SHP format.

## Dictionary

 * Województwo - en. Province.
 * Powiat - en. County.
 * Gmina - en. Commune.
 * TERC code - id of administrative unit. It combines id of province, county, commune and unit type.  

# Usage

There are going to be multiple clients for different data sets. Instantiating them might load a lot of data, so it's better to keep only single instance of each one.

Currently there are clients: 

 * [TercApiClient](https://github.com/warg-pl/terytor/blob/master/src/main/java/pl/warg/terytor/api/TercApiClient.java) - it returns names of units of provided TERC code.
 * GugikApiClient - it allows to check if given coordinates are inside provided TERC unit.

