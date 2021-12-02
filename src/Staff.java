public class Staff {
    private String name;
    private String address;
    private String phone;
    private String title;

    public Staff(String name, String address, String phone, String title) {
        this.name = name;
        this.address = address;
        this.phone = phone;

        this.title = title;
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
        return String.format("Name: %s\nAddress: %s\nPhone: %s\nDOB: %s\nTitle", this.getName(), this.getAddress(), this.getPhone(),this.getTitle());
    }
}
