CREATE TABLE universities
(
    university_id UUID PRIMARY KEY,
    name          VARCHAR(50) NOT NULL,
    address_id    UUID        NOT NULL,
    CONSTRAINT fk_university_address_id
        FOREIGN KEY (address_id)
            REFERENCES address (address_id)
);