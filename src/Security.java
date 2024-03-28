import java.util.Objects;

public abstract class Security {
    protected String isin;
    protected String issuer;

    protected Security(String isin, String issuer) {
        this.isin = isin;
        this.issuer = issuer;
    }

    public String getIsin() {
        return isin;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Security security = (Security) o;
        return Objects.equals(isin, security.isin) && Objects.equals(issuer, security.issuer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isin, issuer);
    }
}
