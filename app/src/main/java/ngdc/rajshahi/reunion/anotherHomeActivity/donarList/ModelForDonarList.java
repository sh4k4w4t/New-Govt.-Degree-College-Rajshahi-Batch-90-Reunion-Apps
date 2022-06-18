package ngdc.rajshahi.reunion.anotherHomeActivity.donarList;

public class ModelForDonarList {
    String name;
    String email;
    String mobile;
    String amount;

    public ModelForDonarList() {
    }
    public ModelForDonarList(String name, String email, String mobile, String amount) {
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile() {
        return mobile;
    }

    public String getAmount() {
        return amount;
    }
}
