CREATE TABLE "public"."Table1" (
  "id" int4 NOT NULL,
  CONSTRAINT "table1_pkey" PRIMARY KEY ("id")
)
;

CREATE TABLE "public"."Table2" (
  "id" int4 NOT NULL,
  "Table1_id" int4,
  CONSTRAINT "table2_pkey" PRIMARY KEY ("id"),
  CONSTRAINT "Table2_Table1_id_fkey" FOREIGN KEY ("Table1_id") REFERENCES "public"."Table1" ("id") ON DELETE CASCADE ON UPDATE CASCADE
)
;