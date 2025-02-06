%   Bonfanti    Omar    879322
%   Condello    Alessandro  887918
%   Dozio   Luca    866375


%%% -*- Mode: Prolog; -*-

:- dynamic urilib_parse/2.
:- dynamic read_authority/3.

%%% urilib_parse/2
%%%
%%% urilib_parse(URIString, URI) è vero se URIString può essere diviso
%%% nei seguenti termini:
%%% URI = uri(Scheme, Userinfo, Host, Port, Query, Fragment).
urilib_parse(URIString,
	  uri(DScheme, User, Host, Port, Path, Query, Fragment)) :-
    string_chars(URIString, ListChars),
    chars_to_atom(ListChars, AtomList),
    scheme(AtomList, Scheme, RestUriChars),
    downcase_atom(Scheme, DScheme),
    aux_urilib_parse(DScheme, RestUriChars,
		  uri_no_scheme(User, Host, Port, Path, Query, Fragment)),
    asserta((urilib_parse(URIString,
		    uri(Scheme, User, Host, Port, Path, Query, Fragment)) :- !)).

%%% urilib_display/1
%%%
%%% Stampa le parti dell'URI sullo stream di default.
urilib_display(URI) :- urilib_display(URI, user_output).

%%% urilib_display/2
%%%
%%% Stampa le parti dell'URI su file.
urilib_display(URI, Stream) :-
    is_stream(Stream), print_uri(Stream, URI), close(Stream).

%%% print_uri/2
%%%
%%% Stampa dell'URI.
print_uri(Out, uri(Scheme, User, Host, Port, Path, Query, Fragment)) :-
    writeln(Out, "Display URI:"),
    write(Out, "\tScheme: "), writeln(Out, Scheme),
    write(Out, "\tUserinfo: "), writeln(Out, User),
    write(Out, "\tHost: "), writeln(Out, Host),
    write(Out, "\tPort: "), writeln(Out, Port),
    write(Out, "\tPath: "), writeln(Out, Path),
    write(Out, "\tQuery: "), writeln(Out, Query),
    write(Out, "\tFragment: "), writeln(Out, Fragment).

%%% aux_urilib_parse/3
%%%
%%% Predicato per riconoscere le parti rimanenti dell'URI.
%%% Sceglie sulla base dello schema o in base ai caratteri dopo ":".

%%% Schema vuoto
aux_urilib_parse([], _, _) :- !, fail.

%%% Schema "mailto"
aux_urilib_parse(mailto, Chars,
	            uri_no_scheme(User, Host, [], [], [], [])) :- !,
    controlla_lista(Chars),
    user_parse(Chars, UserList, OtherChars),
    check_host_mail(OtherChars),
    list_to_atom(OtherChars, Host),
    list_to_atom(UserList, User).

%%% Schema "news"
aux_urilib_parse(news, Chars, uri_no_scheme([], Host, [], [], [], [])) :- !,
    controlla_lista(Chars),
    check_host(Chars),
    list_to_atom(Chars, Host).

%%% Schema "tel"
aux_urilib_parse(tel, Chars, uri_no_scheme(User, [], [], [], [], [])) :- !,
    user_parse(Chars, UserList, _),
    list_to_atom(UserList, User).

%%% Schema "fax"
aux_urilib_parse(fax, Chars, uri_no_scheme(User, [], [], [], [], [])) :- !,
    user_parse(Chars, UserList, _),
    list_to_atom(UserList, User).


%%% Schema "zos" 
aux_urilib_parse(zos, [(/), (/)], _) :- !, fail.

aux_urilib_parse(zos, [(/), (/) | T], _) :-
    authority_parse(T, _, []), last(T, (/)), !, fail.

aux_urilib_parse(zos, [(/), (/) | T],
	      uri_no_scheme(User, Host, Port, Path, Query, Fragment)) :-
    authority_parse(T, authority_part(User, Host, Port), Other),
    path_parse(Other, optional(PathC, QueryC, FragmentC)),
    !, path_zos(PathC, 0),
    list_to_atom(PathC, Path),
    list_to_atom(QueryC, Query),
    list_to_atom(FragmentC, Fragment).


