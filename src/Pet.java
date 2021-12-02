public class Pet {
    private String name;
    private String type;
    private String owner;

    public Pet(String name, String type, String owner) {
        this.name = name;
        this.type = type;
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
    public String toString() {
        return String.format("Name: %s\nType: %s\nOwner: ", this.getName(), this.getType(), this.getOwner());
    }
}
