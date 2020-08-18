--
-- PostgreSQL database dump
--

-- Dumped from database version 12.0
-- Dumped by pg_dump version 12rc1

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: kullanicilar; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.kullanicilar (
    kullaniciadi character varying(2044) NOT NULL,
    sifre character varying(2044) NOT NULL
);


ALTER TABLE public.kullanicilar OWNER TO postgres;

--
-- Data for Name: kullanicilar; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.kullanicilar VALUES ('mehmet', '121212');
INSERT INTO public.kullanicilar VALUES ('ayse', 'aysenur');
INSERT INTO public.kullanicilar VALUES ('ali', 'parola');


--
-- PostgreSQL database dump complete
--

