CREATE DATABASE "car_rental";
CREATE DATABASE "process_engine";
CREATE DATABASE "keycloak";

--
-- PostgreSQL database dump
--

-- Dumped from database version 14.1
-- Dumped by pg_dump version 14.1

-- Started on 2021-11-22 13:03:32

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
SET search_path TO car_rental;

--
-- TOC entry 3322 (class 0 OID 17271)
-- Dependencies: 210
-- Data for Name: cars; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.cars (id, category, license_plate, price_day) VALUES (1, 'A', 'JT487Z', 80);
INSERT INTO public.cars (id, category, license_plate, price_day) VALUES (2, 'B', 'NX698L', 50);
INSERT INTO public.cars (id, category, license_plate, price_day) VALUES (3, 'C', '68LBVN', 30);


--
-- TOC entry 3326 (class 0 OID 17287)
-- Dependencies: 214
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.users (id, date_of_birth, drivers_license_obtained, is_verified, mail, password) VALUES (1, '1990-01-24', '2018-01-24', true, 'demo@demo.com', 'demo');
INSERT INTO public.users (id, date_of_birth, drivers_license_obtained, is_verified, mail, password) VALUES (2, NULL, NULL, false, 'test@test.nl', 'test');


--
-- TOC entry 3324 (class 0 OID 17280)
-- Dependencies: 212
-- Data for Name: contract; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.contract (rental_id, end_date, start_date, car_id, user_id) VALUES (2, '2021-11-08', '2021-11-01', 1, 1);


--
-- TOC entry 3332 (class 0 OID 0)
-- Dependencies: 209
-- Name: cars_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.cars_id_seq', 3, true);


--
-- TOC entry 3333 (class 0 OID 0)
-- Dependencies: 211
-- Name: contract_rental_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.contract_rental_id_seq', 2, true);


--
-- TOC entry 3334 (class 0 OID 0)
-- Dependencies: 213
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.users_id_seq', 2, true);


-- Completed on 2021-11-22 13:03:32

--
-- PostgreSQL database dump complete
--

