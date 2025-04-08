package GIT;

public class lista {
    reserva primero = null;
    reserva ultimo = null;
    
    public lista() {
    }
    int r = 0;
    
    public void insertarAlInicio(reserva nuevo) {
        if(primero == null) {
            primero = ultimo = nuevo;
            nuevo.siguiente = null;
            nuevo.anterior = null;
        } else {
           
            nuevo.siguiente = primero; 
            primero.anterior = nuevo;
            primero = nuevo;
            nuevo.anterior = null; 
        }
    }
    
    public void insertarEnmedio(reserva nuevo) {
        if(primero == null) {
            ultimo = primero = nuevo;
            nuevo.siguiente = null;
            nuevo.anterior = null;
        } else {
        	//Reiniciar aux al principio de la lista
            reserva aux = primero;
     
            while(aux != null && aux.siguiente != null && 
                  aux.getCliente().compareTo(nuevo.getCliente()) < 0) {
                aux = aux.siguiente;
            }
            

            if(aux == primero && nuevo.getCliente().compareTo(aux.getCliente()) < 0) {
                insertarAlInicio(nuevo);
            } 
            else if(aux == ultimo && nuevo.getCliente().compareTo(aux.getCliente()) > 0) {
                inserAlFinal(nuevo);
            } 
            // Insertar en medio
            else {
                nuevo.anterior = aux.anterior;
                nuevo.siguiente = aux;
                if(aux.anterior != null) {
                    aux.anterior.siguiente = nuevo;
                }
                aux.anterior = nuevo;
            }
        }
    }
    
    public void inserAlFinal(reserva nuevo) {
        if(primero == null) {
            ultimo = primero = nuevo;
            nuevo.siguiente = null;
            nuevo.anterior = null;
        } else {
            nuevo.anterior = ultimo;
            nuevo.siguiente = null; 
            ultimo.siguiente = nuevo;
            ultimo = nuevo;
        }
    }
    
    public void insertaordenadamente(reserva nuevo) {
        if(primero == null) {
            primero = ultimo = nuevo;
            nuevo.siguiente = null;
            nuevo.anterior = null;
        } else {
            int r = nuevo.getCliente().compareTo(ultimo.getCliente());
            if(r > 0)
                inserAlFinal(nuevo);
            else {
                r = nuevo.getCliente().compareTo(primero.getCliente());
                if(r < 0)
                    insertarAlInicio(nuevo);
                else
                    insertarEnmedio(nuevo);
            }
        }
    }

    public reserva imprimelista() {
        reserva aux = primero; 
        while(aux != null) {
            JOptionPane.showMessageDialog(null, aux.getCliente());
            aux = aux.siguiente;
        }
        return null;
    }
    
    
    
}