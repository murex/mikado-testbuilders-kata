package com.murex.tbw.client;

import com.murex.tbw.domain.country.Country;

import java.util.Objects;

public final class Client {
    private final String name;
    private final Country country;

    public Client(String name, Country country) {
        this.name = name;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public Country getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", country=" + country +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(name, client.name) &&
                Objects.equals(country, client.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, country);
    }
}
