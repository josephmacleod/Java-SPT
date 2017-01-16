CREATE TABLE spt(
	date_time       DATETIME       NOT NULL,
    Hs				NUMERIC(8,3)   NOT NULL,
    Tz				NUMERIC(6,3)   NOT NULL,
    Battery         NUMERIC(2)     NOT NULL,
	PRIMARY KEY (date_time)
);