%%% schemi non accettati.    
aux_urilib_parse(_,[(/), (/)], _) :- !, fail.

%%% caso http con due slash
aux_urilib_parse(http,[(/), (/) | T],
	      uri_no_scheme(User, Host, Port, Path, Query, Fragment)) :-
    !, authority_parse(T, authority_part(User, Host, Port),
		       OptionalChar),
    path_parse(OptionalChar, optional(PathC, QueryC, FragmentC)),
    check_path(PathC, _), !,
    list_to_atom(PathC, Path),
    list_to_atom(QueryC, Query),
    list_to_atom(FragmentC, Fragment).

%%% caso http con uno slash
aux_urilib_parse(http, [(/) | T],
	      uri_no_scheme([], [], 80, Path, Query, Fragment)) :- !,
    path_parse(T, optional(PathC, QueryC, FragmentC)),
    check_path(PathC, _), !,
    list_to_atom(PathC, Path),
    list_to_atom(QueryC, Query),
    list_to_atom(FragmentC, Fragment).

%%% caso http senza slash
aux_urilib_parse(http, T,
	      uri_no_scheme([], [], 80, Path, Query, Fragment)) :- !,
    path_parse(T, optional(PathC, QueryC, FragmentC)),
    check_path(PathC, _), !,
    list_to_atom(PathC, Path),
    list_to_atom(QueryC, Query),
    list_to_atom(FragmentC, Fragment).


%%% caso https con due slash
aux_urilib_parse(https,[(/), (/) | T],
    uri_no_scheme(User, Host, Port, Path, Query, Fragment)) :-
    !, authority_parse(T, authority_part(User, Host, Port),
         OptionalChar),
    path_parse(OptionalChar, optional(PathC, QueryC, FragmentC)),
    check_path(PathC, _), !,
    list_to_atom(PathC, Path),
    list_to_atom(QueryC, Query),
    list_to_atom(FragmentC, Fragment).

%%% caso https con uno slash
aux_urilib_parse(https, [(/) | T],
    uri_no_scheme([], [], 443, Path, Query, Fragment)) :- !,
    path_parse(T, optional(PathC, QueryC, FragmentC)),
    check_path(PathC, _), !,
    list_to_atom(PathC, Path),
    list_to_atom(QueryC, Query),
    list_to_atom(FragmentC, Fragment).

%%% caso https senza slash
aux_urilib_parse(https, T,
    uri_no_scheme([], [], 443, Path, Query, Fragment)) :- !,
    path_parse(T, optional(PathC, QueryC, FragmentC)),
    check_path(PathC, _), !,
    list_to_atom(PathC, Path),
    list_to_atom(QueryC, Query),
    list_to_atom(FragmentC, Fragment).


%%% caso ftp con due slash
aux_urilib_parse(ftp,[(/), (/) | T],
	      uri_no_scheme(User, Host, Port, Path, Query, Fragment)) :-
    !, authority_parse(T, authority_part(User, Host, Port),
		       OptionalChar),
    path_parse(OptionalChar, optional(PathC, QueryC, FragmentC)),
    check_path(PathC, _), !,
    list_to_atom(PathC, Path),
    list_to_atom(QueryC, Query),
    list_to_atom(FragmentC, Fragment).

%%% caso ftp con uno slash
aux_urilib_parse(ftp, [(/) | T],
	      uri_no_scheme([], [], 21, Path, Query, Fragment)) :- !,
    path_parse(T, optional(PathC, QueryC, FragmentC)),
    check_path(PathC, _), !,
    list_to_atom(PathC, Path),
    list_to_atom(QueryC, Query),
    list_to_atom(FragmentC, Fragment).

%%% caso ftp senza slash
aux_urilib_parse(ftp, T,
	      uri_no_scheme([], [], 21, Path, Query, Fragment)) :- !,
    path_parse(T, optional(PathC, QueryC, FragmentC)),
    check_path(PathC, _), !,
    list_to_atom(PathC, Path),
    list_to_atom(QueryC, Query),
    list_to_atom(FragmentC, Fragment).


