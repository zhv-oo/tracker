package ru.job4j.collection;

import org.junit.Test;
import java.util.Comparator;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class JobTest {
    @Test
    public void whenCompatorByNameAndPrority() {
        Comparator<Job> cmpNamePriority = new JobDescByNameToMore().thenComparing(
                                                new JobDescByPriorityToMore());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorByPryorityAndName() {
        Comparator<Job> cmpNamePriority = new JobDescByPriorityToMore().thenComparing(
                new JobDescByNameToLess());
        int rsl = cmpNamePriority.compare(
                new Job("Fix bug", 2),
                new Job("Impl task", 3)

        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorByNameToMore() {
        Comparator<Job> cmpNamePriority = new JobDescByNameToMore();
        int rsl = cmpNamePriority.compare(
                new Job("Fix bug", 1),
                new Job("Impl task", 0)

        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompatorByNameToLess() {
        Comparator<Job> cmpNamePriority = new JobDescByNameToLess();
        int rsl = cmpNamePriority.compare(
                new Job("Fix bug", 1),
                new Job("Impl task", 0)

        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorByNameEquals() {
        Comparator<Job> cmpNamePriority = new JobDescByNameToLess();
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Impl task", 1)
        );
        assertThat(rsl, is(0));
    }

    @Test
    public void whenCompatorByPriorityToMore() {
        Comparator<Job> cmpNamePriority = new JobDescByPriorityToMore();
        int rsl = cmpNamePriority.compare(
                new Job("Fix bug", 1),
                new Job("Impl task", 0)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompatorByPriorityToLess() {
        Comparator<Job> cmpNamePriority = new JobDescByPriorityToLess();
        int rsl = cmpNamePriority.compare(
                new Job("Fix bug", 1),
                new Job("Impl task", 0)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorByPriorityEquals() {
        Comparator<Job> cmpNamePriority = new JobDescByPriorityToMore();
        int rsl = cmpNamePriority.compare(
                new Job("Fix bug", 0),
                new Job("Impl task", 0)
        );
        assertThat(rsl, is(0));
    }
}