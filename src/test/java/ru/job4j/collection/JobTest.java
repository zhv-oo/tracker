package ru.job4j.collection;

import org.junit.Test;
import java.util.Comparator;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class JobTest {
    @Test
    public void whenCompatorByNameAndPrority() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(
                                                new JobByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Impl task", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorByPryorityAndName() {
        Comparator<Job> cmpNamePriority = new JobByPriority().thenComparing(
                new JobByName());
        int rsl = cmpNamePriority.compare(
                new Job("Fix bug", 3),
                new Job("Impl task", 3)

        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorByNameToMore() {
        Comparator<Job> cmpName = new JobAscByName();
        int rsl = cmpName.compare(
                new Job("Fix bug", 1),
                new Job("Impl task", 0)

        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompatorByNameToLess() {
        Comparator<Job> cmpName = new JobByName();
        int rsl = cmpName.compare(
                new Job("Fix bug", 1),
                new Job("Impl task", 0)

        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorByNameEquals() {
        Comparator<Job> cmpName = new JobByName();
        int rsl = cmpName.compare(
                new Job("Impl task", 0),
                new Job("Impl task", 1)
        );
        assertThat(rsl, is(0));
    }

    @Test
    public void whenCompatorByPriorityToMore() {
        Comparator<Job> cmpPriority = new JobByPriority();
        int rsl = cmpPriority.compare(
                new Job("Fix bug", 1),
                new Job("Impl task", 0)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompatorByPriorityToLess() {
        Comparator<Job> cmpPriority = new JobAscByPriority();
        int rsl = cmpPriority.compare(
                new Job("Fix bug", 1),
                new Job("Impl task", 0)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorByPriorityEquals() {
        Comparator<Job> cmpNamePriority = new JobAscByPriority();
        int rsl = cmpNamePriority.compare(
                new Job("Fix bug", 0),
                new Job("Impl task", 0)
        );
        assertThat(rsl, is(0));
    }
}