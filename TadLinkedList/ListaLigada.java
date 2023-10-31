package TadLinkedList;

public class ListaLigada {

    private Elemento inicio;

    public boolean push(Elemento e) {
        try {
            e.setNext(inicio);
            inicio = e;
            return true;

        } catch (Exception ex) {

            return false;
        }
    }

    public Elemento pop() {
        if( inicio == null) {
            return null;
        }

        Elemento e = inicio;
        inicio = e.getNext();
        e.setNext(null);
        return e;
    }
}
