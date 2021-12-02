public class Staff {
    private String name;
    private String address;
    private int phone;
    private String dob;
    private String title;

    public Staff(String name, String address, int phone, String dob, String title) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.dob = dob;
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

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return String.format("Name: %s\nAddress: %s\nPhone: %s\nDOB: %s\nTitle", this.getName(), this.getAddress(), this.getPhone(), this.getDob(),this.getTitle());
    }
}
