package blagtunez;

public class matriz {

    nodoCol     inicioCol;
    nodoFila    inicioFila;

    nodoCol     finHeader;
    nodoCol     finFila;

    nodoFila    fiPuntoInsercion;
    nodoCol     coPuntoInsercion;



    matriz(){
        inicioCol       = new nodoCol();
        inicioFila      = new nodoFila();

    }

    public nodo agregarNodo(nodoEl ing){
        nodoFila filTem = inicioFila;
        nodoCol coltem = inicioCol;
        if (this.esVacia()){
            //ya que esta vacia, debo crear filas y columnas
            nodoFila tempFi = new nodoFila();
            tempFi.setLetra(ing.getLetrina());

            nodoCol tempCol = new nodoCol ();
            tempCol.setGenero(ing.getGenero());

            //aca pongo los punteros de mis columnas y filas creadas
            inicioCol.setDerecha(tempCol);
            tempCol.setIzquierda(inicioCol);
            inicioFila.setAbajo(tempFi);
            tempFi.setDerecha(tempFi);

            //aca enlazo el nodo nuevo en mis columnas creadas
            tempFi.setDerecha(ing);
            tempCol.setAbajo(ing);
            //conecto el nodo
            ing.setLet(tempFi);
            ing.setGen(tempCol);
        }
        else { //aqui viene lo bueno, no esta vacia

            //vamos a comenzar a buscar por filas
            nodoFila tempFi;

            char letra = ing.getLetrina();
            tempFi =  buscarFila(letra);

            if (tempFi==null){ //significa que la fila no existe, hay que crearla
                boolean piNulo = true; //pinulo dice si el siguiente de Punto de insercion es nulo
                if (fiPuntoInsercion.getAbajo() == null)
                    piNulo = false;

                nodoFila fiPuntoInsercionSig=null;
                
                if (piNulo)
                    fiPuntoInsercionSig = (nodoFila)fiPuntoInsercion.getAbajo();
                
                tempFi = new nodoFila(letra);
                if (piNulo)
                    tempFi.setAbajo(fiPuntoInsercionSig); //le ponemos apuntadores a el nodo
                tempFi.setArriba(fiPuntoInsercion);

                fiPuntoInsercion.setAbajo(tempFi);  //le ponemos apuntadores a de donde lo sacamos
                if (piNulo)
                    fiPuntoInsercionSig.setArriba(tempFi);
            }
            // ya buscamos por fila, la fila correcta deberia ser tempFi
            
            nodoCol tempCol;

            String genero = ing.getGenero();
            tempCol =  buscarColumna(genero);

            if (tempCol==null){ //significa que la fila no existe, hay que crearla
                boolean piNulo = true; //pinulo dice si el siguiente de Punto de insercion es nulo
                if (coPuntoInsercion.getDerecha() == null)
                    piNulo = false;

                nodoFila coPuntoInsercionSig=null;

                if (piNulo)
                    coPuntoInsercionSig = (nodoFila)coPuntoInsercion.getDerecha();

                tempCol = new nodoCol(genero);
                if (piNulo)
                    tempCol.setDerecha(coPuntoInsercionSig); //le ponemos apuntadores a el nodo
                tempCol.setIzquierda(coPuntoInsercion);

                coPuntoInsercion.setDerecha(tempCol);  //le ponemos apuntadores a de donde lo sacamos
                if (piNulo)
                    coPuntoInsercionSig.setIzquierda(tempCol);
            }

            //entonces ya tenemos en tempCol y en tempFi nuestros nodos coordenados
            char le='a';
            nodo ninf = tempCol;
            //recorrer pa abajo
            if (ninf.isAbajo())
            do { //mientras haya abajo y la letra del de abajo
                                                     //sea inferior a
                ninf = tempCol.getAbajo();
                le = ninf.getLetrina();
            }
            while (((ninf.isAbajo())&&(letra<=le)));
            else { // no hay abajo, entonces es l primer nodo

            }

            //supositoriamente n deberia tener el nodo con letra igual o menor a 'le'

            if (ninf.getLetrina()==letra) //si supositoriamente existe, ahi esta :D
                return ninf;

            //tonces solo tenemos el espacio para añadir
            //toca recorrer a lo horizontal

            String ge = genero;
            nodo nec = tempFi;

            while (nec.isDerecha()){
                nec = nec.getDerecha();
            }
            //supuestamente nec tiene lo mas extremo de la fila
            // y ninf es el que tiene letra inferior a

            nec.setDerecha(ing);
            ing.setIzquierda(nec);
            
            ninf.setAbajo(ing);
            ing.setArriba(ninf);

            return ing;
        }

        //algo muy malo debio haber pasado :(

        return null;
    }

    public boolean esVacia(){
        if ((inicioCol.getAbajo() == null) || (inicioFila.getDerecha() == null))
            return true;
        else
            return false;
    }

    nodoFila buscarFila(char C){
        nodoFila temp=inicioFila;
        while ((temp.isDerecha())){
            if (temp.getLetra()==C)
                return temp;
            temp = (nodoFila)temp.getDerecha();
        }
        fiPuntoInsercion = temp;
        // fipuntoInsercion = alguna onda
        return null; //no lo encontramos, por eso tiramos null
    }

    nodoCol buscarColumna(String s){ //la misma onda que con las filas

        nodoCol temp=inicioCol;
        while ((temp.isDerecha())){
            if (temp.getGenero().equals(s))
                return temp;
            temp = (nodoCol)temp.getAbajo();
        }
        coPuntoInsercion = temp;
        return null;
    }

}
