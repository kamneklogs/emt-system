package co.edu.icesi.emt.auth.domain.model.role;

public class Role {

    private String name;
    private String domainName;
    private String description;

    public Role(String name, String domainName , String description) {
        this.name = name;
        this.domainName = domainName;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}