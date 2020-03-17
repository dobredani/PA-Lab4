public class Hospital implements Comparable{
    private String name;

    public Hospital(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Object o) {
        return this.getName().compareTo(((Hospital) o).getName());
    }

    @Override
    public String toString(){
        return name;
    }
}
