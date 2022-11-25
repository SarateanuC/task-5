CREATE TABLE professor
(
    professor_id UUID PRIMARY KEY,
    firstname    VARCHAR(50) NOT NULL,
    lastname     VARCHAR(50) NOT NULL,
    course_id    UUID        NOT NULL,
    CONSTRAINT fk_course_id
        FOREIGN KEY (course_id)
            REFERENCES course (course_id)
);