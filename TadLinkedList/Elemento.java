package TadLinkedList;

public class Elemento {
    
    private String name;
    private Integer number;
    private Elemento next;
   
    public Elemento(String name, Integer number, Elemento next) {
        this.name = name;
        this.number = number;
        this.next = null;
    }

    public String getName() {
        return name;
    }

    public Integer getNumber() {
        return number;
    }

    public Elemento getNext() {
        return next;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setNext(Elemento next) {
        this.next = next;
    }
    

    
}
