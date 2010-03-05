package blagtunez;

/**
 * Enter The Matrix
 * @author tian
 */
public class matriz implements java.io.Serializable {

    private nodoCol     inicioCol;
    private nodoFila    inicioFila;

    private nodoCol     finCol;
    private nodoFila    finFila;

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
            finCol = tempCol;
            //tempCol.setIzquierda(inicioCol);
            inicioFila=tempFi;
            finFila = tempFi;
            //tempFi.setDerecha(tempFi);

            //aca enlazo el nodo nuevo en mis columnas creadas
            tempFi.setDerecha(ing);
            tempCol.setAbajo(ing);
            //conecto el nodo
            ing.setIzquierda(tempFi);
            ing.setArriba(tempCol);
            ing.setLet(tempFi);
            ing.setGen(tempCol);

            arreglarFinales(); //en caso que algo salga mal

            return ing;
        }
        else { //aqui viene lo bueno, no esta vacia

            //comenzamos a buscar si existe una columna con el genero del nodo

            String  generoDeNodo = ing.getGenero();
            char    letraDeNodo  = ing.getLetra();

            nodoCol columnaPropuesta = buscarOCrearColumna(generoDeNodo);

            if (columnaPropuesta == null){
                throw new Exception("BLAG!, columna mala corrupta, algo malo paso insertando "+ing);
            }

            //ya por aca, sabemos que columnaPropuesta tiene nuestro nodo

            nodoFila filaPropuesta = buscarOCrearFila(letraDeNodo);

            if (filaPropuesta == null){
                throw new Exception("BLAG!, fila mala corrupta, algo malo paso insertando "+ing);
            }
            //ahora toca buscar por filas y columnas todos los nodos a los que hay que conectar

            //toca buscar por columnas por la izquierda
            //nodoCol cotm = columnaPropuesta;
            //boolean colfound = false;
            nodo linkArriba = recorrerColumnaAbajo(columnaPropuesta,letraDeNodo);

            nodo linkIzquierda = recorrerFilaDerecha(filaPropuesta,generoDeNodo);

            //vamos a enlazar los nodos, yay!

            //primero le ponemos los generos a nuestro nodo a ingresar

            ing.setArriba(linkArriba);
            ing.setAbajo(linkArriba.getAbajo());

            ing.setIzquierda(linkIzquierda);
            ing.setDerecha(linkIzquierda.getDerecha());

            ing.setGen(columnaPropuesta);
            ing.setLet(filaPropuesta);

            //ahora lo insertamos a la matrix

            if (linkIzquierda.isDerecha())
                linkIzquierda.getDerecha().setIzquierda(ing);
            linkIzquierda.setDerecha(ing);

            if (linkArriba.isAbajo())
                linkArriba.getAbajo().setArriba(ing);
            linkArriba.setAbajo(ing);

            //exito :D
            
            arreglarFinales(); //en caso que algo salga mal

            return ing;
        }

        //algo muy malo debio haber pasado :(
    }

    public nodo recorrerColumnaAbajo(nodo n, char C){
        nodo nodoTemp = n;
        while (nodoTemp.isAbajo()){
            if (nodoTemp.getLetra()==C){
                return nodoTemp;
            }
            //else if (nodoTemp.getLetra()>C){
            //    return nodoTemp.getArriba();
            //}
            nodoTemp = nodoTemp.getAbajo();
        }
        return nodoTemp;

    }

    public void arreglarFinales(){
        try {
        if(finCol.isDerecha()){ //en algun momento se nos safo el fin correcto
            while (finCol.isDerecha())
                finCol = finCol.getDerecha();
        }
        if(finFila.isDerecha()){
            while (finFila.isAbajo()){
                finFila = finFila.getAbajo();
            }
        }
        }
        catch (Exception e) { /*nunca deberia fallar, pero nunca se sabe */ }
    }

    public nodo recorrerFilaDerecha(nodo n, String ge){
        nodo nodoTemp=n;
        while (nodoTemp.isDerecha()){
            if (nodoTemp.getGenero().equalsIgnoreCase(ge)){
                return nodoTemp;
            }
            //else if (nodoTemp.getDerecha().getGenero().compareToIgnoreCase(ge)>0){
            //    return nodoTemp.getDerecha();
            //}
            nodoTemp = nodoTemp.getDerecha();
        }
        return nodoTemp;
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
                else
                    finCol=colAUsar; //no columna mas tiene, por lo tanto fin es
                colAUsar.setIzquierda(coPuntoInsercion);

                if (coPuntoInsercion.isDerecha())
                    coPuntoInsercion.getDerecha().setIzquierda(colAUsar);
                coPuntoInsercion.setDerecha(colAUsar);

                //columnaPropuesta = colAUsar;
                return colAUsar;
            }
        }else  if (columnaPropuesta.getGenero().equalsIgnoreCase(generoDeNodo)){ //columnaPropuesta si contiene la columna con genero igual.
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
                else
                    finFila = filAUsar; //Si es el ultimo, entonces el fin de la Fila deberia ser.
                filAUsar.setArriba(fiPuntoInsercion);

                if (fiPuntoInsercion.isAbajo())
                    fiPuntoInsercion.getAbajo().setArriba(filAUsar);
                fiPuntoInsercion.setAbajo(filAUsar);

                return filAUsar;
            }
        } if (filaPropuesta.getLetra()==C){
            return filaPropuesta;
        }

        return null;
    }

    public nodoCol buscarColumna(String gen){
        nodoCol temp =  inicioCol;
        coPuntoInsercion = null;
        while (temp!=null){
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
        if(temp.getLetra()==C){ //ataque preventivo
            return temp;
        }
        fiPuntoInsercion = null;
        while (temp!=null){
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

    public nodoEl buscarNodo(char C, String s){
        nodoCol colPro = buscarColumna(s);
        nodoFila filPro= buscarFila(C);

        nodo recAb = recorrerColumnaAbajo(colPro,C);
        nodo recDer= recorrerFilaDerecha(filPro,s);
        if (recAb.equals(recDer)){
            return (nodoEl)recAb; //porque le tengo preferencia
        }
        
        return null; //no se encontro
    }

    public nodoEl borrarNodo(nodoEl n){
        return borrarNodo(n.getLetra(),n.getGenero());
    }

    public nodoEl borrarNodo(char C,String s){
        
        nodoEl nba = buscarNodo(C,s);
        
        if (nba==null){
            return null;
        }
        
        nodo iz = nba.getIzquierda();
        nodo ar = nba.getArriba();

        //Tratamiento especial si es nodo inicial

        if (ar.equals(inicioCol)){
            inicioCol = (inicioCol.getDerecha());
        }
        if (iz.equals(inicioFila)){
            inicioFila = inicioFila.getAbajo();
        }

        if (nba.isDerecha())
            nba.getDerecha().setIzquierda(iz);
        iz.setDerecha(nba.getDerecha());

        if (nba.isAbajo())
            nba.getAbajo().setArriba(nba.getArriba());
        ar.setAbajo(nba.getAbajo());

        return (nodoEl)nba;
    }

    public int contarArtistas(){
        int contador=0;

        nodo tempFi = inicioFila;
        nodo tempAr;
        while(tempFi!=null){
            tempAr = tempFi.getDerecha();
            while (tempAr!=null){
                contador++;
                tempAr = tempAr.getDerecha();
            }
            tempFi = tempFi.getAbajo();
        }
        return contador;
    }

    /**
     * Cuenta cuantas letras hay
     */
    public int contarFilas(){
        int contador=0;
        nodo temp = inicioFila;
        while(temp!=null){
            contador++;
            temp = temp.getAbajo();
        }
        return contador;
    }

    /**
     * Cuenta cuantos generos hay
     */
    public int contarColumnas(){
        int contador=0;
        nodo temp = inicioCol;
        while(temp!=null){
            contador++;
            temp = temp.getDerecha();
        }
        return contador;
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

    public java.util.List<String> getGeneros(){ //tambien deberia funcionar
        java.util.List<String> lis;
        if (liston.FuncioListon){
            lis = new liston<String>();
        }
        else {
            lis = new java.util.ArrayList<String>();
        }
        nodoCol temp = inicioCol;
        while(temp!=null){
            lis.add(temp.getGenero());
            temp = temp.getDerecha();
        }
        if (lis.isEmpty())
            return null;
        return lis;
    }

    public java.util.List<artista> getArtistas(){
        java.util.List<artista> lis;
        lis = new liston<artista>();
        nodoFila anclaIz = inicioFila;
        try {
        nodoEl nodoRecorrer;
            while (anclaIz!=null){ //ciclo grande
                nodoRecorrer = (nodoEl)anclaIz.getDerecha();
                while(nodoRecorrer!=null){
                    lis.addAll(nodoRecorrer.getPayload());
                    nodoRecorrer = (nodoEl)nodoRecorrer.getDerecha();
                }
                anclaIz = anclaIz.getAbajo();
            }
        }
        catch (Exception e){
            return null;
        }

        return lis;
    }

    public java.util.List<artista> getArtistasPorGenero(String s){
        java.util.List<artista> lis;
        lis = new liston<artista>();
        nodoCol tiraEcol = buscarColumna(s);
        if (tiraEcol==null)
            return null;
        nodoEl nodoRecorre;
        try {
            nodoRecorre = (nodoEl)tiraEcol.getAbajo();
            while(nodoRecorre!=null){
                lis.addAll(nodoRecorre.getPayload());
                nodoRecorre = (nodoEl)nodoRecorre.getAbajo();
            }
            return lis;
        }
        catch (Exception e){
            return null;
        }
    }

    public java.util.List<artista> getArtistasPorLetra(char l){ //Hay que arreglar esto
        java.util.List<artista> lis;
            lis = new liston<artista>();
        nodoFila filoso = buscarFila(l);
        nodoEl temp=(nodoEl)filoso.getDerecha();
        try {
            while(temp!=null){
                lis.addAll(temp.getPayload());
                temp.getDerecha();
            }

            if (lis.isEmpty())
                return null;
        } catch(Exception e){
            return null;
        }
        return lis;
    }

}