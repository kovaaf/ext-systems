DROP TABLE IF EXISTS ro_marriage_certificate;
DROP TABLE IF EXISTS ro_birth_certificate;
DROP TABLE IF EXISTS ro_passport;
DROP TABLE IF EXISTS ro_person;

CREATE TABLE ro_person (
    person_id SERIAL,
    sex smallint not null,
    first_name varchar(100) not null,
    last_name varchar(100) not null,
    patronymic varchar(100),
    date_birth date not null,
    PRIMARY KEY (person_id)
);

CREATE TABLE ro_passport (
    passport_id SERIAL,
    person_id integer not null,
    seria varchar(10) not null,
    number varchar(10) not null,
    date_issue date not null,
    issue_department varchar(200) not null,
    PRIMARY KEY (passport_id),
    FOREIGN KEY (person_id) references ro_person(person_id) ON delete restrict
);

create table ro_birth_certificate (
    birth_certificate_id serial,
    number_certificate varchar(10) not null,
    date_issue date not null,
    person_id integer not null,
    father_id integer,
    mother_id integer,
    primary key (birth_certificate_id),
    FOREIGN KEY (person_id) references ro_person(person_id) ON delete restrict,
    FOREIGN KEY (father_id) references ro_person(person_id) ON delete restrict,
    FOREIGN KEY (mother_id) references ro_person(person_id) ON delete restrict
);

create table ro_marriage_certificate (
    marriage_certificate_id serial,
    number_certificate varchar(10) not null,
    date_issue date not null,
    husband_id integer not null,
    wife_id integer not null,
    active boolean default false,
    end_date date,
    primary key (marriage_certificate_id),
    FOREIGN KEY (husband_id) references ro_person(person_id) ON delete restrict,
    FOREIGN KEY (wife_id) references ro_person(person_id) ON delete restrict
);

insert into ro_person (sex, first_name, last_name, patronymic, date_birth)
values (1, 'Елена', 'Васильева', 'Сергеевна', '1998-03-24'),
(2, 'Олег', 'Васильев', 'Петрович', '1997-10-16'),
(2, 'Николай', 'Васильев', 'Олегович', '2018-10-21');

insert into ro_passport (person_id, seria, number, date_issue, issue_department)
values (1, '4000', '123456', '2012-03-24', 'Passport Department');

insert into ro_birth_certificate (number_certificate, date_issue, person_id, mother_id, father_id)
values ('123 Birth', '2018-11-01', 3, 1, 2);

insert into ro_marriage_certificate (number_certificate, date_issue, husband_id, wife_id, active, end_date)
values ('123 Birth', '2018-11-01', 2, 1, 'true', null);