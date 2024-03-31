package IMADWRGH.MyJob.Controller.Model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class FormateurRegistrationBody {
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
    @NotNull
    @NotBlank
    private String demaineExperter;

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

    public String getDemaineExperter() {
        return demaineExperter;
    }

    public void setDemaineExperter(String demaineExperter) {
        this.demaineExperter = demaineExperter;
    }

    public FormateurRegistrationBody() {
    }
}
