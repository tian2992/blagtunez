package blagtunez;

/**
 * Enter The Matrix
 * @author tian
 */
public class matriz {

    private nodoCol     inicioCol;
    private nodoFila    inicioFila;


    private nodoFila    fiPuntoInsercion;
    private nodoCol     coPuntoInsercion;



    matriz(){
        inicioCol       = new nodoCol();
        inicioFila      = new nodoFila();
    }


     /**
     * Deberia poder añadir nodos, pero no sirve de nada.
      * @param ing
      * @return el nodo si todo salio bien, null si algo malo paso
     */
    public nodo agregarNodo(nodoEl ing) throws Exception{
        if (this.esVacia()){
            //ya que esta vacia, debo crear filas y columnas
            nodoFila tempFi = new nodoFila();
            tempFi.setLetra(ing.getLetra());

            nodoCol tempCol = new nodoCol ();
            tempCol.setGenero(ing.getGenero());

            //aca pongo los punteros de mis columnas y filas creadas
            inicioCol=tempCol;
            //tempCol.setIzquierda(inicioCol);
            inicioFila=tempFi;
            //tempFi.setDerecha(tempFi);

            //aca enlazo el nodo nuevo en mis columnas creadas
            tempFi.setDerecha(ing);
            tempCol.setAbajo(ing);
            //conecto el nodo
            ing.setIzquierda(tempFi);
            ing.setArriba(tempCol);
            ing.setLet(tempFi);
            ing.setGen(tempCol);
            
            return ing;
        }
        else { //aqui viene lo bueno, no esta vacia

            //comenzamos a buscar si existe una columna con el genero del nodo

            String  generoDeNodo = ing.getGenero();
            char    letraDeNodo  = ing.getLetra();
            
            nodoCol columnaPropuesta = buscarOCrearColumna(generoDeNodo);

            if (columnaPropuesta == null)
                throw new Exception("BLAG!, matriz corrupta, algo malo paso");

            //ya por aca, sabemos que columnaPropuesta tiene nuestro nodo

            nodoFila filaPropuesta = buscarFila(letraDeNodo);

            if (filaPropuesta == null)
                throw new Exception("BLAG!, matriz corrupta, algo malo paso");



            //para ir a buscar los nodos siguientes, hay que buscar buscarcolumna.buscarLetra=!null

            return null;
        }

        //algo muy malo debio haber pasado :(
    }

    public nodoCol buscarOCrearColumna(String generoDeNodo){

        nodoCol columnaPropuesta = buscarColumna(generoDeNodo);

        if (columnaPropuesta == null){ //no se encontro match exacto se usa coPuntoDeInsercion
            nodoCol colAUsar = new nodoCol(generoDeNodo);

            if(coPuntoInsercion==null){ // o sea el primer nodoCol es siguiente a el nodo Nuevo
                nodoCol exInicio = inicioCol;
                exInicio.setIzquierda(colAUsar);
                colAUsar.setDerecha(exInicio);
                inicioCol = colAUsar;
                // columnaPropuesta = colAUsar;
                return colAUsar;
            }
            else{ //o sea punto insercion tiene el nodo anterior
                if (coPuntoInsercion.isDerecha()) //asegurando que haya nodo a la derecha
                    colAUsar.setDerecha(coPuntoInsercion.getDerecha());
                colAUsar.setIzquierda(coPuntoInsercion);

                if (coPuntoInsercion.isDerecha())
                    coPuntoInsercion.getDerecha().setIzquierda(colAUsar);
                coPuntoInsercion.setDerecha(colAUsar);

                //columnaPropuesta = colAUsar;
                return colAUsar;
            }
        }
        else if (columnaPropuesta.getGenero().equalsIgnoreCase(generoDeNodo)){ //columnaPropuesta si contiene la columna con genero igual.
            return columnaPropuesta;
        }
        return null;
    }

    public nodoFila buscarOCrearFila(char C){
        nodoFila filaPropuesta = buscarFila(C);

        if (filaPropuesta == null){
            nodoFila filAUsar = new nodoFila(C);

            if (fiPuntoInsercion==null){
                nodoFila exInicio = inicioFila;
                exInicio.setArriba(filAUsar);
                filAUsar.setAbajo(exInicio);
                inicioFila = filAUsar;

                return filAUsar;
            }
            else {
                if (fiPuntoInsercion.isAbajo())
                    filAUsar.setAbajo(fiPuntoInsercion.getAbajo());
                filAUsar.setArriba(fiPuntoInsercion);

                if (fiPuntoInsercion.isAbajo())
                    fiPuntoInsercion.getAbajo().setArriba(filAUsar);
                fiPuntoInsercion.setAbajo(filAUsar);

                return filAUsar;
            }
        }
        else if (filaPropuesta.getLetra()==C){
            return filaPropuesta;
        }

        return null;
    }

    public nodoCol buscarColumna(String gen){
        nodoCol temp =  inicioCol;
        coPuntoInsercion = null;
        while ((temp.isDerecha())){
            if(temp.getGenero().compareToIgnoreCase(gen)==0){ //si es el mismo, match perfecto
                return temp;
            }
            else if (temp.getGenero().compareToIgnoreCase(gen)<0){ //mientras el genero de temp sea alfabeticamente inferior a gen
                coPuntoInsercion = temp;
            }
            temp = temp.getDerecha();
        }

        return null;
    }

    public nodoFila buscarFila(char C){
        nodoFila temp = inicioFila;
        fiPuntoInsercion = null;
        while (temp.isAbajo()){
            if(temp.getLetra()==C){
                return temp;
            }
            else if (temp.getLetra()<C){
                fiPuntoInsercion = temp;
            }
            temp = temp.getAbajo();
        }
        return null;
    }

    /**
     * Ver si esVacia o no
     * @return true si es vacia, false si no lo es
     */
    public boolean esVacia(){
        if ((inicioCol.getAbajo() == null) || (inicioFila.getDerecha() == null))
            return true;
        else
            return false;
    }

}
