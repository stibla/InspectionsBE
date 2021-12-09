CREATE TABLE public.files
(
    id character varying(255) COLLATE pg_catalog."default" NOT NULL,
    data oid,
    name character varying(255) COLLATE pg_catalog."default",
    type character varying(255) COLLATE pg_catalog."default",
    n_inspection_id bigint,
    CONSTRAINT files_pkey PRIMARY KEY (id)
)

ALTER TABLE public.files
    OWNER to postgres;


CREATE TABLE public.inspections
(
    n_inspection_id bigint NOT NULL,
    s_inspection_number character varying(255) COLLATE pg_catalog."default",
    s_pdf_content text COLLATE pg_catalog."default",
    s_manufacturer_code character varying(255) COLLATE pg_catalog."default",
    s_manufacturer_name character varying(255) COLLATE pg_catalog."default",
    s_model_code character varying(255) COLLATE pg_catalog."default",
    s_sub_model_code character varying(255) COLLATE pg_catalog."default",
    n_ax_paint_coef double precision,
    n_discount_nh double precision,
    n_discount_spares double precision,
    n_rate1 double precision,
    n_rate2 double precision,
    n_rate3 double precision,
    n_rate_paint1 double precision,
    n_discount double precision,
    CONSTRAINT inspections_pkey PRIMARY KEY (n_inspection_id)
)

TABLESPACE pg_default;

ALTER TABLE public.inspections
    OWNER to postgres;


CREATE TABLE public.regexcalculation (
    n_regexcalculation_id bigint NOT NULL,
    b_mandatory boolean,
    n_priority bigint,
    s_column character varying(255),
    s_regex character varying(255),
    s_type character varying(255)
);

ALTER TABLE public.regexcalculation OWNER TO postgres;

INSERT INTO public.regexcalculation (n_regexcalculation_id, b_mandatory, n_priority, s_column, s_regex, s_type) VALUES (17, false, 1, 'sSubModelCode', 'TYP-KÓD +[A-Z0-9][A-Z0-9] [A-Z0-9][A-Z0-9] ([A-Z0-9][A-Z0-9])', 'String');
INSERT INTO public.regexcalculation (n_regexcalculation_id, b_mandatory, n_priority, s_column, s_regex, s_type) VALUES (18, false, 1, 'nAxPaintCoef', ' 51 +([0-9]+\.[0-9]+)', 'Number');
INSERT INTO public.regexcalculation (n_regexcalculation_id, b_mandatory, n_priority, s_column, s_regex, s_type) VALUES (20, false, 1, 'nDiscount', ' 88 +([0-9]+\.[0-9]+) +', 'Number');
INSERT INTO public.regexcalculation (n_regexcalculation_id, b_mandatory, n_priority, s_column, s_regex, s_type) VALUES (26, false, 1, 'nDiscountSpares', ' 20 +([0-9]+\.[0-9]+) +', 'Number');
INSERT INTO public.regexcalculation (n_regexcalculation_id, b_mandatory, n_priority, s_column, s_regex, s_type) VALUES (14, true, 1, 'sManufacturerCode', 'TYP-KÓD +([A-Z0-9][A-Z0-9]) ', 'String');
INSERT INTO public.regexcalculation (n_regexcalculation_id, b_mandatory, n_priority, s_column, s_regex, s_type) VALUES (15, true, 1, 'sManufacturerName', 'VÝROBCA +: +(.+)', 'String');
INSERT INTO public.regexcalculation (n_regexcalculation_id, b_mandatory, n_priority, s_column, s_regex, s_type) VALUES (16, true, 1, 'sModelCode', 'TYP-KÓD +[A-Z0-9][A-Z0-9] ([A-Z0-9][A-Z0-9]) ', 'String');
INSERT INTO public.regexcalculation (n_regexcalculation_id, b_mandatory, n_priority, s_column, s_regex, s_type) VALUES (22, false, 1, 'nRate1', 'MECH\/KAROS\s+:\s+([0-9]+\.[0-9]+)\s+EUR\/HOD', 'Number');
INSERT INTO public.regexcalculation (n_regexcalculation_id, b_mandatory, n_priority, s_column, s_regex, s_type) VALUES (27, false, 2, 'nRate1', ' +([0-9]+\.[0-9]+)\s+EUR\/HOD', 'Number');
INSERT INTO public.regexcalculation (n_regexcalculation_id, b_mandatory, n_priority, s_column, s_regex, s_type) VALUES (23, false, 1, 'nRate2', 'MECH\/KAROS\s+:\s+[0-9]+\.[0-9]+\s+EUR\/HOD\s+([0-9]+\.[0-9]+)\s+EUR\/HOD', 'Number');
INSERT INTO public.regexcalculation (n_regexcalculation_id, b_mandatory, n_priority, s_column, s_regex, s_type) VALUES (24, false, 1, 'nRate3', 'MECH\/KAROS\s+:\s+[0-9]+\.[0-9]+\s+EUR\/HOD\s+[0-9]+\.[0-9]+\s+EUR\/HOD\s+([0-9]+\.[0-9]+)\s+EUR\/HOD', 'Number');
INSERT INTO public.regexcalculation (n_regexcalculation_id, b_mandatory, n_priority, s_column, s_regex, s_type) VALUES (21, false, 1, 'nRatePaint1', 'LAKOVANIE  -AZT\s+:\s+([0-9]+\.[0-9]+)\s+EUR\/HOD', 'Number');
INSERT INTO public.regexcalculation (n_regexcalculation_id, b_mandatory, n_priority, s_column, s_regex, s_type) VALUES (25, false, 1, 'nDiscountNh', ' 33 +([0-9]+\.[0-9]+) +', 'Number');

ALTER TABLE ONLY public.regexcalculation
    ADD CONSTRAINT regexcalculation_pkey PRIMARY KEY (n_regexcalculation_id);