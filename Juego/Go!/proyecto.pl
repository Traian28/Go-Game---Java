:-dynamic blanca/2.
:-dynamic negra/2.
:-dynamic pausa/1.
:-dynamic puntaje/2.
:-dynamic invalida/2.

puntaje(j1,0).
puntaje(j2,0).

fueraDeRango(0,_Y).
fueraDeRango(20,_Y).
fueraDeRango(_X,0).
fueraDeRango(_X,20).

finJuego:-pausa(j1),pausa(j2).

pausaJugador1:-assert(pausa(j1)).
pausaJugador2:-assert(pausa(j2)).

incrementarPuntajeJ1(P):-puntaje(j1,X),X2 is X+P,retract(puntaje(j1,X)),assert(puntaje(j1,X2)).
incrementarPuntajeJ2(P):-puntaje(j2,X),X2 is X+P,retract(puntaje(j2,X)),assert(puntaje(j2,X2)).

longitud([],0).
longitud([_H|T],L):-longitud(T,X),L is X+1.

reiniciar:-findall(blanca(X,Y),blanca(X,Y),Blancas),eliminarFichasBlancas(Blancas),findall(negra(X,Y),negra(X,Y),Negras),eliminarFichasNegras(Negras).

eliminarFichasBlancas([]).
eliminarFichasBlancas([blanca(X,Y)|T]):-retract(blanca(X,Y)),eliminarFichasBlancas(T).

eliminarFichasNegras([]).
eliminarFichasNegras([negra(X,Y)|T]):-retract(negra(X,Y)),eliminarFichasNegras(T).

libre(X,Y):-not(blanca(X,Y)),not(negra(X,Y)).

colocarBlanca(X,Y,Borradas):-libre(X,Y),not(invalida(X,Y)),assert(blanca(X,Y)),noHaySuicidioBlanca(X,Y,Xelim,Yelim),atraparNegras(Borradas),longitud(Borradas,L),eliminarInvalida(Xelim,Yelim,L).
colocarBlanca(X,Y,_Borradas):-retract(blanca(X,Y)),fail.

eliminarInvalida(X,Y,_L):-X=0,Y=0,invalida(A,B),retract(invalida(A,B)).
eliminarInvalida(X,Y,_L):-X=0,Y=0.
eliminarInvalida(X,Y,1):-invalida(A,B),retract(invalida(A,B)),assert(invalida(X,Y)).
eliminarInvalida(_X,_Y,L):-invalida(A,B),L\=1,retract(invalida(A,B)).
eliminarInvalida(X,Y,1):-assert(invalida(X,Y)).
eliminarInvalida(_X,_Y,L):-L\=1.

colocarNegra(X,Y,Borradas):-libre(X,Y),not(invalida(X,Y)),assert(negra(X,Y)),noHaySuicidioNegra(X,Y,Xelim,Yelim),atraparBlancas(Borradas),longitud(Borradas,L),eliminarInvalida(Xelim,Yelim,L).
colocarNegra(X,Y,_Borradas):-retract(negra(X,Y)),fail.

atraparNegras(Eliminar):-findall((X,Y),atrapaNegra(X,Y,[]),Eliminar),eliminarNegras(Eliminar,Puntos),incrementarPuntajeJ2(Puntos).
eliminarNegras([],0).
eliminarNegras([(X,Y)|T],P):-retract(negra(X,Y)),eliminarNegras(T,P2),P is P2+1.

%atraparBlancas
%busca las fichas blancas que deban ser eliminadas y las elimina
atraparBlancas(Eliminar):-findall((X,Y),atrapaBlanca(X,Y,[]),Eliminar),eliminarBlancas(Eliminar,Puntos),incrementarPuntajeJ1(Puntos).

%eliminarBlancas
%elimina las fichas blancas que se encuentran en la lista
eliminarBlancas([],0).
eliminarBlancas([(X,Y)|T],P):-retract(blanca(X,Y)),eliminarBlancas(T,P2),P is P2+1.

noHaySuicidioBlanca(X,Y,0,0):-noHaySuicidioBlancaAux(X,Y,[]).
noHaySuicidioBlanca(X,Y,X1,Y):-X1 is X-1,atrapaNegra(X1,Y,[]).
noHaySuicidioBlanca(X,Y,X1,Y):-X1 is X+1,atrapaNegra(X1,Y,[]).
noHaySuicidioBlanca(X,Y,X,Y1):-Y1 is Y-1,atrapaNegra(X,Y1,[]).
noHaySuicidioBlanca(X,Y,X,Y1):-Y1 is Y+1,atrapaNegra(X,Y1,[]).

noHaySuicidioBlancaAux(X,Y,Visitados):-X1 is X-1,(libre(X1,Y);(blanca(X1,Y),noVisitadaBlanca(X1,Y,Visitados),noHaySuicidioBlancaAux(X1,Y,[blanca(X,Y)|Visitados]))).
noHaySuicidioBlancaAux(X,Y,Visitados):-X1 is X+1,(libre(X1,Y);(blanca(X1,Y),noVisitadaBlanca(X1,Y,Visitados),noHaySuicidioBlancaAux(X1,Y,[blanca(X,Y)|Visitados]))).
noHaySuicidioBlancaAux(X,Y,Visitados):-Y1 is Y-1,(libre(X,Y1);(blanca(X,Y1),noVisitadaBlanca(X,Y1,Visitados),noHaySuicidioBlancaAux(X,Y1,[blanca(X,Y)|Visitados]))).
noHaySuicidioBlancaAux(X,Y,Visitados):-Y1 is Y+1,(libre(X,Y1);(blanca(X,Y1),noVisitadaBlanca(X,Y1,Visitados),noHaySuicidioBlancaAux(X,Y1,[blanca(X,Y)|Visitados]))).

