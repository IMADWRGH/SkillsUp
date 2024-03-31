package IMADWRGH.MyJob.Controller.Model;

import jakarta.validation.constraints.*;

public class CandidatRegistrationBody {
    @NotNull
    @NotBlank
    @Size(max = 256,min = 3)
    private String username;
    @NotNull
    @NotBlank
    private String fullname;
    @NotNull
    @Email
    @NotBlank
    private String email;
    @NotNull
    @NotBlank
    @Size(max = 25,min = 8)
    private String password;

    @Size(max = 100)
    private String adress;
    private String tel;
    private String cv;

    public CandidatRegistrationBody() {
    }


    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
