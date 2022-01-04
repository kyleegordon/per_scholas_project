import java.util.Objects;

public class EmployeeEntity {
    private String email;
    private String name;
    private String password;
    private String address;
    private String state;
    private int zipCode;

    public EmployeeEntity(String email, String name, String password, String address, String state, int zipCode) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.address = address;
        this.state = state;
        this.zipCode = zipCode;
    }

    public EmployeeEntity() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    //methods

//    @Override
//    public boolean equals(Object obj){
//        if (obj instanceof EmployeeEntity){
//            EmployeeEntity other = (EmployeeEntity) obj;
//            boolean sameId = this.email.equals(other.email);
//            boolean sameName = this.name.equals(other.name);
//            boolean sameAddress = this.address.equals(other.address);
//
//            if (sameId && sameName && sameAddress) return true;
//            else return false;
//        }
//        else{
//            return false;
//        }
//    }

    @Override
    public int hashCode() {
        return Objects.hash(email, name, password, address, state, zipCode);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeeEntity)) return false;
        EmployeeEntity that = (EmployeeEntity) o;
        return getZipCode() == that.getZipCode() && Objects.equals(getEmail(), that.getEmail()) && Objects.equals(getName(), that.getName()) && Objects.equals(getPassword(), that.getPassword()) && Objects.equals(getAddress(), that.getAddress()) && Objects.equals(getState(), that.getState());
    }
}