atrapaNegra(X,Y,Visitados):-negra(X,Y),VisitadosAux=[negra(X,Y)|Visitados],X1 is X-1,flancoOcupadoBlanca(X1,Y,VisitadosAux),X2 is X+1,flancoOcupadoBlanca(X2,Y,VisitadosAux),Y1 is Y-1,flancoOcupadoBlanca(X,Y1,VisitadosAux),Y2 is Y+1,flancoOcupadoBlanca(X,Y2,VisitadosAux).
flancoOcupadoBlanca(X,Y,_Visitados):-blanca(X,Y).
flancoOcupadoBlanca(X,Y,_Visitados):-fueraDeRango(X,Y).
flancoOcupadoBlanca(X,Y,Visitados):-negra(X,Y),noVisitadaNegra(X,Y,Visitados),atrapaNegra(X,Y,Visitados).
flancoOcupadoBlanca(X,Y,Visitados):-negra(X,Y),visitadaNegra(X,Y,Visitados).

visitadaNegra(X,Y,[negra(X,Y)|_T]).
visitadaNegra(X,Y,[H|T]):-H\=negra(X,Y),visitadaNegra(X,Y,T).

noVisitadaNegra(_X,_Y,[]).
noVisitadaNegra(X,Y,[H|T]):-H\=negra(X,Y),noVisitadaNegra(X,Y,T).

%noHaySuicidioNegra(+X,+Y)
%determina si al colocar la ficha negra en
%la posicion X,Y no hay suicidio
noHaySuicidioNegra(X,Y,0,0):-noHaySuicidioNegraAux(X,Y,[]).
noHaySuicidioNegra(X,Y,X1,Y):-X1 is X-1,atrapaBlanca(X1,Y,[]).
noHaySuicidioNegra(X,Y,X1,Y):-X1 is X+1,atrapaBlanca(X1,Y,[]).
noHaySuicidioNegra(X,Y,X,Y1):-Y1 is Y-1,atrapaBlanca(X,Y1,[]).
noHaySuicidioNegra(X,Y,X,Y1):-Y1 is Y+1,atrapaBlanca(X,Y1,[]).

%noHaySuicidioNegraAux(+X,+Y,+Visitados)
%se encarga de realizar la tarea del predicado
%noHaySuicidioNegra, ya que este es usado como cascarón
noHaySuicidioNegraAux(X,Y,Visitados):-X1 is X-1,(libre(X1,Y);(negra(X1,Y),noVisitadaNegra(X1,Y,Visitados),noHaySuicidioNegraAux(X1,Y,[negra(X,Y)|Visitados]))).
noHaySuicidioNegraAux(X,Y,Visitados):-X1 is X+1,(libre(X1,Y);(negra(X1,Y),noVisitadaNegra(X1,Y,Visitados),noHaySuicidioNegraAux(X1,Y,[negra(X,Y)|Visitados]))).
noHaySuicidioNegraAux(X,Y,Visitados):-Y1 is Y-1,(libre(X,Y1);(negra(X,Y1),noVisitadaNegra(X,Y1,Visitados),noHaySuicidioNegraAux(X,Y1,[negra(X,Y)|Visitados]))).
noHaySuicidioNegraAux(X,Y,Visitados):-Y1 is Y+1,(libre(X,Y1);(negra(X,Y1),noVisitadaNegra(X,Y1,Visitados),noHaySuicidioNegraAux(X,Y1,[negra(X,Y)|Visitados]))).

%atrapaBlanca(+X,+Y,+Visitados)
%determina si la ficha en
%la posicion X,Y es blanca y se encuentra atrapada
atrapaBlanca(X,Y,Visitados):-blanca(X,Y),VisitadosAux=[blanca(X,Y)|Visitados],X1 is X-1,flancoOcupadoNegra(X1,Y,VisitadosAux),X2 is X+1,flancoOcupadoNegra(X2,Y,VisitadosAux),Y1 is Y-1,flancoOcupadoNegra(X,Y1,VisitadosAux),Y2 is Y+1,flancoOcupadoNegra(X,Y2,VisitadosAux).
flancoOcupadoNegra(X,Y,_Visitados):-negra(X,Y).
%flancoOcupadoNegra(X,Y,_Visitados):-borde(X,Y).
flancoOcupadoNegra(X,Y,_Visitados):-fueraDeRango(X,Y).
flancoOcupadoNegra(X,Y,Visitados):-blanca(X,Y),noVisitadaBlanca(X,Y,Visitados),atrapaBlanca(X,Y,Visitados).
flancoOcupadoNegra(X,Y,Visitados):-blanca(X,Y),visitadaBlanca(X,Y,Visitados).

%visitadaBlanca(+X,+Y,+Visitados)
%determina si la ficha blanca(X,Y) fue visitada
visitadaBlanca(X,Y,[blanca(X,Y)|_T]).
visitadaBlanca(X,Y,[H|T]):-H\=blanca(X,Y),visitadaBlanca(X,Y,T).

%noVisitadaBlanca(+X,+Y,+Visitados)
%determina si la ficha blanca(X,Y) no fue visitada
noVisitadaBlanca(_X,_Y,[]).
noVisitadaBlanca(X,Y,[H|T]):-H\=blanca(X,Y),noVisitadaBlanca(X,Y,T).



