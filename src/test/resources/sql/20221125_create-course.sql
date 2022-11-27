CREATE TABLE course
(
    course_id  UUID PRIMARY KEY,
    name       VARCHAR(50) NOT NULL,
    university UUID,
    CONSTRAINT fk_university
        FOREIGN KEY (university)
            REFERENCES universities (university_id)
);