%%% scheme/3
%%%
%%% Riceve lista di caratteri in input e ritorna lo schema riconosciuto
%%% come un atomo e la lista dei caratteri seguenti.
scheme(ListChar, Scheme, Rest) :-
    controlla_primo(ListChar),
    aux_scheme(ListChar, ListOut, Rest),
    list_to_atom(ListOut, Scheme).

%%% controlla_primo/1
%%%
%%% impedisce che lo scheme sia vuoto
controlla_primo([':' | _]) :- !, fail.
controlla_primo([_ | _]).

%%% controlla_lista/1
%%%
controlla_lista([]) :- !, fail.
controlla_lista([_ | _]).

%%% aux_scheme/3
%%%
%%% Prende in input una lista di atomi e riconosce lo schema, ritorna lista.
%%% Inoltre, ritorna una lista di atomi non usati.
aux_scheme([], [], []) :- !, fail.
aux_scheme([(:)| T], [], T) :- !.
aux_scheme([H | T], [H | Rest], OtherChar) :-
    is_valid_char(H), !,
    aux_scheme(T, Rest, OtherChar).

%%% is_valid_char/1
%%%
%%% Controlla se corrisponde a <carattere>
is_valid_char(Char) :- 
    char_type(Char, alnum).
is_valid_char('+').
is_valid_char('=').
is_valid_char('-').
is_valid_char('_').


%%% authority_parse/3
%%%
%%% Prende in input una lista di caratteri e ritorna
%%% l'authority e i caratteri rimasti.
%%% Passa la lista a un predicato che riconosce l'authority.
%%% Poi controlla la validità e converte la lista in un atomo.
authority_parse([], authority_part([], [], []), []) :- !.
authority_parse(Chars, authority_part(User, Host, Port),
		RestURIChars) :-
    read_authority(Chars, Authority_chars, RestURIChars),
    authority(Authority_chars, author(UserList, HostList, PortList)),
    !, check_host(HostList),
    list_to_atom(UserList, User),
    list_to_atom(HostList, Host),
    list_to_atom(PortList, PortA),
    atom_number(PortA, Port),
    between(0, 65536, Port).

%%% read_authority/3
%%%
%%% Prende lista di atomi e riconosce l'authority.
%%% Ritorna l'authority e il resto della lista.
read_authority([], [], []) :- !.
read_authority([(/) | T], [], T) :- !.
read_authority([H | T], [H | Rest], Other) :-
    read_authority(T, Rest, Other).


%%% authority/2
%%%
%%%
authority([(@) | _], _) :- !, fail.
authority(List, author([], User, Port)) :-
    aux_authority(List, autho(User, [], Port)), !.
authority(List, author(User, Host, Port)) :-
    aux_authority(List, autho(User, Host, Port)), !.


%%% aux_authority/2
%%%
%%% Prende in input una lista e controlla se contiene @.
%%% Gestisce e contrlla la correttaza del authority.
aux_authority(List, Result) :-
    ( member(@, List) ->  
        aux_authority(List, Result, true)  
    ; 
        aux_authority(List, Result, false)  
    ).

aux_authority([], autho([], [], ['8', '0']), _) :- !.

aux_authority([H | T], autho([H | Rest], Host, Port), true) :-
    H \= (@),  
    is_valid_char_user(H),   
    aux_authority(T, autho(Rest, Host, Port), true).

aux_authority([(@) | T], autho([], Host, Port), _) :- !,
    T \= [], !,  
    host_parse(T, host(Host, Port)).

