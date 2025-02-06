Bonfanti	Omar	879322
Condello	Alessandro	887918
Dozio	Luca	866375


Il codice prolog realizza un URI parser basandosi sulle specifiche
contenute nella consegna del progetto.

Il predicato principale è urilib_parse.
Sono stati implementati dei predicati ausiliari che consentono di
analizzare i campi degli URI.
Sono presenti anche due predicati per la stampa formattata dell'URI,
dividendo i vari campi (userinfo, host, port, path, query e fragment).

Gli schemi standard accettati sono: http, https e ftp.
Sono presenti anche degli schemi particolari che seguono regole specifiche:
mailto, news, tel, fax e zos.
Per lo schema zos, identificato da zos://, è obbligatorio inserire il path
nella forma specificata sul progetto.
