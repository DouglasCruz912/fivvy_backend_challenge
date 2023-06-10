--
-- PostgreSQL database dump
--

-- Dumped from database version 14.5
-- Dumped by pg_dump version 14.5

-- Started on 2023-06-10 00:18:16 -04

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

--
-- TOC entry 3590 (class 1262 OID 14020)
-- Name: postgres; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE postgres WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'C';


ALTER DATABASE postgres OWNER TO postgres;

\connect postgres

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

--
-- TOC entry 3591 (class 0 OID 0)
-- Dependencies: 3590
-- Name: DATABASE postgres; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON DATABASE postgres IS 'default administrative connection database';


--
-- TOC entry 4 (class 2615 OID 2200)
-- Name: public; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA public;


ALTER SCHEMA public OWNER TO postgres;

--
-- TOC entry 3592 (class 0 OID 0)
-- Dependencies: 4
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON SCHEMA public IS 'standard public schema';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 213 (class 1259 OID 30868)
-- Name: Acceptance; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Acceptance" (
    disclaimer_id bigint NOT NULL,
    user_id bigint NOT NULL,
    create_at date NOT NULL
);


ALTER TABLE public."Acceptance" OWNER TO postgres;

--
-- TOC entry 212 (class 1259 OID 30867)
-- Name: Acceptance_disclaimer_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."Acceptance_disclaimer_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."Acceptance_disclaimer_id_seq" OWNER TO postgres;

--
-- TOC entry 3593 (class 0 OID 0)
-- Dependencies: 212
-- Name: Acceptance_disclaimer_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."Acceptance_disclaimer_id_seq" OWNED BY public."Acceptance".disclaimer_id;


--
-- TOC entry 211 (class 1259 OID 30859)
-- Name: Disclaimer; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Disclaimer" (
    id bigint NOT NULL,
    name character varying NOT NULL,
    text text NOT NULL,
    version text NOT NULL,
    create_at date NOT NULL,
    update_at date NOT NULL
);


ALTER TABLE public."Disclaimer" OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 30858)
-- Name: Disclaimer_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."Disclaimer_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."Disclaimer_id_seq" OWNER TO postgres;

--
-- TOC entry 3594 (class 0 OID 0)
-- Dependencies: 210
-- Name: Disclaimer_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."Disclaimer_id_seq" OWNED BY public."Disclaimer".id;


--
-- TOC entry 3437 (class 2604 OID 30871)
-- Name: Acceptance disclaimer_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Acceptance" ALTER COLUMN disclaimer_id SET DEFAULT nextval('public."Acceptance_disclaimer_id_seq"'::regclass);


--
-- TOC entry 3436 (class 2604 OID 30862)
-- Name: Disclaimer id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Disclaimer" ALTER COLUMN id SET DEFAULT nextval('public."Disclaimer_id_seq"'::regclass);


--
-- TOC entry 3584 (class 0 OID 30868)
-- Dependencies: 213
-- Data for Name: Acceptance; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3582 (class 0 OID 30859)
-- Dependencies: 211
-- Data for Name: Disclaimer; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public."Disclaimer" VALUES (1, 'Prueba', 'texto de prueba', '1', '2023-09-06', '2023-09-06');


--
-- TOC entry 3595 (class 0 OID 0)
-- Dependencies: 212
-- Name: Acceptance_disclaimer_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."Acceptance_disclaimer_id_seq"', 1, false);


--
-- TOC entry 3596 (class 0 OID 0)
-- Dependencies: 210
-- Name: Disclaimer_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."Disclaimer_id_seq"', 1, true);


--
-- TOC entry 3441 (class 2606 OID 30873)
-- Name: Acceptance Acceptance_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Acceptance"
    ADD CONSTRAINT "Acceptance_pkey" PRIMARY KEY (disclaimer_id);


--
-- TOC entry 3439 (class 2606 OID 30866)
-- Name: Disclaimer Disclaimer_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Disclaimer"
    ADD CONSTRAINT "Disclaimer_pkey" PRIMARY KEY (id);


-- Completed on 2023-06-10 00:18:16 -04

--
-- PostgreSQL database dump complete
--