aux_authority([H | T], autho([H | Rest], Host, Port), false) :-
    H \= (/), H \= (?), H \= (#), H \= (:), H \= (@), !,
    aux_authority(T, autho(Rest, Host, Port), false).

aux_authority([(:)], autho([], [], []), _) :- !, fail.
aux_authority([(:) | T], autho([], [], Port), _) :- !,
    port_parse(T, Port).



%%% user_parse/3
%%%
%%% Prende una lista di atomi e riconosce lo userinfo.
%%% Ritorna come lista di atomi.
%%% Ritorna anche la lista con gli atomi inutilizzati.
user_parse([], [], []) :- !.
user_parse([(@)], _, _) :- !, fail.
user_parse([(@) | T], [], T) :- !.
user_parse([H | T], [H | UserChars], RestAuto) :-   
    is_valid_char_user(H), !,  
    user_parse(T, UserChars, RestAuto).

%%% is_valid_char_user/1
%%%
%%% Controlla validità caratteri dello user.
is_valid_char_user(Char) :- 
    char_type(Char, alnum).
is_valid_char_user('+').
is_valid_char_user('=').
is_valid_char_user('-').
is_valid_char_user('_').
is_valid_char_user(':').  
    

%%% host_parse/3
%%%
%%% Prende una lista di atomi. Riconosce l'host e lo ritorna
%%% come lista di atomi.
%%% Ritorna anche lista con atomi non usati.
host_parse([], host([], ['8', '0'])) :- !.
host_parse([(:)], host([], _)) :- !, fail.
host_parse([(:) | T], host([], Port)) :- !,
    port_parse(T, Port).
host_parse([H | T], host([H | Rest], Port)) :-
    H \= (/), H \= (?), H \= (#), H \= (:), H \= (@), !,
    host_parse(T, host(Rest, Port)).

%%% port_parse/2
%%%
%%% Prende lista di atomi. 
%%% Riconosce la porta e la ritorna come lista di atomi.
%%% Inoltre controlla che ogni atomo contenga numeri.
port_parse([], []) :- !.
port_parse([(/) | _], []) :- !.
port_parse([H | T], [H | Rest]) :-
    char_type(H, digit),
    port_parse(T, Rest).

%%% path_parse/3
%%%
%%% Prende lista di atomi. Riconosce il path e lo ritorna
%%% come lista di atomi che appartengono alla struttura optional.
%%% La struttura contiene il path e in aggiunta la query se presente.
path_parse([], optional([], [], [])) :- !.
path_parse([(#)], _) :- !, fail.
path_parse([(?)], _) :- !, fail.
path_parse([(#) | T], optional([], [], Frag)) :- !,
    fragment_parse(T, Frag).
path_parse([(?) | T], optional([], Query, Frag)) :- !,
    query_parse(T, query_part(Query, Frag)).
path_parse([H | T], optional([H | Rest], Query, Fragment)) :-
    H \= (@), H \= (?), H \= (#), H \= (:), !,
    path_parse(T, optional(Rest, Query, Fragment)).

%%% query_parse/3
%%%
%%% Prende una lista di atomi. Riconosce la query e la ritorna
%%% come lista di atomi che appartengono a una struttura chiamata query_part.
%%% La struttura contiene oltre alla query il fragment se presente.
query_parse([], query_part([], [])) :- !.
query_parse([(#)], _) :- !, fail.
query_parse([(#) | T], query_part([], Frag)) :- !,
    fragment_parse(T, Frag).
query_parse([H | T], query_part([H | Rest], Frag)) :-
    H \= (#), 
    is_valid_char(H), !,  
    query_parse(T, query_part(Rest, Frag)).

%%% fragment_parse/2
%%%
%%% Prende in input una lista di atomi. Riconosce il fragment.
%%% Ritorna il fragment come lista di atomi.
fragment_parse([], []) :- !.
fragment_parse([H | T], [H | Rest]) :-
    is_valid_char(H),   %aggiunto
    fragment_parse(T, Rest).

%%% chars_to_atom/2
%%%
%%% Prende una lista di caratteri e ritorna lista di atomi.
chars_to_atom([], []) :- !.
chars_to_atom([H | T], [A | Rest]) :-
    chars_to_atom(T, Rest),
    atom_codes(A, [H]).

%%% list_to_atom/2
%%%
%%% Prende una lista e ritorna un atomo.
list_to_atom([], []) :- !.
list_to_atom(List, Atom) :-
    atomic_list_concat(List, Atom). 

%%% check_host/1
%%%
%%% Controlla la validità dell'host o del ip.
check_host(List) :-
    check_num_dots(List),
    length(List, X),
    X =< 15,
    is_ip(List), !.
check_host(List) :-
    accept_id_host(List).

%%% check_host_mail/1
%%%
%%% Controlla la validità dell'host per lo scheme mailto.
check_host_mail([]) :- !.
check_host_mail([H]) :- !,
    check_host([H]).
check_host_mail([H | T]) :-
    check_host([H | T]).


%%% Controllo struttura host <lettera> <alfanum>*
accept_id_host([H | T]) :-
    char_type(H, alpha),      
    accept_segments_host(T).

%%% Controllo sui segmenti dopo la prima lettera
accept_segments_host([]).         
accept_segments_host([H | T]) :-
    char_type(H, alnum),     
    accept_segments_host(T).
accept_segments_host(['.' | T]) :- 
    T = [H2 | T2],
    char_type(H2, alpha),     
    accept_segments_host(T2).

%%% check_path/2
%%%
%%% Controlla la validità del path.
check_path([], []) :- !.
check_path(['/'], _) :- !, fail.
check_path(['/' | T], []) :- !,
    check_path(T, _).
check_path([H | T], [H | Rest]) :- !,
    is_valid_char(H),  
    check_path(T, Rest).

%%% is_ip/1
%%%
%%% Prende in input la lista e controlla che sia un ip e
%%% che ogni blocco NNN sia tra 0 e 255.
is_ip(List) :-
    ip(List, Uno, Due, Tre, Quattro),
    between(0, 255, Uno),
    between(0, 255, Due),
    between(0, 255, Tre),
    between(0, 255, Quattro), !.
is_ip(_) :- fail.

%%% chek_num_dots/1
%%%
%%% Controlla se la lista contiene solo numeri e punti.
check_num_dots([]) :- !.
check_num_dots([H | T]) :-
    char_type(H, digit), !,
    check_num_dots(T).
check_num_dots(['.']) :- !, fail.
check_num_dots(['.' | T]) :- !,
    check_num_dots(T).

%%% ip/5
%%%
%%% Legge le parti di un ip e le converte in numeri.
ip(List, P1, P2, P3, P4) :-
    read_part(List, LP1, RestP1), list_number(LP1, P1),
    read_part(RestP1, LP2, RestP2), list_number(LP2, P2),
    read_part(RestP2, LP3, RestP3), list_number(LP3, P3),
    read_part(RestP3, LP4, _RestP4), list_number(LP4, P4).

%%% read_part/3
%%%
%%% Predicato per leggere le parti di un ip.
read_part([], [], []) :- !.
read_part(['.' | T], [], T) :- !.
read_part([H | T], [H | Xs], Rest) :-
    read_part(T, Xs, Rest).

%%% list_number/2
%%%
%%% Predicato per convertire una lista in numeri.
list_number(List, Num) :-
    atomic_list_concat(List, Atom),
    atom_number(Atom, Num).

%%% path_zos/3
%%%
%%% Predicato che legge il path se lo schema è zos, con i dovuti controlli.
path_zos([], 0) :- !, fail.
path_zos([], Acc) :- !, Acc =< 44.
path_zos(['.' | _], 0) :- !, fail.
path_zos(['(' | T], Acc) :-
    Acc =< 44, !, id8(T, 0).
path_zos([H], Acc) :-
    Acc < 44, is_valid_char_path_zos(H), !.
path_zos([(/) | T], 0) :- !,
    AccUp is 1,
    path_zos(T, AccUp).
path_zos(['.' | T], Acc) :- 
    Acc > 0, !,
    AccUp is Acc + 1,
    path_zos(T, AccUp).
path_zos([H | T], 0) :- !,
    char_type(H, alpha),
    AccUp is 1,
    path_zos(T, AccUp).
path_zos([H | T], Acc) :- !,
    char_type(H, alnum),
    AccUp is Acc + 1,
    path_zos(T, AccUp).

%%% is_valid_char_path_zos/1
%%%
%%% Controlla validità caratteri del path in caso di scheme zos.
is_valid_char_path_zos(Char) :- 
    char_type(Char, alnum).
is_valid_char_path_zos('.').
 
%%% id8/4
%%%
%%% Predicato che legge la parte opzionale di id8 nel path (schema zos).
id8([')'], 0) :- !, fail.
id8([')'], Acc) :- !, Acc =< 8.
id8([')' | _], _) :- !, fail.
id8([H | T], 0) :- !,
    AccUp is 0 + 1, char_type(H, alpha),
    id8(T, AccUp).
id8([H | T], Acc) :-
    AccUp is Acc + 1, char_type(H, alnum),
    id8(T, AccUp).