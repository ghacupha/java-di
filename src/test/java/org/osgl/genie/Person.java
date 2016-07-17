package org.osgl.genie;

import javax.inject.Inject;
import javax.inject.Qualifier;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static org.osgl.genie.Person.Gender.F;
import static org.osgl.genie.Person.Gender.M;

public interface Person {

    @Qualifier
    @Retention(RetentionPolicy.RUNTIME)
    @interface Female {
    }

    enum Gender {
        M, F;
        public boolean isFemale() {
            return this == F;
        }
    }

    Gender gender();

    class Man implements Person {
        @Override
        public Gender gender() {
            return M;
        }
    }

    class Woman implements Person {
        @Override
        public Gender gender() {
            return F;
        }
    }

    class Family {

        @Inject
        Person dad;

        @Inject
        @Female
        Person mom;

        @Female
        Person daughter;

        Person son;
    }

}
