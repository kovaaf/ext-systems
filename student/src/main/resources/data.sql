insert into sr_university (university_name) values ('NSU');

insert into sr_faculty (university_id, faculty_name) values (1, 'Economics');
insert into sr_faculty (university_id, faculty_name) values (1, 'Information Systems');

insert into sr_student (last_name, first_name, middle_name, date_of_birth, passport_seria, passport_number, passport_date)
values ('last', 'first', 'middle', '1993-11-30', 'seria', 'number', '2022-05-15');

insert into sr_student_document (document_number, document_date, expired_date, student_id, faculty_id, student_form)
values ('123456', '2017-09-01', '2021-05-31', 1, 1, 0);