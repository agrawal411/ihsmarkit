create table USER (
	USER_ID int,
	USERNAME varchar(32),
	PASSWORD varchar(32),
	ROLE varchar(32)
);

create table TRADE_CAPTURE (
	TRADE_ID int,
	COUNTER_PARTY varchar(256),
	CURRENCY_PAIR varchar(32),
	RATE decimal(4,2),
	SIDE varchar(32),
	NOTIONAL varchar(32),
	VALUE_DATE date,
	USER_ID int,
	STATUS varchar(32),
	CANCEL_DATE date,
	USER_CANCELLED varchar(256)
);

create table CURRENCY_PAIR(
	CURRENCY_PAIR_NAME varchar(32),
	RATE decimal(4,2) 
);

CREATE SEQUENCE trade_sequence START 1 INCREMENT 1;
