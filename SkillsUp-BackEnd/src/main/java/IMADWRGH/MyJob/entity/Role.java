package IMADWRGH.MyJob.entity;

public enum Role {
    ADMIN("ADMIN"),
    CANDIDAT("CANDIDAT"),
    FORMATEUR("FORMATEUR"),
    RECRUTEUR("RECRUTEUR");
    private final  String type;

    Role(String string) {
        type = string;
    }

    @Override
    public String toString() {
        return type;
    }
}
