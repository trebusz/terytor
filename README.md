The library is in early stages of development and it's not yet usable.

# Introduction

[Teryt](https://pl.wikipedia.org/wiki/TERYT) is a database of the administrative division of Poland. You can download the data from (government) [GUS website](http://eteryt.stat.gov.pl/eTeryt/rejestr_teryt/udostepnianie_danych/baza_teryt/uzytkownicy_indywidualni/pobieranie/pliki_pelne.aspx). Unfortunately available files are XMLs, which are in many cases quite inconvenient.

Teryt contains multiple registries:

 * TERC -
 * SIMC -
 * ULIC -

Terytor is a Java library to help handle Teryt data files.

## Dictionary

 * Województwo - 
 * Powiat -
 * Gmina - 
 * TERC code -

# Usage

Each registry has its own client (like [TercApiClient](https://github.com/warg-pl/terytor/blob/master/src/main/java/pl/warg/terytor/api/TercApiClient.java). Clients require to be provided with path to XML file and each time they are instantiated XML file is parsed. So generally it's the best to keep a single instance of a client. Exposed methods are threadsafe. Stored registry data should be collectable by GC (once there's no client reference).

# TERC

## Done

 * Return division unit name by TERC code.

## TODO

 * TERC code validation.
 * Return lists of data like gminy of powiat. 


## SIMC

## ULIC
