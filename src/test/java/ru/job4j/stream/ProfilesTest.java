package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ProfilesTest {
    @Test
    public void whenCollect4() {
        List<Profile> profileList = List.of(
                new Profile(new Address("Norilsk", "Lenina", 20, 11)),
                new Profile(new Address("Norilsk", "Sovetskaya", 3, 3)),
                new Profile(new Address("Norilsk", "Nemirovicha", 5, 9)),
                new Profile(new Address("Norilsk", "Frunze", 31, 12))
        );
        Profiles profiles = new Profiles();
        List<Address> addressList = profiles.collect(profileList);
        assertThat(addressList.size(), is(4));
    }

    @Test
    public void whenCollectTrue() {
        List<Profile> profileList = List.of(
                new Profile(new Address("Norilsk", "Lenina", 20, 11)),
                new Profile(new Address("Norilsk", "Sovetskaya", 3, 3)),
                new Profile(new Address("Norilsk", "Nemirovicha", 5, 9)),
                new Profile(new Address("Norilsk", "Frunze", 31, 12))
        );
        Profiles profiles = new Profiles();
        List<Address> addressList = profiles.collect(profileList);
        Address expected = profileList.get(2).getAddress();
        assertEquals(expected, addressList.get(2));
    }
}