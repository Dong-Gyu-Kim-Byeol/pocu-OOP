package academy.pocu.comp2500.lab7;

public final class Author {
    private final String firstName;
    private final String lastName;

    public Author(final String firstName, final String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder(this.firstName.length() + this.lastName.length() + 2);
        sb.append(this.firstName);
        sb.append(" ");
        sb.append(this.lastName);
        return sb.toString();
    }

    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null) {
            return false;
        }

        if (this.hashCode() != o.hashCode()) {
            return false;
        }

        if (o instanceof Author == false) {
            return false;
        }

        final Author other = (Author) o;
        return this.firstName.equals(other.firstName)
                && this.lastName.equals(other.lastName);
    }

    public int hashCode() {
        return this.firstName.hashCode()
                ^ this.lastName.hashCode();
    }

}
