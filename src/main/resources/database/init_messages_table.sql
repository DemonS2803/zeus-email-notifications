CREATE SEQUENCE public.message_inc_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;


CREATE TABLE IF NOT EXISTS public.messages
(
    id bigint NOT NULL DEFAULT nextval('message_inc_seq'::regclass),
    message character varying(255) COLLATE pg_catalog."default",
    status smallint DEFAULT 0,
    title character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT messages_pkey PRIMARY KEY (id)
)

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.messages
    OWNER to postgres;