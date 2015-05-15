SET search_path = public, pg_catalog;
--
-- Name: t2; Type: TABLE; Schema: public; Owner: botov_av; Tablespace: 
--

CREATE TABLE t2 (
    c3 integer,
    c4 integer DEFAULT nextval('seq2'::regclass)
)
INHERITS (t1);


ALTER TABLE public.t2 OWNER TO botov_av;

--
-- Name: c1; Type: DEFAULT; Schema: public; Owner: botov_av
--

ALTER TABLE ONLY t2 ALTER COLUMN c1 SET DEFAULT nextval('seq1'::regclass);