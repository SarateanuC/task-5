CREATE TABLE students
(
    student_id UUID PRIMARY KEY,
    firstname  VARCHAR(50) NOT NULL,
    lastname   VARCHAR(50) NOT NULL,
    age        INTEGER     NOT NULL,
    address_id UUID        NOT NULL,
    CONSTRAINT fk_address_id
        FOREIGN KEY (address_id)
            REFERENCES address (address_id)
);