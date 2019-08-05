create table if not exists question
(
    questionid bigint not null
        constraint question_pkey
            primary key,
    question_text varchar(500) not null,
    room varchar(255)
);

alter table question owner to postgres;

create table if not exists answer
(
    answerid integer not null
        constraint answer_pkey
            primary key,
    answer_text varchar(1500) not null,
    right_answer boolean not null,
    question_questionid bigint
        constraint fkk8r3s2m5xualispohtavnrkol
            references question
);

alter table answer owner to postgres;

create table if not exists rating
(
    ratingid bigint not null
        constraint rating_pkey
            primary key,
    rated_as_known boolean not null,
    question_id bigint
        constraint fktb6rpvqse82j14xx04lp9vs9q
            references question
);

alter table rating owner to postgres;

create table if not exists tag
(
    tagid bigint not null
        constraint tag_pkey
            primary key,
    name varchar(255) not null
        constraint uk_1wdpsed5kna2y38hnbgrnhi5b
            unique
);

alter table tag owner to postgres;

create table if not exists question_tag
(
    question_id bigint not null
        constraint fk44ydihbi2qk8k96175quf5q63
            references question,
    tag_id bigint not null
        constraint fknacet7y1n8llxvrbmm3xdq13j
            references tag
);

alter table question_tag owner to postgres;

create sequence hibernate_sequence;

alter sequence hibernate_sequence owner to postgres;

