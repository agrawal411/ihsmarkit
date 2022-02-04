
create table TRADE_BLOTTER (
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

