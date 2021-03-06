public class Staff {
    private String name;
    private String address;
    private String title;
    private String phone;

    public Staff(String name, String address, String title, String phone) {
        this.name = name;
        this.address = address;
        this.title = title;
        this.phone = phone;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return String.format("Name: %s\nAddress: %s\nTitle %s\nPhone: ", this.getName(), this.getAddress() ,this.getTitle(), this.getPhone());
    }
}
